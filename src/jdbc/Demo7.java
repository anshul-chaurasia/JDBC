package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo7 {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/employee";
		String un = "root";
		String pwd = "root";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver successfully loaded");

			con = DriverManager.getConnection(url, un, pwd);
			System.out.println("Connection  established");

			String query = "insert into emp (`id`,`name`,`dsig`,`salary`) values (?,?,?,?)";

			pstmt = con.prepareStatement(query);

			Scanner scan = new Scanner(System.in);

			System.out.println("Enter id");
			int id = scan.nextInt();
			System.out.println("Enter Name");
			String name = scan.next();
			System.out.println("Enter Dsig");
			String dsig = scan.next();
			System.out.println("Enter salary");
			int salary = scan.nextInt();

			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, dsig);
			pstmt.setInt(4, salary);

			pstmt.execute();
			System.out.println("Queries execute succefully");

		} catch (ClassNotFoundException e) {

			System.out.println("Driver not loaded");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
//batch processing .....