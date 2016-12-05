package game;

import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 * The main frame of the application.
 *
 */
public class MainAppFrame extends JFrame {

    public MainAppFrame(ClockView clockView, ScoreView scoreView, GameView gameView,
            PlayerOptionsView optionsView, GameOptionsView speedView, InfoPanel infoView) throws HeadlessException {

        super("The Tackle-Breaking Runningback");

        MainAppPanel mainAppPanel = null;
        try {
           
           // the pumpkin button doesn't look right if the cross platform LAF is used.
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            mainAppPanel = new MainAppPanel(clockView, scoreView, gameView, optionsView, speedView, infoView);
            add(mainAppPanel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }

}
