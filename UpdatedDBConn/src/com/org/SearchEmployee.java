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


@WebServlet("/servlet/SearchEmployee")
public class SearchEmployee extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
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
					p.print("<body><div class='container mt-5' align='center'>");
					p.print("<div class='row'>");
					p.print("<div class='col-md-4'>");
					p.print("</div>");
					p.print("<div class='col-md-4 jumbotron'>");
					p.print("<form action=http://localhost:8080/UpdatedDBConn/servlet/UpdateEmployee class='form-group'>");
					p.print("Eno:<input type=text value="+rs.getString(1)+ " name=eno id=eno class='form-control' />");
					p.print("Ename:<input type=text value="+rs.getString(2)+ " name=ename id=ename class='form-control' />");
					p.print("city:<input type=text value="+rs.getString(3)+ " name=city id=city class='form-control' />");
					p.print("salary:<input type=text value="+rs.getString(4)+ " name=salary id=salary class='form-control' />");
					p.print("<div class='mt-3'>");
					p.print("<input type=submit value=Delete name=btn1 class='btn btn-block bg-danger p-1' style='color:white;' />");
					p.print("<input type=submit value=Update name=btn1 class='btn btn-block bg-success p-1' style='color:white;' />");
					p.print("<input type=submit value=Insert name=btn1 class='btn btn-block bg-primary p-1' style='color:white;' />");
					p.print("</form>");
					p.print("</div>");
					p.print("</div>");
					p.print("</div>");
					p.print("</div>");
					p.print("</body>");
				}
				else
				{
					/*p.print("<head><link rel='stylesheet' href='../css/bootstrap.css'></head>");
					p.print("<body><div class='container jumbotron mt-5' align='center'>");
					p.print("<script type='text/javascript'>\n");
		            p.print("alert('Employee no not found')");
		            p.print("</script>");*/
		            response.sendRedirect("../index.html");
				}
				
			}
			
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
		}

	}


