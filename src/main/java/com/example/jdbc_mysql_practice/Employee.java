package com.example.jdbc_mysql_practice;

public class Employee {
	
	private int id;
	private String name;
	private String department;
	private int salary;
	
	public Employee() {};
	
	public Employee(int id,String name,String department,int salary) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	
	public Employee(String name,String department,int salary) {
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	
	public int getID() {
		return this.id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDepartment() {
		return this.department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public int getSalary() {
		return this.salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
