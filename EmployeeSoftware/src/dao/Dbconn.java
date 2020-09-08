package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.PreparedStatement;

public class Dbconn {
Connection cn;
Statement st;
PreparedStatement pt;
	public Dbconn() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","avnish");
		st=cn.createStatement();
	}
	public ResultSet Login(String userid,String password) throws SQLException
	{
		pt=cn.prepareStatement("select * from login where userid=? and password=?");
		pt.setString(1, userid);
		pt.setString(2, password);
		ResultSet rs=pt.executeQuery();
		return rs;
	}
	public ResultSet getDept() throws SQLException
	{
		ResultSet rs=st.executeQuery("select * from department");
		return rs;
	}
	public ResultSet getDesignation() throws SQLException
	{
		ResultSet rs=st.executeQuery("select * from designation");
		return rs;
	}
	public int insertEmp(int eno,String ename,String DOB,String gender,String address,String email,String password,String mobileno,String city,
			String state,int salary,String designation,String dept,String photo)throws SQLException
	{
		pt=cn.prepareStatement("insert into emp(eno,ename,DOB,gender,address,"
				+ "email,password,mobileno,city,state,salary,designation,dept,photo)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		pt.setInt(1, eno);
		pt.setString(2, ename);
		pt.setString(3, DOB);
		pt.setString(4, gender);
		pt.setString(5, address);
		pt.setString(6, email);
		pt.setString(7, password);
		pt.setString(8, mobileno);
		pt.setString(9, city);
		pt.setString(10, state);
		pt.setInt(11, salary);
		pt.setString(12, designation);
		pt.setString(13, dept);
		pt.setString(14, photo);
		int x=pt.executeUpdate();
		return x;
	}
	public ResultSet getRecords() throws SQLException
	{
		ResultSet rs=st.executeQuery("select * from emp");
		return rs;
	}
	public ResultSet getEmployee(int eno) throws SQLException
	{
		ResultSet rs=st.executeQuery("select * from emp where eno="+eno);
		return rs;
	}
	public int deleteEmp(int eno) throws SQLException
	{
		int x=st.executeUpdate("delete from emp where eno="+eno);
		return x;
	}
	public int updateEmp(int eno ,String ename,String address,String email,String password,String mobileno,String city,String state,int salary,String designation,String dept)throws SQLException
	{
		PreparedStatement pt=cn.prepareStatement("update emp set ename=?,address=?,email=?,password=?,mobileno=?,city=?,state=?,salary=?,designation=?,dept=? where eno=?");
		pt.setString(1, ename);
		pt.setString(2, address);
		pt.setString(3, email);
		pt.setString(4, password);
		pt.setString(5, mobileno);
		pt.setString(6, city);
		pt.setString(7, state);
		pt.setInt(8, salary);
		pt.setString(9, designation);
		pt.setString(10, dept);
		pt.setInt(11, eno);
		int x=pt.executeUpdate();
		return x;
	}
	public int insertPay(int eno,String month,String year,int salary,double da,double ta,double hra,double sa,double gross) throws SQLException
	{
		pt=cn.prepareStatement("insert into paymaster(eno,month,year,salary,da,ta,hra,sa,gross)values(?,?,?,?,?,?,?,?,?)");
		pt.setInt(1, eno);
		pt.setString(2, month);
		pt.setString(3, year);
		pt.setInt(4, salary);
		pt.setDouble(5, da);
		pt.setDouble(6, ta);
		pt.setDouble(7, hra);
		pt.setDouble(8, sa);
		pt.setDouble(9, gross);
		int x=pt.executeUpdate();
		return x;
	}
	public ResultSet getPaySlip(String month,String year) throws SQLException
	{
		pt=cn.prepareStatement("select emp.eno,designation,dept,da,ta,hra,sa,gross from emp,paymaster where emp.eno=paymaster.eno and month=? and year=?");
		pt.setString(1, month);
		pt.setString(2, year);
		ResultSet rs=pt.executeQuery();
		return rs;
	}
	public ResultSet getPay(String month,String year) throws SQLException
	{
		pt=cn.prepareStatement("select emp.eno,ename,emp.salary,designation,dept,da,ta,hra,sa,gross from emp,paymaster where emp.eno=paymaster.eno and month=? and year=?");
		pt.setString(1, month);
		pt.setString(2, year);
		ResultSet rs=pt.executeQuery();
		return rs;
	}
	public ResultSet getM(String month,String year)throws SQLException
	{
		pt=cn.prepareStatement("select * from paymaster where month=? and year=?");
		pt.setString(1, month);
		pt.setString(2, year);
		ResultSet rs=pt.executeQuery();
		return rs;
	}
}
