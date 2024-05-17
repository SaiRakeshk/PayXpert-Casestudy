package com.java.jdbc.main;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.java.jdbc.dao.PayrollService;
import com.java.jdbc.model.Payroll;

public class GetPayrollsForPeriod {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter employee payroll start date (dd/MM/yyyy):");
            String dateStr = sc.next();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date utilStartDate = sdf.parse(dateStr);
            Date startDate = new Date(utilStartDate.getTime());

            System.out.println("Enter employee payroll end date (dd/MM/yyyy):");
            String dateStr1 = sc.next();
            java.util.Date utilEndDate = sdf.parse(dateStr1);
            Date endDate = new Date(utilEndDate.getTime());

            PayrollService payrollService = new PayrollService();
            List<Payroll> payrollList = payrollService.GetPayrollsForPeriod(startDate, endDate);

            if (payrollList != null) {
                for (Payroll payroll : payrollList) {
                    System.out.println(payroll);
                }
            } else {
                System.out.println("Records not found");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
