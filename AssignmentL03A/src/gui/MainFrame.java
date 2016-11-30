package gui;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.UIManager;
import people.FootballPlayer;

/**
 * The MainFrame class is the container for the app UI.
 *
 */
public class MainFrame extends JFrame {

   public MainFrame(List<FootballPlayer> players) {
      super("Football team");
      
      try
        {
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
        } catch (Exception e)
        {
            e.printStackTrace();
        } 

      MainPanel mainPanel = new MainPanel(players);
      add(mainPanel);
  
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(1000, 700);
      setVisible(true);
   }
   

}
