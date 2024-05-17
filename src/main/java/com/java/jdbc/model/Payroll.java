package com.java.jdbc.model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class Payroll {
	private int PayrollID;
	private int EmployeeID;
	private Date PayPeriodStartDate;
	private Date PayPeriodEndDate;
	private double BasicSalary;
	private double OvertimePay;
	private double Deductions;
	private double NetSalary;
	public int getPayrollID() {
		return PayrollID;
	}
	public void setPayrollID(int payrollID) {
		PayrollID = payrollID;
	}
	public int getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}
	public Date getPayPeriodStartDate() {
		return PayPeriodStartDate;
	}
	public void setPayPeriodStartDate(Date payPeriodStartDate) {
		PayPeriodStartDate = payPeriodStartDate;
	}
	public Date getPayPeriodEndDate() {
		return PayPeriodEndDate;
	}
	public void setPayPeriodEndDate(Date payPeriodEndDate) {
		PayPeriodEndDate = payPeriodEndDate;
	}
	public double getBasicSalary() {
		return BasicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		BasicSalary = basicSalary;
	}
	public double getOvertimePay() {
		return OvertimePay;
	}
	public void setOvertimePay(double overtimePay) {
		OvertimePay = overtimePay;
	}
	public double getDeductions() {
		return Deductions;
	}
	public void setDeductions(double deductions) {
		Deductions = deductions;
	}
	public double getNetSalary() {
		return NetSalary;
	}
	public void setNetSalary(double netSalary) {
		NetSalary = netSalary;
	}
	public Payroll(int payrollID, int employeeID, Date payPeriodStartDate, Date payPeriodEndDate, double basicSalary,
	        double overtimePay, double deductions, double netSalary) {

    this.PayrollID = payrollID;
    this.EmployeeID = employeeID;
    this.PayPeriodStartDate = payPeriodStartDate;
    this.PayPeriodEndDate = payPeriodEndDate;
    this.BasicSalary = basicSalary;
    this.OvertimePay = overtimePay;
    this.Deductions = deductions;
    this.NetSalary = netSalary;
}

	public Payroll() {
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(BasicSalary, Deductions, EmployeeID, NetSalary, OvertimePay, PayPeriodEndDate,
				PayPeriodStartDate, PayrollID);
	}



	@Override
	public String toString() {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    return "Payroll [PayrollID=" + PayrollID + ", EmployeeID=" + EmployeeID +
	           ", PayPeriodStartDate=" + sdf.format(PayPeriodStartDate) +
	           ", PayPeriodEndDate=" + sdf.format(PayPeriodEndDate) +
	           ", BasicSalary=" + BasicSalary + ", OvertimePay=" + OvertimePay +
	           ", Deductions=" + Deductions + ", NetSalary=" + NetSalary + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payroll other = (Payroll) obj;
		return Double.doubleToLongBits(BasicSalary) == Double.doubleToLongBits(other.BasicSalary)
				&& Double.doubleToLongBits(Deductions) == Double.doubleToLongBits(other.Deductions)
				&& EmployeeID == other.EmployeeID
				&& Double.doubleToLongBits(NetSalary) == Double.doubleToLongBits(other.NetSalary)
				&& Double.doubleToLongBits(OvertimePay) == Double.doubleToLongBits(other.OvertimePay)
				&& Objects.equals(PayPeriodEndDate, other.PayPeriodEndDate)
				&& Objects.equals(PayPeriodStartDate, other.PayPeriodStartDate) && PayrollID == other.PayrollID;
	}




	

}
