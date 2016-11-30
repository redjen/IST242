import java.awt.*;
import javax.swing.*;

public class TopPanel extends JPanel
{	
    private JButton DisplayPosition;
    private footballPlayer fp1;
    public TopPanel()
    {
        super();
        setBackground(Color.yellow);		
        fp1 = new footballPlayer("Mark","Allen",22, "IST", 5.6f, 180, "Junior","Running Back");		
        DisplayPosition = new JButton(getFp1().getInfo());
        add(DisplayPosition);
    }

    /**
     * @return the buttonPosition
     */
    public JButton getDisplayPosition() {
        return DisplayPosition;
    }

    /**
     * @param buttonPosition the buttonPosition to set
     */
    public void setDisplayPosition(JButton buttonPosition) {
        this.DisplayPosition = buttonPosition;
    }

    /**
     * @return the fp1
     */
    public footballPlayer getFp1() {
        return fp1;
    }

    /**
     * @param fp1 the fp1 to set
     */
    public void setFp1(footballPlayer fp1) {
        this.fp1 = fp1;
    }

}