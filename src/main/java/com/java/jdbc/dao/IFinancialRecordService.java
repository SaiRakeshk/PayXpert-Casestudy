package com.java.jdbc.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.java.jdbc.model.FinancialRecord;

public interface IFinancialRecordService {
	//AddFinancialRecord(employeeId, description, amount, recordType)
	//• GetFinancialRecordById(recordId)
	//• GetFinancialRecordsForEmployee(employeeId)
	//• GetFinancialRecordsForDate(recordDate)
	String AddFinancialRecord(int EmployeeID,String Descr,double Amount,String RecordType) throws ClassNotFoundException, SQLException;
	FinancialRecord GetFinancialRecordById(int recordID) throws ClassNotFoundException, SQLException;
	List<FinancialRecord> GetFinancialRecordsForEmployee(int EmployeeID) throws ClassNotFoundException, SQLException;
	List<FinancialRecord> GetFinancialRecordsForDate(Date RecordDate) throws ClassNotFoundException, SQLException;
	
}
