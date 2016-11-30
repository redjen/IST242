package app;

import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.text.BadLocationException;

/**
 * The InfoPanel provides a list of the available keyboard commands.
 * 
 * Based on the tutorial available at:
 * https://docs.oracle.com/javase/tutorial/uiswing/components/editorpane.html
 */
public class InfoPanel extends BasePanel {

   public InfoPanel() throws BadLocationException {
      super();

      GridBagConstraints gbc = getDefaultGridBagConstraints();
      JLabel label;

      gbc.fill = GridBagConstraints.HORIZONTAL;

      // Game control commands      
      gbc.gridwidth = 2;
      gbc.gridx = 0;

      addText("Begin/pause/resume: <space>", gbc);
      addText("Stop: <esc>", gbc);
      addText("Quit: <q>", gbc);

      

      // Movement commands     
      gbc.gridy++;
      gbc.gridx = 0;
      gbc.gridwidth = 1;
      
      addText("Left: <←>, <h>", gbc);
      addText("Right: <→>, <l>", gbc);
      addText("Up: <↑>, <k>", gbc);
      addText("Down: <↓>, <j>", gbc);
      addText("Diagonals: <y>, <u>, <b>, <n>", gbc);
      
   }

   /**
    * Inserts the text into the panel and positions it.
    * 
    * @param text text 
    * @param gbc gridbagconstraints in use
    */
   private void addText(String text, GridBagConstraints gbc) {
      
      JLabel label = new JLabel(text);
      Font currentFont = getFont();
      label.setFont(new Font(currentFont.getFontName(), Font.PLAIN, (int) (currentFont.getSize() * .75)));
      
      gbc.gridx++;
      add(label, gbc);      

   }

}
