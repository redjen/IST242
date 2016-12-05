package game;

import javax.swing.JOptionPane;

/**
 * The MessageView class represents
 * 
 */
public class MessageView {

   /**
    * Shows a pop-up message at the start of the game.
    */
   public void showWelcomeMessage() {

      JOptionPane.showMessageDialog(null,
              "<html><body style='width: 500px'><p>Welcome to my final project!</p><p></p>"
              + "<p>I've added a challenge mode in which the goal is to score as many "
              + "touchdowns as possible before being tackled.</p><p></p>"
              + "<p>The game will also now keep a high score log that persists "
              + "across sessions.</p></body></html>",
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
   
   public void showChallengeModeStartMesage() {
      // TODO
   }
}
