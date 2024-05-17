package com.java.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.jdbc.model.Employee;

public interface IEmployeeService {
	Employee GetEmployeeById(int employeeid) throws ClassNotFoundException,SQLException;
	List <Employee> GetAllEmployee() throws ClassNotFoundException,SQLException;
	String AddEmployee(Employee employe) throws ClassNotFoundException,SQLException;
	String UpdateEmployee(Employee employe) throws ClassNotFoundException,SQLException;
	String RemoveEmployee(int employeeId) throws ClassNotFoundException, SQLException;
	
}
