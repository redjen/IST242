package app;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import players.PlayerTraits;
import players.Runningback;

/**
 * The OptionsPanel class is a container for PlayerTraitButtons and other player
 * and game-related settings.
 *
 */
public class OptionsPanel extends BasePanel implements ActionListener {

   private GamePanel gamePanel;
   private Runningback rb;
   private ArrayList<PlayerTraitButton> traits;

   private final String HALLOWEEN_BUTTON_LOCATION = "resources/buttons/pumpkin.png";

   public OptionsPanel(GamePanel gamePanel) {
      super("Options");

      this.gamePanel = gamePanel;
      this.rb = gamePanel.getRunningback();

      traits = new ArrayList<>();
      createButtons();
      createPumpkinButton();
   }

   /**
    * Catches the button press and sets the selected trait.
    *
    * @param e ActionEvent button press
    */
   @Override
   public void actionPerformed(ActionEvent e) {
      Object o = e.getSource();
      if (o.getClass() == PlayerTraitButton.class) {
        
         for (PlayerTraitButton trait : traits) {
            trait.setActiveAppearance(false);
         }
         
         PlayerTraitButton btn = (PlayerTraitButton) o;
         btn.setTrait();
      } else {
         gamePanel.toggleHalloween();
      }
      gamePanel.returnFocus();
   }

   /**
    * Helper methods to create the buttons.
    */
   private void createButtons() {
      GridBagConstraints gbc = getDefaultGridBagConstraints();
      PlayerTraitButton btn;

      for (PlayerTraits trait : PlayerTraits.values()) {
         btn = new PlayerTraitButton(trait.toString().toLowerCase(), trait, rb);
         btn.setToolTipText(trait.getHelp());
         add(btn, gbc);
         btn.addActionListener(this);
         gbc.gridx++;
         traits.add(btn);
      }

   }

   /**
    * Creates the hallowwen toggle.
    */
   private void createPumpkinButton() {
      ImageIcon icon = new ImageIcon(HALLOWEEN_BUTTON_LOCATION);
      
      GridBagConstraints gbc = getDefaultGridBagConstraints();
      gbc.gridx++;
      gbc.fill = GridBagConstraints.NONE;

      JButton halloween = new JButton("");
      halloween.setIcon(icon);
      halloween.setBorder(null);
      halloween.setToolTipText("Toggle Halloween mode");

//      halloween.setSize(icon.getIconWidth(), icon.getIconHeight());
      halloween.setOpaque(false);
      halloween.setContentAreaFilled(false);
      halloween.setBorderPainted(false);
      halloween.setVisible(true);

      add(halloween, gbc);
      halloween.addActionListener(this);
      
   }

}
