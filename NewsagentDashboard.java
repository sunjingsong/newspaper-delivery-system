package nds;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/** 
 * A interface class to show information for newsagent to view and select.
 * <pre>
 * @author Yimin Wang
 * @author <a href = "mailto:jsun18@toromail.csudh.edu">Jingsong Sun</a>
 * @version 1.0.0
 * @since 1.0.0
 * </pre>
 */
public class NewsagentDashboard extends JFrame
{
	protected Newsagent ne;
    private JLabel JIb_DB = new JLabel("Welcome to NDS Dashboard");
    private JLabel Jlb_CS = new JLabel("View Customers");
    private JLabel Jlb_CS1 = new JLabel("Add a Customer");
    private JLabel Jlb_SMB = new JLabel("Delete a Customer");
    private JLabel Jlb_SMB1 = new JLabel("Modify a Customer");
    private JLabel Jlb_SMB2 = new JLabel("Hold a Customer");
    private JButton Jbtn_CS = new JButton("V");
    private JButton Jbtn_CS1 = new JButton("A");
    private JButton Jbtn_SMB = new JButton("D");
    private JButton Jbtn_SMB1 = new JButton("M");
    private JButton Jbtn_SMB2 = new JButton("H");
    private ButtonHandler hbtHandler = new ButtonHandler();  



