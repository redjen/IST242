package app;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

/**
 * The SettingsButton class represents
 *
 */
public abstract class SettingsButton extends JButton {

   private Color BACKGROUND_COLOR = new Color(199, 208, 212);
   private Color BORDER_COLOR = new Color(192, 197, 209);

   public SettingsButton(String label) {
      super(label);
      
      setAppearance();

   }

   /**
    * Triggers the action defined for the button.
    * 
    * @param drawPanel the drawing panel.
    */
   public abstract void performAction(DrawPanel drawPanel);
   
   private void setAppearance() {
      LineBorder border = new LineBorder(BORDER_COLOR, 1, true);
      setBorder(border);
      setBackground(BACKGROUND_COLOR);
      setOpaque(true);
      setVisible(true);
   }
}
