package app;

import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 * The main frame of the application.
 *
 */
public class MainAppFrame extends JFrame {
     

   public MainAppFrame() throws HeadlessException {
      
      super("Simple Paint");
      
      Dimension dim = new Dimension(1000, 700);
      MainAppPanel mainAppPanel = new MainAppPanel();
          
      try {
         UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      add(mainAppPanel);
      
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(dim);
      setVisible(true);
      

   }

}
