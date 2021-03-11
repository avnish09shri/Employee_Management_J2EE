package com.org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dbconn;

@WebServlet("/servlet/EmpRecords")
public class EmpRecords extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p=response.getWriter();
		response.setContentType("text/html");
		try
		{
			Dbconn d=new Dbconn();
			ResultSet rs=d.getRecords();
			p.print("<head><link rel='stylesheet' href='../css/bootstrap.css'></head>");
			p.print("<body><div class='container mt-5' align='center'>");
			p.print("<a href='../index.html'>Back</a>");
			p.print("<table class='table table-hover table-striped mt-4'>");
			p.print("<tr><td>Eno<td>Ename<td>City<td>salary");
			while(rs.next())
			{
				p.print("<tr><td><a href=Searchemp?eno="+rs.getString(1)+">"+rs.getString(1)+"</a><td>"+rs.getString(2)+
				"<td>"+rs.getString(3)+"<td>"+rs.getString(4));
			}
			p.print("</table>");
		}
		catch(Exception ex)
		{
			p.print(ex.getMessage());
			ex.printStackTrace();
		}
	}

}
