package nds;
import java.sql.*;
/** 
 * A database of Newspaper Delivery System.
 * <pre>
 * The database includes 4 tables.
 * It can check, add, delete and update the data.
 * @author <a href = "mailto:jsun18@toromail.csudh.edu">Jingsong Sun</a>
 * @version 1.0.0
 * @since 1.0.0
 * </pre>
 */
public class NDSDatabase
{
	// data for customers
	protected Object o[][];
	protected Customer cu;
	protected CustomerDashboard cd;
	protected CustomerInterface ci;
	
   
	// data for publication
	protected int publicationID;
	protected double pricePerMonth;
	
	// data for orders
	protected int orderID;
	protected String orderDate;
	protected String orderTime;
	
	// data for delivery person
	protected DeliveryInterface di;
	protected int deliverID;
	protected String deliverUserName;
	protected String deliverUserPassword;
	
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/ndsdatabase";

	//  Database credentials
	static final String USER = "newsagent";
	static final String PASS = "mysql958";
	
	Connection conn = null;
	Statement stmt = null;

	/**
     * Adds a customer account to the database.
     * @param customerID customerID(int) to identify customer.
     */
	public void addCustomerAccount( int customerID )
	{
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      //STEP 4: Execute a query
		      stmt = conn.createStatement();
              String sql = "SELECT * FROM requirements WHERE customer_id = " + customerID;
		      ResultSet rs = stmt.executeQuery(sql);
		      if( rs.next())
		      {
		          int ci = customerID;
	    	      String un = rs.getString( "user_name" );
	    	      String up = rs.getString( "user_password" );
	    	      String na = rs.getString( "name" );
	    	      String ad = rs.getString( "address" );
	    	      int zi = rs.getInt( "zip_code" );
	    	      String tel = rs.getString( "tel" );
	    	      int ds = rs.getInt( "deliver_status" );
	    	      String pu = rs.getString( "publication" );
		      
	    	      String sql1 = "INSERT INTO customers VALUES(NULL," + "\"" + un + "\"" + ","
	    	                + "\"" + up + "\"" + "," + "\"" + na + "\"" + ","
	    	                + "\"" + ad + "\"" + "," + zi + "," + "\"" + tel + "\"" + ","
	    	                + ds + "," + 0 + ")";
	    	      System.out.println( sql1 );
	    	      
	    	      stmt.executeUpdate( sql1 );
	    	      
	    	      String sql0 = "SELECT * FROM customers WHERE user_name = " + "\"" + un
	    	    		        + "\"" + " AND " + "user_password = " + "\"" + up + "\"";    	      
			      ResultSet rs0 = stmt.executeQuery(sql0);
			      if( rs0.next())
			      {
			    	  ci = rs0.getInt( "customer_id" );
			    	  System.out.println(ci);
			      }
			      
	    	      String sql2 = "INSERT INTO orders values(NULL," + ci + ","
  	                    + "NULL" + "," + "NULL" + ","
  	                    + "\"" + pu + "\"" +"," + "NULL" + ")";
	    	      System.out.println( sql2 );
	    	      stmt.executeUpdate( sql2 );
		      }
		   }
		catch(SQLException se)
		{
		      //Handle errors for JDBC
		      se.printStackTrace();
		}
		catch(Exception e)
		{
		     //Handle errors for Class.forName
		     e.printStackTrace();
		}
		finally
		{
		     //finally block used to close resources
		      
			try{
		         if(stmt!=null)
		            stmt.close();
		       }
			   catch(SQLException se)
			   {
		       }// do nothing
		    try{
		         if(conn!=null)
		            conn.close();
		       }
		      catch(SQLException se)
		      {
		         se.printStackTrace();
		      }//end finally try
		   }//end try
	}
	
	/**
     * Delete a customer account from the database.
     * @param customerID customerID(int) to identify customer.
     */
	public void deleteCustomerAccount( int customerID )
	{
		int cid = 0;
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      //STEP 4: Execute a query
		      stmt = conn.createStatement();
              String sql = "SELECT * FROM requirements WHERE customer_id = " + customerID;
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      if( rs.next())
		      {
		          int ci = customerID;
	    	      String un = rs.getString( "user_name" );
	    	      String up = rs.getString( "user_password" );
	    	      String na = rs.getString( "name" );
	    	      String ad = rs.getString( "address" );
	    	      int zi = rs.getInt( "zip_code" );
	    	      String tel = rs.getString( "tel" );
	    	      int ds = rs.getInt( "deliver_status" );
	    	      String pu = rs.getString( "publication" );
		      
	    	      String sql0 = "SELECT * from customers WHERE user_name = " + "\"" + un
  	    		        + "\"" + " AND " + "user_password = " + "\"" + up + "\"";
	    	      ResultSet rs0 = stmt.executeQuery(sql0);
	    	      if( rs0.next())
	    	      {
	    	    	  cid = rs0.getInt("customer_id");
	    	      }
  	      
	    	      String sql1 = "Delete from customers WHERE user_name = " + "\"" + un
	    	    		        + "\"" + " AND " + "user_password = " + "\"" + up + "\"";
	    	      
	    	      System.out.println( sql1 );
	    	      
	    	      stmt.executeUpdate( sql1 );
	    	      
	    	      String sql2 = "DELETE FROM orders WHERE customer_id = " + cid;
	    	      System.out.println( sql2 );
	    	      stmt.executeUpdate( sql2 );
	    	      
	    	  
	    	     
		      }
		   }
		catch(SQLException se)
		{
		      //Handle errors for JDBC
		      se.printStackTrace();
		}
		catch(Exception e)
		{
		     //Handle errors for Class.forName
		     e.printStackTrace();
		}
		finally
		{
		     //finally block used to close resources
		      
			try{
		         if(stmt!=null)
		            stmt.close();
		       }
			   catch(SQLException se)
			   {
		       }// do nothing
		    try{
		         if(conn!=null)
		            conn.close();
		       }
		      catch(SQLException se)
		      {
		         se.printStackTrace();
		      }//end finally try
		   }//end try
	}
	
	/**
     * Update a customer account in the database.
     * @param customerID customerID(int) to identify customer.
     */
	public void updateCustomerAccount( int customerID )
	{
		int cid = 0;
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      //STEP 4: Execute a query
		      stmt = conn.createStatement();
              String sql = "SELECT * FROM requirements WHERE customer_id = " + customerID;
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      if( rs.next())
		      {
		          int ci = customerID;
	    	      String un = rs.getString( "user_name" );
	    	      String up = rs.getString( "user_password" );
	    	      String na = rs.getString( "name" );
	    	      String ad = rs.getString( "address" );
	    	      int zi = rs.getInt( "zip_code" );
	    	      String tel = rs.getString( "tel" );
	    	      int ds = rs.getInt( "deliver_status" );
	    	      String pu = rs.getString( "publication" );
		      
	    	      String sql0 = "SELECT * from customers WHERE user_name = " + "\"" + un
  	    		        + "\"" + " AND " + "user_password = " + "\"" + up + "\"";
	    	      ResultSet rs0 = stmt.executeQuery(sql0);
	    	      if( rs0.next())
	    	      {
	    	    	  cid = rs0.getInt("customer_id");
	    	      }
  	      
	    	      String sql1 = "UPDATE customers set name = " + "\"" + na + "\"" + ","
	    	                    + "address = " + "\"" + ad + "\"" + "," + "zip_code = "
	    	    		        + zi + "," + "tel = " + "\"" + tel + "\"" + ","
	    	                    + "WHERE user_name = " + "\"" + un
	    	    		        + "\"" + " AND " + "user_password = " + "\"" + up + "\"";
	    	      
	    	      System.out.println( sql1 );
	    	      
	    	      stmt.executeUpdate( sql1 );
	    	      
	    	      String sql2 = "UPDATE orders set publication = " + "\"" + pu
	    	    		        + "\"" + " WHERE customer_id = " + cid;
	    	      System.out.println( sql2 );
	    	      stmt.executeUpdate( sql2 );
	    	      
	    	  
	    	     
		      }
		   }
		catch(SQLException se)
		{
		      //Handle errors for JDBC
		      se.printStackTrace();
		}
		catch(Exception e)
		{
		     //Handle errors for Class.forName
		     e.printStackTrace();
		}
		finally
		{
		     //finally block used to close resources
		      
			try{
		         if(stmt!=null)
		            stmt.close();
		       }
			   catch(SQLException se)
			   {
		       }// do nothing
		    try{
		         if(conn!=null)
		            conn.close();
		       }
		      catch(SQLException se)
		      {
		         se.printStackTrace();
		      }//end finally try
		   }//end try
	}
	
	/**
     * Hold a customer account in the database.
     * @param customerID customerID(int) to identify customer.
     */
	public void holdCustomerAccount( int customerID )
	{
		int cid = 0;
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      //STEP 4: Execute a query
		      stmt = conn.createStatement();
              String sql = "SELECT * FROM requirements WHERE customer_id = " + customerID;
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      if( rs.next())
		      {
		          int ci = customerID;
	    	      String un = rs.getString( "user_name" );
	    	      String up = rs.getString( "user_password" );
	    	      String na = rs.getString( "name" );
	    	      String ad = rs.getString( "address" );
	    	      int zi = rs.getInt( "zip_code" );
	    	      String tel = rs.getString( "tel" );
	    	      int ds = rs.getInt( "deliver_status" );
	    	      String pu = rs.getString( "publication" );
		      
	    	      String sql0 = "SELECT * from customers WHERE user_name = " + "\"" + un
  	    		        + "\"" + " AND " + "user_password = " + "\"" + up + "\"";
	    	      ResultSet rs0 = stmt.executeQuery(sql0);
	    	      if( rs0.next())
	    	      {
	    	    	  cid = rs0.getInt("customer_id");
	    	      }
  	      
	    	      String sql1 = "UPDATE customers set hold_status = " + 1
	    	                    + "WHERE user_name = " + "\"" + un
	    	    		        + "\"" + " AND " + "user_password = " + "\"" + up + "\"";
	    	      
	    	      System.out.println( sql1 );
	    	      
	    	      stmt.executeUpdate( sql1 );
	    	      
	    	  
	    	     
		      }
		   }
		catch(SQLException se)
		{
		      //Handle errors for JDBC
		      se.printStackTrace();
		}
		catch(Exception e)
		{
		     //Handle errors for Class.forName
		     e.printStackTrace();
		}
		finally
		{
		     //finally block used to close resources
		      
			try{
		         if(stmt!=null)
		            stmt.close();
		       }
			   catch(SQLException se)
			   {
		       }// do nothing
		    try{
		         if(conn!=null)
		            conn.close();
		       }
		      catch(SQLException se)
		      {
		         se.printStackTrace();
		      }//end finally try
		   }//end try
	}
		
	/**
     * Select a customer account in the database.
     * @return (boolean) show select successful.
     */	
	public boolean selectCustomer()
	{
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      //STEP 4: Execute a query
		      stmt = conn.createStatement();

		      String sql = "SELECT customer_id, user_name, user_password,"
		      		       + " name, address, zip_code, tel, hold_status,"
		      		       + " deliver_status" +" FROM customers"
		      		       + " where customer_id = " + cu.customerID;
		      ResultSet rs = stmt.executeQuery(sql);
		      while(rs.next())
		      {
		          //Retrieve by column name
		          int id  = rs.getInt("customer_id");
		          System.out.println( id );
		      }

		      

		}
		catch(SQLException se)
		{
		      //Handle errors for JDBC
		      se.printStackTrace();
		}
		catch(Exception e)
		{
		     //Handle errors for Class.forName
		     e.printStackTrace();
		}
		finally
		{
		     //finally block used to close resources
		      
			try{
		         if(stmt!=null)
		            stmt.close();
		       }
			   catch(SQLException se)
			   {
		       }// do nothing
		    try{
		         if(conn!=null)
		            conn.close();
		       }
		      catch(SQLException se)
		      {
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		return false;
	}
	
	/**
     * Login a customer account via validate user name and password in the database.
     * @param userName(String) represent customer user name
     * @param password(String) represent the password for login
     * @return (boolean) to indicates if login successful
     */
	public boolean loginCustomer(String userName, String password)
	{	
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      //STEP 4: Execute a query
		      stmt = conn.createStatement();
              String sql = "SELECT * FROM customers "
		               + "WHERE user_name = " + "\"" + userName + "\""+ " AND"
		               + " user_password = " + "\"" + password+ "\"";

              ResultSet rs = stmt.executeQuery( sql );
		      if( rs.next() )
		      {
		  		
		  		  int c = rs.getInt( "customer_id" );
		  		  String u = rs.getString( "user_name" );
		  		  String p = rs.getString( "user_password" );
		  		  String n = rs.getString( "name" );
		  		  String a = rs.getString( "address" );
		  		  int z = rs.getInt( "zip_code" );
		  		  String t = rs.getString( "tel" );
		  		  int h = rs.getInt( "hold_status" );
		  		  int d = rs.getInt( "deliver_Status" );
		          cu = new Customer( c, u, p, n, a, z, t, h, d );
		    	  return true;
		    	  
		      }	      

		}
		catch(SQLException se)
		{
		      //Handle errors for JDBC
		      se.printStackTrace();
		}
		catch(Exception e)
		{
		     //Handle errors for Class.forName
		     e.printStackTrace();
		}
		finally
		{
		     //finally block used to close resources
			try{
		         if(stmt!=null)
		            stmt.close();
		       }
			   catch(SQLException se)
			   {
		       }// do nothing
		    try{
		         if(conn!=null)
		            conn.close();
		       }
		      catch(SQLException se)
		      {
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		return false;
	}
	
	/**
     * Login a delivery person account via validate user name and password in the database.
     * @param userName(String) represent delivery person's user name
     * @param password(String) represent the password for login
     * @return (boolean) to indicates if login successful
     */
	public boolean loginDelivery(String userName, String password)
	{	
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      //STEP 4: Execute a query
		      stmt = conn.createStatement();
              String sql = "SELECT * FROM delivery "
		               + "WHERE user_name = " + "\"" + userName + "\""+ " AND"
		               + " user_password = " + "\"" + password+ "\"";
              
            
              ResultSet rs = stmt.executeQuery( sql );
		      if( rs.next() )
		      {
		  		
		  		  /* int c = rs.getInt( "customer_id" );
		  		  String u = rs.getString( "user_name" );
		  		  String p = rs.getString( "user_password" );
		  		  String n = rs.getString( "name" );
		  		  String a = rs.getString( "address" );
		  		  int z = rs.getInt( "zip_code" );
		  		  String t = rs.getString( "tel" );
		  		  int h = rs.getInt( "hold_status" );
		  		  int d = rs.getInt( "deliver_Status" );
		          cu = new Delivery( c, u, p, n, a, z, t, h, d );*/
		    	  return true;
		    	  
		      }	      

		}
		catch(SQLException se)
		{
		      //Handle errors for JDBC
		      se.printStackTrace();
		}
		catch(Exception e)
		{
		     //Handle errors for Class.forName
		     e.printStackTrace();
		}
		finally
		{
		     //finally block used to close resources
			try{
		         if(stmt!=null)
		            stmt.close();
		       }
			   catch(SQLException se)
			   {
		       }// do nothing
		    try{
		         if(conn!=null)
		            conn.close();
		       }
		      catch(SQLException se)
		      {
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		return false;
	}
	
	/**
     * The order condition of a customer.
     * @param customerID(int) to identify customer
     * @return o(Object[][]) the object of customer with data
     */
	public Object[][] customerOrder( int customerID )
	{	
		
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      //STEP 4: Execute a query
		      stmt = conn.createStatement();
              String sql = "SELECT * FROM orders "
		               + "WHERE customer_id = " + customerID;
              System.out.println(sql);
              ResultSet rs = stmt.executeQuery( sql );
              
              o = new Object[10][5];
              int k = 0;
		      while( rs.next() )
		      {
		  		  int oi = rs.getInt( "order_id" );
		  		  String od = rs.getString( "order_date" );
		  		  String ot = rs.getString( "order_time" );
		  		  String pub = rs.getString( "publication" );
		  		  double pr = rs.getDouble( "price" );
		  		  
		  		  
		  		  o[k][0] = oi;
		  		  o[k][1] = od;
		  		  o[k][2] = ot;
		  		  o[k][3] = pub;
		  		  o[k][4] = pr;
		  		  
		  		  k++;
		  		  
		    	  
		      }	
		      return o;
		     

		}
		catch(SQLException se)
		{
		      //Handle errors for JDBC
		      se.printStackTrace();
		}
		catch(Exception e)
		{
		     //Handle errors for Class.forName
		     e.printStackTrace();
		}
		finally
		{
		     //finally block used to close resources
		      
			try{
		         if(stmt!=null)
		            stmt.close();
		       }
			   catch(SQLException se)
			   {
		       }// do nothing
		    try{
		         if(conn!=null)
		            conn.close();
		       }
		      catch(SQLException se)
		      {
		         se.printStackTrace();
		      }
		     
		}//end try
	    return o;
	}

	/**
     * The delivery information for delivery person.
     * @return o(Object[][]) the delivery information
     */
	public Object[][] deliveryInfo()
	{	
		
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      //STEP 4: Execute a query
		      stmt = conn.createStatement();
              String sql = "SELECT * FROM orders";
              
              ResultSet rs = stmt.executeQuery( sql );
              
              
              o = new Object[20][3];
              int k = 0;
		      while( rs.next() )
		      {
		    	  
		  		  int oi = rs.getInt( "order_id" );
		  		  int ci = rs.getInt( "customer_id" );
		  		  String od = rs.getString( "order_date" );
		  		  String ot = rs.getString( "order_time" );
		  		  String pub = rs.getString( "publication" );
		  		  double pr = rs.getDouble( "price" );
		  		  
		  		  
		  		  
		  		  o[k][0] = pub;
		  		  
		  		  String sql1 = "SELECT * FROM customers "
	            		  + "WHERE hold_status = 0" + " AND"
			              + " deliver_status = 0" + " AND"
	            		  + " customer_id = " + ci;
	              ResultSet rs1 = stmt.executeQuery( sql1 );
	              if(rs1.next())
	              {
	                  String ad = rs1.getString( "address" );
	              
	                  int zip = rs1.getInt( "zip_code" );
	                  o[k][1] = ad;
	                  o[k][2] = zip;
	              }
		  		  rs1.close();
		  		  
	              k++;
		  		  
		    	  
		      }	
		      return o;
		     

		}
		catch(SQLException se)
		{
		      //Handle errors for JDBC
		      se.printStackTrace();
		}
		catch(Exception e)
		{
		     //Handle errors for Class.forName
		     e.printStackTrace();
		}
		finally
		{
		     //finally block used to close resources
		      
			try{
		         if(stmt!=null)
		            stmt.close();
		       }
			   catch(SQLException se)
			   {
		       }// do nothing
		    try{
		         if(conn!=null)
		            conn.close();
		       }
		      catch(SQLException se)
		      {
		         se.printStackTrace();
		      }
		     
		}//end try
	    return o;
	}
	
	/**
     * The customer information for viewing.
     * @return o(Object[][]) the customer information
     */
	public Object[][] viewCustomerInfo()
	{	
		
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      //STEP 4: Execute a query
		      stmt = conn.createStatement();
              String sql = "SELECT * FROM orders";
              
              ResultSet rs = stmt.executeQuery( sql );
              
              
              o = new Object[20][10];
              int k = 0;
		      while( rs.next() )
		      {
		  		  int oi = rs.getInt( "order_id" );
		  		  int ci = rs.getInt( "customer_id" );
		  		  String od = rs.getString( "order_date" );
		  		  String ot = rs.getString( "order_time" );
		  		  String pub = rs.getString( "publication" );
		  		  double pr = rs.getDouble( "price" );
		  		  
		  		  
		  		  
		  		  o[k][0] = ci;
		  		  o[k][1] = pub;
		  		  o[k][2] = pr;
		  		  o[k][3] = od;
		  		  o[k][4] = ot;

		  		  
		  		  String sql1 = "SELECT * FROM customers "
	            		  + "WHERE customer_id = " + ci;
		  		  System.out.println(sql1);
		  		  try
		  		  {
		  			  PreparedStatement pstmt = conn.prepareStatement(sql1);
	                  ResultSet rs1 = pstmt.executeQuery( sql1 );
	                  if(rs1.next())
		              {
		            	  String na = rs1.getString( "name" );
		                  String ad = rs1.getString( "address" );
		                
		                  int zip = rs1.getInt( "zip_code" );
		                  String tel = rs1.getString( "tel" );
		                  int ho = rs1.getInt( "hold_status" );
		     
		                  o[k][5] = na;
		                  o[k][6] = ad;
		                  o[k][7] = zip;
		                  o[k][8] = tel;
		                  o[k][9] = ho;
		              }
		  		  }
		  		  catch(SQLException ex)
		  		  {
		  			  
		  		  }

	              
	              
		  		  k++;
		  		  System.out.println(k);
		  		  
		  		  
		    	  
		      }	
		      rs.close();
		      return o;
		     

		}
		catch(SQLException se)
		{
		      //Handle errors for JDBC
		      se.printStackTrace();
		}
		catch(Exception e)
		{
		     //Handle errors for Class.forName
		     e.printStackTrace();
		}
		finally
		{
		     //finally block used to close resources
		      
			try{
		         if(stmt!=null)
		            stmt.close();
		       }
			   catch(SQLException se)
			   {
		       }// do nothing
		    try{
		         if(conn!=null)
		            conn.close();
		       }
		      catch(SQLException se)
		      {
		         se.printStackTrace();
		      }
		     
		}//end try
	    return o;
	}

	/**
     * The information for adding account.
     * @return o(Object[][]) the information of new account
     */
	public Object[][] viewAdd()
	{	
		
		try
		{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      //STEP 4: Execute a query
		      stmt = conn.createStatement();
              String sql = "SELECT * FROM requirements WHERE add_status = 1";
              
              ResultSet rs = stmt.executeQuery( sql );
              
              
              o = new Object[20][10];
              int k = 0;
		      while( rs.next() )
		      {
		    	         
		  		  int ci = rs.getInt( "customer_id" );
		    	  String un = rs.getString( "user_name" );
		    	  String up = rs.getString( "user_password" );
		    	  String na = rs.getString( "name" );
		    	  String ad = rs.getString( "address" );
		    	  int zi = rs.getInt( "zip_code" );
		    	  String tel = rs.getString( "tel" );
		    	  int ds = rs.getInt( "deliver_status" );
		    	  String pu = rs.getString( "publication" );		    	  		  		  
		  		  
		  		  
		  		  o[k][0] = ci;
		  		  o[k][1] = un;
		  		  o[k][2] = up;
		  		  o[k][3] = na;
		  		  o[k][4] = ad;
		  		  o[k][5] = zi;
		  		  o[k][6] = tel;
		  		  o[k][7] = ds;
		  		  o[k][8] = pu;  
		  		  
		  		  k++;
		  		 
	         }
	         return o;
		}	   
		catch(SQLException se)
		{
		      //Handle errors for JDBC
		      se.printStackTrace();
		}
		catch(Exception e)
		{
		     //Handle errors for Class.forName
		     e.printStackTrace();
		}
		finally
		{
		     //finally block used to close resources
		      
			try{
		         if(stmt!=null)
		            stmt.close();
		       }
			   catch(SQLException se)
			   {
		       }// do nothing
		    try{
		         if(conn!=null)
		            conn.close();
		       }
		      catch(SQLException se)
		      {
		         se.printStackTrace();
		      }
		     
		}//end try
	    return o;
	}
	
	/**
     * The  information for deleting account.
     * @return o(Object[][]) the information of deleted account
     */
	public Object[][] viewDelete()
	{	
		
		try
		{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      //STEP 4: Execute a query
		      stmt = conn.createStatement();
              String sql = "SELECT * FROM requirements WHERE delete_status = 1";
              
              ResultSet rs = stmt.executeQuery( sql );
              
              
              o = new Object[20][10];
              int k = 0;
		      while( rs.next() )
		      {
		    	         
		  		  int ci = rs.getInt( "customer_id" );
		    	  String un = rs.getString( "user_name" );
		    	  String up = rs.getString( "user_password" );
		    	  String na = rs.getString( "name" );
		    	  String ad = rs.getString( "address" );
		    	  int zi = rs.getInt( "zip_code" );
		    	  String tel = rs.getString( "tel" );
		    	  int ds = rs.getInt( "deliver_status" );
		    	  String pu = rs.getString( "publication" );		    	  		  		  
		  		  
		  		  
		  		  o[k][0] = ci;
		  		  o[k][1] = un;
		  		  o[k][2] = up;
		  		  o[k][3] = na;
		  		  o[k][4] = ad;
		  		  o[k][5] = zi;
		  		  o[k][6] = tel;
		  		  o[k][7] = ds;
		  		  o[k][8] = pu;  
		  		  
		  		  k++;
		  		 
	         }
	         return o;
		}	   
		catch(SQLException se)
		{
		      //Handle errors for JDBC
		      se.printStackTrace();
		}
		catch(Exception e)
		{
		     //Handle errors for Class.forName
		     e.printStackTrace();
		}
		finally
		{
		     //finally block used to close resources
		      
			try{
		         if(stmt!=null)
		            stmt.close();
		       }
			   catch(SQLException se)
			   {
		       }// do nothing
		    try{
		         if(conn!=null)
		            conn.close();
		       }
		      catch(SQLException se)
		      {
		         se.printStackTrace();
		      }
		     
		}//end try
	    return o;
	}

	/**
     * The information for updating account.
     * @return o(Object[][]) the information of updating account
     */
	public Object[][] viewUpdate()
	{	
		
		try
		{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      //STEP 4: Execute a query
		      stmt = conn.createStatement();
              String sql = "SELECT * FROM requirements WHERE update_status = 1";
              
              ResultSet rs = stmt.executeQuery( sql );
              
              
              o = new Object[20][10];
              int k = 0;
		      while( rs.next() )
		      {
		    	         
		  		  int ci = rs.getInt( "customer_id" );
		    	  String un = rs.getString( "user_name" );
		    	  String up = rs.getString( "user_password" );
		    	  String na = rs.getString( "name" );
		    	  String ad = rs.getString( "address" );
		    	  int zi = rs.getInt( "zip_code" );
		    	  String tel = rs.getString( "tel" );
		    	  int ds = rs.getInt( "deliver_status" );
		    	  String pu = rs.getString( "publication" );		    	  		  		  
		  		  
		  		  
		  		  o[k][0] = ci;
		  		  o[k][1] = un;
		  		  o[k][2] = up;
		  		  o[k][3] = na;
		  		  o[k][4] = ad;
		  		  o[k][5] = zi;
		  		  o[k][6] = tel;
		  		  o[k][7] = ds;
		  		  o[k][8] = pu;  
		  		  
		  		  k++;
		  		 
	         }
	         return o;
		}	   
		catch(SQLException se)
		{
		      //Handle errors for JDBC
		      se.printStackTrace();
		}
		catch(Exception e)
		{
		     //Handle errors for Class.forName
		     e.printStackTrace();
		}
		finally
		{
		     //finally block used to close resources
		      
			try{
		         if(stmt!=null)
		            stmt.close();
		       }
			   catch(SQLException se)
			   {
		       }// do nothing
		    try{
		         if(conn!=null)
		            conn.close();
		       }
		      catch(SQLException se)
		      {
		         se.printStackTrace();
		      }
		     
		}//end try
	    return o;
	}
	
	/**
     * The information for holding customer.
     * @return o(Object[][]) the information of holding customer
     */
	public Object[][] viewHold()
	{	
		
		try
		{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      //STEP 4: Execute a query
		      stmt = conn.createStatement();
              String sql = "SELECT * FROM requirements WHERE hold_status = 1";
              
              ResultSet rs = stmt.executeQuery( sql );
              
              
              o = new Object[20][10];
              int k = 0;
		      while( rs.next() )
		      {
		    	         
		  		  int ci = rs.getInt( "customer_id" );
		    	  String un = rs.getString( "user_name" );
		    	  String up = rs.getString( "user_password" );
		    	  String na = rs.getString( "name" );
		    	  String ad = rs.getString( "address" );
		    	  int zi = rs.getInt( "zip_code" );
		    	  String tel = rs.getString( "tel" );
		    	  int ds = rs.getInt( "deliver_status" );
		    	  String pu = rs.getString( "publication" );		    	  		  		  
		  		  
		  		  
		  		  o[k][0] = ci;
		  		  o[k][1] = un;
		  		  o[k][2] = up;
		  		  o[k][3] = na;
		  		  o[k][4] = ad;
		  		  o[k][5] = zi;
		  		  o[k][6] = tel;
		  		  o[k][7] = ds;
		  		  o[k][8] = pu;  
		  		  
		  		  k++;
		  		 
	         }
	         return o;
		}	   
		catch(SQLException se)
		{
		      //Handle errors for JDBC
		      se.printStackTrace();
		}
		catch(Exception e)
		{
		     //Handle errors for Class.forName
		     e.printStackTrace();
		}
		finally
		{
		     //finally block used to close resources
		      
			try{
		         if(stmt!=null)
		            stmt.close();
		       }
			   catch(SQLException se)
			   {
		       }// do nothing
		    try{
		         if(conn!=null)
		            conn.close();
		       }
		      catch(SQLException se)
		      {
		         se.printStackTrace();
		      }
		     
		}//end try
	    return o;
	}
}
