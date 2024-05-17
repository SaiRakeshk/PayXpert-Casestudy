package com.java.jdbc;
import static org.junit.Assert.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.java.jdbc.model.Payroll;

public class PayrollTest {

    @Test
    public void testConstructors() throws ParseException {
        Payroll p = new Payroll();
        assertNotNull(p);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Payroll p1 = new Payroll(1, 1, new Date(sdf.parse("10/10/2000").getTime()), new Date(sdf.parse("01/05/2024").getTime()), 50000.0, 3000.0, 1000.0, 52000.0);
    }

    @Test
    public void testGettersSetters() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Payroll p = new Payroll();
        p.setPayrollID(1);
        p.setEmployeeID(1);
        p.setPayPeriodStartDate(new Date(sdf.parse("10/10/2000").getTime()));
        p.setPayPeriodEndDate(new Date(sdf.parse("01/05/2024").getTime()));
        p.setBasicSalary(50000.0);
        p.setOvertimePay(3000.0);
        p.setDeductions(1000.0);
        p.setNetSalary(52000.0);            
        assertEquals(1, p.getPayrollID());
        assertEquals(1, p.getEmployeeID());
        assertEquals(new Date(sdf.parse("10/10/2000").getTime()), p.getPayPeriodStartDate());
        assertEquals(new Date(sdf.parse("01/05/2024").getTime()), p.getPayPeriodEndDate());
        assertEquals(50000.0, p.getBasicSalary(), 0);
        assertEquals(3000.0, p.getOvertimePay(), 0);
        assertEquals(1000.0, p.getDeductions(), 0);
        assertEquals(52000.0, p.getNetSalary(), 0);
    }
    


    @Test
    public void testHashCode() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Payroll p1 = new Payroll(1, 1, new java.sql.Date(sdf.parse("10/10/2000").getTime()), new java.sql.Date(sdf.parse("01/05/2024").getTime()), 50000.0, 3000.0, 1000.0, 52000.0);
        Payroll p2 = new Payroll(1, 1, new java.sql.Date(sdf.parse("10/10/2000").getTime()), new java.sql.Date(sdf.parse("01/05/2024").getTime()), 50000.0, 3000.0, 1000.0, 52000.0);

        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    public void testEquals() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Payroll p1 = new Payroll(1, 1, new java.sql.Date(sdf.parse("10/10/2000").getTime()), new java.sql.Date(sdf.parse("01/05/2024").getTime()), 50000.0, 3000.0, 1000.0, 52000.0);
        Payroll p2 = new Payroll(1, 1, new java.sql.Date(sdf.parse("10/10/2000").getTime()), new java.sql.Date(sdf.parse("01/05/2024").getTime()), 50000.0, 3000.0, 1000.0, 52000.0);
        Payroll p3 = new Payroll(1, 1, new java.sql.Date(sdf.parse("10/11/2000").getTime()), new java.sql.Date(sdf.parse("01/05/2024").getTime()), 50000.0, 3000.0, 1000.0, 52000.0);
        assertTrue(p1.equals(p2));
        assertFalse(p1.equals(p3));
        assertTrue(p1.equals(p2));
        assertTrue(p1.equals(p2));
        assertTrue(p1.equals(p2));
        assertTrue(p1.equals(p2));
        assertTrue(p2.equals(p1));
        assertTrue(p1.equals(p1));
        assertFalse(p1.equals(p3));
        assertFalse(p2.equals(p3));
        assertFalse(p1.equals(null));
        assertFalse(p1.equals("Some String"));
        
        
    }

    @Test
    public void testToString() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Payroll p1 = new Payroll(1, 1, new java.sql.Date(sdf.parse("10/10/2000").getTime()), new java.sql.Date(sdf.parse("01/05/2024").getTime()), 50000.0, 3000.0, 1000.0, 52000.0);

        String expected = "Payroll [PayrollID=1, EmployeeID=1, PayPeriodStartDate=2000-10-10, PayPeriodEndDate=2024-05-01, BasicSalary=50000.0, OvertimePay=3000.0, Deductions=1000.0, NetSalary=52000.0]";
        assertEquals(expected.toLowerCase(), p1.toString().toLowerCase());
    }

}
