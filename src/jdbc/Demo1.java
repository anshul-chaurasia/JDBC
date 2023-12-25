package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo1 {
	
		  public static void main(String[] args) {
			  
			  String url ="jdbc:mysql://localhost:3306/employee";
			  String un ="root";
			  String pwd ="root";
			
			  try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver successfully loaded");
				
				 Connection con = DriverManager.getConnection(url,un,pwd);
				 System.out.println("Connection  established");
				
				
			} catch (ClassNotFoundException e) {
				
				System.out.println("Driver not loaded");
			}
			  catch (SQLException e) {
				  System.out.println("Connection not established");
			  }
			  
		}
	  }
//driver loaded and connection established..


