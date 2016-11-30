package game;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * The PlayerView class represents a football player depicted as an image.
 *
 */
public class PlayerView extends JButton {
   
   private String iconLocation;

   public PlayerView(String iconLocation) {
      super(new ImageIcon(iconLocation));
      
      this.iconLocation = iconLocation;
      
      setOpaque(true);
      setContentAreaFilled(false);
      setBorderPainted(false);

      // the game will need to show and hide the players
      setVisible(true);
   }
   
   /**
    * Sets the player's icon.
    * 
    * @param iconLocation the path to the icon file
    */
   public void changeIcon(String iconLocation) {
      this.iconLocation = iconLocation;
      repaint();
   }

}
