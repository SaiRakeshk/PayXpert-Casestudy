package com.java.jdbc.main;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.java.jdbc.dao.EmployeeService;
import com.java.jdbc.model.Employee;

public class AddEmployee {
    public static void main(String[] args) {
        Employee employ = new Employee();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter firstname..");
        employ.setFirstName(sc.next());
        System.out.println("Enter Lastname..");
        employ.setLastName(sc.next());
        System.out.println("Enter Gender..");
        employ.setGender(sc.next());
        System.out.println("Enter Email..");
        employ.setEmail(sc.next());
        System.out.println("Enter phone number..");
        employ.setPhoneNumber(sc.next());
        System.out.println("Enter Address..");
        employ.setAddress(sc.next());
        
        // Wait for valid input for position
        String position = null;
        while (position == null || position.trim().isEmpty()) {
            System.out.println("Enter position..");
            sc.nextLine(); // Consume newline character
            position = sc.nextLine();

        }
        employ.setPosition(position.trim());
        
        // Wait for valid input for dob (Date of Birth)
        Date dob = null;
        while (dob == null) {
            try {
                System.out.println("Enter dob.. (dd/MM/yyyy)");
                String dateStr = sc.next();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date utilDate = sdf.parse(dateStr);
                dob = new Date(utilDate.getTime());
                employ.setDob(dob);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in dd/MM/yyyy format.");
            }
        }
        
        // Wait for valid input for joining date
        Date joiningDate = null;
        while (joiningDate == null) {
            try {
                System.out.println("Enter joining date.. (dd/MM/yyyy)");
                String dateStr = sc.next();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date utilDate = sdf.parse(dateStr);
                joiningDate = new Date(utilDate.getTime());
                employ.setJoiningDate(joiningDate);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in dd/MM/yyyy format.");
            }
        }
        
        // Wait for valid input for termination date
        Date terminationDate = null;
        while (terminationDate == null) {
            try {
                System.out.println("Enter termination date.. (dd/MM/yyyy) ");
                String dateStr = sc.next();
                if (dateStr.isEmpty()) {
                    terminationDate = null;
                    break;
                }
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date utilDate = sdf.parse(dateStr);
                terminationDate = new Date(utilDate.getTime());
                employ.setTerminationDate(terminationDate);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in dd/MM/yyyy format.");
            }
        }
        
        // Add employee to database
        EmployeeService e = new EmployeeService();
        try {
            System.out.println(e.AddEmployee(employ));
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        }
    }
}
