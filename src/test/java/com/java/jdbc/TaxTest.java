package com.java.jdbc; 

import static org.junit.Assert.*; 

import java.text.ParseException; 

import java.text.SimpleDateFormat; 

import org.junit.Test; 

import com.java.jdbc.model.Payroll; 

import com.java.jdbc.model.Tax; 

public class TaxTest 

{ 

	@Test 

	public void testConstructors() throws ParseException 

	{ 

		Tax t=new Tax(); 

		assertNotNull(t); 

		Tax t1 = new Tax(1, 1, "2020", 44500,7500 ); 

		} 

	@Test 

	public void testGettersSetters() throws ParseException 

	{ 

		Tax t=new Tax(); t.setTaxID(1); 

		t.setEmployeeID(1); 

		t.setTaxYear("2020"); 

		t.setTaxableIncome(44500); 

		t.setTaxAmount(7500); 

		assertEquals(1,t.getTaxID()); 

		assertEquals(1,t.getEmployeeID()); 

		assertEquals("2020",t.getTaxYear()); 

		assertEquals(44500,t.getTaxableIncome(),0); 

		assertEquals(7500,t.getTaxAmount(),0); 

		} 

	@Test 

	public void testHashCode() throws ParseException 

	{ 

		Tax t1 = new Tax(1, 1, "2020", 44500,7500 ); 

		Tax t2 = new Tax(1, 1, "2020", 44500,7500 ); 

		assertEquals(t1.hashCode(), t2.hashCode()); 

		} 

	@Test public void testEquals() throws ParseException 

	{ 

		Tax t1 = new Tax(1, 1, "2020", 44500,7500 ); 

		Tax t2 = new Tax(1, 1, "2020", 44500,7500 );

		Tax t3 = new Tax(1, 1, "2020", 43500,7500 ); 

		assertTrue(t1.equals(t2));

		assertFalse(t1.equals(t3)); 

		} 

	@Test public void testToString() throws ParseException 

	{ 

		Tax t1 = new Tax(1, 1, "2020", 44500,7500 ); 

		String result = 

				"Tax [TaxID=1, EmployeeID=1, TaxYear=2020, TaxableIncome=44500.0, TaxAmount=7500.0]"; 

		assertEquals(t1.toString(), result); 

		} 

	}