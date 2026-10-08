package com.example.jdbc_mysql_practice;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
			Scanner scanner = 
					new Scanner(System.in);
			
			EmployeeDAO employeeDAO =
					new EmployeeDAO();
			
			while(true) {
				
				System.out.println();
	            System.out.println("========== Employee Management ==========");
	            System.out.println("1. Add Employee");
	            System.out.println("2. Search Employee");
	            System.out.println("3. View All Employees");
	            System.out.println("4. Update Employee");
	            System.out.println("5. Delete Employee");
	            System.out.println("6. Exit");
	            System.out.println("==========================================");

	            int choice = InputUtil.readInt(scanner, "Enter your choice");
	            
	            switch (choice) {

                case 1:
                    Services.addEmployee(scanner, employeeDAO);
                    break;

                case 2:
                	Services.searchEmployee(scanner, employeeDAO);
                    break;

                case 3:
                    Services.getAllEmployees(scanner, employeeDAO);
                    break;

                case 4:
                	Services.updateEmployee(scanner, employeeDAO);
                    break;

                case 5:
                    Services.deleteEmployee(scanner, employeeDAO);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter 1-6.");
	            }
			}
	}
}
