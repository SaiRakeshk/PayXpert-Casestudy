package com.java.jdbc.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.java.jdbc.dao.PayrollService;
import com.java.jdbc.model.Payroll;

public class GetPayrollsForEmployee {
	public static void main(String[] args) 
	{ 
		int employeeid; 
		Scanner sc=new Scanner(System.in); 
		System.out.println("Enter employeeid.."); 
		employeeid=sc.nextInt(); 
		PayrollService p=new PayrollService(); 
		List<Payroll> payrollList; 
		try { 
			payrollList=p.GetPayrollsForEmployee(employeeid); 
			if(payrollList!=null) 
			{ 
				for (Payroll payroll : payrollList) 
				{ 
					System.out.println(payroll); 
					} 
				} 
			else 
				{ 
					System.out.println("Records not found"); 
					} 
			} 
		catch (ClassNotFoundException | SQLException e) 
		{ // TODO Auto-generated catch block 
			e.printStackTrace(); } }
		
	}


