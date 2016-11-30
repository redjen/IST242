package gui;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The DetailsPanel class displays additional information about the sports team.
 * 
 */
public class DetailsPanel extends JPanel {

   public DetailsPanel() {
      super();
      
      GridLayout layout = new GridLayout(1, 1);
      setLayout(layout);
      
      // Image obtained from Wikipedia and used according to their Fair Use guidelines
      // By Source (WP:NFCC#4), Fair use, https://en.wikipedia.org/w/index.php?curid=40155776
      ImageIcon img = new ImageIcon("images/Seahawks.png");
      JLabel label = new JLabel(img);
      label.setOpaque(false);
      
      add(label);
      
      setOpaque(false);
      setVisible(true);
   }
   
   
}
