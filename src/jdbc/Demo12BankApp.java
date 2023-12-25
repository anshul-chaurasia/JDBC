package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.util.Scanner;

public class Demo12BankApp {
	
	 public static void main(String[] args) {
		 
		 
		 String url = "jdbc:mysql://localhost:3306/tapacademy";
		 String un = "root";
		 String pwd = "root";
		 Connection con = null;
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(url,un,pwd);
			 Scanner scan = new Scanner(System.in);
			 //login module
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
		     //Transfer module...
		     
		     System.out.println("<--Transfer details-->");
		     System.out.println("Enter the beneficiary account number:");
		     int bacc_num = scan.nextInt();
		     System.out.println("Enter the tranfer amount");
		     int t_amount = scan.nextInt();
		     
		     con.setAutoCommit(false);
		     Savepoint s = con.setSavepoint();
		     
		     PreparedStatement pstmt2 = con.prepareStatement("update account set balance = balance-? where ac_num=?");
		     pstmt2.setInt(1, t_amount);
		     pstmt2.setInt(2, ac_num);
		     pstmt2.executeUpdate();
		     
		     System.out.println("<--Incoming credit request-->");
		     System.out.println( name + " account no " + ac_num + " want to transfer "+ t_amount);
		     System.out.println("Press Y to receive");
		     System.out.println("Press N to reject");
		     String choice = scan.next();
		     
		     if(choice.equals("Y")) {
		    	 PreparedStatement pstmt3 = con.prepareStatement("update account set balance = balance+? where ac_num=?");
		    	 pstmt3.setInt(1, t_amount);
			     pstmt3.setInt(2, bacc_num);
			     pstmt3.executeUpdate();
			     
			     PreparedStatement pstmt4 = con.prepareStatement("Select * from account where ac_num =? ");
			     pstmt4.setInt(1, bacc_num);
			     ResultSet res2 =pstmt4.executeQuery();
			     res2.next();
			     System.out.println("update balance is:" +res2.getInt(4));
		     }
		     else {
		    	 con.rollback();
		    	 PreparedStatement pstmt5 = con.prepareStatement("Select * from account where ac_num =? ");
			     pstmt5.setInt(1, bacc_num);
			     ResultSet res2 =pstmt5.executeQuery();
			     res2.next();
			     System.out.println("update balance is:" +res2.getInt(4));
		     }
		     con.commit();
		
		} catch (Exception e) {
			e.printStackTrace();
		}

   }
}
//Transaction management in login and transfer module....