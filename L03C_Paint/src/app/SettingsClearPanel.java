package app;

import java.awt.GridBagConstraints;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;

/**
 * The SettingsClearPanel class provides the ability to clear the drawing area.
 *
 */
public class SettingsClearPanel extends SettingsPanel {

   public SettingsClearPanel(DrawPanel drawPanel) throws HeadlessException {
      super("Actions", drawPanel);
      createButtons();
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      Object o = e.getSource();

      if (o.getClass() == SettingsClearButton.class) {
         SettingsClearButton button = (SettingsClearButton) o;
         button.performAction(getDrawPanel());
      }
   }

   @Override
   public void createButtons() {
      GridBagConstraints gbc = getDefaultGridBagConstraints();

      SettingsClearButton button = new SettingsClearButton("clear");
      add(button, gbc);
      button.addActionListener(this);

   }
}
