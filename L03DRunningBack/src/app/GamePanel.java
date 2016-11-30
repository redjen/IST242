package app;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLayeredPane;
import javax.swing.Timer;
import players.Direction;
import players.Opponent;
import players.PlayerTraits;
import players.Runningback;

/**
 * The GamePanel class displays and controls a football game with one runningback,
 * and two opponents. The user controls the runningback through keyboard commands.
 *
 */
public class GamePanel extends JLayeredPane implements ActionListener, KeyListener {

   private static final String BACKGROUND_IMAGE = "resources/field/football_field.png";
   private static final String HALLOWEEN_IMAGE = "resources/field/halloween.jpg";

   private Timer timer;
   private final int[] SPEEDS = {1000, 500, 200, 100, 50};
   private final int DEFAULT_SPEED = 3;
   private int speed;

   private ScorePanel scorePanel;
   private ClockPanel clockPanel;
   private MainAppPanel mainAppPanel; // for Halloween mode
   private MessageLabel message;

   private Runningback rb;
   private Opponent opp1;
   private Opponent opp2;

   private final int TRAIT_TRIGGER_THRESHOLD = 95;
   private final double RUNNINGBACK_START_X_PCT = .33;
   private final double RUNNINGBACK_START_Y_PCT = .50;
   private final double OPPONENT_START_X_PCT = .66;
   private final double OPPONENT_START_Y_PCT = .33;

   private GameState state;

   private boolean isHalloween = false;

   private Logger logger = Logger.getLogger("GamePanel");

   public GamePanel(ScorePanel scorePanel, ClockPanel clockPanel, MainAppPanel mainAppPanel) {

      super();

      this.scorePanel = scorePanel;
      this.clockPanel = clockPanel;
      this.mainAppPanel = mainAppPanel;
      this.speed = SPEEDS[DEFAULT_SPEED];
      timer = new Timer(speed, this);

      setLayout(null);

      addKeyListener(this);
      setFocusable(true);

      state = GameState.WELCOME;

      initPlayers();
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

      logger.log(Level.INFO, "Speed changed to: " + speed);
      this.speed = SPEEDS[speedLevel - 1];
      timer.setDelay(speed);
   }

   /**
    * Turns the Halloween appearance off and on.
    */
   public void toggleHalloween() {

      if (isHalloween) {
         isHalloween = false;
      } else {
         isHalloween = true;
      }

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

   @Override
   public void actionPerformed(ActionEvent e) {
      Object o = e.getSource();

      if (o == timer) {

         int evadeChance = 0;
         if (rb.getTrait(PlayerTraits.PERCEPTIVE)) {
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
            logger.log(Level.INFO, "Agililty triggered");
         }

         detectScoreEvent();
      }

   }

   @Override
   public void paintComponent(Graphics gg) {
      super.paintComponent(gg);
      requestFocusInWindow();

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
    * Creates the players and places them on the field.
    */
   private void initPlayers() {

      rb = new Runningback();
      opp1 = new Opponent();
      opp2 = new Opponent();

      setLayer(rb, 0);
      add(rb);

      setLayer(opp1, 1);
      add(opp1);

      setLayer(opp2, 2);
      add(opp2);

      message = new MessageLabel();
      setLayer(message, 3);
      add(message);

   }

   /**
    * Starts the game.
    *
    * This method must be called to start the timers and allow the user to move
    * the player.
    *
    */
   private void startGame() {

      if (state == GameState.WELCOME) {
         clockPanel.resetClock();
         scorePanel.reset();
      }

      int fieldWidth = getWidth();
      int fieldHeight = getHeight();

      message.hideMessage();

      rb.setLocation((int) (fieldWidth * RUNNINGBACK_START_X_PCT), (int) (fieldHeight * RUNNINGBACK_START_Y_PCT));
      opp1.setLocation((int) (fieldWidth * OPPONENT_START_X_PCT), (int) (fieldHeight * OPPONENT_START_Y_PCT));
      opp2.setLocation((int) (fieldWidth * OPPONENT_START_X_PCT), (int) (fieldHeight * OPPONENT_START_Y_PCT * 2));

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
    * Resumes the game.
    */
   private void resumeGame() {
      clockPanel.startClock();
      timer.start();
      state = GameState.RUNNING;
   }

   /**
    * Stops the clock and repositions the players for another round of play.
    */
   private void startNewRound() {
      int fieldWidth = getWidth();
      int fieldHeight = getHeight();

      clockPanel.stopClock();
      timer.stop();

      rb.setLocation((int) (fieldWidth * RUNNINGBACK_START_X_PCT), (int) (fieldHeight * RUNNINGBACK_START_Y_PCT));
      opp1.setLocation((int) (fieldWidth * OPPONENT_START_X_PCT), (int) (fieldHeight * OPPONENT_START_Y_PCT));
      opp2.setLocation((int) (fieldWidth * OPPONENT_START_X_PCT), (int) (fieldHeight * OPPONENT_START_Y_PCT * 2));

      state = GameState.STOPPED;
   }

   /**
    * Ends the game.
    *
    * Calling this method ends the game. Starting a new game will reset the
    * scores, clock, etc.
    */
   private void endGame() {
      clockPanel.stopClock();
      timer.stop();
      state = GameState.WELCOME;
      message.showMessage(MessageLabel.GAME_OVER);
      message.setBounds(0, getHeight() / 4, getWidth(), getHeight() / 2);

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
            case WELCOME:
            case STOPPED:
               startGame();
               break;
            case RUNNING:
               pauseGame();
               break;
            case PAUSED:
               resumeGame();
               break;
         }
      } else if (key == KeyEvent.VK_ESCAPE) {
         endGame();
      } else if (state == GameState.RUNNING) {
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

            if (rb.getTrait(PlayerTraits.LUCKY)) {
               Random rand = new Random();
               evadeChance = rand.nextInt(100);
            }

            if (evadeChance > TRAIT_TRIGGER_THRESHOLD) {
               pauseGame();
               rb.evadeTackle();
               logger.log(Level.INFO, "tackle evaded");
               resumeGame();
            } else {
               scorePanel.addMiss();
               message.showMessage(MessageLabel.TACKLE);
               message.setBounds(0, getHeight() / 4, getWidth(), getHeight() / 2);
               startNewRound();
            }
         }

         // touchdown
         if (rb.getLocation().getX() >= getWidth() * 0.88) {
            scorePanel.addTouchdown();
            message.showMessage(MessageLabel.TOUCHDOWN);
            message.setBounds(0, getHeight() / 4, getWidth(), getHeight() / 2);
            startNewRound();
         }
      }

   }

   private enum GameState {
      WELCOME,
      RUNNING,
      PAUSED,
      STOPPED
   }

   @Override
   public void keyTyped(KeyEvent e) {

      detectScoreEvent();
      keyHandler(e.getKeyCode());

   }

   @Override
   public void keyPressed(KeyEvent e) {

      detectScoreEvent();
      keyHandler(e.getKeyCode());
   }

   @Override
   public void keyReleased(KeyEvent e) {
      // no-op
   }
}
