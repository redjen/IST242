import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TopPanel extends JPanel implements ActionListener
{	
    private JButton DisplayPosition;
    private footballPlayer fp1;
//    private BottomPanel bottomPanel;
    private JButton outputButton;
    
    public TopPanel()
    {
        super();
        
        setBackground(Color.yellow);		
        fp1 = new footballPlayer("Mark","Allen",22, "IST", 5.6f, 180, "Junior","Running Back");	
        DisplayPosition = new JButton(getFp1().getInfo());
        DisplayPosition.addActionListener(this);
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
    

    /**
     * Sets the button on which the player's info will be displayed
     * @param outputButton the output button
     */
    public void setOutputButton(JButton outputButton) {
        this.outputButton = outputButton;
    }

    /**
     * Sets the text of the bottom button to this player's info when the 
     * button in this panel is clicked.
     * 
     * @param e the ActionEvent 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (e != null && outputButton != null) {
            if (source == DisplayPosition) {
                outputButton.setText(fp1.getAllInfo());
            }
        }
        
        
    }

}