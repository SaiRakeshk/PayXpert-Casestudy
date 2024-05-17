package com.java.jdbc.main;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.java.jdbc.dao.PayrollService;
import com.java.jdbc.model.Payroll;

public class GeneratePayroll {    
    public static void main(String[] args) throws ParseException {        
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter employee id:");
    	int emp_id = sc.nextInt();
    	System.out.println("Enter pay period start date (yyyy-MM-dd):"); // Corrected format
    	String sd = sc.next();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Corrected format
    	Date str = sdf.parse(sd);
    	System.out.println("Enter pay period end date (yyyy-MM-dd):"); // Corrected format
    	String sd1 = sc.next();
    	Date str1 = sdf.parse(sd1);      
        PayrollService p = new PayrollService();        
        List<Payroll> payrollList = new ArrayList<Payroll>();        
        try {            
            // Convert java.util.Date to java.sql.Date
            java.sql.Date sqlStartDate = new java.sql.Date(str.getTime());
            java.sql.Date sqlEndDate = new java.sql.Date(str1.getTime());
            
            payrollList = p.GeneratePayroll(emp_id, sqlStartDate, sqlEndDate);            
            if (payrollList.size() > 0) {                
                for (Payroll payroll : payrollList) {                    
                    System.out.println(payroll);                
                }            
            }            
            if (payrollList.size() == 0) {                
                System.out.println("Record not found");            
            }        
        } catch (ClassNotFoundException | SQLException e) {            
            e.printStackTrace();        
        }    
    }
}
