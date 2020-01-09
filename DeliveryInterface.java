package nds;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/** 
 * A interface class for delivery person login.
 * <pre>
 * @author Rong Yang
 * @author <a href = "mailto:jsun18@toromail.csudh.edu">Jingsong Sun</a>
 * @version 1.0.0
 * @since 1.0.0
 * </pre>
 */
public class DeliveryInterface extends JFrame
{
	protected NDSDatabase ndsd;
	protected DeliveryInterface di;
	
	protected String userName;
	protected String password;
	
    private JLabel JIb_NDS = new JLabel("Newspaper Delvery System (NDS)");
    private JLabel Jlb_ID = new JLabel("ID");
    private JLabel Jlb_PW = new JLabel("Password");
    private JPasswordField jpw = new JPasswordField(8);
    private JTextField jid = new JTextField();
    private JButton Jbtn_YES = new JButton("Login");
    private JButton Jbtn_NO = new JButton("Cancel");
    private ButtonHandler hbtHandler = new ButtonHandler();  //Handle button event


    /** 
     * default constructor.
     * Initialize window for delivery person login
     */
    public DeliveryInterface()
    {
        super("Delivery Login");
        Container c = getContentPane();
        c.setLayout(null);

        // Titel size and situation
        JIb_NDS.setLocation(150,75);
        JIb_NDS.setSize(1000,100);
        JIb_NDS.setFont(new Font("Serif",Font.BOLD,60));
        c.add(JIb_NDS);

        // Design Jlb_ID's size, position and font
        Jlb_ID.setLocation(300,250);
        Jlb_ID.setSize(500,50);
        Jlb_ID.setFont(new Font("Serif",Font.BOLD,30));
        c.add(Jlb_ID);

        //Design size and position of account input and font
        jid.setLocation(400,250);
        jid.setSize(500,50);
        jid.setFont(new Font("",Font.BOLD,30));
        c.add(jid);

        //Define Jlb_PW's size, position and font
        Jlb_PW.setLocation(250,400);
        Jlb_PW.setSize(500,50);
        Jlb_PW.setFont(new Font("Serif",Font.BOLD,30));
        c.add(Jlb_PW);

        // set password frame size position and font
        jpw.setLocation(400,400);
        jpw.setSize(500,50);
        jpw.setFont(new Font("Serif",Font.BOLD,30));
        jpw.setEchoChar('.');
        jpw.setToolTipText("The length of password more than 8");
        c.add(jpw);

        jpw.addActionListener(hbtHandler);

        //set Button size position and font
        Jbtn_YES.setLocation(500,550);
        Jbtn_YES.setSize(100,40);
        Jbtn_YES.setFont(new Font("Serif",Font.BOLD,20));
        Jbtn_YES.addActionListener(hbtHandler);
        c.add(Jbtn_YES);

        // set button size position and font
        Jbtn_NO.setLocation(700,550);
        Jbtn_NO.setSize(100,40);
        Jbtn_NO.setFont(new Font("Serif",Font.BOLD,20));
        Jbtn_NO.addActionListener(hbtHandler);
        c.add(Jbtn_NO);
        
        //Set windows
        setSize(1200,1000);
        setLocation(900,400);
        setResizable(false);//Zoom button is unavailable
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent evtE)
        {
            if(evtE.getSource() == Jbtn_YES)
            {
            	userName = jid.getText();
            	char[] passwordc = jpw.getPassword();
            	password = "";
            	for( int i = 0; i < passwordc.length; i++ )
            	{
            		password += passwordc[i];
            	}
            	
            	ndsd = new NDSDatabase();
            	if( ndsd.loginDelivery(userName, password) )
            	{
            		di = ndsd.di;
            		DeliveryDashboard CD = new DeliveryDashboard();
                    this.Hide();
            	}
            	else
            	{
            		JOptionPane.showMessageDialog( null, "User name or Password incorrect!",
            				"NDS Login Error", JOptionPane.ERROR_MESSAGE );
            	}
            	
               
            }else if(evtE.getSource() == Jbtn_NO)
            {
                jid.setText(null);
                jpw.setText(null);
              
            }else
            {

            }
        }

        private void Hide() {
        }
    }

    
	
	
    public static void main(String [] args)
    {
        DeliveryInterface di = new DeliveryInterface();
    }
}