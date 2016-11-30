package players;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 * The Runningback class represents the player in the game. 
 * 
 * The runningback is controlled through keyboard commands in the game panel.
 * 
 * It can have a number of traits associated with it as specified in the
 * PlayerTraits enum. Only one may be active at a time. Trait status can be
 * checked and used in other classes to alter how other classes interact with
 * the Runningback.
 * 
 * These traits are implemented:
 * 
 * Agile:      reduces the player's size, making it harder to be tackled
 * Fast:       increases the distance the player moves per turn
 * Luck:       provides a small chance to escape a tackle
 * Perceptive: makes the player harder for opponents to track
 * None:       no traits enabled
 * 
 *
 */
public class Runningback extends Player {

   private static final String DEFAULT_ICON_LOCATION = "resources/players/psu.png";
   private static final String HALLOWEEN_ICON_LOCATION = "resources/players/pumpkin.png";
   private final String TRAIT_LOG_FORMAT = "Trait %s changed: %b";
   
   private final int DEFAULT_MOVE_DISTANCE = 10;
   private final int FAST_MOVE_DISTANCE = 20;
   
   private boolean fast;
   private boolean agile;
   private boolean lucky;
   private boolean perceptive;
   private Logger logger = Logger.getLogger("runningback");

   public Runningback(int startX, int startY) {
      super(DEFAULT_ICON_LOCATION, startX, startY);
      
      agile = false;
      fast = false;
      lucky = false;
      perceptive = false;

      // the runningback has to move a little faster than the opponents to be able to win.
      setMoveDistance(DEFAULT_MOVE_DISTANCE);
   }

   public Runningback() {
      this(0, 0);
   }

   public boolean isFast() {
      return fast;
   }

   public void setFast(boolean fast) {
      this.fast = fast;
      if(fast) {
         setMoveDistance(FAST_MOVE_DISTANCE);
      } else {
         setMoveDistance(DEFAULT_MOVE_DISTANCE);
      }
      
      logger.log(Level.INFO, String.format(TRAIT_LOG_FORMAT, "fast", fast));
   }

   public boolean isAgile() {
      return agile;
   }

   public void setAgile(boolean agile) {
      this.agile = agile;
      logger.log(Level.INFO, String.format(TRAIT_LOG_FORMAT, "agile", agile));
   }

   public boolean isLucky() {
      return lucky;
   }

   public void setLucky(boolean lucky) {
      this.lucky = lucky;
      logger.log(Level.INFO, String.format(TRAIT_LOG_FORMAT, "lucky", lucky));
   }

   public boolean isPerceptive() {
      return perceptive;
   }

   public void setPerceptive(boolean perceptive) {
      this.perceptive = perceptive;
      logger.log(Level.INFO, String.format(TRAIT_LOG_FORMAT, "perceptive", perceptive));
   }

   
   /**
    * Sets Halloween display.
    * 
    * @param isHalloween true for Halloween mode, otherwise false
    */
   public void setHalloween(boolean isHalloween) {
      if (isHalloween) {
         setIcon(new ImageIcon(HALLOWEEN_ICON_LOCATION));
      } else {
         setIcon(new ImageIcon(DEFAULT_ICON_LOCATION));
      }
   }

   
   

}
