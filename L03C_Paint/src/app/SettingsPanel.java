package app;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 * The SettingsPanel class is the base class which any settings panel added
 * to the app should extend.
 *
 */
public abstract class SettingsPanel extends JPanel implements ActionListener {

   private DrawPanel drawPanel;
   private GridBagConstraints gbc;
   
   private Color BACKGROUND_COLOR = new Color(213, 220, 220);
   private final Color BORDER_COLOR = new Color(96, 96, 102);
   private final Color LABEL_COLOR = new Color(96, 96, 102);

   public SettingsPanel(String name, DrawPanel drawPanel) throws HeadlessException {
      super();

      this.drawPanel = drawPanel;

      GridBagLayout layout = new GridBagLayout();
      setLayout(layout);
      setUpGrid();
      setTitle(name);
      setAppearance();
   }

   public DrawPanel getDrawPanel() {
      return drawPanel;
   }

   /**
    * Returns the GridBagConstraints for button instance.
    *
    * Call this, then add buttons by incrementing the value of y.
    *
    * @return the GridBagConstraints
    */
   public GridBagConstraints getDefaultGridBagConstraints() {
      // the label is on the first row of the grid; start buttons on row 2
      gbc.gridy = 1;

      return gbc;
   }

   /**
    * The handler for panel object interaction.
    *
    * @param e
    */
   public abstract void actionPerformed(ActionEvent e);

   /**
    * Create the buttons.
    */
   public abstract void createButtons();

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
      label.setForeground(LABEL_COLOR);
      
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      add(label, gbc);
      gbc.gridwidth = 1;
   }
   
   /**
    * Sets the panel UI.
    */
   private void setAppearance() {
      LineBorder border = new LineBorder(BORDER_COLOR, 1, true);
      setBorder(border);
      setBackground(BACKGROUND_COLOR);
      
      setOpaque(true);
      setVisible(true);
   }
}
