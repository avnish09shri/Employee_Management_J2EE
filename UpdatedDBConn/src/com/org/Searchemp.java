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

@WebServlet("/servlet/Searchemp")
public class Searchemp extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p=response.getWriter();
		response.setContentType("text/html");
		String eno=request.getParameter("eno");
		try
		{
			Dbconn d=new Dbconn();
			ResultSet rs=d.getEmp(Integer.parseInt(eno));
			if(rs.next())
			{
				p.print("<head><link rel='stylesheet' href='../css/bootstrap.css'></head>");
				p.print("<body><div class='container jumbotron mt-5' align='center'>");
				p.print("<table class='table table-hover table-striped'>");
				p.print(rs.getString(1)+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString(2)+"&nbsp;&nbsp;&nbsp;&nbsp;"+
						rs.getString(3)+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString(4));
				p.print("</table>");
			}
			else
			{
				p.print("<head><link rel='stylesheet' href='../css/bootstrap.css'></head>");
				p.print("<body><div class='container jumbotron mt-5' align='center'>");
				p.print("invalid");
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		p.print("<a href=EmpRecords>Back</a>");
	}

}
