import java.awt.*;
import javax.swing.*;

public class BottomPanel extends JPanel
{
	private JButton b1;
	public BottomPanel()
	{
            super();
            setBackground(Color.pink);
            b1 = new JButton("When the user clicks on the button in the UPPER panel, displays the football player's position here" );
            add(b1);
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
}