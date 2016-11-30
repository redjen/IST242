package app;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
import players.Direction;
import players.Opponent;
import players.Runningback;

/**
 * The GamePanel class displays and controls a football game with one
 * runningback, and two opponents. The user controls the runningback through
 * keyboard commands.
 *
 */
public class GamePanel extends JPanel {

   private static final String BACKGROUND_IMAGE = "resources/field/football_field.png";
   private static final String HALLOWEEN_IMAGE = "resources/field/halloween.jpg";

   private Timer timer;
   private final int[] SPEEDS = {1000, 500, 200, 100, 50};
   private final int DEFAULT_SPEED = 3;
   private int speed;

   private final ScorePanel scorePanel;
   private final ClockPanel clockPanel;
   private final MainAppPanel mainAppPanel; // for Halloween mode
   
   private Runningback rb;
   private Opponent opp1;
   private Opponent opp2;

   private final int TRAIT_TRIGGER_THRESHOLD = 95;
   private final double RUNNINGBACK_START_X_PCT = .33;
   private final double RUNNINGBACK_START_Y_PCT = .50;
   private final double OPPONENT_START_X_PCT = .66;
   private final double OPPONENT_START_Y_PCT = .33;

   private boolean isHalloween;
   private GameState state;

   private static final Logger logger = Logger.getLogger("GamePanel");

   public GamePanel(ScorePanel scorePanel, ClockPanel clockPanel, MainAppPanel mainAppPanel) {

      super();

      isHalloween = false;
      this.scorePanel = scorePanel;
      this.clockPanel = clockPanel;
      this.mainAppPanel = mainAppPanel;
      this.speed = SPEEDS[DEFAULT_SPEED];

      setVisible(true);
      setFocusable(true);

      setLayout(null);
      initPlayers();
      initTimer();
      initKeyListener();
      
      this.state = GameState.STOPPED;    
   }

   /**
    * Sets the game speed, which drives the opponent speed.
    *
    * @param speedLevel
    */
   public void setSpeed(int speedLevel) {
      if (speedLevel < 0 || speedLevel > SPEEDS.length) {
         logger.log(Level.WARNING, "Attempted to set invalid speed.");
         throw new IllegalArgumentException("Invalid speed");
      }

      logger.log(Level.INFO, String.format("Speed changed to %s", speed));
      this.speed = SPEEDS[speedLevel - 1];
      timer.setDelay(speed);
   }

   /**
    * Turns the Halloween appearance off and on.
    *
    * @param isHalloween true for Halloween, false otherwise
    */
   public void setHalloween(boolean isHalloween) {

      this.isHalloween = isHalloween;
      repaint();
      rb.setHalloween(isHalloween);
      opp1.setHalloween(isHalloween);
      opp2.setHalloween(isHalloween);
      mainAppPanel.setHalloween(isHalloween);

   }

   /**
    * Gets the runningback.
    *
    * @return the runningback
    */
   public Runningback getRunningback() {
      return rb;
   }

   /**
    * Allows an external panel to give up focus and return it to this panel.
    *
    */
   public void returnFocus() {
      requestFocusInWindow();
   }

