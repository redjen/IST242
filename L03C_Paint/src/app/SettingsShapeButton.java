package app;

import settings.DrawShape;

/**
 * The SettingsShapeButton class provides a control for selecting the
 * shape to be drawn.
 * 
 * Shapes are defined in DrawShape.
 * 
 */
public class SettingsShapeButton extends SettingsButton {
   
   private DrawShape shape;

   public SettingsShapeButton(DrawShape shape) {
      super(shape.toString().toLowerCase());
      
      this.shape = shape;
   }
   
   @Override
   public void performAction(DrawPanel drawPanel) {
      drawPanel.setShape(shape);
   }

}
