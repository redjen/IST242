package game;

import java.awt.GridBagConstraints;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JLabel;

/**
 * The ClockView provides a simple clock display.
 *
 */
public class ClockView extends BasePanel {

   private final SimpleDateFormat SDF = new SimpleDateFormat("HH:mm:ss");
   private JLabel display;

   public ClockView() {
      super("Time");

      GridBagConstraints gbc = getDefaultGridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.anchor = GridBagConstraints.CENTER;

      display = new JLabel("", JLabel.CENTER);
      display.setAlignmentX(CENTER_ALIGNMENT);
      add(display, gbc);
      display.setVisible(true);

      resetClock();
   }

   /**
    * Resets the clock to zero.
    */
   public void resetClock() {
      Calendar cal = Calendar.getInstance();
      cal.set(0, 0, 0, 0, 0, 0);
      updateClock(cal);
   }

   /**
    * Updates the clock display.
    *
    * @param cal Calendar object representing the time to be displayed
    */
   public void updateClock(Calendar cal) {
      display.setText(SDF.format(cal.getTime()));
   }

   @Override
   public void setAlternateUI(boolean alternate) {
      // no-op
   }

}
