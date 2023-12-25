package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo4 {
	
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
				 
			    ResultSetMetaData metaData= res.getMetaData();	 
			    for(int i=1; i<=metaData.getColumnCount(); i++) {
			    	System.out.println(metaData.getColumnName(i) + " " + metaData.getColumnTypeName(i));
			    }
			    
			    res.absolute(2);
			    System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getInt(4));
				
				
			} catch (ClassNotFoundException e) {
				
				System.out.println("Driver not loaded");
			}
			  catch (SQLException e) {
				  e.printStackTrace();
			  }
			  
		}
	  }
//use metadata we can perform many operation without knowing table 