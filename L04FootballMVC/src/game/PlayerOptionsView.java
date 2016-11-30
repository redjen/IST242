package game;

import java.awt.GridBagConstraints;
import javax.swing.ButtonGroup;

/**
 *
 * The PlayerOptionsView provides controls for changing player and game options.
 */
public class PlayerOptionsView extends BasePanel {
    
   private final PlayerOptionButton agileButton;
   private final PlayerOptionButton fastButton;
   private final PlayerOptionButton luckyButton;
   private final PlayerOptionButton perceptiveButton;
   private final PlayerOptionButton noneButton;
   
   
   public PlayerOptionsView() {
      super("Options");
          
      ButtonGroup buttonGroup = new ButtonGroup();
      agileButton = createButton("agile", "Makes the player harder to tackle", buttonGroup);
      fastButton = createButton("fast", "Increases the player's speed", buttonGroup);
      luckyButton = createButton("lucky", "Gives the player a chance to evade a tackle", buttonGroup);
      perceptiveButton = createButton("perceptive", "Makes the player harder to chase", buttonGroup);
      noneButton = createButton("none", "Unsets all special traits.", buttonGroup);
   }

   public PlayerOptionButton getAgileButton() {
      return agileButton;
   }

   public PlayerOptionButton getFastButton() {
      return fastButton;
   }

   public PlayerOptionButton getLuckyButton() {
      return luckyButton;
   }

   public PlayerOptionButton getPerceptiveButton() {
      return perceptiveButton;
   }

   public PlayerOptionButton getNoneButton() {
      return noneButton;
   }
   
   

   /**
    * Helper method to create a single PlayerOptionButton
    *
    * @param label the label
    * @param toolTip the tooltip
    * @param bg the ButtonGroup to which the button should be added
    * @return the new button
    */
   private PlayerOptionButton createButton(String label, String toolTip, ButtonGroup bg) {

      GridBagConstraints gbc = getDefaultGridBagConstraints();
      gbc.gridx++;

      PlayerOptionButton button = new PlayerOptionButton(label, toolTip);
      add(button, gbc);
      bg.add(button);

      return button;
   }

   @Override
   public void setAlternateUI(boolean alternate) {
      // no-op
   }
}
