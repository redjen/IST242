package game;

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 * The BasePanel class represents the basic structure and theme of an
 * application panel/view.
 *
 */
public abstract class BasePanel extends JPanel {

    private GridBagConstraints gbc;

    private final static Color DEFAULT_BACKGROUND_COLOR = new Color(213, 220, 220);
    private final static Color DEFAULT_BORDER_COLOR = new Color(96, 96, 102);
    private final static Color DEFAULT_LABEL_COLOR = new Color(96, 96, 102);


    public BasePanel(String name) {

        this();
        setTitle(name);

    }

    public BasePanel() {
        super();

        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        setUpGrid();
        setAppearance();
    }

    /**
     * Returns the GridBagConstraints for button instance.
     *
     * Call this, then add buttons by incrementing the value of y.
     *
     * @return the GridBagConstraints
     */
    public GridBagConstraints getDefaultGridBagConstraints() {
        return gbc;
    }
    
    public abstract void setAlternateUI(boolean alternate);


    /**
     * Creates the grid layout with default settings.
     */
    private void setUpGrid() {
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.insets = new Insets(5, 5, 5, 5);
    }

    /**
     * Sets the title.
     *
     * @param name the new title
     */
    private void setTitle(String name) {
        JLabel label = new JLabel(name, JLabel.CENTER);
        label.setLabelFor(this);
        label.setForeground(DEFAULT_LABEL_COLOR);

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(label, gbc);
        gbc.gridwidth = 1;
        gbc.gridy = 1;
    }

    /**
     * Sets the panel UI.
     */
    private void setAppearance() {
        LineBorder border = new LineBorder(DEFAULT_BORDER_COLOR, 1, true);
        setBorder(border);
        setBackground(DEFAULT_BACKGROUND_COLOR);

        setOpaque(true);
        setVisible(true);
    }
}
