

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dbconn;

@WebServlet("/servlet/SalarySlipDB")
public class SalarySlipDB extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String month=request.getParameter("month");
		String year=request.getParameter("year");
		PrintWriter p=response.getWriter();
		response.setContentType("text/html");
		try
		{
			
			Dbconn d=new Dbconn();
			ResultSet rs=d.getPaySlip(month,year);
			p.print("<div class='container'>");
			p.print("<link rel=stylesheet href='../css/bootstrap.css'></link>");
			while(rs.next())
			{
				
				p.print("<div class='card-text border mt-3'>");
				p.print("<table class='table table-borderless'>");
				p.print("<tr><td>Eno<td>month<td>year<td>Designation<td>Department<td>Da<td>Ta<td>"
						+ "hra<td>Sa<td>Gross");
				p.print("<tr><td>"+rs.getString(1)+"<td>"+month+"<td>"+year+"<td>"+rs.getString(2)+"<td>"
						+rs.getString(3)+"<td>"+rs.getString(4)+"<td>"+rs.getString(5)+"<td>"+rs.getString(6)+"<td>"
						+rs.getString(7)+"<td>"+rs.getString(8));
	
				p.print("</table>");
				p.print("</div>");
				
				p.print("<center class='mt-2'><input type='button' value='print' onclick='window.print()'></center>");
			}

			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
