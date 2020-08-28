package mobileDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mobileModel.RegisterModel;
public class ForgotDAO {

	  @SuppressWarnings("finally")
	public static boolean validate(RegisterModel registerModel)
	  {
		  boolean status=false;
		  Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	    
		  try{
			  Class.forName("com.mysql.jdbc.Driver");
			  conn = DriverManager
	                    .getConnection("jdbc:mysql://localhost:3306/mobiledb", "root", "sahil123");

			  stmt=conn.prepareStatement("select * from register where userid=? and secretqsn=? and secretans=?");
			  stmt.setString(1, registerModel.getUserid());
			  stmt.setString(2, registerModel.getSecretqsn());
			  stmt.setString(3, registerModel.getSecretans());
			   rs=stmt.executeQuery();  
			  status=rs.next(); 
		  }
		  catch (Exception e) {
	            System.out.println(e);
		  }
		  finally {
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            if (stmt != null) {
	                try {
	                    stmt.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	                if (rs != null) {
	                    try {
	                        rs.close();
	                    } catch (SQLException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	            return status;
			  }
		  }	 
}
