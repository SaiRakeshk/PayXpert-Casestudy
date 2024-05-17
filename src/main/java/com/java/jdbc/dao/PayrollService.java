package com.java.jdbc.dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.jdbc.model.Payroll;
import com.java.jdbc.util.DBConnUtil;
import com.java.jdbc.util.DBPropertyUtil;

public class PayrollService implements IPayrollService {
	Connection conn;
	PreparedStatement pst;
	@Override	
	public List<Payroll> GeneratePayroll(int employeeId, Date startDate, Date endDate)			throws ClassNotFoundException, SQLException 
	{		String connstr=DBPropertyUtil.getConnectionString("db");
			conn = DBConnUtil.getConnection(connstr);		
			String cmd="select * from payroll where employeeid= ? and payperiodstartdate=? and payperiodenddate=? ";		
			pst=conn.prepareStatement(cmd);		
			pst.setInt(1, employeeId);		
			pst.setDate(2, new java.sql.Date(startDate.getTime()));		
			pst.setDate(3, new java.sql.Date(endDate.getTime()));		
			ResultSet rs=pst.executeQuery();		
			List<Payroll> payrollList = new ArrayList<Payroll>();		
			Payroll payroll=null;		
			while(rs.next()) 
			{			
				payroll=new Payroll();			
				payroll.setPayrollID(rs.getInt("payrollid"));			
				payroll.setEmployeeID(employeeId);			
				payroll.setPayPeriodStartDate(startDate);			
				payroll.setPayPeriodEndDate(endDate);			
				payroll.setBasicSalary(rs.getDouble("Basicsalary"));			
				payroll.setOvertimePay(rs.getDouble("overtimepay"));			
				payroll.setDeductions(rs.getDouble("deductions"));			
				payroll.setNetSalary(rs.getDouble("netsalary"));			
				payrollList.add(payroll);		}		
			return payrollList;	}			
	@Override
	public Payroll GetPayrollById(int payrollID) throws ClassNotFoundException, SQLException {
		String connstr=DBPropertyUtil.getConnectionString("db");
		conn = DBConnUtil.getConnection(connstr);		
		String cmd="select * from payroll where payrollid=?";		
		pst=conn.prepareStatement(cmd);		
		pst.setInt(1, payrollID);		
		ResultSet rs=pst.executeQuery();		
		Payroll payroll=null;		
		if(rs.next()) 
		{			
			payroll=new Payroll();			
			payroll.setPayrollID(payrollID);			
			payroll.setEmployeeID(rs.getInt("employeeId"));			
			payroll.setPayPeriodStartDate(rs.getDate("payperiodstartdate"));			
			payroll.setPayPeriodEndDate(rs.getDate("payperiodenddate"));			
			payroll.setBasicSalary(rs.getDouble("Basicsalary"));			
			payroll.setOvertimePay(rs.getDouble("overtimepay"));			
			payroll.setDeductions(rs.getDouble("deductions"));			
			payroll.setNetSalary(rs.getDouble("netsalary"));		}		
		return payroll;
		
	}

	@Override
	public List<Payroll> GetPayrollsForEmployee(int EmployeeID) throws SQLException, ClassNotFoundException {
		String connstr=DBPropertyUtil.getConnectionString("db");		
		conn = DBConnUtil.getConnection(connstr);		
		String cmd="select * from payroll where employeeid=?";		
		pst=conn.prepareStatement(cmd);		
		pst.setInt(1, EmployeeID);		
		ResultSet rs=pst.executeQuery();		
		List<Payroll> payrollList = new ArrayList<Payroll>();		
		Payroll payroll=null;		
		if(rs.next()) {			
			payroll=new Payroll();			
			payroll.setPayrollID(EmployeeID);			
			payroll.setEmployeeID(rs.getInt("employeeId"));			
			payroll.setPayPeriodStartDate(rs.getDate("payperiodstartdate"));			
			payroll.setPayPeriodEndDate(rs.getDate("payperiodenddate"));			
			payroll.setBasicSalary(rs.getDouble("Basicsalary"));			
			payroll.setOvertimePay(rs.getDouble("overtimepay"));			
			payroll.setDeductions(rs.getDouble("deductions"));			
			payroll.setNetSalary(rs.getDouble("netsalary"));			
			payrollList.add(payroll);		}		
		return payrollList;
	}

	@Override

	public List<Payroll> GetPayrollsForPeriod(Date startDate, Date endDate) throws SQLException, ClassNotFoundException {

		String connstr=DBPropertyUtil.getConnectionString("db");		

		conn = DBConnUtil.getConnection(connstr);		

		String cmd="select * from payroll where payperiodstartdate=? and payperiodenddate=? ";		

		pst=conn.prepareStatement(cmd);		

		pst.setDate(1, new java.sql.Date(startDate.getTime()));		

		pst.setDate(2, new java.sql.Date(endDate.getTime()));		

		ResultSet rs=pst.executeQuery();		

		List<Payroll> payrollList = new ArrayList<Payroll>();		

		Payroll payroll=null;		

		if(rs.next()) {			

			payroll=new Payroll();			

			payroll.setPayrollID(rs.getInt("payrollid"));			

			payroll.setEmployeeID(rs.getInt("employeeId"));			

			payroll.setPayPeriodStartDate(startDate);			

			payroll.setPayPeriodEndDate(endDate);			

			payroll.setBasicSalary(rs.getDouble("Basicsalary"));			

			payroll.setOvertimePay(rs.getDouble("overtimepay"));			

			payroll.setDeductions(rs.getDouble("deductions"));			

			payroll.setNetSalary(rs.getDouble("netsalary"));			

			payrollList.add(payroll);		}		return payrollList;

	}



}