package com.java.jdbc.main;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.java.jdbc.dao.EmployeeService;
import com.java.jdbc.model.Employee;

public class UpdateEmployee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeService();

        // Input employee ID to update
        System.out.println("Enter the ID of the employee you want to update:");
        int employeeId = sc.nextInt();
        sc.nextLine(); // Consume newline

        // Check if the employee exists
        try {
            Employee existingEmployee = employeeService.GetEmployeeById(employeeId);
            if (existingEmployee == null) {
                System.out.println("Employee with ID " + employeeId + " does not exist.");
                return;
            }

            // Input updated employee details
            Employee updatedEmployee = new Employee();
            updatedEmployee.setEmployeeID(employeeId);
            System.out.println("Enter firstname:");
            updatedEmployee.setFirstName(sc.nextLine());
            System.out.println("Enter Lastname:");
            updatedEmployee.setLastName(sc.nextLine());
            System.out.println("Enter Gender:");
            updatedEmployee.setGender(sc.nextLine());
            System.out.println("Enter Email:");
            updatedEmployee.setEmail(sc.nextLine());
            System.out.println("Enter phone number:");
            updatedEmployee.setPhoneNumber(sc.nextLine());
            System.out.println("Enter Address:");
            updatedEmployee.setAddress(sc.nextLine());
            System.out.println("Enter position:");
            updatedEmployee.setPosition(sc.nextLine());

            // Input updated dob (Date of Birth)
            System.out.println("Enter dob (dd/MM/yyyy):");
            String dobStr = sc.next();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            updatedEmployee.setDob(new java.sql.Date(sdf.parse(dobStr).getTime()));

            // Input updated joining date
            System.out.println("Enter joining date (dd/MM/yyyy):");
            String joiningDateStr = sc.next();
            updatedEmployee.setJoiningDate(new java.sql.Date(sdf.parse(joiningDateStr).getTime()));

            // Input updated termination date
            System.out.println("Enter termination date (dd/MM/yyyy) ");
            String terminationDateStr = sc.next();
            if (!terminationDateStr.isEmpty()) {
                updatedEmployee.setTerminationDate(new java.sql.Date(sdf.parse(terminationDateStr).getTime()));
            } else {
                updatedEmployee.setTerminationDate(null);
            }

            // Update employee in database
            String result = employeeService.UpdateEmployee(updatedEmployee);
            System.out.println(result);
        } catch (ClassNotFoundException | SQLException | ParseException e) {
            e.printStackTrace();
        }
    }
}
