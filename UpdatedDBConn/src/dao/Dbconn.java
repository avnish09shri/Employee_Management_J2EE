package dao;
import java.sql.*;
public class Dbconn {
	Connection cn;
	Statement st;
	PreparedStatement ps;
	public Dbconn()throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		 cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/avi","root","avnish");
	     st=cn.createStatement();
	}
	public ResultSet getRecords()throws SQLException
	{
		ResultSet rs=st.executeQuery("select * from employee");
		return rs;
	}
	public ResultSet getEmp(int eno)throws SQLException
	{
		ResultSet rs=st.executeQuery("select * from employee where eno="+eno);
		return rs;
	}
	public int deleteEmp(int eno) throws SQLException
	{
		int x=st.executeUpdate("delete from employee where eno="+eno);
		return x;
	}
	public int updateEmp(int eno ,String ename,String city,int salary)throws SQLException
	{
		PreparedStatement pt=cn.prepareStatement("update employee set ename=?,city=?,salary=? where eno=?");
		pt.setString(1, ename);
		pt.setString(2, city);
		pt.setInt(3, salary);
		pt.setInt(4, eno);
		int x=pt.executeUpdate();
		return x;
	}
	public int insertEmp(int eno,String ename,String city,int salary)throws SQLException
	{
		PreparedStatement pt=cn.prepareStatement("insert into employee(eno,ename,city,salary)values(?,?,?,?)");
		pt.setInt(1, eno);
		pt.setString(2, ename);
		pt.setString(3, city);
		pt.setInt(4, salary);
		int x=pt.executeUpdate();
		return x;
	}
}
