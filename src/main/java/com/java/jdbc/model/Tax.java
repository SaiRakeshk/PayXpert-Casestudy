package com.java.jdbc.model;



import java.util.Objects;



public class Tax {

	private int TaxID;

	private int EmployeeID;

	private String TaxYear;

	private double TaxableIncome;

	private double TaxAmount;

	public int getTaxID() {

		return TaxID;

	}

	public void setTaxID(int taxID) {

		TaxID = taxID;

	}

	public int getEmployeeID() {

		return EmployeeID;

	}

	public void setEmployeeID(int employeeID) {

		EmployeeID = employeeID;

	}

	public String getTaxYear() {

		return TaxYear;

	}

	public void setTaxYear(String taxYear) {

		TaxYear = taxYear;

	}

	public double getTaxableIncome() {

		return TaxableIncome;

	}

	public void setTaxableIncome(double taxableIncome) {

		TaxableIncome = taxableIncome;

	}

	public double getTaxAmount() {

		return TaxAmount;

	}

	public void setTaxAmount(double taxAmount) {

		TaxAmount = taxAmount;

	}

	public Tax(int taxID, int employeeID, String taxYear, double taxableIncome, double taxAmount) {

		

		TaxID = taxID;

		EmployeeID = employeeID;

		TaxYear = taxYear;

		TaxableIncome = taxableIncome;

		TaxAmount = taxAmount;

	}

	public Tax() {

		

		// TODO Auto-generated constructor stub

	}

	@Override

	public String toString() {

		return "Tax [TaxID=" + TaxID + ", EmployeeID=" + EmployeeID + ", TaxYear=" + TaxYear + ", TaxableIncome="

				+ TaxableIncome + ", TaxAmount=" + TaxAmount + "]";

	}

	@Override public int hashCode() 

	{ 

		return Objects.hash(TaxID, EmployeeID, TaxYear, TaxableIncome ,TaxAmount );

		} 

	@Override public boolean equals(Object obj) 

	{ 

		Tax t = (Tax)obj; if (t.getTaxID() == TaxID && t.getEmployeeID() == EmployeeID && t.getTaxYear()==TaxYear && t.getTaxableIncome()==TaxableIncome && t.getTaxAmount()==TaxAmount ) 

		{ 

			return true; 

			}

		return false;

		}

	

	

}

