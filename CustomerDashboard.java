package nds;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/** 
 * A interface class to show information for customer to view and select.
 * <pre>
 * @author YuNing Yu
 * @author <a href = "mailto:jsun18@toromail.csudh.edu">Jingsong Sun</a>
 * @version 1.0.0
 * @since 1.0.0
 * </pre>
 */
public class CustomerDashboard extends JFrame
{
	protected String userName;
	protected String password;
	
	protected Customer cu;
	protected CustomerInterface ci;
	protected NDSDatabase ndsd;
	protected Update up;
	
    private JLabel JIb_DB = new JLabel("Welcome to NDS Dashboard");
    private JLabel Jlb_CS = new JLabel("Check Status");
    private JLabel Jlb_UP = new JLabel("Update Information");
    private JLabel Jlb_DE = new JLabel("Delete Account");
    private JLabel Jlb_SMB = new JLabel("See Monthly Bill");
    private JButton Jbtn_CS = new JButton("C");
    private JButton Jbtn_UP = new JButton("U");
    private JButton Jbtn_SMB = new JButton("B");
    private JButton Jbtn_DE = new JButton("D");
    private ButtonHandler hbtHandler = new ButtonHandler();  



    /** One-argument constructor.
     *  Initialize windows to show information for customer.
     * @param cu(Customer)
     */
    public CustomerDashboard( Customer cu )
    {
        super("Customer Selection");
        Container c = getContentPane();
        c.setLayout(null);

        // Title size and situation
        JIb_DB.setLocation(250,75);
        JIb_DB.setSize(1000,100);
        JIb_DB.setFont(new Font("Serif",Font.BOLD,60));
        c.add(JIb_DB);

 
        Jlb_CS.setLocation(450,300);
        Jlb_CS.setSize(500,70);
        Jlb_CS.setFont(new Font("Serif",Font.BOLD,40));
        c.add(Jlb_CS);
        
        Jbtn_CS.setLocation(300,300);
        Jbtn_CS.setSize(75,75);
        Jbtn_CS.setFont(new Font("Serif",Font.BOLD,40));
        Jbtn_CS.addActionListener(hbtHandler);
        c.add(Jbtn_CS);
        
        
        Jlb_UP.setLocation(450,400);
        Jlb_UP.setSize(500,70);
        Jlb_UP.setFont(new Font("Serif",Font.BOLD,40));
        c.add(Jlb_UP);
        
        Jbtn_UP.setLocation(300,400);
        Jbtn_UP.setSize(75,75);
        Jbtn_UP.setFont(new Font("Serif",Font.BOLD,40));
        Jbtn_UP.addActionListener(hbtHandler);
        c.add(Jbtn_UP);
        
        Jlb_DE.setLocation(450,500);
        Jlb_DE.setSize(500,70);
        Jlb_DE.setFont(new Font("Serif",Font.BOLD,40));
        c.add(Jlb_DE);
        
        Jbtn_DE.setLocation(300,500);
        Jbtn_DE.setSize(75,75);
        Jbtn_DE.setFont(new Font("Serif",Font.BOLD,40));
        Jbtn_DE.addActionListener(hbtHandler);
        c.add(Jbtn_DE);



        Jlb_SMB.setLocation(450,600);
        Jlb_SMB.setSize(500,70);
        Jlb_SMB.setFont(new Font("Serif",Font.BOLD,40));
        c.add(Jlb_SMB);

        Jbtn_SMB.setLocation(300,600);
        Jbtn_SMB.setSize(75,75);
        Jbtn_SMB.setFont(new Font("Serif",Font.BOLD,40));
        Jbtn_SMB.addActionListener(hbtHandler);
        c.add(Jbtn_SMB);

  
        setSize(1200,1000);
        setLocation(900,400);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.cu = cu;
    }

    

    
    /** A listener for event driven */
    private class ButtonHandler implements ActionListener
    {
    	/** Overwrite actionPerformed.
    	 *@param evtE(ActionEvent)
    	 */
        public void actionPerformed(ActionEvent evtE)
        {
            if(evtE.getSource() == Jbtn_CS)
            {
            	cu.customerTable();
            	cu.orderTable();
            	
                //char [] pw = jpw.getPassword();
                //System.out.println(""+pw.toString());
                System.out.println("C");
            
            }
            else if( evtE.getSource() == Jbtn_UP )
            {
            	up = new Update();
            }
            else if( evtE.getSource() == Jbtn_DE )
            {
            	JOptionPane.showMessageDialog( null, "Your delete requirement has been sent,"
            			+ "wait the newsagent to confirm.", "Register Reminder",
	                      JOptionPane.INFORMATION_MESSAGE );
            }
            else if(evtE.getSource() == Jbtn_SMB)
            {
                //char [] pw = jpw.getPassword();
                //System.out.println(""+pw.toString());
                System.out.println("B");
            }
        }
    }

    public static void main(String [] args)
    {
        CustomerDashboard pw = new CustomerDashboard();
    }
}
