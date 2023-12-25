package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo2 {
	
		  public static void main(String[] args) {
			  
			  String url ="jdbc:mysql://localhost:3306/employee";
			  String un ="root";
			  String pwd ="root";
			
			  try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver successfully loaded");
				
				 Connection con = DriverManager.getConnection(url, un, pwd);
				 System.out.println("Connection  established");
				 
				Statement stmt =  con.createStatement();//statement(query) sending to the database mysql server
				
				String query ="select * from emp";
				
				ResultSet res = stmt.executeQuery(query);//(result) fetch data send rdbms to the java program
				System.out.println("Query execute");
				 
				
				
//				res.first();
//				System.out.println(res.getInt(1) + " " + res.getString(2) + " " +res.getString(3) + " " + res.getInt(4));
//				 Another way to fetch (only for 1 coloum)
				
		     while(res.next()==true) 
			 System.out.println(res.getInt("id") + " " + res.getString("name") + " " +res.getString("dsig") + " " + res.getInt("salary"));
				 
		    
				
				
			} catch (ClassNotFoundException e) {
				
				System.out.println("Driver not loaded");
			}
			  catch (SQLException e) {
				  e.printStackTrace();
			  }
			  
		}
	  }
//create statement and fetch the data from sql table...
