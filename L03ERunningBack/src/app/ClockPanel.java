package app;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * The ClockPanel provides a simple clock that counts up from zero.
 *
 */
public class ClockPanel extends BasePanel {

   private final SimpleDateFormat SDF = new SimpleDateFormat("HH:mm:ss");
   private Calendar clock;
   private JLabel display;
   private Timer timer;

   public ClockPanel() {
      super("Time");

      clock = Calendar.getInstance();
      resetClock();

      GridBagConstraints gbc = getDefaultGridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.anchor = GridBagConstraints.CENTER;
      
      display = new JLabel("", JLabel.CENTER);
      display.setAlignmentX(CENTER_ALIGNMENT);
      display.setText(SDF.format(clock.getTime()));
      
      
      resetClock();
      add(display, gbc);
      

      // handler for timer events.
      timer = new Timer(1000, new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            clock.add(Calendar.SECOND, 1);
            display.setText(SDF.format(clock.getTime()));
         }
      });
   }

   /**
    * Starts/resumes the clock.
    */
   public void startClock() {
      if (!timer.isRunning()) {
         timer.start();
      }
   }

   /**
    * Stops the clock.
    */
   public void stopClock() {
      if (timer.isRunning()) {
         timer.stop();
      }
   }

   /**
    * Resets the clock to zero.
    */
   public void resetClock() {
      clock.set(0, 0, 0, 0, 0, 0);
   }

}
