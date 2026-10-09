package com.example.jdbc_mysql_practice;

import java.util.Scanner;

public class Services {
	
	public static void addEmployee(Scanner scanner, EmployeeDAO employeeDAO){
		
		System.out.println();
        System.out.println("---------- Add Employee ----------");
        
        int id = InputUtil.readInt(scanner, "Enter Employee ID");
        String name = InputUtil.readString(scanner, "Enter Employee Name");
        String department = InputUtil.readString(scanner, "Enter Department");
        int salary = InputUtil.readInt(scanner, "Enter Salary");
        
        Employee employee =
        		new Employee(id, name, department, salary);
        
        employeeDAO.addEmployee(employee);
	}
	
	public static void deleteEmployee(Scanner scanner, EmployeeDAO employeeDAO) {
		
		System.out.println();
        System.out.println("---------- Delete Employee ----------");
        
        int id = InputUtil.readInt(scanner, "Enter Employee ID");
        
        Employee employee =
        		new Employee();
        
        employee.setID(id);
        
        employeeDAO.deleteEmployee(employee);
	}
	
	public static void getAllEmployees(Scanner scanner, EmployeeDAO employeeDAO) {
		
		System.out.println();
        System.out.println("---------- All Employees ----------");
        
        employeeDAO.getAllEmployees();
	}
	
	public static void searchEmployee(Scanner scanner, EmployeeDAO employeeDAO) {
		
		int id = InputUtil.readInt(scanner, "Enter Employee ID");
		
		System.out.println();
        System.out.println("---------- Searched Employee ----------");
			
		Employee employee =
				new Employee();
		
		employee.setID(id);
		
		employeeDAO.searchEmployee(employee);
	}
	
	public static void updateEmployee(Scanner scanner, EmployeeDAO employeeDAO) {
		
		String department;
		int salary;
		
		int id = InputUtil.readInt(scanner, "Enter Employee ID");
		
		Employee employee =
				new Employee();
		
		employee.setID(id);
		
		if(!employeeDAO.findEmployee(employee)) {
			return;
		}
		
		while(true) {
			System.out.println();
			System.out.println("Update Entity\n1.Department\n2.Salary\n3.Both\n");
			int choice = InputUtil.readInt(scanner, "Enter the choice");
			
			switch(choice) {
				
			case 1:
				department = InputUtil.readString(scanner, "Enter Department");
				employee.setDepartment(department);
				employeeDAO.updateEmployee(choice, employee);
				return;
			
			case 2:
				salary = InputUtil.readInt(scanner, "Enter Salary");
				employee.setSalary(salary);
				employeeDAO.updateEmployee(choice, employee);
				return;
				
			case 3:
				department = InputUtil.readString(scanner, "Enter Department");
				employee.setDepartment(department);
				salary = InputUtil.readInt(scanner, "Enter Salary");
				employee.setSalary(salary);
				employeeDAO.updateEmployee(choice, employee);
				
			default:
				System.out.println("Enter valid choice!");
			}
		}	
	}	
}
