package mobileDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mobileModel.ProductModel;



public class EditDAO {
	
	 private static Connection con; 
	 private static PreparedStatement stmt;
	  
	public static void getConnection()
	  {	 	
		  String JdbcURL = "jdbc:mysql://localhost:3306/test123?" + "autoReconnect=true&useSSL=false";
	      String Username = "root";
	      String password = "";
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
	  
  public static ArrayList<String> getAllBrand()
  {
  ArrayList<String> allbrand=new ArrayList<String>();	  
  try
  {
    getConnection();
    stmt=con.prepareStatement("select distinct brand from product");       
    ResultSet rs=stmt.executeQuery();  
    while(rs.next())
	  {  
	    	allbrand.add(rs.getString(1))	; 		
	  }  
     closeConnection();	 
     return allbrand;
  }
  catch(SQLException e)
  {	  e.printStackTrace();	 return null; }
  catch(Exception e)
  {	  e.printStackTrace();	 return null; }  	  
}
  public static ArrayList<ProductModel> getProductssByBrand(String brand)
  {
	  ArrayList <ProductModel> products=new ArrayList<ProductModel>();
	  ProductModel temp; 
	  	  
	  try
	  {
	  getConnection();
      stmt=con.prepareStatement("select pid,pname,ram,rom,processor,battery,price,descrptn from product where brand=?"); 
      stmt.setString(1, brand);
	  ResultSet rs=stmt.executeQuery();  
	 // System.out.println(branch);
	  while(rs.next())
		  {  		   
		  temp=new ProductModel(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),brand);	
		  products.add(temp); 		  
		  
		  }  
	     closeConnection();	 
	     return products;
	  }
	  catch(SQLException e)
	  {	  e.printStackTrace();	 return null; }
	  catch(Exception e)
	  {	  e.printStackTrace();	 return null; }  	  
  }
  public static ProductModel getProductsByPid(String pid)
  {
	  ProductModel temp=null;	  	  
	  try
	  {
	  getConnection();
      stmt=con.prepareStatement("select pid,pname,brand,ram,rom,processor,battery,price,descrptn from product where brand=?");
      stmt.setString(1, pid);
	  ResultSet rs=stmt.executeQuery(); 
	  boolean flag=false;
	 // System.out.println(brand);
	  if(rs.next())
		  {  		
		//System.out.println(rs.getInt(1)+ rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5));

		  temp=new ProductModel(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));	
          flag=true;
		  }  
	     closeConnection();	 
	     if(flag==true)
	       return temp;
	     else
	    	 return null;
	  }
	  catch(SQLException e)
	  {	  e.printStackTrace();	 return null; }
	  catch(Exception e)
	  {	  e.printStackTrace();	 return null; }  	  
  }
  public static boolean EditProductByPid(ProductModel temp)
  {
	 	  	  
	  try
	  {
	  getConnection();
      stmt=con.prepareStatement("update product set pname=?,brand=?,ram=?,rom=?,processor=?,battery=?,price=?,descrptn=? where pid=?"); 
      stmt.setString(9, temp.getPid());
      stmt.setString(1, temp.getPname());
      stmt.setString(3, temp.getBrand());
      stmt.setString(4, temp.getRam());
      stmt.setString(5, temp.getRom());
      stmt.setString(6, temp.getProcessor());
      stmt.setString(7, temp.getBattery());
      stmt.setString(8, temp.getPrice()); 
	  System.out.println(stmt.toString());
	  boolean flag=false;
	  int nor=stmt.executeUpdate();
	    closeConnection();	 
	     if(nor>0)
	       return true;
	     else
	    	 return false;
	  }
	  catch(SQLException e)
	  {	  e.printStackTrace();	 return false; }
	  catch(Exception e)
	  {	  e.printStackTrace();	 return false; }  	  
  }
  public static boolean deleteProductsByPid(String pid)
  {
	  try
	  {
	  getConnection();
      stmt=con.prepareStatement("delete from product where pid=?"); 
      
      stmt.setString(1, pid);
    
	  System.out.println(stmt.toString());
	  boolean flag=false;
	  int nor=stmt.executeUpdate();
	    closeConnection();	 
	     if(nor>0)
	       return true;
	     else
	    	 return false;
	  }
	  catch(SQLException e)
	  {	  e.printStackTrace();	 return false; }
	  catch(Exception e)
	  {	  e.printStackTrace();	 return false; }  
	  
  }

}
