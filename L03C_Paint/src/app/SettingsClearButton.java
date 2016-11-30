package app;

import settings.DrawShape;

/**
 * The SettingsClearButton provides a button to clear the drawing area.
 *
 */
public class SettingsClearButton extends SettingsButton {

   public SettingsClearButton(String label) {
      super(label);
   }

   @Override
   public void performAction(DrawPanel drawPanel) {
      drawPanel.clear();
      System.out.println("clear button clicked");
   }

}
