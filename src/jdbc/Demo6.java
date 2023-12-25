package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo6 {
	
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
				
				 String query1 = "insert into emp (`id`,`name`,`dsig`,`salary`) values (16,'Ram','SM',25000)";
				 String query2 = "insert into emp (`id`,`name`,`dsig`,`salary`) values (17,'Ram','SM',25000)";
				 String query3 = "insert into emp (`id`,`name`,`dsig`,`salary`) values (18,'Ram','SM',25000)";
				 
				 stmt.addBatch(query1);
				 stmt.addBatch(query2);
				 stmt.addBatch(query3);
				 
				 stmt.executeBatch();
				 
				 System.out.println("Queries executed successfully");
				
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
// batch processing same like as previous program.....we can add more data in one knock of harddisk(reduce harddisk)