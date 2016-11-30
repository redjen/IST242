package game;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.logging.Logger;

/**
 * The PlayerOptionsController class is the controller for the in-game options.
 * 
 */
public class PlayerOptionsController {

   private RunningbackModel playerModel;
   private PlayerView playerView;
   private final PlayerOptionsView optionsView;
   
   private final static Logger logger = Logger.getLogger("PlayerOptionsController");

   public PlayerOptionsController(PlayerOptionsView view) {
      this.optionsView = view;
      
      // set up buttons
      view.getAgileButton().addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            nullModelCheck();
            playerModel.setAgile(e.getStateChange() == ItemEvent.SELECTED);
            playerView.setBounds(playerModel.getBounds());
         }
      });
      
      view.getFastButton().addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            nullModelCheck();
            playerModel.setFast(e.getStateChange() == ItemEvent.SELECTED);
         }
      });
      
      view.getLuckyButton().addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            nullModelCheck();
            playerModel.setLucky(e.getStateChange() == ItemEvent.SELECTED);
         }
      });
      
      view.getPerceptiveButton().addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            nullModelCheck();
            playerModel.setPerceptive(e.getStateChange() == ItemEvent.SELECTED);
         }
      });
      
   }
  
   /**
    * Sets the runningback to be configured.
    * 
    * @param playerModel the runningback model
    * @param playerView the runningback view
    */
   public void setPlayer(RunningbackModel playerModel, PlayerView playerView) {
      this.playerModel = playerModel;
      this.playerView = playerView;
   }
   
   private void nullModelCheck() {
      if (playerModel == null) {
         logger.warning("Tried to change options but runningback model was null.");
         throw new IllegalArgumentException("Runningback model not set.");
      }
   }
   
}
