package com.java.jdbc.model;

import java.sql.Date;
import java.util.Objects;

public class Employee {
    private int EmployeeID;
    private String FirstName;
    private String LastName;
    private Date Dob;
    private String Gender;
    private String Email;
    private String PhoneNumber;
    private String Address;
    private String Position;
    private Date JoiningDate;
    private Date TerminationDate;

    public Employee() {}

    public Employee(int employeeID, String firstName, String lastName, String gender, String email,
                    String phoneNumber, String address, String position, Date dob, Date joiningDate, Date terminationDate) {
        EmployeeID = employeeID;
        FirstName = firstName;
        LastName = lastName;
        Gender = gender;
        Email = email;
        PhoneNumber = phoneNumber;
        Address = address;
        Position = position;
        Dob = dob;
        JoiningDate = joiningDate;
        TerminationDate = terminationDate;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Date getDob() {
        return Dob;
    }

    public void setDob(Date dob) {
        Dob = dob;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public Date getJoiningDate() {
        return JoiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        JoiningDate = joiningDate;
    }

    public Date getTerminationDate() {
        return TerminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        TerminationDate = terminationDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(EmployeeID, FirstName, LastName, Dob, Gender, Email, PhoneNumber, Address, Position, JoiningDate, TerminationDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return EmployeeID == employee.EmployeeID &&
               Objects.equals(FirstName, employee.FirstName) &&
               Objects.equals(LastName, employee.LastName) &&
               Objects.equals(Dob, employee.Dob) &&
               Objects.equals(Gender, employee.Gender) &&
               Objects.equals(Email, employee.Email) &&
               Objects.equals(PhoneNumber, employee.PhoneNumber) &&
               Objects.equals(Address, employee.Address) &&
               Objects.equals(Position, employee.Position) &&
               Objects.equals(JoiningDate, employee.JoiningDate) &&
               Objects.equals(TerminationDate, employee.TerminationDate);
    }

    @Override
    public String toString() {
        return "Employee [EmployeeID=" + EmployeeID + ", FirstName=" + FirstName + ", LastName=" + LastName +
               ", Gender=" + Gender + ", Email=" + Email + ", PhoneNumber=" + PhoneNumber +
               ", Address=" + Address + ", Position=" + Position + ", Dob=" + Dob +
               ", JoiningDate=" + JoiningDate + ", TerminationDate=" + TerminationDate + "]";
    }

}
