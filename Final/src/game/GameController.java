package game;

import gamehistory.GameHistoryController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * The GameController class is the controller providing the interface between
 * the user and the game.
 *
 */
public class GameController {

   private final GameModel gameModel;
   private final ClockView clockView;
   private final ScoreView scoreView;
   private final GameView gameView;
   private final PlayerOptionsView optionsView;
   private final GameOptionsView speedView;
   private final MessageView messageView;

   private PlayerView runningbackView;
   private RunningbackModel runningbackModel;
   private HashMap<PlayerModel, PlayerView> opponents;
   private PlayerOptionsController playerOptionsController;
   private GameHistoryController gameHistoryController;

   private Timer gameTimer;
   private Timer clockTimer;

   private boolean gameIsInProgress;

   private static final Logger logger = Logger.getLogger("GameController");

   public GameController(GameModel gameModel, ClockView clockView, ScoreView scoreView,
           GameView gameView, PlayerOptionsView optionsView, GameOptionsView speedView,
           PlayerOptionsController playerOptionsController) {
      this.gameModel = gameModel;
      this.clockView = clockView;
      this.scoreView = scoreView;
      this.gameView = gameView;
      this.optionsView = optionsView;
      this.speedView = speedView;
      this.playerOptionsController = playerOptionsController;
      this.messageView = new MessageView();

      // initialize timers
      initClockTimer();
      initGameTimer();

      // initialize the key listener
      initKeyListener();

      // initialize the speed controls
      initSpeedControl();

      // initialize the challenge mode control
      initChallengeControl();

      // initialize players
      initPlayers();

      // start game history controller
      gameHistoryController = new GameHistoryController();

      gameIsInProgress = false;
      messageView.showWelcomeMessage();
   }

