package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo10 {
	
		  public static void main(String[] args) {
			  
			  String url ="jdbc:mysql://localhost:3306/employee";
			  String un ="root";
			  String pwd ="root";
			  PreparedStatement pstmt =null;
			  ResultSet res=null;
			  Connection con =null;
			  Statement stmt = null;
			  
			
			  try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver successfully loaded");
				
				 con = DriverManager.getConnection(url, un, pwd);
				 System.out.println("Connection  established");
				 
				String query = "delete from emp where name='Emli'";
				stmt = con.createStatement();
				
				System.out.println("Number of rows deleted:" +stmt.executeUpdate(query));
				
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			  catch (SQLException e) {}
			  try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			  
		}
	  }
//Acid properties...(Delete rob on the table members)...