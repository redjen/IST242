package game;

import javax.swing.text.BadLocationException;

/**
 *
 * @author Jennifer Mullen jsm158@psu.edu
 */
public class App {

   public static void main(String[] args) throws BadLocationException {

      // initialize model
      GameModel gameModel = new GameModel();

      // initialize views
      ClockView clockView = new ClockView();
      ScoreView scoreView = new ScoreView();
      GameView gameView = new GameView(gameModel);
      PlayerOptionsView optionsView = new PlayerOptionsView();
      GameOptionsView speedView = new GameOptionsView();
      InfoPanel infoView = new InfoPanel();

      // initialize UI
      MainAppFrame frame = new MainAppFrame(clockView, scoreView, gameView, optionsView, speedView, infoView);

      // intialize controllers
      PlayerOptionsController playerOptionsController = new PlayerOptionsController(optionsView);
      GameController gameController = new GameController(gameModel, clockView, scoreView, gameView, optionsView, speedView, playerOptionsController);

   }

}
