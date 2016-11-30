package app;

import java.awt.GridBagConstraints;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import settings.DrawShape;

/**
 * The SettingsShapePanel class provides controls for changing the shape
 * that will be drawn.
 * 
 */
public class SettingsShapePanel extends SettingsPanel {

   public SettingsShapePanel(DrawPanel drawPanel) throws HeadlessException {
      super("Shapes", drawPanel);
      
      createButtons();
   }
     

   @Override
   public void actionPerformed(ActionEvent e) {
      
      Object o = e.getSource();
      
      if (o.getClass() == SettingsShapeButton.class) {
         SettingsShapeButton button = (SettingsShapeButton) o;
         button.performAction(getDrawPanel());
      }
   }

   @Override
   public void createButtons() {
      
      GridBagConstraints gbc = getDefaultGridBagConstraints();
      SettingsShapeButton button = null;

      for (DrawShape shape : DrawShape.values()) {
         button = new SettingsShapeButton(shape);
         add(button, gbc);
         button.addActionListener(this);
         gbc.gridx++;
      }
   }

}
