package game;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The RunningbackModel class represents a football runningback with traits
 * that opponents do not have. It provides methods to set these traits and 
 * calculate the new position when evading a tackle.
 *
 */
public class RunningbackModel extends PlayerModel {

   private boolean fast;
   private boolean agile;
   private boolean lucky;
   private boolean perceptive;

   private final String TRAIT_LOG_FORMAT = "Trait %s changed: %b";
   private final static Logger logger = Logger.getLogger("RunningbackModel");

   public RunningbackModel(String iconLocation) {
      super(iconLocation);

      fast = false;
      agile = false;
      lucky = false;
      perceptive = false;
   }

   /**
    * Tests the player's fast trait.
    * 
    * @return true if fast, false otherwise
    */
   public boolean isFast() {
      return fast;
   }

   /**
    * Sets the player's fast trait.
    * @param fast true if fast, false otherwise
    */
   public void setFast(boolean fast) {
      this.fast = fast;
      if (fast) {
         setMoveDistance(getMoveDistance() * 2);
      } else {
         setMoveDistance(getMoveDistance() / 2);
      }

      logger.log(Level.INFO, String.format(TRAIT_LOG_FORMAT, "fast", fast));
   }

   /**
    * Tests the player's agile trait.
    * 
    * @return true if agile, false otherwise
    */
   public boolean isAgile() {
      return agile;
   }

   /**
    * Sets the player's agile trait.
    * 
    * @param agile true if agile, false otherwise
    */
   public void setAgile(boolean agile) {
      this.agile = agile;
      logger.log(Level.INFO, String.format(TRAIT_LOG_FORMAT, "agile", agile));
   }

   /**
    * Tests the player's lucky trait
    * 
    * @return true if lucky, false otherwise
    */
   public boolean isLucky() {
      return lucky;
   }

   /**
    * Sets the player's lucky trait
    * 
    * @param lucky true if lucky, false otherwise
    */
   public void setLucky(boolean lucky) {
      this.lucky = lucky;
      logger.log(Level.INFO, String.format(TRAIT_LOG_FORMAT, "lucky", lucky));
   }

   /**
    * Tests the player's perceptive trait
    * 
    * @return true if perceptive, false otherwise
    */
   public boolean isPerceptive() {
      return perceptive;
   }

   /**
    * Sets the player's perceptive trait.
    * 
    * @param perceptive true if perceptive, false otherwise
    * 
    */
   public void setPerceptive(boolean perceptive) {
      this.perceptive = perceptive;
      logger.log(Level.INFO, String.format(TRAIT_LOG_FORMAT, "perceptive", perceptive));
   }

   /**
    * Advances the player toward the goal if an attempt to tackle fails.
    */
   public void evadeTackle() {
      setLocation((int) getBounds().getX() + 100, (int) getBounds().getY());

   }
}
