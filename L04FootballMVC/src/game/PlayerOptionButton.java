package game;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;

/**
 * The PlayerOptionButton class provides an options button with a label
 * and a tooltip.
 *
 */
public class PlayerOptionButton extends JToggleButton {

   private final static Color BORDER_COLOR = new Color(192, 197, 209);

   public PlayerOptionButton(String label, String toolTip) {
      super(label);
      init(toolTip);
   }

   public PlayerOptionButton(Icon icon, String toolTip) {
      super(icon);      
      init(toolTip);
   }

   private void init(String toolTip) {
      LineBorder border = new LineBorder(BORDER_COLOR, 1, true);
      setBorder(border);
      setBackground(new Color(255, 255, 255, 200));
      setToolTipText(toolTip);
      setVisible(true);
   }

   // Set the button's color depending on its selection state.
   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      setContentAreaFilled(getModel().isSelected());
   }
   
   
   

}
