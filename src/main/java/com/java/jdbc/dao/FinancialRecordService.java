package com.java.jdbc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.java.jdbc.model.FinancialRecord;
import com.java.jdbc.util.DBConnUtil;
import com.java.jdbc.util.DBPropertyUtil;
public class FinancialRecordService implements IFinancialRecordService{
	Connection con;	
	PreparedStatement pst;	
	public int GenerateRecordId() throws ClassNotFoundException, SQLException {		
		String connstr=DBPropertyUtil.getConnectionString("db");		
		con=DBConnUtil.getConnection(connstr);		
		String cmd="Select max(recordid)+1 rid from finance";		
		pst=con.prepareStatement(cmd);		
		ResultSet rs=pst.executeQuery();		
		rs.next();		
		int rid = rs.getInt("rid");		
		return rid;	}
	

	//@Override
	//public String addFinancialRecord(int EmployeeID, String Descr, int Amount, String RecordType) throws ClassNotFoundException, SQLException {
		//String connstr=DBPropertyUtil.getConnectionString("db"); 
		//con=DBConnUtil.getConnection(connstr); 
		//String cmd="insert into finance (RecordID, EmployeeID, RecordDate, Descr, Amount, RecordType) values (?,?,?,?,?,?)"; 
		//pst=con.prepareStatement(cmd); 
		//pst.setInt(1,GenerateRecordId()); 
		//pst.setInt(2, EmployeeID); 
		//pst.setDate(3, new java.sql.Date(new java.util.Date().getTime())); 
		//pst.setString(4, Descr); 
		//pst.setDouble(5, Amount); 
		//pst.setString(6, RecordType); 
		//pst.executeUpdate(); 
		//return "Inserted successfully";	
	//}

	@Override
	public
	FinancialRecord GetFinancialRecordById(int recordId) throws ClassNotFoundException, SQLException 
	{		
		String connstr=DBPropertyUtil.getConnectionString("db");		
		con=DBConnUtil.getConnection(connstr);		
		String cmd="select * from finance where recordid=?";		
		pst=con.prepareStatement(cmd);		
		pst.setInt(1, recordId);		
		ResultSet rs=pst.executeQuery();		
		FinancialRecord finance=null;		
		if(rs.next())		
		{			
			finance = new FinancialRecord();			
			finance.setRecordID(recordId);			
			finance.setEmployeeID(rs.getInt("Employeeid"));			
			finance.setRecordDate(rs.getDate("recorddate"));			
			finance.setAmount(rs.getDouble("amount"));			
			finance.setDescr(rs.getString("descr"));			
			finance.setRecordType(rs.getString("recordtype"));					
			}		
		return finance;	}

	@Override
	public
	List<FinancialRecord> GetFinancialRecordsForEmployee(int EmployeeID) throws ClassNotFoundException, SQLException {
		String connstr=DBPropertyUtil.getConnectionString("db");		
		con=DBConnUtil.getConnection(connstr);		
		String cmd="select * from finance where employeeid=?";		
		pst=con.prepareStatement(cmd);		
		pst.setInt(1, EmployeeID);		
		ResultSet rs=pst.executeQuery();		
		List<FinancialRecord> finList=new ArrayList<FinancialRecord>();		
		FinancialRecord finance=null;		
		while(rs.next())		
		{			
			finance = new FinancialRecord();			
			finance.setRecordID(rs.getInt("recordid"));			
			finance.setEmployeeID(EmployeeID);			
			finance.setRecordDate(rs.getDate("recorddate"));			
			finance.setAmount(rs.getDouble("amount"));			
			finance.setDescr(rs.getString("descr"));			
			finance.setRecordType(rs.getString("recordtype"));			
			finList.add(finance);		}		
		return finList;			}
		
	
	@Override
	public List<FinancialRecord> GetFinancialRecordsForDate(java.sql.Date RecordDate) throws ClassNotFoundException, SQLException {
		
			String connstr=DBPropertyUtil.getConnectionString("db"); 
			con=DBConnUtil.getConnection(connstr); 
			String cmd="select * from finance where recorddate=?"; 
			pst=con.prepareStatement(cmd); 
			pst.setDate(1, new java.sql.Date(RecordDate.getTime())); 
			ResultSet rs=pst.executeQuery(); 
			List<FinancialRecord> finList=new ArrayList<FinancialRecord>(); 
			FinancialRecord finance=null; 
			while(rs.next()) { finance = new FinancialRecord(); 
			finance.setRecordID(rs.getInt("recordid")); 
			finance.setEmployeeID(rs.getInt("employeeid")); 
			finance.setRecordDate(new java.sql.Date(RecordDate.getTime())); 
			finance.setAmount(rs.getDouble("amount")); 
			finance.setDescr(rs.getString("descr")); 
			finance.setRecordType(rs.getString("recordtype")); 
			finList.add(finance); } return finList; }


	public String AddFinancialRecord(int EmployeeID, String Descr, double Amount, String RecordType) 
            throws ClassNotFoundException, SQLException {
        String connstr = DBPropertyUtil.getConnectionString("db");
        Connection con = DBConnUtil.getConnection(connstr);
        
        String cmd = "INSERT INTO finance (RecordID, EmployeeID, RecordDate, Descr, Amount, RecordType) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(cmd);
        
        pst.setInt(1, GenerateRecordId());
        pst.setInt(2, EmployeeID);
        pst.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
        pst.setString(4, Descr);
        pst.setDouble(5, Amount);
        pst.setString(6, RecordType);
        
        pst.executeUpdate();
        return "Inserted successfully";
    }
}
	
		
	