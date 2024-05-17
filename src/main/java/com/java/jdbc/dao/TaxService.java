package com.java.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.jdbc.model.Payroll;
import com.java.jdbc.model.Tax;
import com.java.jdbc.util.DBConnUtil;
import com.java.jdbc.util.DBPropertyUtil;

public class TaxService implements ITaxService {
	Connection conn;
	PreparedStatement pst;

	@Override
	public double CalculateTax(int EmployeeID, String TaxYear) throws SQLException, ClassNotFoundException {
		String connstr=DBPropertyUtil.getConnectionString("db");		
		conn=DBConnUtil.getConnection(connstr);		
		String cmd1="select netsalary from payroll where employeeid=?";		
		pst=conn.prepareStatement(cmd1);		
		pst.setInt(1, EmployeeID);		
		ResultSet rs=pst.executeQuery();		
		Payroll payroll=null;		
		if(rs.next()) 
		{			
			payroll=new Payroll();			
			payroll.setNetSalary(rs.getDouble("netsalary"));		}			 
		String cmd2="select taxableincome from tax where employeeid=? and taxyear=?";	 
		pst=conn.prepareStatement(cmd2);	 
		pst.setInt(1, EmployeeID);	 
		pst.setString(2, TaxYear);	 
		Tax tax=null;	 
		rs=pst.executeQuery();		
		if(rs.next()) {			
			tax=new Tax();			
			tax.setTaxableIncome(rs.getDouble("taxableincome"));		}				
		return payroll.getNetSalary()-tax.getTaxableIncome();

	}

	@Override
	public double GetTaxById(int TaxID) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String connstr=DBPropertyUtil.getConnectionString("db");		
		conn=DBConnUtil.getConnection(connstr);		
		String cmd="select employeeid,taxyear from tax where taxid=?";		
		pst=conn.prepareStatement(cmd);		
		pst.setInt(1, TaxID);		
		ResultSet rs=pst.executeQuery();		
		double dar=-1;		
		Tax tax=null;		
		if(rs.next())		
		{			
			tax=new Tax();			
			tax.setEmployeeID(rs.getInt("employeeid"));			
			tax.setTaxYear(rs.getString("taxyear"));			 
			int x=tax.getEmployeeID();			
			String y=tax.getTaxYear();			 
			return CalculateTax(x, y);		}		
		return dar;
		
	}

	@Override
	public List<Tax> GetTaxesForEmployee(int EmployeeID) throws ClassNotFoundException, SQLException {
		String connstr=DBPropertyUtil.getConnectionString("db");		
		conn=DBConnUtil.getConnection(connstr);		
		String cmd="select * from tax where employeeid=?";		
		pst=conn.prepareStatement(cmd);		
		pst.setInt(1, EmployeeID);		
		ResultSet rs=pst.executeQuery();		
		List<Tax> taxList=new ArrayList<Tax>();		
		Tax tax=null;		
		while(rs.next()) 
		{			
			tax=new Tax();			
			tax.setEmployeeID(EmployeeID);			
			tax.setTaxID(rs.getInt("taxid"));			
			tax.setTaxYear(rs.getString("taxyear"));			
			tax.setTaxableIncome(rs.getDouble("taxableincome"));			
			tax.setTaxAmount(CalculateTax(EmployeeID, rs.getString("taxyear")));			
			taxList.add(tax);		}		
		return taxList;	}	
	

	@Override
	public List<Tax> GetTaxesForYear(String TaxYear) throws SQLException, ClassNotFoundException {
		String connstr=DBPropertyUtil.getConnectionString("db");		
		conn=DBConnUtil.getConnection(connstr);		
		String cmd="select * from tax where taxyear=?";		
		pst=conn.prepareStatement(cmd);		
		pst.setString(1, TaxYear);		
		ResultSet rs=pst.executeQuery();		
		List<Tax> taxList=new ArrayList<Tax>();		
		Tax tax=null;		
		while(rs.next()) 
		{			
			tax=new Tax();			
			tax.setEmployeeID(rs.getInt("employeeid"));			
			tax.setTaxID(rs.getInt("taxid"));			
			tax.setTaxYear(TaxYear);			
			tax.setTaxableIncome(rs.getDouble("taxableincome"));			
			tax.setTaxAmount(CalculateTax(rs.getInt("employeeid"), rs.getString("taxyear")));			
			taxList.add(tax);		}		return taxList;
		
	}

}
