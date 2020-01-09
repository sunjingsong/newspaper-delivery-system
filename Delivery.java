package nds;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/** 
 * A delivery class store information of delivery person.
 * <pre>
 * @author <a href = "mailto:jsun18@toromail.csudh.edu">Jingsong Sun</a>
 * @author Alexander Toneff
 * @version 1.0.0
 * @since 1.0.0
 * </pre>
 */
public class Delivery
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
	public Delivery()
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
	public Delivery(int c, String un, String p, String n, String a,
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
	
	/** Constructs a table for delivery information*/
	public void deliveryTable()
    {
		System.out.println("Hello");

		ndsd = new NDSDatabase();
		Object[][] tableData = ndsd.deliveryInfo();
    	JFrame jf1 = new JFrame("Delivery Information");
    	JTable table;

    	Object[] columnTitle = {"Publication" , "Address" , "Zip code"};
    	
    	table = new JTable(tableData , columnTitle);

    	jf1.add(new JScrollPane(table));
    	jf1.pack();
    	jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jf1.setVisible(true);
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