   /**
    * Creates the players
    */
   private void initPlayers() {

      rb = new Runningback();
      add(rb);
      opp1 = new Opponent();
      add(opp1);
      opp2 = new Opponent();
      add(opp2);
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
         
         switch (state) {
            case STOPPED:
               initNewGame();
               runGame();
               break;
            case RUNNING:
               pauseGame();
               break;
            case PAUSED:
               runGame();
               break;
         }

         
      } else if (key == KeyEvent.VK_ESCAPE) {
         pauseGame();
         initNewGame();
         
      } else if (timer.isRunning()) {
         switch (key) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_K:
               rb.move(Direction.NORTH);
               break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_J:
               rb.move(Direction.SOUTH);
               break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_H:
               rb.move(Direction.WEST);
               break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_L:
               rb.move(Direction.EAST);
               break;
            case KeyEvent.VK_Y:
               rb.move(Direction.NORTHWEST);
               break;
            case KeyEvent.VK_U:
               rb.move(Direction.NORTHEAST);
               break;
            case KeyEvent.VK_B:
               rb.move(Direction.SOUTHWEST);
               break;
            case KeyEvent.VK_N:
               rb.move(Direction.SOUTHEAST);
               break;
         }
      }

   }

   /**
    * Detects touchdowns and tackles.
    */
   private void detectScoreEvent() {

      if (state == GameState.RUNNING) {

         // tackle
         // if the player is lucky, they have a 5% chance of evading the
         // tackle and advancing toward the goal
         if (rb.getBounds().intersects(opp1.getBounds()) || rb.getBounds().intersects(opp2.getBounds())) {
            // TODO fix this!
            int evadeChance = 0;

            if (rb.isLucky()) {
               Random rand = new Random();
               evadeChance = rand.nextInt(100);
            }

            if (evadeChance > TRAIT_TRIGGER_THRESHOLD) {
               pauseGame();
               rb.evadeTackle();
               logger.log(Level.INFO, "tackle evaded");
               runGame();
            } else {
               scorePanel.addMiss();
               pauseGame();
               initNewRound();
            }
         }

         // touchdown
         if (rb.getLocation().getX() >= getWidth() * 0.88) {
            scorePanel.addTouchdown();
            pauseGame();
            initNewRound();
         }
      }

   }

   /* Game state **************************************************************/
   /**
    * Defines the game states.
    */
   private enum GameState {
      RUNNING,
      PAUSED,
      STOPPED
   }

   /**
    * Sets up a new game, resetting the score and clock.
    *
    * No movement allowed in this state.
    *
    */
   private void initNewGame() {

      timer.stop();
      clockPanel.stopClock();
      clockPanel.resetClock();
      scorePanel.reset();
      resetPlayerPositions();
      initNewRound();

   }

   /**
    * Stops the clock and repositions the players for another round of play.
    */
   private void initNewRound() {

      clockPanel.stopClock();
      timer.stop();

      resetPlayerPositions();      
   }

   /**
    * Starts or resumes the game.
    */
   private void runGame() {
      clockPanel.startClock();
      timer.start();
      state = GameState.RUNNING;
   }

   /**
    * Pauses the game.
    *
    * No movement allowed in this state.
    */
   private void pauseGame() {

      clockPanel.stopClock();
      timer.stop();
      state = GameState.PAUSED;
   }


   /**
    * Moves the players to their starting positions.
    */
   private void resetPlayerPositions() {

      int fieldWidth = getWidth();
      int fieldHeight = getHeight();
      rb.setLocation((int) (fieldWidth * RUNNINGBACK_START_X_PCT), (int) (fieldHeight * RUNNINGBACK_START_Y_PCT));
      rb.setVisible(true);
      opp1.setLocation((int) (fieldWidth * OPPONENT_START_X_PCT), (int) (fieldHeight * OPPONENT_START_Y_PCT));
      opp1.setVisible(true);
      opp2.setLocation((int) (fieldWidth * OPPONENT_START_X_PCT), (int) (fieldHeight * OPPONENT_START_Y_PCT * 2));
      opp2.setVisible(true);
      
   }

   /* Initialization helper methods *******************************************/
   /**
    * Initializes the timer that drives the game
    */
   private void initTimer() {
      this.timer = new Timer(speed, new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            int evadeChance = 0;
            if (rb.isPerceptive()) {
               Random rand = new Random();
               evadeChance = rand.nextInt(100);
            }

            if (evadeChance < TRAIT_TRIGGER_THRESHOLD) {
               opp1.chase(rb.getLocation());
               opp2.chase(rb.getLocation());
            } else {
               if (evadeChance % 2 == 0) {
                  opp1.chase(rb.getLocation());
               } else {
                  opp2.chase(rb.getLocation());
               }
               logger.log(Level.INFO, "Agility triggered");
            }

            detectScoreEvent();
         }
      });

   }

   /**
    * Sets up the keyboard listener.
    *
    * Keyboard events are passed to keyHandler.
    */
   private void initKeyListener() {

      addKeyListener(new KeyAdapter() {
         @Override
         public void keyPressed(KeyEvent e) {
            detectScoreEvent();
            keyHandler(e.getKeyCode());
         }

      });

   }

   @Override
   public void paintComponent(Graphics gg) {
      super.paintComponent(gg);

      requestFocusInWindow();
      
      if (state == GameState.STOPPED) {
         resetPlayerPositions();
      }

      try {
         BufferedImage background;

         if (isHalloween) {
            background = ImageIO.read(new File(HALLOWEEN_IMAGE));
         } else {
            background = ImageIO.read(new File(BACKGROUND_IMAGE));
         }

         gg.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this);

      } catch (IOException ex) {
         Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
      }

   }

   /**
    * * End initialization helper methods ************************************
    */
}
