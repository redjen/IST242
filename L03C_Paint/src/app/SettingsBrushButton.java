package app;

import settings.DrawBrush;

/**
 * The SettingsBrushButton is a button used to change the brush shape.
 * 
 */
public class SettingsBrushButton extends SettingsButton  {
   
   private DrawBrush brush;

   public SettingsBrushButton(DrawBrush brush) {
      super(brush.toString().toLowerCase());
      
      this.brush = brush;
   }
   
   

   @Override
   public void performAction(DrawPanel drawPanel) {
      drawPanel.setBrush(brush);
   }

}
