package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo9 {
	
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
				 
				String query = "update emp set salary = salary + salary*0.20";
				stmt = con.createStatement();
				
				System.out.println("Number of rows updated:" +stmt.executeUpdate(query));
				
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
//Acid properties...(Hike salary on the table members)...
// when we use select query that time we use createstatement
// when we use crud query that time we use preparedstatement
//whenever we used select based query we use methodexecutequery which will you give result
//whenever we use DML query(insert,update,delete) we use execute and executeupdate