package game;

import java.awt.Rectangle;
import java.util.Calendar;
import java.util.Observable;
import java.util.Random;
import java.util.Set;
import java.util.logging.Logger;

/**
 * The GameModel class is the model for the game.
 *
 */
public class GameModel extends Observable {

   /* Field size */
   private Rectangle field;
   private Rectangle endZone;
   private final double FIELD_START_X_SCALE = 0.025;
   private final double FIELD_START_Y_SCALE = 0.054;
   private final double FIELD_WIDTH_SCALE = 0.9475;
   private final double FIELD_HEIGHT_SCALE = 0.8891;
   private final double END_ZONE_X_SCALE = 0.895;

   /* Score */
   private int touchdownScore;
   private int tackleScore;

   /* Clock */
   private Calendar clock;

   /* Speed */
   private final int[] SPEEDS = {1000, 500, 200, 100, 50};
   private final int DEFAULT_SPEED = 2;
   private int speed;

   /* Mode */
   private boolean challengeMode;

   /* Threshold at which a runningback trait is triggered */
   private final int TRAIT_TRIGGER_THRESHOLD = 95;

   private final String LOG_MESSAGE_FORMAT = "%s changed to %b";
   private final static Logger logger = Logger.getLogger("GameModel");

   public GameModel() {
      super();

      field = new Rectangle();
      endZone = new Rectangle();
      challengeMode = false;

      // initialize the score to 0
      resetScore();

      // initialize the time to 0
      clock = Calendar.getInstance();
      resetClock();

      // set the game speed to the default
      speed = SPEEDS[DEFAULT_SPEED];
   }

   /**
    * Tests whether challenge mode is enabled.
    *
    * @return true if enabled, false otherwise
    */
   public boolean isChallengeMode() {
      return challengeMode;
   }

   /**
    * Sets challenge mode.
    *
    * @param challengeMode true for enabled, false for disabled
    */
   public void setChallengeMode(boolean challengeMode) {
      this.challengeMode = challengeMode;
      logger.info(String.format(LOG_MESSAGE_FORMAT, "Challenge mode", challengeMode));
   }

   /**
    * Return the current number of touchdowns.
    *
    * @return the current number of touchdowns
    */
   public int getTouchdownScore() {
      return touchdownScore;
   }

   /**
    * Increase the current touchdown count by one.
    */
   public void incrementTouchdownScore() {
      touchdownScore++;
      notifyObservers();
   }

   /**
    * Returns the current number of tackles.
    *
    * @return the current number of tackles
    */
   public int getTackleScore() {
      return tackleScore;
   }

   /**
    * Increases the current tackle count by one.
    */
   public void incrementTackleScore() {
      tackleScore++;
      notifyObservers();
   }

   /**
    * Resets the scores to 0.
    */
   public void resetScore() {
      touchdownScore = 0;
      tackleScore = 0;
      notifyObservers();
   }

   /**
    * Gets the current time.
    *
    * @return clock
    */
   public Calendar getClock() {
      return clock;
   }

   /**
    * Resets the clock to 0.
    */
   public void resetClock() {
      clock.set(0, 0, 0, 0, 0, 0);
      notifyObservers();
   }

   /**
    * Adds a second to the clock
    */
   public void tickClock() {
      clock.add(Calendar.SECOND, 1);
      notifyObservers();
   }

   /**
    * Returns the available speed levels.
    *
    * @return the array of speed levels
    */
   public int[] getSpeeds() {
      return SPEEDS;
   }

   public int getSpeed() {
      return speed;
   }

   /**
    * Set the game's speed.
    *
    * @param index the number corresponding to the speed level
    */
   public void setSpeed(int index) {
      if (index < 0 || index >= SPEEDS.length) {
         String message = String.format("Invalid speed [%d] requested.", index);
         logger.warning(message);
         throw new IllegalArgumentException(message);
      }

      speed = SPEEDS[index];
   }

   /**
    * Returns the threshold at which a player's trait should be triggered.
    *
    * This number represents a percent chance of success. If the threshold is
    * 90, then the trait should be expressed when the random number it's
    * compared against is greater than 90—a 10% chance.
    *
    * @return the threshold
    */
   public int getTraitTriggerThreshold() {
      return TRAIT_TRIGGER_THRESHOLD;
   }

   /**
    * Tests for a tackle, defined as any opponent intersecting with the
    * runningback.
    *
    * @param runningback the runningback model
    * @param opponents the set of opponents
    * @return true if a tackle occurred, false otherwise
    */
   public boolean detectTackleEvent(RunningbackModel runningback, Set<PlayerModel> opponents) {
      for (PlayerModel opponent : opponents) {
         if (opponent.getBounds().intersects(runningback.getBounds())) {

            int evadeChance = 0;
            if (runningback.isLucky()) {
               Random rand = new Random();
               evadeChance = rand.nextInt(100);
            }

            if (evadeChance > TRAIT_TRIGGER_THRESHOLD) {
               runningback.evadeTackle();
               return false;
            } else {
               return true;
            }

         }
      }

      return false;
   }

   public boolean detectTouchdownEvent(Rectangle position) {
      return (position.intersects(endZone));
   }

   public void setFieldBoundaries(int viewWidth, int viewHeight) {

      int startX = (int) (viewWidth * FIELD_START_X_SCALE);
      int startY = (int) (viewHeight * FIELD_START_Y_SCALE);
      int width = (int) (viewWidth * FIELD_WIDTH_SCALE);
      int height = (int) (viewHeight * FIELD_HEIGHT_SCALE);
      int endZoneX = (int) (viewWidth * END_ZONE_X_SCALE);

      field.setBounds(startX, startY, width, height);
      endZone.setBounds(endZoneX, startY, viewWidth - endZoneX, height);

   }

   public Rectangle getFieldBounds() {
      return field;
   }

   public Rectangle getEndZoneBounds() {
      return endZone;
   }
}
