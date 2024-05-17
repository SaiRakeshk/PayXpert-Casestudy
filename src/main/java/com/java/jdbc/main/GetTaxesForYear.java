package com.java.jdbc.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.java.jdbc.dao.TaxService;
import com.java.jdbc.model.Tax;

public class GetTaxesForYear {
	public static void main(String[] args) 
	{		
		Scanner sc=new Scanner(System.in);		
		System.out.println("Enter taxyear..");		
		String tax_year=sc.next();		
		TaxService t=new TaxService();		
		List<Tax> taxList= null;		
		try 
		{			
			taxList= t.GetTaxesForYear(tax_year);			
			if(taxList != null)			
			{				
				for (Tax tax : taxList) 
				{					
					System.out.println(tax);				
					}			
				}			
			else 
			{				
				System.out.println("record not found..");			
				}		
			} 
		catch (ClassNotFoundException | SQLException e) 
		{			// TODO Auto-generated catch block			
			e.printStackTrace();		
			}	
		}
		
	}