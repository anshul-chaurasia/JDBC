package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Demo11BankApp {
	
	 public static void main(String[] args) {
		 
		 
		 String url = "jdbc:mysql://localhost:3306/tapacademy";
		 String un = "root";
		 String pwd = "root";
		 Connection con = null;
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(url, un,pwd);
			 Scanner scan = new Scanner(System.in);
			 
			 System.out.println("<---Welcome to tapbank--->");
			 System.out.println("Enter Account number");
			 int ac_num = scan.nextInt();
			 System.out.println("Enter Pin");
			 int pin = scan.nextInt();
			 
			 PreparedStatement pstmt1 = con.prepareStatement("Select * from account where " + " ac_num=? and pin = ?");
			 pstmt1.setInt(1, ac_num);
			 pstmt1.setInt(2, pin);
			 
		     ResultSet res1 = pstmt1.executeQuery();
		     res1.next();
		     String name=res1.getString(2);
		     int bal =res1.getInt(4);
		     System.out.println("Welcome "+name);
		     System.out.println("Available balance is: "+bal);
		     
			
		} catch (Exception e) {
			e.printStackTrace();
		}

   }
}
//Transaction management in login module....