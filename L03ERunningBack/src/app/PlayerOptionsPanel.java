package app;

import java.awt.GridBagConstraints;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.logging.Level;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import players.Runningback;

/**
 * The PlayerOptionsPanel class is a container for PlayerTraitButtons and other
 * player and game-related settings.
 *
 */
public class PlayerOptionsPanel extends BasePanel {

   private GamePanel gamePanel;
   private Runningback rb;

   private final String HALLOWEEN_BUTTON_LOCATION = "resources/buttons/pumpkin.png";

   public PlayerOptionsPanel(GamePanel gamePanel) {
      super("Options");

      this.gamePanel = gamePanel;
      this.rb = gamePanel.getRunningback();

      createButtonGroup();
      createPumpkinButton();
   }

   /**
    * Helper methods to create the group of buttons.
    */
   private void createButtonGroup() {

      ButtonGroup buttonGroup = new ButtonGroup();
      OptionButton button;

      // agile trait
      button = createButton("agile", "Makes the player harder to tackle", buttonGroup);
      button.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            rb.setAgile(e.getStateChange() == ItemEvent.SELECTED);
            gamePanel.returnFocus();
         }
      });

      // fast trait
      button = createButton("fast", "Increases the player's speed", buttonGroup);
      button.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            rb.setFast(e.getStateChange() == ItemEvent.SELECTED);
            gamePanel.returnFocus();
         }
      });

      // lucky trait
      button = createButton("lucky", "Gives the player a chance to evade a tackle", buttonGroup);
      button.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            rb.setLucky(e.getStateChange() == ItemEvent.SELECTED);
            gamePanel.returnFocus();
         }
      });

      // Perceptive trait
      button = createButton("perceptive", "Makes the player harder to chase", buttonGroup);
      button.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            rb.setPerceptive(e.getStateChange() == ItemEvent.SELECTED);
            gamePanel.returnFocus();
         }
      });

      // No special traits
      button = createButton("none", "Unsets all special traits.", buttonGroup);
      button.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            // no-op
            // when the button is clicked the others will automatically be deselected
            gamePanel.returnFocus();
         }
      });

   }

   /**
    * Helper method to create a single OptionButton
    *
    * @param label the label
    * @param toolTip the tooltip
    * @param bg the ButtonGroup to which the button should be added
    * @return the new button
    */
   private OptionButton createButton(String label, String toolTip, ButtonGroup bg) {

      GridBagConstraints gbc = getDefaultGridBagConstraints();
      gbc.gridx++;

      OptionButton button = new OptionButton(label, toolTip);
      add(button, gbc);
      bg.add(button);

      return button;
   }

   /**
    * Creates the halloween toggle.
    */
   private void createPumpkinButton() {
      ImageIcon icon = new ImageIcon(HALLOWEEN_BUTTON_LOCATION);

      GridBagConstraints gbc = getDefaultGridBagConstraints();
      gbc.gridx++;

      OptionButton button = new OptionButton(icon, "Toggle Halloween mode");
      add(button, gbc);

      button.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            boolean isHalloween = (e.getStateChange() == ItemEvent.SELECTED);
            gamePanel.setHalloween(isHalloween);
         }
      });

   }

}
