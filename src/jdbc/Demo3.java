package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo3 {
	
		  public static void main(String[] args) {
			  
			  String url ="jdbc:mysql://localhost:3306/employee";
			  String un ="root";
			  String pwd ="root";
			
			  try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver successfully loaded");
				
				 Connection con = DriverManager.getConnection(url, un, pwd);
				 System.out.println("Connection  established");
				 
				Statement stmt =  con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,0);
				
				String query ="select * from emp";
				
				ResultSet res = stmt.executeQuery(query);
				System.out.println("Query execute");
				 
			
			 while(res.next()==true) 
			 System.out.println(res.getInt("id") + " " + res.getString("name") + " " +res.getString("dsig") + " " + res.getInt("salary"));
				 
//		     res.first(); 
//		     System.out.println(res.getInt("id") + " " + res.getString("name") + " " +res.getString("dsig") + " " + res.getInt("salary"));
		     
//		     res.last(); 
//		     System.out.println(res.getInt("id") + " " + res.getString("name") + " " +res.getString("dsig") + " " + res.getInt("salary"));
				
//			 res.absolute(3);
//			 System.out.println(res.getInt("id") + " " + res.getString("name") + " " +res.getString("dsig") + " " + res.getInt("salary"));
			 
			} catch (ClassNotFoundException e) {
				
				System.out.println("Driver not loaded");
			}
			  catch (SQLException e) {
				  e.printStackTrace();
			  }
			  
		}
	  }

// data fetch from the sql table and its scroable by absulate way...