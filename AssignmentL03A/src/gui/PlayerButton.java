package gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import people.FootballPlayer;

/**
 * The PlayerButton class is a button that displays the summary information
 * for a single football player.
 *
 */
public class PlayerButton extends JButton {

   public PlayerButton(FootballPlayer player) {
      super();

      Font buttonFont = new Font("Helvetica", Font.PLAIN, 18);
      Color bgColor = new Color(255, 255, 255, 20);
      Border border = new LineBorder(bgColor);

      setText(player.getSummaryInfo());
      setHorizontalAlignment(SwingConstants.LEFT);
      setBackground(bgColor);
      setOpaque(true);
      setFont(buttonFont);
      setForeground(Color.white);
      setBorder(border);
   }

}
