package game;

import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;

/**
 * The ScoreView class shows the current game score.
 *
 */
public class ScoreView extends BasePanel  {

    private JLabel touchdownCountTitle;
    private JLabel touchdownCount;
    private JLabel tackleCountTitle;
    private JLabel tackleCount;

    private final String DEFAULT_TOUCHDOWN = "Home";
    private final String DEFAULT_MISS = "Away";
    private final String ALTERNATE_TOUCHDOWN = "Sunny";
    private final String ALTERNATE_MISS = "Rainy";
        
    public ScoreView() {
        super();
 
        touchdownCountTitle = new JLabel(DEFAULT_TOUCHDOWN, JLabel.CENTER);
        touchdownCountTitle.setForeground(new Color(96, 96, 102));
        touchdownCount = new JLabel("", JLabel.CENTER);
        tackleCountTitle = new JLabel(DEFAULT_MISS, JLabel.CENTER);
        tackleCountTitle.setForeground(new Color(96, 96, 102));
        tackleCount = new JLabel("", JLabel.CENTER);
        

        GridBagConstraints gbc = getDefaultGridBagConstraints();
        gbc.gridx = 0;
        add(touchdownCountTitle, gbc);
        gbc.gridx = 1;
        add(tackleCountTitle, gbc);
        gbc.gridy++;

        gbc.gridx = 0;
        add(touchdownCount, gbc);
        gbc.gridx = 1;
        add(tackleCount, gbc);
        
        updateScore(0, 0);
    }

    /**
     * Updates the displayed score.
     * 
     * @param touchdown
     * @param tackle 
     */
    public void updateScore(int touchdown, int tackle) {
        touchdownCount.setText(Integer.toString(touchdown));
        tackleCount.setText(Integer.toString(tackle));        
    }


   @Override
   public void setAlternateUI(boolean alternate) {
      if (alternate) {
         touchdownCountTitle.setText(ALTERNATE_TOUCHDOWN);
         tackleCountTitle.setText(ALTERNATE_MISS);
      } else {
         touchdownCountTitle.setText(DEFAULT_TOUCHDOWN);
         tackleCountTitle.setText(DEFAULT_MISS);
      }
   }

}
