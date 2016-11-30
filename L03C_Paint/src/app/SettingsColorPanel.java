package app;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;

/**
 * The SettingsColorPanel class represents a group of color controls.
 *
 */
public class SettingsColorPanel extends SettingsPanel {

   private final Color[] BUTTON_COLORS = {Color.black, Color.red, Color.orange,
      Color.yellow, Color.green, Color.BLUE, Color.pink};

   public SettingsColorPanel(DrawPanel drawPanel) throws HeadlessException {
      super("Colors", drawPanel);
      createButtons();
   }

   @Override
   public void createButtons() {

      GridBagConstraints gbc = getDefaultGridBagConstraints();
      
      SettingsColorButton button = null;

      for (Color buttonColor : BUTTON_COLORS) {
         button = new SettingsColorButton(buttonColor);
         add(button, gbc);
         button.addActionListener(this);
         
         gbc.gridx++;
      }
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      Object o = e.getSource();

      if (o.getClass() == SettingsColorButton.class) {
         SettingsColorButton button = (SettingsColorButton) o;
         button.performAction(getDrawPanel());
      } 

   }
}
