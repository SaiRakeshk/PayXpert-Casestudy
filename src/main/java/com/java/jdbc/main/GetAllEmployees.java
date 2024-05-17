package com.java.jdbc.main;

import java.sql.SQLException;
import java.util.List;

import com.java.jdbc.dao.EmployeeService;
import com.java.jdbc.model.Employee;

public class GetAllEmployees {
	public static void main(String[] args) 
	{ 
		EmployeeService e= new EmployeeService(); 
		try { List<Employee> employList = e.GetAllEmployee(); 
		if(employList != null) 
		{ 
			for (Employee employee : employList) 
			{ 
				System.out.println(employee); 
				} 
			} 
		else 
			{ 
				System.out.println("No records"); }
		} 
		catch (ClassNotFoundException | SQLException e1) 
		{ // TODO Auto-generated catch block 
			e1.printStackTrace(); }
		}
	}


