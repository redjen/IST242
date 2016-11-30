import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class InitialPanel extends JPanel implements ActionListener
{
    
    private JButton playerButton;
    private JButton displayButton;
    private footballPlayer player;
    
    public InitialPanel()
    {
        super();
        setBackground(Color.gray);
        setLayout(new BorderLayout());
        TopPanel top = new TopPanel();
        add(top,BorderLayout.NORTH);
        BottomPanel bot = new BottomPanel();
        add(bot,BorderLayout.CENTER);
        
        playerButton = top.getDisplayPosition();
        player = top.getFp1();
        displayButton = bot.getB1();
        playerButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (e != null && playerButton != null && displayButton != null &&
                player != null) {
            if (source == playerButton) {
                displayButton.setText(player.getAllInfo());
            }
        }
    }
}