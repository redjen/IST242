package app;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * The MainAppPanel class is the main container for the application.
 *
 */
public class MainAppPanel extends JPanel {

   private Color BACKGROUND_COLOR = new Color(139, 138, 136);
   
   /**
    * Creates a new MainAppPanel
    *
    */
   MainAppPanel() {

      super();

      // set background
      setBackground(BACKGROUND_COLOR);

      // set layout
      GridBagLayout layout = new GridBagLayout();
      GridBagConstraints gbc = new GridBagConstraints();
      setLayout(layout);

      DrawPanel drawPanel = new DrawPanel();
      SettingsColorPanel settingsColorPanel = new SettingsColorPanel(drawPanel);
      SettingsShapePanel settingsShapePanel = new SettingsShapePanel(drawPanel);
      SettingsBrushPanel settingsBrushPanel = new SettingsBrushPanel(drawPanel);
      SettingsClearPanel settingsClearPanel = new SettingsClearPanel(drawPanel);
      
      gbc.anchor = GridBagConstraints.CENTER;
      gbc.fill = GridBagConstraints.BOTH;      
      gbc.insets = new Insets(10, 10, 10, 10);
      gbc.weightx = 0.5;
      
      
      gbc.gridx = 0;
      gbc.gridy = 0;
      add(settingsClearPanel, gbc);
      
      gbc.gridx = 1;
      gbc.gridy = 0;
      add(settingsColorPanel, gbc);

      gbc.gridx = 2;
      gbc.gridy = 0;
      add(settingsShapePanel, gbc);

      gbc.gridx = 3;
      gbc.gridy = 0;
      add(settingsBrushPanel, gbc);

      gbc.anchor = GridBagConstraints.SOUTH;
      gbc.ipady = 40;
      gbc.weightx = 0.0;
      gbc.weighty = 1.0;
      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.gridwidth = GridBagConstraints.REMAINDER;      
      add(drawPanel, gbc);

      setOpaque(true);
      setVisible(true);
   }

}
