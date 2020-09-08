

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dbconn;

//@WebServlet("/servlet/AllEmployees")
public class AllEmployees extends HttpServlet {

	String heading1,heading2,heading3,heading4,heading5,heading6,heading7,heading8,footer1
	,url1,url2,url3,url4,url5,url6,url7,url8;	

	public void init(ServletConfig sc) throws ServletException
	{
		
		heading1=sc.getInitParameter("heading1");
		url1=sc.getInitParameter("url1");
		heading2=sc.getInitParameter("heading2");
		url2=sc.getInitParameter("url2");
		heading3=sc.getInitParameter("heading3");
		url3=sc.getInitParameter("url3");
		heading4=sc.getInitParameter("heading4");
		url4=sc.getInitParameter("url4");
		heading5=sc.getInitParameter("heading5");
		url5=sc.getInitParameter("url5");
		heading6=sc.getInitParameter("heading6");
		url6=sc.getInitParameter("url6");
		heading7=sc.getInitParameter("heading7");
		url7=sc.getInitParameter("url7");
		heading8=sc.getInitParameter("heading8");
		url8=sc.getInitParameter("url8");
		footer1=sc.getInitParameter("footer1");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession hs=request.getSession();
		if(hs.isNew())
		{
			response.sendRedirect("../index.html");
		}
		
		
		PrintWriter p=response.getWriter();
		response.setContentType("text/html");
		
		String paramValue= (String)  request.getAttribute("paramName");
		
		RequestDispatcher rd=request.getRequestDispatcher("Menu");
		request.setAttribute("heading1", heading1);
		request.setAttribute("heading2", heading2);
		request.setAttribute("url1", url1);
		request.setAttribute("url2", url2);
		request.setAttribute("heading3", heading3);
		request.setAttribute("heading4", heading4);
		request.setAttribute("url3", url3);
		request.setAttribute("url4", url4);
		request.setAttribute("heading5", heading5);
		request.setAttribute("heading6", heading6);
		request.setAttribute("url5", url5);
		request.setAttribute("url6", url6);
		request.setAttribute("heading7", heading7);
		request.setAttribute("heading8", heading8);
		request.setAttribute("url7", url7);
		request.setAttribute("url8", url8);
		
		p.print("<head><link rel='stylesheet' href='../css/bootstrap.css' /></head>");
		
		
		p.print("<body>");
		rd.include(request, response);
		
		try
		{
			Dbconn d=new Dbconn();
			ResultSet rs=d.getRecords();
			p.print("<head><link rel='stylesheet' href='../css/bootstrap.css'></head>");
			p.print("<body><div class='container-fluid mt-5' align='center'>");
			
			p.print("<table class='table table-hover table-striped mt-4'>");
			p.print("<tr><td>Eno<td>Ename<td>DOB<td>gender<td>address<td>email<td>password<td>mobileno<td>"
					+ "city<td>state<td>salary<td>designation<td>dept<td>photo");
			while(rs.next())
			{
				p.print("<tr><td>"+rs.getString(1)+"<td>"+rs.getString(2)+"<td>"
						+rs.getString(3)+"<td>"+rs.getString(4)+"<td>"+rs.getString(5)+"<td>"+rs.getString(6)+"<td>"
						+rs.getString(7)+"<td>"+rs.getString(8)+"<td>"+rs.getString(9)+"<td>"+rs.getString(10)+"<td>"
						+rs.getString(11)+"<td>"+rs.getString(12)+"<td>"+rs.getString(13)+
						"<td><img width=100px height=100px src=../photo/"+rs.getString(14)+ " />");
			}
			p.print("</table>");
		}
		catch(Exception ex)
		{
			
			ex.printStackTrace();
		}
		RequestDispatcher rd1=request.getRequestDispatcher("Footer");
		request.setAttribute("footer1", footer1);
		rd1.include(request, response);
	}

}
