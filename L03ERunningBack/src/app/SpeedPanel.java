package app;

import java.awt.GridBagConstraints;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * The SpeedPanel class provides a slider to change the game's speed.
 *
 */
public class SpeedPanel extends BasePanel {

   private final GamePanel gamePanel;
   private final JSlider speedControl;
   private final int MIN_SPEED = 1;
   private final int MAX_SPEED = 5;
   private final int DEFAULT_SPEED = 3;

   public SpeedPanel(GamePanel gamePanel) {
      super("Speed");

      this.gamePanel = gamePanel;

      // add the slider
      speedControl = new JSlider(JSlider.HORIZONTAL, MIN_SPEED, MAX_SPEED, DEFAULT_SPEED);
      speedControl.setBackground(this.getBackground());
      GridBagConstraints gbc = getDefaultGridBagConstraints();
      add(speedControl, gbc);

      // add the listener that tells the game to update its speed.
      speedControl.addChangeListener(new ChangeListener() {
         @Override
         public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider) e.getSource();
            if (!source.getValueIsAdjusting()) {
               gamePanel.setSpeed(source.getValue());
            }
            gamePanel.returnFocus();
         }
      });

   }

   /**
    * Sets Halloween mode.
    *
    * @param isHalloween true for Halloween mode, false for normal.
    */
   @Override
   public void setHalloween(boolean isHalloween) {
      super.setHalloween(isHalloween);
      speedControl.setBackground(this.getBackground());
   }
}
