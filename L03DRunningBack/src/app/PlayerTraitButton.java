package app;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import players.PlayerTraits;
import players.Runningback;

/**
 * The PlayerTraitButton class provides a mechanism for setting a player trait.
 *
 */
public class PlayerTraitButton extends JButton {

   private Color BORDER_COLOR = new Color(192, 197, 209);
   
   private final PlayerTraits trait;
   private final Runningback rb;

   public PlayerTraitButton(String label, PlayerTraits trait, Runningback rb) {
      super(label);
      
      this.trait = trait;
      this.rb = rb;
      setAppearance();

   }

   /**
    * Sets the trait associated with this button.
    */
   public void setTrait() {
       rb.setTrait(trait);
       setActiveAppearance(true);
   }
   
   /**
    * Sets the button's appearance to selected or unselected.
    * 
    * @param isActive 
    */
   public void setActiveAppearance(boolean isActive) {
      setContentAreaFilled(isActive);
   }
   
   private void setAppearance() {
      LineBorder border = new LineBorder(BORDER_COLOR, 1, true);
      setBorder(border);
      setBackground(new Color(255, 255, 255, 200));
      setContentAreaFilled(false);
      setVisible(true);
   }
}
