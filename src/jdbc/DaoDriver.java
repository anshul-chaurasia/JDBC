package jdbc;

import java.util.List;
import java.util.Scanner;

import com.tap.dao.EmployeeDAOEmpl;
import com.tap.dto.Employee;

public class DaoDriver {
	public static void main(String[] args) {
		EmployeeDAOEmpl emplDAOEmpl = new EmployeeDAOEmpl();
//		 List<Employee> employees = emplDAOEmpl.getEmployee();
//		 
//		 for(Employee e : employees ) {
//			 System.out.println(e);
//			 
//		 }
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the emplyee id to be updated:");
		int id = scan.nextInt();
		
		Employee e = emplDAOEmpl.getEmployee(id);
		System.out.println(e);
		
		System.out.println("Enter the salary to be updated");
		int Newsalary = scan.nextInt();
		
		e.setSalary(Newsalary);
		
		System.out.println(emplDAOEmpl.updateEmployee(e));
		
		
		
		
		
	}

}
