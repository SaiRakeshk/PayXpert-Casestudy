package com.java.jdbc.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.java.jdbc.dao.FinancialRecordService;
import com.java.jdbc.model.FinancialRecord;

public class GetFinancialRecordsForEmployee {
	public static void main(String[] args) 
	{ 
		List<FinancialRecord> finList=null; 
		FinancialRecordService f= new FinancialRecordService(); 
		Scanner sc=new Scanner(System.in); 
		System.out.println("Enter employee id.."); 
		int emp_id = sc.nextInt(); 
		try { finList=f.GetFinancialRecordsForEmployee(emp_id); 
		if(finList!=null) 
		{ 
			for (FinancialRecord financialRecord : finList) 
			{ 
				System.out.println(financialRecord); 
				} 
			} else 
			{ 
				System.out.println("Record not found"); 
				} 
		} catch (ClassNotFoundException | SQLException e) 
		{ // TODO Auto-generated catch block 
			e.printStackTrace(); 
			} 
		}
		
	}


