
import java.awt.*;
import javax.swing.*;

public class InitialPanel extends JPanel {

    public InitialPanel() {
        super();
        setBackground(Color.gray);
        setLayout(new BorderLayout());
        TopPanel top = new TopPanel();
        add(top, BorderLayout.NORTH);
        BottomPanel bot = new BottomPanel();
        add(bot, BorderLayout.CENTER);

        bot.setFpl(top.getFp1());
        bot.setPlayerButton(top.getDisplayPosition());
    }
}
