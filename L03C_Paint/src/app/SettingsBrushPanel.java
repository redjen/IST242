package app;

import java.awt.GridBagConstraints;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import settings.DrawBrush;

/**
 * The SettingsBrushPanel provides the controls to change the brush used for
 * drawing.
 *
 */
public class SettingsBrushPanel extends SettingsPanel {
   
   public SettingsBrushPanel(DrawPanel drawPanel) throws HeadlessException {
      super("Sketching brush type", drawPanel);

      createButtons();
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      Object o = e.getSource();

      if (o.getClass() == SettingsBrushButton.class) {
         SettingsBrushButton button = (SettingsBrushButton) o;
         button.performAction(getDrawPanel());
      } 
   }

   @Override
   public void createButtons() {
      GridBagConstraints gbc = getDefaultGridBagConstraints();
      SettingsBrushButton button = null;

      for (DrawBrush brush : DrawBrush.values()) {
         button = new SettingsBrushButton(brush);
         add(button, gbc);
         button.addActionListener(this);
         gbc.gridx++;
      }
   }

}
