package players;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * The Player class represents a basic football player which the user
 * can control with the keyboard.
 *
 */
public class Player extends JButton {

   private int moveDistance;

   private final int DEFAULT_MOVE_DISTANCE = 5;
   private final int DEFAULT_WIDTH = 50;
   private final int DEFAULT_HEIGHT = 50;
   private final int SMALL_WIDTH = 40;
   private final int SMALL_HEIGHT = 40;

   public Player(String iconLocation, int startX, int startY) {

      super(new ImageIcon(iconLocation));

      this.moveDistance = DEFAULT_MOVE_DISTANCE;
      setAppearance();
      setBounds(startX, startY, DEFAULT_WIDTH, DEFAULT_HEIGHT);

   }

   public Player(String iconLocation) {
      this(iconLocation, 0, 0);
   }

   /**
    * Moves the player in the specified direction.
    * 
    * @param d the Direction in which to move
    */
   public void move(Direction d) {

      int x = (int) getLocation().getX();
      int y = (int) getLocation().getY();

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

      setLocation(x, y);

   }

   /**
    * Advances the player toward the goal if an attempt to tackle fails.
    */
   public void evadeTackle() {
      setLocation((int) getLocation().getX() + 100, (int) getLocation().getY());
   }
   
   /**
    * Returns the distance the player travel on each turn.
    * 
    * @return the distance
    */
   public int getMoveDistance() {
      return moveDistance;
   }

   /**
    * Sets the number of pixels the player moves during each turn
    * 
    * @param moveDistance the number of pixels
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
         setSize(SMALL_WIDTH, SMALL_HEIGHT);
      } else {
         setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
      }
   }

   private void setAppearance() {
      setOpaque(false);
      setContentAreaFilled(false);
      setBorderPainted(false);
      
      // the game will need to show and hide the players
      setVisible(true);
   }
}
