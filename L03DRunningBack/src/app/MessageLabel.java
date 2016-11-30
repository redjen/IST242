package app;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 * The MessageLabel class provides a banner to show and hide messages to the user.
 * 
 */
public class MessageLabel extends JLabel {
   
   // Using public static constants instead of a special enum class
   // seemed like the best way to allow the game panel to choose the appropriate
   // message.
   public static final String TOUCHDOWN = "Touchdown!";
   public static final String TACKLE = "Tackle!";
   public static final String START = "Press space to start";
   public static final String GAME_OVER = "Game over";

   public MessageLabel()  {
      super("");
      
      // set appearance
      Font currentFont = getFont();
      setFont(new Font(currentFont.getName(), Font.BOLD, currentFont.getSize() * 5));
      setForeground(new Color(22, 45, 106));
      setBackground(new Color(255, 255, 255, 200));
      setOpaque(true);
      setHorizontalAlignment(CENTER);
      
      setBounds(0, 0, (getFont().getSize() * 20), (getFont().getSize() * 3));
      setVisible(false);
   }
   
   /**
    * Shows the label and displays the specified message
    * 
    * @param message one of the static constants for this class
    */
   public void showMessage(String message) {
      
      if (message.equals(TOUCHDOWN)) {
         setText(TOUCHDOWN);
      } else if (message.equals(TACKLE)) {
         setText(TACKLE);
         setAlignmentX(JLabel.CENTER_ALIGNMENT);
      } else if (message.equals(START)) {
         setText(START);
      } else if (message.equals(GAME_OVER)) {
         setText(GAME_OVER);
      }
      
      setVisible(true);
   }
   
   /**
    * Hides the message field
    */
   public void hideMessage() {
      setText("");
      setVisible(false);
   }

   
   
}
