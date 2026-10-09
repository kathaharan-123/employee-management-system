# Employee Management System

A console-based Employee Management System developed using Java, JDBC, and MySQL to manage employee records.

## Features

- Add employee records
- Search for an employee
- View all employees
- Update employee details
- Delete employee records

## Technologies Used

- Java 17
- JDBC (Java Database Connectivity)
- MySQL
- Maven
- Eclipse IDE

## Prerequisites

- JDK 17 or higher
- MySQL Server
- Maven (or Eclipse with Maven support)

## Database Setup

1. Install and start MySQL.
2. Run the SQL script in the `sql` directory to create the `company` database and `employees` table:

3. Set these environment variables with your own MySQL details:

   | Variable | Example value |
   |---|---|
   | `DB_URL` | `jdbc:mysql://localhost:3306/company` |
   | `DB_USERNAME` | your MySQL username |
   | `DB_PASSWORD` | your MySQL password |

   In Eclipse, add them under **Run → Run Configurations → Environment**.

4. Run the `App` class from Eclipse.

## Learning Outcomes

- Practiced object-oriented programming in Java.
- Connected a Java application to MySQL using JDBC.
- Used SQL queries and `PreparedStatement` for database operations.
- Practiced CRUD operations and exception handling.

## Future Improvements

- Add input validation and improved error handling.
- Separate application logic from database access.
- Build a REST API using Spring Boot.
