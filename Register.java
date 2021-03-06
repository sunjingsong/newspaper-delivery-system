package nds;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/** 
 * A interface class for customer to register.
 * <pre>
 * @author YuNing Yu
 * @author <a href = "mailto:jsun18@toromail.csudh.edu">Jingsong Sun</a>
 * @version 1.0.0
 * @since 1.0.0
 * </pre>
 */
public class Register extends JFrame
{
    private JLabel JIb_MR = new JLabel("Membership Registration");
    private JLabel Jlb_UN = new JLabel("UserName");
    private JLabel Jlb_PW = new JLabel("Password");
    private JLabel Jlb_PWV = new JLabel("Password Verify");
    private JLabel Jlb_RN = new JLabel("Real Name");
    private JLabel Jlb_EM = new JLabel("E-mail");
    private JLabel Jlb_PN = new JLabel("Phone Namber");
    private JLabel Jlb_AD = new JLabel("Address");
    private JLabel Jlb_ZI = new JLabel("Zip Code");
    
    private JTextField jun = new JTextField();
    private JPasswordField jpw = new JPasswordField(8);
    private JPasswordField jpwv = new JPasswordField(8);
    private JTextField jrn = new JTextField();
    private JTextField jem = new JTextField();
    private JTextField jpn = new JTextField();
    private JTextField jad = new JTextField();
    private JTextField jzi = new JTextField();
    private JButton Jbtn_NO = new JButton("Cancel");
    private JButton Jbtn_RI = new JButton("Register");
    private ButtonHandler hbtHandler = new ButtonHandler();  

