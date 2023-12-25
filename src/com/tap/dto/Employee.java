package com.tap.dto;

public class Employee {

	private int id;
	private String name;
	private String desig;
	private int salary;
	
	public Employee() {
		
	}
	
	public Employee(int id, String name, String desig, int salary) {
		this.id = id;
		this.name = name;
		this.desig = desig;
		this.salary = salary;
	}
  
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDesignation() {
		return desig;
	}



	public void setDesignation(String desig) {
		this.desig = desig;
	}



	public int getSalary() {
		return salary;
	}



	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		
		return id + " " + name + " " + desig + " " + salary;
	}


	

	
}









