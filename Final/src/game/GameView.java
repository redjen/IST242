package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * The GameView is the play area of the game, upon which the field and players
 * are shown.
 */
public class GameView extends BasePanel {

   private static final String BACKGROUND_IMAGE = "resources/field.png";
   private static final String RAINYTOWN_IMAGE = "resources/field_puget_sound.png";

   private final GameModel gameModel;
   
   private boolean alternateUI;
   
   private static final Logger logger = Logger.getLogger("GameView");

   public GameView(GameModel gameModel) {
      super();
      
      // necessary to keep the positions in the game model in sync with 
      // what is actually painted on screen
      this.gameModel = gameModel;

      setVisible(true);
      setFocusable(true);

      setLayout(null);
      alternateUI = false;

   }

   /**
    * Adds a PlayerView to the display.
    * 
    * @param player 
    */
   public void addPlayer(PlayerView player) {
      add(player);
      logger.info("Added player");
   }

   @Override
   public void paintComponent(Graphics gg) {
      super.paintComponent(gg);

      requestFocusInWindow();

      try {
         
         String backgroundPath;
         if (alternateUI) {
            backgroundPath = RAINYTOWN_IMAGE;
         } else {
            backgroundPath = BACKGROUND_IMAGE;
         }
         BufferedImage background = ImageIO.read(new File(backgroundPath));
        
         gg.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this);
         gameModel.setFieldBoundaries(getWidth(), getHeight());

      } catch (IOException ex) {
      }

   }

   @Override
   public void setAlternateUI(boolean alternate) {
      this.alternateUI = alternate;
   }

}
