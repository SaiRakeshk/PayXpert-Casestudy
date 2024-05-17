package com.java.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.java.jdbc.model.Employee;
import com.java.jdbc.util.DBConnUtil;
import com.java.jdbc.util.DBPropertyUtil;

public class EmployeeService implements IEmployeeService{
	Connection conn;
	PreparedStatement pst;
	public int GenerateEmployeeId() throws ClassNotFoundException, SQLException 
	{ 
		String connstr = DBPropertyUtil.getConnectionString("db"); 
		conn=DBConnUtil.getConnection(connstr); 
		String cmd="select max(employeeid)+1 eid from employee"; 
		pst=conn.prepareStatement(cmd); 
		ResultSet rs=pst.executeQuery(); 
		rs.next(); int eid = rs.getInt("eid"); 
		return eid; }
	

	@Override
	public Employee GetEmployeeById(int employeeid) throws ClassNotFoundException, SQLException {
		String connstr=DBPropertyUtil.getConnectionString("db");
		conn=DBConnUtil.getConnection(connstr);
		String cmd="select * from Employee where employeeid=?";
		pst=conn.prepareStatement(cmd);
		pst.setInt(1, employeeid);
		ResultSet rs=pst.executeQuery();
		Employee employ = null; 
		if(rs.next()) { 
			employ = new Employee(); 
			employ.setEmployeeID(rs.getInt("employeeId")); 
			employ.setFirstName(rs.getString("FirstName")); 
			employ.setLastName(rs.getString("LastName")); 
			employ.setPhoneNumber(rs.getString("phonenumber")); 
			employ.setEmail(rs.getString("Email")); 
			employ.setAddress(rs.getString("Address")); 
			employ.setDob(rs.getDate("dob")); 
			employ.setGender(rs.getString("Gender")); 
			employ.setPosition(rs.getString("Position")); 
			employ.setJoiningDate(rs.getDate("JoiningDate")); 
			employ.setTerminationDate(rs.getDate("TerminationDate"));
			} 
		return employ;

	}

	@Override
	public List<Employee> GetAllEmployee() throws ClassNotFoundException, SQLException {
		String connstr=DBPropertyUtil.getConnectionString("db");
		conn=DBConnUtil.getConnection(connstr);
		String cmd="select * from employee";
		pst=conn.prepareStatement(cmd);
		ResultSet rs=pst.executeQuery();
		List<Employee> employeList=new ArrayList<Employee>();
		Employee employ=null;
		while(rs.next()) {
			employ=new Employee(); 
			employ.setEmployeeID(rs.getInt("employeeId")); 
			employ.setFirstName(rs.getString("FirstName")); 
			employ.setLastName(rs.getString("LastName")); 
			employ.setPhoneNumber(rs.getString("phonenumber")); 
			employ.setEmail(rs.getString("Email")); 
			employ.setAddress(rs.getString("Address")); 
			employ.setDob(rs.getDate("dob")); 
			employ.setGender(rs.getString("Gender")); 
			employ.setPosition(rs.getString("Position")); 
			employ.setJoiningDate(rs.getDate("JoiningDate")); 
			employ.setTerminationDate(rs.getDate("TerminationDate"));
			employeList.add(employ);
			} 
		
		return employeList;
	}

	@Override
	public String AddEmployee(Employee employe) throws ClassNotFoundException, SQLException {
		int emp_id=GenerateEmployeeId();		
		String connstr = DBPropertyUtil.getConnectionString("db");		
		conn=DBConnUtil.getConnection(connstr);		
		String cmd="insert into employee(employeeid,firstname,lastname,phonenumber,email,address,gender,position,dob,joiningdate,TerminationDate) values"				+"(?,?,?,?,?,?,?,?,?,?,?)";		
		pst=conn.prepareStatement(cmd);		
		pst.setInt(1, emp_id);		
		pst.setString(2,employe.getFirstName());		
		pst.setString(3, employe.getLastName());		
		pst.setString(7, employe.getGender());		
		pst.setString(4, employe.getPhoneNumber());		
		pst.setString(5, employe.getEmail());		
		pst.setString(8 , employe.getPosition());		
		pst.setString(6 , employe.getAddress());		
		pst.setDate(9, new java.sql.Date(employe.getDob().getTime()));		
		pst.setDate(10, new java.sql.Date(employe.getJoiningDate().getTime()));		
		pst.setDate(11,new java.sql.Date(employe.getTerminationDate().getTime()));		
		pst.executeUpdate();		
		return "Inserted Successfully..";
	}

	@Override
	public String UpdateEmployee(Employee employe) throws ClassNotFoundException, SQLException {
	    String connstr = DBPropertyUtil.getConnectionString("db");
	    conn = DBConnUtil.getConnection(connstr);
	    String cmd = "update employee set firstname=?,lastname=?,gender=?,phonenumber=?,email=?,position=?,address=?,dob=?,joiningdate=?,TerminationDate=? where employeeid=?";

	    pst = conn.prepareStatement(cmd);
	    pst.setString(1, employe.getFirstName());
	    pst.setString(2, employe.getLastName());
	    pst.setString(3, employe.getGender());
	    pst.setString(4, employe.getPhoneNumber());
	    pst.setString(5, employe.getEmail());
	    pst.setString(6, employe.getPosition());
	    pst.setString(7, employe.getAddress());
	    pst.setDate(8, new java.sql.Date(employe.getDob().getTime()));
	    pst.setDate(9, new java.sql.Date(employe.getJoiningDate().getTime()));
	    if (employe.getTerminationDate() != null) {
	        pst.setDate(10, new java.sql.Date(employe.getTerminationDate().getTime()));
	    } else {
	        pst.setNull(10, java.sql.Types.DATE);
	    }
	    pst.setInt(11, employe.getEmployeeID());

	    pst.executeUpdate();
	    return "updated Successfully..";
	}


	@Override
	public String RemoveEmployee(int employeeId) throws ClassNotFoundException, SQLException {
		String connstr = DBPropertyUtil.getConnectionString("db"); 
		conn=DBConnUtil.getConnection(connstr); 
		String cmd="delete from Employee where employeeid=?"; 
		pst=conn.prepareStatement(cmd); 
		pst.setInt(1, employeeId); 
		pst.executeUpdate(); 
		return "Deleted successfully..";
	}


	

}
