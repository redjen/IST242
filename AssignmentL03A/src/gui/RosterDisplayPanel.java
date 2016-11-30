package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import people.FootballPlayer;

/**
 * The RosterDisplayPanel class shows the team roster.
 *
 */
public class RosterDisplayPanel extends JPanel {

   private List<FootballPlayer> players;

   public RosterDisplayPanel() {
      this(new ArrayList<>());

   }

   public RosterDisplayPanel(List<FootballPlayer> players) {
      super();

      this.players = players;
      
      // layout
      GridLayout layout = new GridLayout(12, 1);
      setLayout(layout);
      layout.setVgap(18);
      
      // header
      JLabel header = new JLabel("Roster");
      Font headerFont = new Font("Helvetica", Font.BOLD, 24);
      header.setFont(headerFont);
      header.setForeground(Color.white);
      add(header);

      // players
      addPlayerButtons();

      setOpaque(false);
      setVisible(true);

   }

   /**
    * Creates the buttons containing player information
    */
   private void addPlayerButtons() {
      
      for (FootballPlayer player : players) {
         
         JButton button = new PlayerButton(player);
         
         add(button);
      }

   }

}
