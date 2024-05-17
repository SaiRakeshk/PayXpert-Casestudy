package com.java.jdbc.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.java.jdbc.model.Payroll;

public interface IPayrollService {
	//GeneratePayroll(employeeId, startDate, endDate)
	//• GetPayrollById(payrollId)
	//• GetPayrollsForEmployee(employeeId)
	//• GetPayrollsForPeriod(startDate, endDate)
	List<Payroll> GeneratePayroll(int EmployeeID,Date startDate,Date endDate) throws ClassNotFoundException, SQLException;
	Payroll GetPayrollById(int payrollID) throws ClassNotFoundException, SQLException;
	List<Payroll> GetPayrollsForEmployee(int EmployeeID) throws SQLException, ClassNotFoundException;
	List<Payroll> GetPayrollsForPeriod(Date startDate,Date endDate) throws SQLException, ClassNotFoundException;

}
