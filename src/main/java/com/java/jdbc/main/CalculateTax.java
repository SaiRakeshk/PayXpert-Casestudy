package com.java.jdbc.main;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import com.java.jdbc.dao.TaxService;
public class CalculateTax 
{	
	public static void main(String[] args) throws ParseException 
	{		
		int employee_id;		
		String year;		
		Scanner sc= new Scanner(System.in);		
		System.out.println("Enter employee id..");		
		employee_id=sc.nextInt();		
		System.out.println("Enter taxyear..");		
		year=sc.next();		
		TaxService t =new TaxService();		
		try 
		{			
			double a=t.CalculateTax(employee_id, year);			
			System.out.println("Taxamount"+a);		
			} 
		catch (ClassNotFoundException | SQLException e) 
		{			// TODO Auto-generated catch block			
			e.printStackTrace();		
			}	
		}
	}
