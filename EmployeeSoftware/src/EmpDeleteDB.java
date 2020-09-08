

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dbconn;


@WebServlet("/servlet/EmpDeleteDB")
public class EmpDeleteDB extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter p=response.getWriter();
		response.setContentType("text/html");
		try
		{
			int eno=Integer.parseInt(request.getParameter("eno"));
			Dbconn d=new Dbconn();
			int x=d.deleteEmp(eno);
			if(x>0)
				response.sendRedirect("SearchDel");
			else
			{
				p.print("<a href='SearchDel'>Eno not found</a>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
