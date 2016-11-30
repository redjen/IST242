import java.awt.*;
import javax.swing.*;

public class InitialFrame extends JFrame
{
	public InitialFrame ()
	{
            super ("Communication Between Classes");
            LayoutSetupMAC();
            InitialPanel inp = new InitialPanel();
            add(inp);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize (800, 280);
            setVisible(true);
	}
    void LayoutSetupMAC()
    {
    // On some MACs it might be necessary to have the statement below 
    //for the background color of the button to appear    
       try 
        {
          UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
         } catch (Exception e) 
         {
                e.printStackTrace();
          }                
    //------------------------------------------------------           
    }

}
