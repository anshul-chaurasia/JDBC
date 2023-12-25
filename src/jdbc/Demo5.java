package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo5 {
	
		  public static void main(String[] args) {
			  
			  String url ="jdbc:mysql://localhost:3306/employee";
			  String un ="root";
			  String pwd ="root";
			  Connection con =null;
			  Statement stmt =null;
			  ResultSet res =null;
			  
			
			  try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver successfully loaded");
				
				 con = DriverManager.getConnection(url, un, pwd);
				 System.out.println("Connection  established");
				 
				 stmt =  con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,0);
				
				 String query = "insert into emp (`id`,`name`,`dsig`,`salary`) values (4,'Koma','PM',55000)";
				 
				 stmt.execute(query);		
				 System.out.println("Query executed successfully");
				 
				
				 
				
				
			} catch (ClassNotFoundException e) {
				
				System.out.println("Driver not loaded");
			}
			  catch (SQLException e) {
				  e.printStackTrace();
			}
			  try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			  
		}
	  }
//insert data in program and show in a workbench...