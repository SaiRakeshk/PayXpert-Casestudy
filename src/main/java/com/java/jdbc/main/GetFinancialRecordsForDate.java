package com.java.jdbc.main;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.java.jdbc.dao.FinancialRecordService;
import com.java.jdbc.model.FinancialRecord;

public class GetFinancialRecordsForDate {
    public static void main(String[] args) {
        List<FinancialRecord> finList = null;
        FinancialRecordService f = new FinancialRecordService();
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date recorddate = null;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter record date (dd/MM/yyyy):");
                String str = sc.nextLine();
                // Parsing the input date
                java.util.Date utilDate = sdf.parse(str);
                // Converting to java.sql.Date
                recorddate = new Date(utilDate.getTime());
                validInput = true;
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in the format dd/MM/yyyy.");
            }
        }

        try {
            finList = f.GetFinancialRecordsForDate(recorddate);
            if (finList != null) {
                for (FinancialRecord financialRecord : finList) {
                    System.out.println(financialRecord);
                }
            } else {
                System.out.println("Record not found");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
