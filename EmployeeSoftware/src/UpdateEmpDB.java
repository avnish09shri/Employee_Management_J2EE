

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dbconn;

@WebServlet("/servlet/UpdateEmpDB")
public class UpdateEmpDB extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p=response.getWriter();
		response.setContentType("text/html");
		
		try
		{
			int eno=Integer.parseInt(request.getParameter("eno")+"");
			String ename=request.getParameter("ename");
			String address=request.getParameter("address");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			String mobileno=request.getParameter("mobileno");
			String city=request.getParameter("city");
			String state=request.getParameter("state");
			int salary=Integer.parseInt(request.getParameter("salary")+"");
			String designation=request.getParameter("designation");
			String dept=request.getParameter("dept");
			
			Dbconn d=new Dbconn();
			
			int x=d.updateEmp(eno, ename,address,email,password,mobileno, city,state,salary,designation,dept);
			if(x>0)
				response.sendRedirect("SearchUpdate");
			else
			{
				response.sendRedirect("../index.html");
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
