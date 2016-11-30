package app;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.text.BadLocationException;

/**
 * The MainAppPanel class is the main container for the application.
 *
 */
public class MainAppPanel extends JPanel {

   private Color BACKGROUND_COLOR = new Color(139, 138, 136);
   
      ClockPanel clockPanel;
      ScorePanel scorePanel;
      GamePanel gamePanel;
      PlayerOptionsPanel optionsPanel;
      SpeedPanel speedPanel;
      InfoPanel infoPanel;
      
   /**
    * Creates a new MainAppPanel
    *
    */
   MainAppPanel() throws BadLocationException {

      super();

      // set background
      setBackground(BACKGROUND_COLOR);

      // set layout
      GridBagLayout layout = new GridBagLayout();
      GridBagConstraints gbc = new GridBagConstraints();
      setLayout(layout);

      clockPanel = new ClockPanel();
      scorePanel = new ScorePanel();
      gamePanel = new GamePanel(scorePanel, clockPanel, this);
      optionsPanel = new PlayerOptionsPanel(gamePanel);
      speedPanel = new SpeedPanel(gamePanel);
      infoPanel = new InfoPanel();
      
      
      gbc.anchor = GridBagConstraints.CENTER;
      gbc.fill = GridBagConstraints.BOTH;      
      gbc.insets = new Insets(10, 10, 10, 10);
      gbc.weightx = 0.5;
      
      
      gbc.gridx = 0;
      gbc.gridy = 0;
      add(clockPanel, gbc);
      
      gbc.gridx = 1;
      gbc.gridy = 0;
      add(scorePanel, gbc);

      gbc.gridx = 2;
      gbc.gridy = 0;
      add(speedPanel, gbc);
      
      
      gbc.gridx = 3;
      gbc.gridy = 0;
      add(optionsPanel, gbc);
      
      // Game pane. It gets all the available vertical space.
      gbc.fill = GridBagConstraints.BOTH;
      gbc.ipady = 40;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.gridwidth = GridBagConstraints.REMAINDER;      
      add(gamePanel, gbc);
      
      // Create the info pane. Anchor it to the bottom and do not let it
      // take up any remaining space.
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.anchor = GridBagConstraints.SOUTH;
      gbc.ipady = 0;
      gbc.gridx = 0;
      gbc.gridy = 2;
      gbc.weightx = 0;
      gbc.weighty = 0;
      gbc.gridwidth = GridBagConstraints.REMAINDER; 
      add(infoPanel, gbc);

      setOpaque(true);
      setVisible(true);
      
      
   }
   
   /**
    * Toggles the Halloween appearance in all panels except the game panel.
    * @param isHalloween 
    */
   public void setHalloween (boolean isHalloween) {
      clockPanel.setHalloween(isHalloween);
      scorePanel.setHalloween(isHalloween);
      optionsPanel.setHalloween(isHalloween);
      speedPanel.setHalloween(isHalloween);
      infoPanel.setHalloween(isHalloween);
      
   }
}
