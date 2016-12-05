package game;

import java.awt.GridBagConstraints;
import javax.swing.JSlider;

/**
 * The SpeedPanel class provides a slider to change the game's speed.
 * 
 */
public class SpeedPanel extends BasePanel {
   
   private final JSlider speedControl;

   public SpeedPanel() {
      super("Speed");
            
      // add the slider
      speedControl = new JSlider(JSlider.HORIZONTAL);
      speedControl.setSnapToTicks(true);
      speedControl.setBackground(this.getBackground());
      GridBagConstraints gbc = getDefaultGridBagConstraints();
      add(speedControl, gbc);      
   }

   /**
    * Configures the slider's limits and number of levels (inclusive of limits).
    * 
    * @param min the minimum speed
    * @param max  the maximum speed
    * @param levels the number of speeds available
    */
   public void setRange(int min, int max, int levels) {
      speedControl.setMinimum(min);
      speedControl.setMaximum(max);
      speedControl.setMajorTickSpacing(levels);
   }
   
   /**
    * Sets the slider position.
    * 
    * This should only be used when changing the slider's range.
    * 
    * @param index new position
    */
   public void setSliderPosition(int index) {
      speedControl.setValue(index);
   }
   
   /**
    * Returns the slider component.
    * 
    * @return the slider componenet.
    */
   public JSlider getSlider() {
      return speedControl;
   }

   @Override
   public void setAlternateUI(boolean alternate) {
      // no-op
   }
   
}