    /** Default constructor */
    public NewsagentDashboard()
    {
        super("NewspaperAgentDashboard");
        Container c = getContentPane();
        c.setLayout(null);

        // Titel size and situation
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

        Jlb_CS1.setLocation(450,400);
        Jlb_CS1.setSize(500,70);
        Jlb_CS1.setFont(new Font("Serif",Font.BOLD,40));
        c.add(Jlb_CS1);



        Jbtn_CS1.setLocation(300,400);
        Jbtn_CS1.setSize(75,75);
        Jbtn_CS1.setFont(new Font("Serif",Font.BOLD,40));
        Jbtn_CS1.addActionListener(hbtHandler);
        c.add(Jbtn_CS1);
        
        Jlb_SMB.setLocation(450,500);
        Jlb_SMB.setSize(500,70);
        Jlb_SMB.setFont(new Font("Serif",Font.BOLD,40));
        c.add(Jlb_SMB);

        Jbtn_SMB.setLocation(300,500);
        Jbtn_SMB.setSize(75,75);
        Jbtn_SMB.setFont(new Font("Serif",Font.BOLD,40));
        Jbtn_SMB.addActionListener(hbtHandler);
        c.add(Jbtn_SMB);

        Jlb_SMB1.setLocation(450,600);
        Jlb_SMB1.setSize(500,70);
        Jlb_SMB1.setFont(new Font("Serif",Font.BOLD,40));
        c.add(Jlb_SMB1);

        Jbtn_SMB1.setLocation(300,600);
        Jbtn_SMB1.setSize(75,75);
        Jbtn_SMB1.setFont(new Font("Serif",Font.BOLD,40));
        Jbtn_SMB1.addActionListener(hbtHandler);
        c.add(Jbtn_SMB1);
        
        Jlb_SMB2.setLocation(450,700);
        Jlb_SMB2.setSize(500,70);
        Jlb_SMB2.setFont(new Font("Serif",Font.BOLD,40));
        c.add(Jlb_SMB2);

        Jbtn_SMB2.setLocation(300,700);
        Jbtn_SMB2.setSize(75,75);
        Jbtn_SMB2.setFont(new Font("Serif",Font.BOLD,40));
        Jbtn_SMB2.addActionListener(hbtHandler);
        c.add(Jbtn_SMB2);
  
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
            if(evtE.getSource() == Jbtn_CS)
            {
            	ne = new Newsagent();
        		ne.viewTable();
                //char [] pw = jpw.getPassword();
                //System.out.println(""+pw.toString());
                System.out.println("V");
            }
            else if(evtE.getSource() == Jbtn_CS1)
            {
            	ne = new Newsagent();
        		ne.viewAddTable();
        		
        		String dialogButton = JOptionPane.showInputDialog(null,
        				                          "Enter a customer id to add:", "Add new account",
        				                          JOptionPane.QUESTION_MESSAGE );
        		if( dialogButton != null )
        		{
        			try
        			{
        				int customerID = Integer.parseInt( dialogButton );
        				ne.addAccount( customerID );
        				JOptionPane.showMessageDialog( null, "Add Customer Successfully", "Add Reminder",
        						                      JOptionPane.INFORMATION_MESSAGE );
        			}
        			catch( NumberFormatException e )
        			{
        				JOptionPane.showMessageDialog( null, "Input error:" + dialogButton,
        						                      "Add Customer Failed", JOptionPane.ERROR_MESSAGE );
        			}
        		}
                //char [] pw = jpw.getPassword();
                //System.out.println(""+pw.toString());
                System.out.println("A");
            }
            else if(evtE.getSource() == Jbtn_SMB)
            {
            	ne = new Newsagent();
        		ne.viewDeleteTable();
        		
        		String dialogButton = JOptionPane.showInputDialog(null,
        				                          "Enter a customer id to delete:", "Delete an account",
        				                          JOptionPane.QUESTION_MESSAGE );
        		if( dialogButton != null )
        		{
        			try
        			{
        				int customerID = Integer.parseInt( dialogButton );
        				ne.deleteAccount( customerID );
        				JOptionPane.showMessageDialog( null, "Delete Customer Successfully", "Delete Reminder",
        						                      JOptionPane.INFORMATION_MESSAGE );
        			}
        			catch( NumberFormatException e )
        			{
        				JOptionPane.showMessageDialog( null, "Input error:" + dialogButton,
        						                      "Delete Customer Failed", JOptionPane.ERROR_MESSAGE );
        			}
        		}
                //char [] pw = jpw.getPassword();
                //System.out.println(""+pw.toString());
                System.out.println("D");
            }
        	else if(evtE.getSource() == Jbtn_SMB1)
            {
        		ne = new Newsagent();
        		ne.viewUpdateTable();
        		
        		String dialogButton = JOptionPane.showInputDialog(null,
        				                          "Enter a customer id to update:", "Update an account",
        				                          JOptionPane.QUESTION_MESSAGE );
        		if( dialogButton != null )
        		{
        			try
        			{
        				int customerID = Integer.parseInt( dialogButton );
        				ne.updateAccount( customerID );
        				JOptionPane.showMessageDialog( null, "Update Customer Successfully", "Update Reminder",
        						                      JOptionPane.INFORMATION_MESSAGE );
        			}
        			catch( NumberFormatException e )
        			{
        				JOptionPane.showMessageDialog( null, "Input error:" + dialogButton,
        						                      "Update Customer Failed", JOptionPane.ERROR_MESSAGE );
        			}
        		}
        		
                //char [] pw = jpw.getPassword();
                //System.out.println(""+pw.toString());
                System.out.println("M");
            }
        	else if(evtE.getSource() == Jbtn_SMB2)
            {
        		ne = new Newsagent();
        		ne.viewHoldTable();
        		
        		String dialogButton = JOptionPane.showInputDialog(null,
        				                          "Enter a customer id to hold:", "Hold an account",
        				                          JOptionPane.QUESTION_MESSAGE );
        		if( dialogButton != null )
        		{
        			try
        			{
        				int customerID = Integer.parseInt( dialogButton );
        				ne.holdAccount( customerID );
        				JOptionPane.showMessageDialog( null, "Hold Customer Successfully", "Hold Reminder",
        						                      JOptionPane.INFORMATION_MESSAGE );
        			}
        			catch( NumberFormatException e )
        			{
        				JOptionPane.showMessageDialog( null, "Input error:" + dialogButton,
        						                      "Hold Customer Failed", JOptionPane.ERROR_MESSAGE );
        			}
        		}
                //char [] pw = jpw.getPassword();
                //System.out.println(""+pw.toString());
                System.out.println("H");
            }
        }
    }

    public static void main(String [] args)
    {
    	NewsagentDashboard pw = new NewsagentDashboard();
    }
}
