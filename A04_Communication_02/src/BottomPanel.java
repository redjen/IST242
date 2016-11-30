
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BottomPanel extends JPanel implements ActionListener {

    private JButton b1;
    private JButton playerButton;
    private footballPlayer fp1;

    public BottomPanel() {
        super();
        setBackground(Color.pink);
        b1 = new JButton("When the user clicks on the button in the UPPER panel, displays the football player's position here");
        add(b1);

        this.playerButton = null;
        this.fp1 = null;

    }

    /**
     * @return the b1
     */
    public JButton getB1() {
        return b1;
    }

    /**
     * @param b1 the b1 to set
     */
    public void setB1(JButton b1) {
        this.b1 = b1;
    }

    /**
     * Changes the text of the bottom button.
     *
     * @param newText the new text
     */
    public void setB1Text(String newText) {
        b1.setText(newText);
    }

    /**
     * Sets the football player button reference
     *
     * @param playerButton
     */
    public void setPlayerButton(JButton playerButton) {
        this.playerButton = playerButton;
        playerButton.addActionListener(this);

    }

    /**
     * Sets the football player reference.
     *
     * @param fp1 the new football player.
     */
    public void setFpl(footballPlayer fp1) {
        this.fp1 = fp1;
    }

    /**
     * Updates the display button when a player button is clicked.
     *
     * @param e the ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source != null && playerButton != null && fp1 != null) {
            if (source == playerButton) {
                setB1Text(fp1.getAllInfo());
            }
        }

    }
}
