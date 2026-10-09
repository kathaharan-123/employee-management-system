-- =====================================================
-- Database setup
-- =====================================================
CREATE DATABASE IF NOT EXISTS company;
USE company;

CREATE TABLE IF NOT EXISTS employees (
    id         INT PRIMARY KEY,
    name       VARCHAR(100) NOT NULL,
    department VARCHAR(100),
    salary     INT
);

-- =====================================================
-- Queries used in EmployeeDAO.java
-- (the ? placeholders are replaced by values from Java;
--  here they are shown with sample values)
-- =====================================================

-- addEmployee(): INSERT INTO employees (id,name,department,salary) VALUES (?,?,?,?);
INSERT INTO employees (id, name, department, salary) VALUES
(1, 'Asha',  'IT',      50000),
(2, 'Ravi',  'HR',      40000),
(3, 'Meena', 'Finance', 45000);

-- getAllEmployees()
SELECT * FROM employees;

-- searchEmployee() and findEmployee()
SELECT * FROM employees
WHERE id = 1;

-- updateEmployee(), choice 1: update department only
UPDATE employees SET department = 'Marketing'
WHERE id = 1;

-- updateEmployee(), choice 2: update salary only
UPDATE employees SET salary = 55000
WHERE id = 1;

-- updateEmployee(), choice 3 (else): update department and salary
UPDATE employees SET department = 'Sales', salary = 60000
WHERE id = 1;

-- deleteEmployee()
DELETE FROM employees
WHERE id = 3;
