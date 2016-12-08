package game;

import java.awt.Point;
import java.awt.Rectangle;

/**
 * The PlayerModel class is the model for a football player.
 *
 */
public class PlayerModel {
   // TODO perhaps this should implement button model and then the view could use it directly

   private final int DEFAULT_MOVE_DISTANCE = 5;
   private final int DEFAULT_WIDTH = 50;
   private final int DEFAULT_HEIGHT = 50;
   private final int SMALL_WIDTH = 40;
   private final int SMALL_HEIGHT = 40;

   private String iconLocation;
   private Rectangle bounds;
   private int moveDistance;

   public PlayerModel(String iconLocation, int moveDistanceWeight) {
      this.iconLocation = iconLocation;
      
      bounds = new Rectangle(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT);
      moveDistance = DEFAULT_MOVE_DISTANCE * moveDistanceWeight;
   }
   
   public PlayerModel(String iconLocation) {
      this(iconLocation, 1);
   }

   /**
    * Returns the path to the icon file.
    * 
    * @return the path as a string
    */
   public String getIconLocation() {
      return iconLocation;
   }

   /**
    * Sets the icon location file
    * 
    * @param iconLocation the new file
    */
   public void setIconLocation(String iconLocation) {
      this.iconLocation = iconLocation;
   }
   
   

   /**
    * Moves the player in the specified direction.
    *
    * @param d the Direction in which to move
    */
   public void move(Direction d) {

      int x = (int) bounds.getX();
      int y = (int) bounds.getY();

      switch (d) {
         case EAST:
            x += moveDistance;
            break;

         case NORTH:
            y -= moveDistance;
            break;

         case NORTHEAST:
            y -= moveDistance / 2;
            x += moveDistance / 2;
            break;

         case NORTHWEST:
            y -= moveDistance / 2;
            x -= moveDistance / 2;
            break;

         case SOUTH:
            y += moveDistance;
            break;

         case SOUTHEAST:
            y += moveDistance / 2;
            x += moveDistance / 2;
            break;

         case SOUTHWEST:
            y += moveDistance / 2;
            x -= moveDistance / 2;
            break;

         case WEST:
            x -= moveDistance;
            break;
      }

      bounds.setLocation(x, y);

   }

       /**
    * Advances the player toward the specified location.
    * 
    * Since the player can only move in 8 directions, it seems fair to 
    * limit the opponents as well.
    *
    * @param rbLoc the chased player's location
    */
   public void chase(Point rbLoc) {

      int x = (int) bounds.getX();
      int y = (int) bounds.getY();

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
    * Sets the player's position.
    * 
    * @param x horizontal position
    * @param y vertical position
    */
   public void setLocation(int x, int y) {
      bounds.setLocation(x, y);
   }
   
   /**
    * Returns the player's position on the field.
    *
    * @return the player's position
    */
   public Rectangle getBounds() {
      return bounds;
   }

   /**
    * Returns the distance the player moves on each turn.
    *
    * @return the distance
    */
   public int getMoveDistance() {
      return moveDistance;
   }

   /**
    * Sets the distance the player moves on each turn.
    *
    * @param moveDistance the distance
    */
   public void setMoveDistance(int moveDistance) {
      this.moveDistance = moveDistance;
   }
   
    /**
    * Reduces the size of the player, making them harder to catch.
    * 
    * @param small true for small size, otherwise false
    */
   public void setSmall(boolean small) {
      if (small) {
         bounds.setSize(SMALL_WIDTH, SMALL_HEIGHT);
      } else {
         bounds.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
      }
   }
   

}
