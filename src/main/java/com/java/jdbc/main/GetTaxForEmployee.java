package com.java.jdbc.main; 
import java.sql.SQLException; 
import java.util.List; 
import java.util.Scanner; 
import com.java.jdbc.dao.TaxService; 
import com.java.jdbc.model.Tax; 
public class GetTaxForEmployee 
{ 
	public static void main(String[] args) 
	{ 
		Scanner sc=new Scanner(System.in); 
		System.out.println("Enter employeeId"); 
		int employee_id=sc.nextInt(); 
		TaxService t=new TaxService(); 
		try 
		{ 
			List<Tax> taxList= t.GetTaxesForEmployee(employee_id); 
			if(taxList != null) 
			{ 
				for (Tax tax : taxList) 
				{ System.out.println(tax); 
				} 
				} 
			else 
			{ 
				System.out.println("record not found.."); 
				} 
			} 
		catch (ClassNotFoundException | SQLException e) 
		{ // TODO Auto-generated catch block 
			e.printStackTrace(); } } 
		
	}

