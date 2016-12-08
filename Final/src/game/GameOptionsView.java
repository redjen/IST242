package game;

import java.awt.GridBagConstraints;
import javax.swing.JSlider;

/**
 * The GameOptionsView class provides controls to change the game options.
 *
 */
public class GameOptionsView extends BasePanel {

   // Speed slider
   private final JSlider speedControl;

   // Challenge option
   private final PlayerOptionButton challengeButton;

   public GameOptionsView() {
      super("Game Options");
      
      // TODO label for the slider

      // add the slider
      speedControl = new JSlider(JSlider.HORIZONTAL);
      speedControl.setSnapToTicks(true);
      speedControl.setBackground(this.getBackground());
      GridBagConstraints gbc = getDefaultGridBagConstraints();
      add(speedControl, gbc);

      challengeButton = createButton("challenge mode",
              "Challenge: score as many touchdowns as you can before you're tackled.");
   }

   /**
    * Returns the challenge mode button.
    * 
    * @return challenge mode button
    */
   public PlayerOptionButton getChallengeButton() {
      return challengeButton;
   }

   /**
    * Configures the slider's limits and number of levels (inclusive of limits).
    *
    * @param min the minimum speed
    * @param max the maximum speed
    * @param levels the number of speeds available
    */
   public void setRange(int min, int max, int levels) {
      speedControl.setMinimum(min);
      speedControl.setMaximum(max);
      speedControl.setMajorTickSpacing(levels);
      speedControl.setFocusable(false);
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

   /**
    * Helper method to create a single PlayerOptionButton
    *
    * @param label the label
    * @param toolTip the tooltip
    * @return the new button
    */
   private PlayerOptionButton createButton(String label, String toolTip) {
      GridBagConstraints gbc = getDefaultGridBagConstraints();
      gbc.gridx++;

      PlayerOptionButton button = new PlayerOptionButton(label, toolTip);
      button.setFocusable(false);
      add(button, gbc);

      return button;
   }

}
