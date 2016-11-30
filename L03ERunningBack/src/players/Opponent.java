package players;

import java.awt.Point;
import javax.swing.ImageIcon;

/**
 * The Opponent class represents the game opponents, who chase and attempt
 * to tackle the player.
 *
 */
public class Opponent extends Player {

   private static final String DEFAULT_ICON_LOCATION = "resources/players/uw.png";
   private static final String HALLOWEEN_ICON_LOCATION = "resources/players/ghost.png";

   public Opponent(int startX, int startY) {
      super(DEFAULT_ICON_LOCATION, startX, startY);

   }
   
   public Opponent() {
       this(0,0);
   }

   /**
    * Advances the player toward the runningback.
    * 
    * Since the player can only move in 8 directions, it seems fair to 
    * limit the opponents as well.
    *
    * @param rbLoc runningback's location
    */
   public void chase(Point rbLoc) {

      int x = (int) getLocation().getX();
      int y = (int) getLocation().getY();

      // East
      if (x < rbLoc.getX()) {

         // South
         if (y < rbLoc.getY()) {
            move(Direction.SOUTHEAST);
            
         // North
         } else {
            move(Direction.NORTHEAST);
         }

      // West
      } else {

         // South
         if (y < rbLoc.getY()) {
            move(Direction.SOUTHWEST);
            
         // North
         } else {
            move(Direction.NORTHWEST);
         }
      }

   }
   
   /**
    * Sets Halloween mode.
    * 
    * @param isHalloween true for Halloween appearance, false otherwise
    */
      public void setHalloween(boolean isHalloween) {
       if (isHalloween) {
           setIcon(new ImageIcon(HALLOWEEN_ICON_LOCATION));
       } else {
           setIcon(new ImageIcon(DEFAULT_ICON_LOCATION));
       }
   }
   
}
