package app;

import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;

/**
 * The ScorePanel class shows the current game score.
 *
 */
public class ScorePanel extends BasePanel {

    private int touchdown = 0;
    private int miss = 0;
    private JLabel touchdownCountTitle;
    private JLabel touchdownCount;
    private JLabel missCountTitle;
    private JLabel missCount;

    private final String DEFAULT_TOUCHDOWN = "Home";
    private final String HALLOWEEN_TOUCHDOWN = "Treats";
    private final String DEFAULT_MISS = "Away";
    private final String HALLOWEEN_MISS = "Tricks";

    public ScorePanel() {
        super();

        touchdownCountTitle = new JLabel(DEFAULT_TOUCHDOWN, JLabel.CENTER);
        touchdownCountTitle.setForeground(new Color(96, 96, 102));
        touchdownCount = new JLabel("", JLabel.CENTER);
        missCountTitle = new JLabel(DEFAULT_MISS, JLabel.CENTER);
        missCountTitle.setForeground(new Color(96, 96, 102));
        missCount = new JLabel("", JLabel.CENTER);

        GridBagConstraints gbc = getDefaultGridBagConstraints();
        gbc.gridx = 0;
        add(touchdownCountTitle, gbc);
        gbc.gridx = 1;
        add(missCountTitle, gbc);
        gbc.gridy++;

        gbc.gridx = 0;
        add(touchdownCount, gbc);
        gbc.gridx = 1;
        add(missCount, gbc);

        update();
    }

    /**
     * Adds a point to the opposing team's score.
     */
    public void addMiss() {
        miss++;
        update();
    }

    /**
     * Adds a point to the home team's score.
     */
    public void addTouchdown() {
        touchdown++;
        update();
    }

    /**
     * Resets the scores to zero.
     */
    public void reset() {
        touchdown = 0;
        miss = 0;
        update();
    }

    /**
     * Sets Halloween mode.
     * 
     * @param isHalloween 
     */
    @Override
    public void setHalloween(boolean isHalloween) {
       super.setHalloween(isHalloween);
        if (isHalloween) {
            touchdownCountTitle.setText(HALLOWEEN_TOUCHDOWN);
            missCountTitle.setText(HALLOWEEN_MISS);
        } else {
            touchdownCountTitle.setText(DEFAULT_TOUCHDOWN);
            missCountTitle.setText(DEFAULT_MISS);
        }
    }

    /**
     * Updates the score display.
     */
    private void update() {
        touchdownCount.setText(Integer.toString(touchdown));
        missCount.setText(Integer.toString(miss));
    }

}
