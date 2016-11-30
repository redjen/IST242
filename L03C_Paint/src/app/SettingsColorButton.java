package app;

import java.awt.Color;

/**
 * The SettingsColorButton provides a control for changing the drawing color.
 * 
 */
public class SettingsColorButton extends SettingsButton {
   
   private Color color;

   public SettingsColorButton(Color color) {
      super(" ");
      
      this.color = color;
      
      setBackground(color);       
   }
   
   
   @Override
   public void performAction(DrawPanel drawPanel) {
      drawPanel.setColor(color);
   }

 

}
