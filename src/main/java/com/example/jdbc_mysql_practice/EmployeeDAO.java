package com.example.jdbc_mysql_practice;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class EmployeeDAO {
	
	public void addEmployee(Employee employee) {
		
		String sql = """
				INSERT INTO employees (id,name,department,salary) VALUES
				(?,?,?,?);
				""";
		
		try {
			
			Connection connection = DBConnection.getConnection();
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, employee.getID());
			statement.setString(2, employee.getName());
			statement.setString(3, employee.getDepartment());
			statement.setInt(4, employee.getSalary());
			
			int rows = statement.executeUpdate();
			System.out.println(rows);
			
			if (rows > 0) {
                System.out.println("Employee added successfully!");
            }
			
			connection.close();
			statement.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getAllEmployees() {
		
		String sql = """
				SELECT * FROM employees;
				""";
		
		try {
			
			Connection connection = DBConnection.getConnection();
			
			Statement statement = connection.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				
				int employeeId = result.getInt("id");
                String name = result.getString("name");
                String department = result.getString("department");
                int salary = result.getInt("salary");
                
                System.out.println(employeeId+" | "+name+" | "+department+" | "+salary);
			}
			
			connection.close();
			statement.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteEmployee(Employee employee) {
		
		String sql = """
				DELETE FROM employees
				WHERE id = ?;
				""";
		try {
			
			Connection connection = 
					DBConnection.getConnection();
			
			PreparedStatement statement = 
					connection.prepareStatement(sql);
			
			statement.setInt(1, employee.getID());
			
			int rows = statement.executeUpdate();
			
			if(rows>0) {
				System.out.println("Employee Deleted");
			}
			
			connection.close();
			statement.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void searchEmployee(Employee employee) {
		
		String sql = """
				SELECT * FROM employees
				WHERE id = ?;
				""";
		try {
			
			Connection connection = 
					DBConnection.getConnection();
			
			PreparedStatement statement = 
					connection.prepareStatement(sql);
			
			statement.setInt(1, employee.getID());
			
			ResultSet result = 
					statement.executeQuery();
			
			if (result.next()) {

                int employeeId = result.getInt("id");
                String name = result.getString("name");
                String department = result.getString("department");
                int salary = result.getInt("salary");

                System.out.println("\nEmployee found!");
                System.out.println("ID: " + employeeId);
                System.out.println("Name: " + name);
                System.out.println("Department: " + department);
                System.out.println("Salary: " + salary);

            } else {

                System.out.println("Employee not found.");

            }
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean findEmployee(Employee employee) {
		
		String sql = """
				SELECT * FROM employees
				WHERE id = ?;
				""";
		try {
			
			Connection connection = 
					DBConnection.getConnection();
			
			PreparedStatement statement = 
					connection.prepareStatement(sql);
			
			statement.setInt(1, employee.getID());
			
			ResultSet result = 
					statement.executeQuery();
			
			if (result.next()) {

                int employeeId = result.getInt("id");
                String name = result.getString("name");
                String department = result.getString("department");
                int salary = result.getInt("salary");

                System.out.println(employeeId+" | "+name+" | "+department+" | "+salary);
                
                return true;

            } else {

                System.out.println("Employee not found.");

            }
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void updateEmployee(int choice, Employee employee) {

	    String sql;

	    if (choice == 1) {
	        sql = "UPDATE employees SET department = ? WHERE id = ?";
	    } else if (choice == 2) {
	        sql = "UPDATE employees SET salary = ? WHERE id = ?";
	    } else {
	        sql = "UPDATE employees SET department = ?, salary = ? WHERE id = ?";
	    }

	    try (Connection connection = DBConnection.getConnection();
	         PreparedStatement statement = connection.prepareStatement(sql)) {

	        if (choice == 1) {
	            statement.setString(1, employee.getDepartment());
	            statement.setInt(2, employee.getID());
	        } else if (choice == 2) {
	            statement.setInt(1, employee.getSalary());
	            statement.setInt(2, employee.getID());
	        } else {
	            statement.setString(1, employee.getDepartment());
	            statement.setInt(2, employee.getSalary());
	            statement.setInt(3, employee.getID());
	        }

	        int rows = statement.executeUpdate();
	        System.out.println(rows+" row affected in database");

	        if (rows > 0) {
	            System.out.println("Employee updated successfully!");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}	
}
