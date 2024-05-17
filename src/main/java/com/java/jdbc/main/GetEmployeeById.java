package com.java.jdbc.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.jdbc.dao.EmployeeService;
import com.java.jdbc.model.Employee;

public class GetEmployeeById {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee Id");
        int emp_id = sc.nextInt();
        EmployeeService e = new EmployeeService();
        try {
            Employee employ = e.GetEmployeeById(emp_id);
            if (employ != null) {
                System.out.println("Employee details " + employ);
            } else {
                System.out.println("*** Employee Record Not Found ***");
            }
        } catch (ClassNotFoundException | SQLException e4) {
            System.out.println("An unexpected error occurred: " + e4.getMessage());
        } finally {
            sc.close();
        }
    }
}
