package game;

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

   private final Color BACKGROUND_COLOR = new Color(139, 138, 136);

   private ClockView clockView;
   private ScoreView scoreView;
   private GameView gameView;
   private PlayerOptionsView optionsView;
   private GameOptionsView speedView;
   private InfoPanel infoView;

   /**
    * Creates a new MainAppPanel
    *
    */
   MainAppPanel(ClockView clockView, ScoreView scoreView, GameView gameView,
            PlayerOptionsView optionsView, GameOptionsView speedView, InfoPanel infoView) throws BadLocationException {

      super();

      // set background
      setBackground(BACKGROUND_COLOR);

      // set layout
      GridBagLayout layout = new GridBagLayout();
      GridBagConstraints gbc = new GridBagConstraints();
      setLayout(layout);

      this.clockView = clockView;
      this.scoreView = scoreView;
      this.gameView = gameView;
      this.optionsView = optionsView;
      this.speedView = speedView;
      this.infoView = infoView;

      gbc.anchor = GridBagConstraints.CENTER;
      gbc.fill = GridBagConstraints.BOTH;
      gbc.insets = new Insets(10, 10, 10, 10);
      gbc.weightx = 0.5;

      gbc.gridx = 0;
      gbc.gridy = 0;
      add(this.clockView, gbc);

      gbc.gridx = 1;
      gbc.gridy = 0;
      add(scoreView, gbc);

      gbc.gridx = 2;
      gbc.gridy = 0;
      add(this.speedView, gbc);

      gbc.gridx = 3;
      gbc.gridy = 0;
      add(this.optionsView, gbc);

      // Game pane. It gets all the available vertical space.
      gbc.fill = GridBagConstraints.BOTH;
      gbc.ipady = 40;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      add(this.gameView, gbc);

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
      add(this.infoView, gbc);

      setOpaque(true);
      setVisible(true);
      
   }

}
