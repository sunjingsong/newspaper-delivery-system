package nds;

import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/** 
 * A Newsagent class store information of newsagent.
 * <pre>
 * @author <a href = "mailto:jsun18@toromail.csudh.edu">Jingsong Sun</a>
 * @author YuNing Yu
 * @version 1.0.0
 * @since 1.0.0
 * </pre>
 */
public class Newsagent 
{
	protected NDSDatabase ndsd;
	protected int customerID;
	protected String userName;
	protected String password;
	protected String name;
	protected String address;
	protected int zipCode;
	protected String telNum;
	protected int holdStatus;
	protected int deliverStatus;
	
	/** Default constructor */
	public Newsagent()
	{
		this.customerID = -999;
		this.userName = "";
		this.password = "";
		this.name = "";
		this.address = "";
		this.zipCode = -999;
		this.telNum = "";
		this.holdStatus = 0;
		this.deliverStatus = 0;	
	}
	
	/** Nine-argument constructor
	 * 
	 * @param c customerID(int)
	 * @param un userName(String)
	 * @param p password(String)
	 * @param n name(String)
	 * @param a address(String)
	 * @param z zipCode(int)
	 * @param t telNum(String)
	 * @param h holdStatus(int)
	 * @param d deliverStatus(int)
	 */
	public Newsagent(int c, String un, String p, String n, String a,
			        int z, String t, int h, int d)
	{
		this.customerID = c;
		this.userName = un;
		this.password = p;
		this.name = n;
		this.address = a;
		this.zipCode = z;
		this.telNum = t;
		this.holdStatus = h;
		this.deliverStatus = d;
	}
	
	/** Setters for userName.
	 * @param userName(String)
	 */
	public void setName( String userName )
	{
	    this.userName = userName;
	}
	 
	/** Setters for password.
	 * @param password(String)
	 */
	public void setPassword( String password )
	{
	    this.password = password;
	}
	
	/** Constructs a table for customer information*/
	public void viewTable()
    {

		ndsd = new NDSDatabase();
		Object[][] tableData = ndsd.viewCustomerInfo();
    	JFrame jf1 = new JFrame("Customer Information");
    	JTable table;

    	Object[] columnTitle = {"Customer id" , "Publication" , "Publication price",
    			                "Order date", "Order time", "Name", "Address",
    			                "Zip code", "Telephone number", "Hold status"};
    	
    	table = new JTable(tableData , columnTitle);

    	jf1.add(new JScrollPane(table));
    	jf1.pack();
    	jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jf1.setVisible(true);
    }
	
	/** Constructs a table for add new account*/
	public void viewAddTable()
    {

		ndsd = new NDSDatabase();
		Object[][] tableData = ndsd.viewAdd();
    	JFrame jf1 = new JFrame("New Account Register");
    	JTable table;

    	Object[] columnTitle = {"Customer id" , "User name" , "Password",
    			                "Name", "Address", "Zip code",
    			                "Telephone", "Delivery status", "Publication"};
    		    	
    	table = new JTable(tableData , columnTitle);

    	jf1.add(new JScrollPane(table));
    	jf1.pack();
    	jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jf1.setVisible(true);
    }
	
	/** Constructs a table for delete account*/
	public void viewDeleteTable()
    {

		ndsd = new NDSDatabase();
		Object[][] tableData = ndsd.viewDelete();
    	JFrame jf1 = new JFrame("Delete Account Information");
    	JTable table;

    	Object[] columnTitle = {"Customer id" , "User name" , "Password",
    			                "Name", "Address", "Zip code",
    			                "Telephone", "Delivery status", "Publication"};
    		    	
    	table = new JTable(tableData , columnTitle);

    	jf1.add(new JScrollPane(table));
    	jf1.pack();
    	jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jf1.setVisible(true);
    }
	
	/** Constructs a table for update account*/
	public void viewUpdateTable()
    {

		ndsd = new NDSDatabase();
		Object[][] tableData = ndsd.viewUpdate();
    	JFrame jf1 = new JFrame("Update Account Information");
    	JTable table;

    	Object[] columnTitle = {"Customer id" , "User name" , "Password",
    			                "Name", "Address", "Zip code",
    			                "Telephone", "Delivery status", "Publication"};
    		    	
    	table = new JTable(tableData , columnTitle);

    	jf1.add(new JScrollPane(table));
    	jf1.pack();
    	jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jf1.setVisible(true);
    }
	
	/** Constructs a table for hold account*/
	public void viewHoldTable()
    {

		ndsd = new NDSDatabase();
		Object[][] tableData = ndsd.viewHold();
    	JFrame jf1 = new JFrame("Hold Account Information");
    	JTable table;

    	Object[] columnTitle = {"Customer id" , "User name" , "Password",
    			                "Name", "Address", "Zip code",
    			                "Telephone", "Delivery status", "Publication"};
    		    	
    	table = new JTable(tableData , columnTitle);

    	jf1.add(new JScrollPane(table));
    	jf1.pack();
    	jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jf1.setVisible(true);
    }
	
	/**
	 * Adds a new account.
	 * @param customerID(int)
	 */
	public void addAccount( int customerID )
	{
		ndsd.addCustomerAccount( customerID );
	}
	 
	/**
	 * Deletes a new account.
	 * @param customerID(int)
	 */
	public void deleteAccount( int customerID )
	{
		ndsd.deleteCustomerAccount( customerID );
	}
	
	/**
	 * Updates a new account.
	 * @param customerID(int)
	 */
	public void updateAccount( int customerID )
	{
		ndsd.updateCustomerAccount( customerID );
	}
	
	/**
	 * Holds a new account.
	 * @param customerID(int)
	 */
	public void holdAccount( int customerID )
	{
		ndsd.holdCustomerAccount( customerID );
	}
	/*
	public String values()
	{
		return "VALUES (" + "'" + userName + "'" + "," + "'" + password 
				        + "'" + "," + "'" + userName + "'" + "," + "'" + address
				        + "'" + "," + zipCode + "," + "'" + address
				        + "'" + "," + "'" + telNum + "'" + "," + holdStatus
				        + "," + deliverStatus + ")";
	}
    */
}
