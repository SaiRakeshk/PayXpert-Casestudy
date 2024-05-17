package com.java.jdbc.model;



import java.util.Date;

import java.util.Objects;



public class FinancialRecord {

	private int RecordID;

	private int EmployeeID;

	private Date RecordDate;

	private String Descr;

	private double Amount;

	private String RecordType;

	public int getRecordID() {

		return RecordID;

	}

	public void setRecordID(int recordID) {

		RecordID = recordID;

	}

	public int getEmployeeID() {

		return EmployeeID;

	}

	public void setEmployeeID(int employeeID) {

		EmployeeID = employeeID;

	}

	public Date getRecordDate() {

		return RecordDate;

	}

	public void setRecordDate(Date recordDate) {

		RecordDate = recordDate;

	}

	public String getDescr() {

		return Descr;

	}

	public void setDescr(String descr) {

		Descr = descr;

	}

	public double getAmount() {

		return Amount;

	}

	public void setAmount(double amount) {

		Amount = amount;

	}

	public String getRecordType() {

		return RecordType;

	}

	public void setRecordType(String recordType) {

		RecordType = recordType;

	}

	public FinancialRecord(int recordID, int employeeID, Date recordDate, String descr, double amount,

			String recordType) {

		RecordID = recordID;

		EmployeeID = employeeID;

		RecordDate = recordDate;

		Descr = descr;

		Amount = amount;

		RecordType = recordType;

	}

	public FinancialRecord() {

		// TODO Auto-generated constructor stub

	}

	@Override

	public String toString() {

		return "FinancialRecord [RecordID=" + RecordID + ", EmployeeID=" + EmployeeID + ", Descr=" + Descr + ", Amount="

				+ Amount + ", RecordType=" + RecordType + "]";

	}

	@Override

	public int hashCode() {

		return Objects.hash(RecordID, EmployeeID, RecordDate, Descr , Amount , RecordType);

	}

	

	@Override

	public boolean equals(Object obj) {

		FinancialRecord f = (FinancialRecord)obj;

		if (f.getRecordID() == RecordID && f.getEmployeeID() == EmployeeID 

            	&&f.getRecordDate().compareTo(RecordDate) ==0 

			&& f.getDescr()==Descr

		&& f.getAmount()==Amount && f.getRecordType()==RecordType

				) {

			return true;

		}

		return false;

	}

	

}

