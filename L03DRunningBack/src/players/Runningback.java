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

   private final int DEFAULT_SPEED = 5;
   private final int DEFAULT_FAST_SPEED = 10;

   private HashMap<String, Boolean> traits;

   private Logger logger = Logger.getLogger("runningback");

   public Runningback(int startX, int startY) {
      super(DEFAULT_ICON_LOCATION, startX, startY);

      traits = new HashMap<>();
      initTraits();
   }

   public Runningback() {
      this(0, 0);
   }

   /**
    * Gets the status of the specified trait.
    * 
    * @param trait the trait name
    * @return true if the trait is set, other wise false
    */
   public boolean getTrait(PlayerTraits trait) {
      return traits.get(trait.toString());
   }

   /**
    * Sets the player's specified trait.
    * 
    * Traits may alter the player's appearance, speed, or other qualities.
    * Refer to PlayerTraits for the list of available traits.
    * @param trait 
    */
   public void setTrait(PlayerTraits trait) {
      // only one trait at a time, so unset all
      setMoveDistance(DEFAULT_SPEED);
      setSmall(false);
      
      for (String s : traits.keySet()) {
         traits.put(s, false);
      }

      switch (trait) {
         case AGILE:
            traits.put(trait.toString(), true);
            setSmall(true);
            break;
         case FAST:
            traits.put(trait.toString(), true);
            setMoveDistance(DEFAULT_FAST_SPEED);
            break;
         case LUCKY:
         case PERCEPTIVE:
            traits.put(trait.toString(), true);
            break;
         case NONE:
            // no-op; traits already unset
            break;
      }

      logger.log(Level.INFO, "Set trait: " + trait.toString());
   }

   /**
    * Sets Halloween display.
    * 
    * @param isHalloween true for Hallween mode, otherwise false
    */
   public void setHalloween(boolean isHalloween) {
      if (isHalloween) {
         setIcon(new ImageIcon(HALLOWEEN_ICON_LOCATION));
      } else {
         setIcon(new ImageIcon(DEFAULT_ICON_LOCATION));
      }
   }

   private void initTraits() {
      traits.put(PlayerTraits.LUCKY.toString(), false);  // chance to evade a tackle
      traits.put(PlayerTraits.FAST.toString(), false);   // faster move speed
      traits.put(PlayerTraits.AGILE.toString(), false);  // smaller
      traits.put(PlayerTraits.PERCEPTIVE.toString(), false); // harder for opponents to follow
   }

}