   /**
    * Drives the game by handling the user's keyboard input.
    *
    * @param key The key pressed or typed.
    */
   private void keyHandler(int key) {

      if (key == KeyEvent.VK_Q) {
         System.exit(0);
      }

      if (key == KeyEvent.VK_SPACE) {

         if (gameIsInProgress) {
            if (gameTimer.isRunning()) {
               pauseGame();
            } else {
               resumeGame();
            }
         } else {
            resetGame();
            resumeGame();
            gameIsInProgress = true;
         }

      } else if (key == KeyEvent.VK_ESCAPE) {
         resetGame();
         gameIsInProgress = false;

      } else if (gameTimer.isRunning()) {
         switch (key) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_K:
               runningbackModel.move(Direction.NORTH);
               break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_J:
               runningbackModel.move(Direction.SOUTH);
               break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_H:
               runningbackModel.move(Direction.WEST);
               break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_L:
               runningbackModel.move(Direction.EAST);
               break;
            case KeyEvent.VK_Y:
               runningbackModel.move(Direction.NORTHWEST);
               break;
            case KeyEvent.VK_U:
               runningbackModel.move(Direction.NORTHEAST);
               break;
            case KeyEvent.VK_B:
               runningbackModel.move(Direction.SOUTHWEST);
               break;
            case KeyEvent.VK_N:
               runningbackModel.move(Direction.SOUTHEAST);
               break;
         }

         runningbackView.setBounds(runningbackModel.getBounds());
         if (gameModel.detectTouchdownEvent(runningbackModel.getBounds())) {
            gameModel.incrementTouchdownScore();
            scoreView.updateScore(gameModel.getTouchdownScore(), gameModel.getTackleScore());
            resetGame();
            messageView.showTouchdownMessage();
         }
      }

   }

   /**
    * Initializes the timer used for the clock display.
    */
   private void initClockTimer() {
      clockTimer = new Timer(1000, new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            gameModel.tickClock();
            clockView.updateClock(gameModel.getClock());
         }
      });
      logger.info("Clock timer initialized.");
   }

   /**
    * Initializes the timer that drives the game.
    */
   private void initGameTimer() {
      gameTimer = new Timer(gameModel.getSpeed(), new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            for (Map.Entry<PlayerModel, PlayerView> entry : opponents.entrySet()) {
               PlayerModel model = entry.getKey();
               PlayerView view = entry.getValue();

               int perceptiveChance = 0;

               if (runningbackModel.isPerceptive()) {
                  Random rand = new Random();
                  perceptiveChance = rand.nextInt(101);
               }

               if (perceptiveChance < gameModel.getTraitTriggerThreshold()) {

                  model.chase(runningbackModel.getBounds().getLocation());
                  view.setBounds(model.getBounds());
               }

               if (gameModel.detectTackleEvent(runningbackModel, opponents.keySet())) {
                  gameModel.incrementTackleScore();
                  scoreView.updateScore(gameModel.getTouchdownScore(), gameModel.getTackleScore());

                  if (gameModel.isChallengeMode()) {
                     resetGameChallenge();
                  } else {
                     messageView.showTackleMessage();
                     resetGame();
                  }

               }

            }
         }
      });
      logger.info("Game timer initialized.");
   }

   /**
    * Initializes the key listener on the game view
    */
   private void initKeyListener() {
      gameView.addKeyListener(new KeyAdapter() {
         @Override
         public void keyPressed(KeyEvent e) {
            keyHandler(e.getKeyCode());
         }
      });
   }

   /**
    * Initialize the speed view.
    */
   private void initSpeedControl() {

      int[] speeds = gameModel.getSpeeds();
      int middle = (speeds.length / 2);

      speedView.setRange(0, speeds.length - 1, 1);
      speedView.setSliderPosition(middle);

      speedView.getSlider().addChangeListener(new ChangeListener() {
         @Override
         public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider) e.getSource();
            if (!source.getValueIsAdjusting()) {
               gameModel.setSpeed(source.getValue());
               gameTimer.setDelay(gameModel.getSpeed());
               logger.info(String.format("Speed changed: %d", source.getValue()));
            }
         }
      });
   }

   /**
    * Initializes the challenge mode view.
    */
   private void initChallengeControl() {

      speedView.getChallengeButton().addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            boolean state = (e.getStateChange() == ItemEvent.SELECTED);
            gameModel.setChallengeMode(state);

            if (state) {

            }
         }
      });

   }

   /**
    * Creates the players and places them on the field.
    *
    * @param numOpponents the number of opponents to create
    */
   public void initPlayers(int numOpponents) {

      runningbackModel = new RunningbackModel("resources/psu.png");
      runningbackView = new PlayerView(runningbackModel.getIconLocation());
      gameView.addPlayer(runningbackView);

      playerOptionsController.setPlayer(runningbackModel, runningbackView);

      opponents = new HashMap<>();
      for (int i = 0; i < numOpponents; i++) {
         PlayerModel model = new PlayerModel("resources/uw.png");
         PlayerView view = new PlayerView(model.getIconLocation());
         gameView.addPlayer(view);
         opponents.put(model, view);
      }

      resetPlayerPostions();

   }

   /**
    * Creates players and places them on the field.
    *
    * This method creates two opponents.
    */
   private void initPlayers() {
      initPlayers(2);
   }

   /**
    * Places the players in their start positions on the field.
    *
    */
   private void resetPlayerPostions() {
      // calculate where the players should be placed
      int rbStartX = (int) (gameModel.getFieldBounds().getX() + (gameModel.getFieldBounds().getWidth() * 0.33));
      int rbStartY = (int) (gameModel.getFieldBounds().getY() + (gameModel.getFieldBounds().getHeight() / 2));
      int oppStartX = (int) (gameModel.getFieldBounds().getX() + (gameModel.getFieldBounds().getWidth() * 0.66));
      int oppStartYOffset = (int) (gameModel.getFieldBounds().getY() + (gameModel.getFieldBounds().getHeight() / (opponents.size() + 1)));

      if (runningbackModel != null && runningbackView != null) {
         runningbackModel.setLocation(rbStartX, rbStartY);
         runningbackView.setBounds(runningbackModel.getBounds());
      }

      int i = 1;
      if (opponents != null) {
         for (Map.Entry<PlayerModel, PlayerView> entry : opponents.entrySet()) {
            PlayerModel model = entry.getKey();
            PlayerView view = entry.getValue();

            model.setLocation(oppStartX, oppStartYOffset * i);
            view.setBounds(model.getBounds());
            i++;
         }
      }
   }

   /**
    * Pauses the game.
    *
    * The clock will not advance and the player cannot be moved while the
    * game is paused.
    */
   private void pauseGame() {
      clockTimer.stop();
      gameTimer.stop();
   }

   /**
    * Resumes the game from pause.
    */
   private void resumeGame() {
      clockTimer.start();
      gameTimer.start();
   }

   /**
    * Resets the game.
    *
    * The players will be moved to their initial positions and the game will
    * be paused.
    */
   private void resetGame() {
      pauseGame();
      resetPlayerPostions();
      gameIsInProgress = true;
   }

   /**
    * Resets the game when challenge mode is enabled.
    * 
    * The player will be prompted to enter their name to save their new
    * high score, then resets the players, clock, and score.
    */
   private void resetGameChallenge() {
      Calendar cal = Calendar.getInstance();
      int score = gameModel.getTouchdownScore();
      String history = gameHistoryController.getHistoryAsString();
      boolean newScore = (score >= gameHistoryController.getLowScore());
      
      
      String name = messageView.showGameOverMessage(newScore, history);
      
      if (name != null && !name.equals("")) {
         gameHistoryController.addHighScore(name, score, cal);
      }
      gameModel.resetScore();
      scoreView.updateScore(0, 0);
      gameModel.resetClock();
      clockView.resetClock();
      resetGame();
   }

}
