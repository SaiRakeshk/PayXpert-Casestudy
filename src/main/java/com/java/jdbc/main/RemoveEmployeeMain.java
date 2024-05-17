package com.java.jdbc.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.jdbc.dao.EmployeeService;

public class RemoveEmployeeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID of the employee you want to remove:");
        int employeeId = scanner.nextInt();

        EmployeeService employeeService = new EmployeeService();
        try {
            String result = employeeService.RemoveEmployee(employeeId);
            System.out.println(result);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
