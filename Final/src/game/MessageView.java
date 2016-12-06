package game;

import javax.swing.JOptionPane;

/**
 * The MessageView class represents
 *
 */
public class MessageView {

   /**
    * Shows a pop-up welcome message.
    */
   public void showWelcomeMessage() {

      JOptionPane.showMessageDialog(null,
              "<html><body style='width: 500px'><p>Welcome to my final project!</p><p></p>"
              + "<p>I've added the following features and improvements:</p>"
              + "<ol>"
              + "<li><b>Challenge mode:</b> score as many touchdowns as you can "
              + "before you're tackled!</li>"
              + "<li><b>High score log:</b> the game will now keep a history of "
              + "the last 20 high scores.</li>"
              + "<li><b>Unit tests:</b> the game history classes are now tested.</li>"
              + "</ol>"
              + "<p>Press space after dismissing this message to begin the game</p></body></html>",
              "Welcome!", JOptionPane.INFORMATION_MESSAGE);
   }

   /**
    * Shows the game over message and prompts the user for their name.
    *
    * @return the user's input
    */
   public String showGameOverMessage() {
      String name = JOptionPane.showInputDialog(null, "Please enter your name.", "Game over!", 0);
      return name;
   }
   
   public void showTouchdownMessage() {
      JOptionPane.showMessageDialog(null, "Touchdown!", "", JOptionPane.INFORMATION_MESSAGE);
   }
   
   public void showTackleMessage() {
      JOptionPane.showMessageDialog(null, "Tackle!", "", JOptionPane.INFORMATION_MESSAGE);
   }

   public void showChallengeModeStartMesage() {
      // TODO
   }
}
