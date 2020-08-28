package mobileDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mobileModel.RegisterModel;
public class LoginDAO {
	private static Connection con; 
	  private static PreparedStatement stmt;
	  
	public static void getConnection()
	  {	 	
		  String JdbcURL = "jdbc:mysql://localhost:3306/mobiledb" + "autoReconnect=true&useSSL=false";
	      String Username = "root";
	      String password = "sahil123";
	       con = null;      
	      try 
	      {
	    	 Class.forName("com.mysql.jdbc.Driver");   // Driver should be registered
	    	 // con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/test1","root","");  
	         con = DriverManager.getConnection(JdbcURL, Username, password);
	         
	      } 
	      catch (Exception e) 
	      {
	         e.printStackTrace();
	      }
		   
		 
	  }
	  public static void closeConnection()
	  {
		  try{
			  if(con.isClosed()==false)
		          con.close();   // closing the connection
		  }
		  catch(Exception e)
		  { e.printStackTrace();	 }
	  }  

	  @SuppressWarnings("finally")
	public static boolean validate(RegisterModel registerModel)
	  {
		  boolean status=false;
		  try
		  {
			  getConnection();
		  stmt=con.prepareStatement("select * from register where userid=? and password=?");
		  stmt.setString(1, registerModel.getUserid());
	      stmt.setString(2, registerModel.getPassword());
		  ResultSet rs=stmt.executeQuery();  
		  status=rs.next(); 
		  closeConnection();
		  }
		  catch(SQLException e)
		  {	  e.printStackTrace();	 return false; }
		  catch(Exception e)
		  {	  e.printStackTrace();	 return false; }  	  
		  
	            return status;
	 }
 

}