package com.java.jdbc;



import static org.junit.Assert.*;



import java.text.ParseException;

import java.text.SimpleDateFormat;



import org.junit.Test;



import com.java.jdbc.model.Employee;

import com.java.jdbc.model.FinancialRecord;

import com.java.jdbc.model.Tax;



public class FinancialRecordTest {





	@Test

	public void testConstructors() throws ParseException {

		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");

		FinancialRecord f= new FinancialRecord();

		assertNotNull(f);

		FinancialRecord f1 = new FinancialRecord(1, 1, sdf.parse("01/04/2024"), "Salary", 50000, "Income");

	}

	

	@Test

	public void testGettersSetters() throws ParseException {

		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");

		FinancialRecord f= new FinancialRecord();

		f.setRecordID(1);

		f.setEmployeeID(1);

		f.setRecordDate(sdf.parse("01/04/2024"));

		f.setDescr("Salary");

		f.setAmount(50000);

		f.setRecordType("Income");

		assertEquals(1,f.getRecordID());

		assertEquals(1,f.getEmployeeID());

		assertEquals(sdf.parse("01/04/2024"),f.getRecordDate());

		assertEquals("Salary",f.getDescr());

		assertEquals(50000,f.getAmount(),0);

		assertEquals("Income",f.getRecordType());

	}

	

	@Test

	public void testHashCode() throws ParseException {

		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");

		FinancialRecord f1 = new FinancialRecord(1, 1, sdf.parse("01/04/2024"), "Salary", 50000, "Income");

		FinancialRecord f2 = new FinancialRecord(1, 1, sdf.parse("01/04/2024"), "Salary", 50000, "Income");

		assertEquals(f1.hashCode(), f2.hashCode());

	}



	@Test

	public void testEquals() throws ParseException {

		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");

		FinancialRecord f1 = new FinancialRecord(1, 1, sdf.parse("01/04/2024"), "Salary", 50000, "Income");

		FinancialRecord f2 = new FinancialRecord(1, 1, sdf.parse("01/04/2024"), "Salary", 50000, "Income");

		FinancialRecord f3 = new FinancialRecord(1, 2, sdf.parse("01/04/2024"), "Salary", 50000, "Income");

		assertTrue(f1.equals(f2));

		assertFalse(f1.equals(f3));

	}

	



	

	@Test

	public void testToString() throws ParseException {

		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");

		FinancialRecord f1 = new FinancialRecord(1, 1, sdf.parse("01/04/2024"), "Salary", 50000, "Income");

		String result = "FinancialRecord [RecordID=1, EmployeeID=1, Descr=Salary, Amount=50000.0, RecordType=Income]";

		assertEquals(f1.toString(), result);

	}
}