    /** Default constructor.
     * Initialize a interface for register.
     */
    public Register() {
        super("Register");
        Container c = getContentPane();
        c.setLayout(null);

        // Title size and situation
        JIb_MR.setLocation(275, 50);
        JIb_MR.setSize(1000, 100);
        JIb_MR.setFont(new Font("Serif", Font.BOLD, 60));
        c.add(JIb_MR);

        //Jlb_ID situation and size
        Jlb_UN.setLocation(320, 250);
        Jlb_UN.setSize(500, 25);
        Jlb_UN.setFont(new Font("Serif", Font.BOLD, 25));
        c.add(Jlb_UN);

        //user name situation and size
        jun.setLocation(450, 250);
        jun.setSize(500, 30);
        jun.setFont(new Font("", Font.BOLD, 25));
        c.add(jun);

        //Jlb_PW situation and size
        Jlb_PW.setLocation(320, 300);
        Jlb_PW.setSize(500, 25);
        Jlb_PW.setFont(new Font("Serif", Font.BOLD, 25));
        c.add(Jlb_PW);

        //password situation and size
        jpw.setLocation(450, 300);
        jpw.setSize(500, 30);
        jpw.setFont(new Font("Serif", Font.BOLD, 25));
        jpw.setEchoChar('.');
        jpw.setToolTipText("password");
        c.add(jpw);


        jpw.addActionListener(hbtHandler);


        //Jlb_PW situation and size
        Jlb_PWV.setLocation(250, 350);
        Jlb_PWV.setSize(500, 25);
        Jlb_PWV.setFont(new Font("Serif", Font.BOLD, 25));
        c.add(Jlb_PWV);

        //password verify situation and size
        jpwv.setLocation(450, 350);
        jpwv.setSize(500, 30);
        jpwv.setFont(new Font("Serif", Font.BOLD, 25));
        jpwv.setEchoChar('.');
        jpwv.setToolTipText("password");
        c.add(jpwv);



        //JJlb_RN situation and size
        Jlb_RN.setLocation(310, 400);
        Jlb_RN.setSize(500, 25);
        Jlb_RN.setFont(new Font("Serif", Font.BOLD, 25));
        c.add(Jlb_RN);

        //real name situation and size
        jrn.setLocation(450, 400);
        jrn.setSize(500, 30);
        jrn.setFont(new Font("", Font.BOLD, 25));
        c.add(jrn);

        //Jlb_EM situation and size
        Jlb_EM.setLocation(350, 450);
        Jlb_EM.setSize(500, 25);
        Jlb_EM.setFont(new Font("Serif", Font.BOLD, 25));
        c.add(Jlb_EM);

        //e-mail situation and size
        jem.setLocation(450, 450);
        jem.setSize(500, 30);
        jem.setFont(new Font("", Font.BOLD, 25));
        c.add(jem);

        //Jlb_PN situation and size
        Jlb_PN.setLocation(270, 500);
        Jlb_PN.setSize(500, 30);
        Jlb_PN.setFont(new Font("Serif", Font.BOLD, 25));
        c.add(Jlb_PN);

        //phone number situation and size
        jpn.setLocation(450, 500);
        jpn.setSize(500, 30);
        jpn.setFont(new Font("", Font.BOLD, 25));
        c.add(jpn);

        // Jlb_AD situation and size
        Jlb_AD.setLocation(330, 550);
        Jlb_AD.setSize(500, 30);
        Jlb_AD.setFont(new Font("Serif", Font.BOLD, 25));
        c.add(Jlb_AD);
        
        //address situation and size
        jad.setLocation(450, 550);
        jad.setSize(500, 30);
        jad.setFont(new Font("", Font.BOLD, 25));
        c.add(jad);
        
        // Jlb_AD situation and size
        Jlb_ZI.setLocation(330,600);
        Jlb_ZI.setSize(500, 30);
        Jlb_ZI.setFont(new Font("Serif", Font.BOLD, 25));
        c.add(Jlb_ZI);
        
        //address situation and size
        jzi.setLocation(450, 600);
        jzi.setSize(500, 30);
        jzi.setFont(new Font("", Font.BOLD, 25));
        c.add(jzi);
        
        Jbtn_RI.setLocation(350, 850);
        Jbtn_RI.setSize(200, 40);
        Jbtn_RI.setFont(new Font("Serif", Font.BOLD, 20));
        Jbtn_RI.addActionListener(hbtHandler);
        c.add(Jbtn_RI);

        //clear button situation and size
        Jbtn_NO.setLocation(650, 850);
        Jbtn_NO.setSize(200, 40);
        Jbtn_NO.setFont(new Font("Serif", Font.BOLD, 20));
        Jbtn_NO.addActionListener(hbtHandler);
        c.add(Jbtn_NO);

        //board situation and size
        setSize(1200, 1000);
        setLocation(900, 400);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /** A Listener to respond the event of customer */
    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent evtE)
        {
        	char[] passwordc = jpw.getPassword();
        	String password = "";
        	for( int i = 0; i < passwordc.length; i++ )
        	{
        		password += passwordc[i];
        	}
        	
        	char[] passwordcv = jpwv.getPassword();
        	String passwordv = "";
        	for( int i = 0; i < passwordcv.length; i++ )
        	{
        		passwordv += passwordc[i];
        	}
            
            if(evtE.getSource() == Jbtn_RI )
            {
            	if(jun.getText().equals(""))
            	{
            		JOptionPane.showMessageDialog( null, "User name cannot be empty",
							"NDS Login Error", JOptionPane.ERROR_MESSAGE );
            	}
            	else if(jrn.getText().equals(""))
            	{
            		JOptionPane.showMessageDialog( null, "Your real name cannot be empty",
							"NDS Login Error", JOptionPane.ERROR_MESSAGE );
            	}
            	else if(jem.getText().equals(""))
            	{
            		JOptionPane.showMessageDialog( null, "Email cannot be empty",
							"NDS Login Error", JOptionPane.ERROR_MESSAGE );
            	}
            	else if(jpn.getText().equals(""))
            	{
            		JOptionPane.showMessageDialog( null, "Phone number cannot be empty",
							"NDS Login Error", JOptionPane.ERROR_MESSAGE );
            	}
            	else if(jad.getText() .equals(""))
            	{
            		JOptionPane.showMessageDialog( null, "Address cannot be empty",
							"NDS Login Error", JOptionPane.ERROR_MESSAGE );
            	}
            	else if(jzi.getText().equals(""))
            	{
            		JOptionPane.showMessageDialog( null, "Zip code cannot be empty",
							"NDS Login Error", JOptionPane.ERROR_MESSAGE );
            	}
            	else if(password.equals(""))
            	{
            		JOptionPane.showMessageDialog( null, "password cannot be empty",
							"NDS Login Error", JOptionPane.ERROR_MESSAGE );
            	}
            	else if(passwordv.equals(""))
            	{
            		JOptionPane.showMessageDialog( null, "Please verify password",
							"NDS Login Error", JOptionPane.ERROR_MESSAGE );
            	}
            	else if( !password.equals(passwordv))
            	{
            		JOptionPane.showMessageDialog( null, "The reentried password is not"
            				+ "same as the previous password",
							"NDS Login Error", JOptionPane.ERROR_MESSAGE );
            	}
            	
            	else
            	{
            	    JOptionPane.showMessageDialog( null, "Your information have been sent,"
            			+ "wait the newsagent to confirm.", "Register Reminder",
	                      JOptionPane.INFORMATION_MESSAGE );
            	}

            }
            else if(evtE.getSource() == Jbtn_NO)
            {
                jun.setText(null);
                jpw.setText(null);
                jpwv.setText(null);
                jrn.setText(null);
                jem.setText(null);
                jpn.setText(null);

            }
        }

        private void Hide() {
        }


    }



    public static void main(String [] args)
    {
        Register pw = new Register();
    }


}