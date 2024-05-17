package com.java.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.jdbc.model.Tax;

public interface ITaxService {
	//• CalculateTax(employeeId, taxYear)
	//• GetTaxById(taxId)
	//• GetTaxesForEmployee(employeeId)
	//• GetTaxesForYear(taxYear)
	double CalculateTax(int EmployeeID,String TaxYear) throws SQLException, ClassNotFoundException;
	double GetTaxById(int TaxID) throws SQLException, ClassNotFoundException;
	List<Tax> GetTaxesForEmployee(int EmployeeID) throws ClassNotFoundException, SQLException;
	List<Tax> GetTaxesForYear(String TaxYear)throws ClassNotFoundException, SQLException;
}
