package com.org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dbconn;


@WebServlet("/servlet/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p=response.getWriter();
		response.setContentType("text/html");
		try
		{
			Dbconn d=new Dbconn();
			String btn1=request.getParameter("btn1");
			if(btn1.equalsIgnoreCase("Delete"))
				delete(request,d);
			else if(btn1.equalsIgnoreCase("Update"))
				update(request,d);
			else if(btn1.equalsIgnoreCase("Insert"))
				insert(request,d);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		response.sendRedirect("EmpRecords");
	}

	void insert(HttpServletRequest request, Dbconn db)throws SQLException
	{
		int eno=Integer.parseInt(request.getParameter("eno"));
		String ename=request.getParameter("ename");
		String city=request.getParameter("city");
		int salary=Integer.parseInt(request.getParameter("salary"));
		db.insertEmp(eno, ename, city, salary);
	}
	void update(HttpServletRequest request, Dbconn db)throws SQLException
	{
		int eno=Integer.parseInt(request.getParameter("eno"));
		String ename=request.getParameter("ename");
		String city=request.getParameter("city");
		int salary=Integer.parseInt(request.getParameter("salary"));
		db.updateEmp(eno, ename, city, salary);
	}
	void delete(HttpServletRequest request, Dbconn db)throws SQLException
	{
		int eno=Integer.parseInt(request.getParameter("eno"));
		db.deleteEmp(eno);
	}
}