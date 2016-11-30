package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JPanel;
import people.FootballPlayer;

/**
 * The MainPanel class is the base UI for the app.
 * 
 */
public class MainPanel extends JPanel {

   public MainPanel(List<FootballPlayer> players) {
      
      super();
      
      setBackground(new Color(20, 20, 20));
      
      GridLayout grid = new GridLayout(1, 2);
      setLayout(grid);     
      
      RosterDisplayPanel rosterPanel = new RosterDisplayPanel(players);
      add(rosterPanel);
      
      DetailsPanel detailsPanel = new DetailsPanel();
      
      add(detailsPanel);
   }
   
      

}
