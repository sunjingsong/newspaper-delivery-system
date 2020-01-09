package nds;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/** 
 * A interface class to show information for delivery person to view and select.
 * <pre>
 * @author Rong Yang
 * @author <a href = "mailto:jsun18@toromail.csudh.edu">Jingsong Sun</a>
 * @version 1.0.0
 * @since 1.0.0
 * </pre>
 */
public class DeliveryDashboard extends JFrame
{
	protected Delivery de;
    private JLabel JIb_DB = new JLabel("Welcome to NDS Dashboard");
   // private JLabel Jlb_CS = new JLabel("Check Status");
    private JLabel Jlb_SMB = new JLabel("See List of Delivery");
   // private JButton Jbtn_CS = new JButton("C");
    private JButton Jbtn_SMB = new JButton("S");
    private ButtonHandler hbtHandler = new ButtonHandler();  



    /** Default constructor */
    public DeliveryDashboard()
    {
        super("CustomerDashboard");
        Container c = getContentPane();
        c.setLayout(null);

        // Titel size and situation
        JIb_DB.setLocation(250,75);
        JIb_DB.setSize(1000,100);
        JIb_DB.setFont(new Font("Serif",Font.BOLD,60));
        c.add(JIb_DB);

        Jlb_SMB.setLocation(450,550);
        Jlb_SMB.setSize(500,70);
        Jlb_SMB.setFont(new Font("Serif",Font.BOLD,40));
        c.add(Jlb_SMB);

        Jbtn_SMB.setLocation(300,550);
        Jbtn_SMB.setSize(75,75);
        Jbtn_SMB.setFont(new Font("Serif",Font.BOLD,40));
        Jbtn_SMB.addActionListener(hbtHandler);
        c.add(Jbtn_SMB);

  
        setSize(1200,1000);
        setLocation(900,400);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    /** A listener for event driven */
    private class ButtonHandler implements ActionListener
    {
    	/** Overwrite actionPerformed.
    	 *@param evtE(ActionEvent)
    	 */
        public void actionPerformed(ActionEvent evtE)
        {
        	if(evtE.getSource() == Jbtn_SMB)
            {
        		de = new Delivery();
        		de.deliveryTable();
                //char [] pw = jpw.getPassword();
                //System.out.println(""+pw.toString());
                System.out.println("B");
            }
        }
    }

    public static void main(String [] args)
    {
    	DeliveryDashboard pw = new DeliveryDashboard();
    }
}
