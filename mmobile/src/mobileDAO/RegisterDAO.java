package mobileDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import mobileModel.RegisterModel;


public class RegisterDAO {
	private static Connection con;
 private String dburl="jdbc:mysql://localhost:3306/mobiledb";
 private String dbuname="root";
 private String dbpassword="sahil123";
 private String dbdriver="com.mysql.jdbc.Driver";
 public void loadDriver(String dbdriver)
 {
	 try {
		Class.forName(dbdriver);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
 public Connection getConnection()
 {
	 Connection con=null;
	 try {
		con=DriverManager.getConnection(dburl, dbuname, dbpassword);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return con;
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
 public boolean insert(RegisterModel registration)
 {
	 loadDriver(dbdriver);
	 Connection con=getConnection();
	 boolean status=false;
	 
	 String sql="insert into mobiledb.register values(?,?,?,?,?,?,?,?,?,?)";
	try {
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,registration.getUserid());
		ps.setString(2,registration.getName());
		ps.setString(3,registration.getGender());
		ps.setString(4,registration.getEmail());
		ps.setString(5,registration.getPassword());
		ps.setString(6,registration.getPhno());
		ps.setString(7,registration.getSecretqsn());
		ps.setString(8,registration.getSecretans());
		ps.setString(9,registration.getAddress());
		ps.setString(10,registration.getUtype());
		System.out.println("sql:"+ps.toString());
		int nor=ps.executeUpdate();
		closeConnection();
		   if(nor>0)
			   return true;
		   else
			   return false;
	  }
	  catch(SQLException e)
	  {
	  e.printStackTrace();
	  return false;
	  }
	  catch(Exception e)
	  {
	  e.printStackTrace();
	  return false;
	  }
		
	
 }
}