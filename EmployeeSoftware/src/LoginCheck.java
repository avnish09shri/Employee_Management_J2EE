
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dbconn;

@WebServlet("/servlet/LoginCheck")
public class LoginCheck extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		
		PrintWriter p=response.getWriter();
		response.setContentType("text/html");
		
		HttpSession hs=request.getSession();
		hs.setAttribute("userid", userid);
		try
		{
			Dbconn d=new Dbconn();
			ResultSet rs=d.Login(userid,password);
			if(rs.next())
			{
				//System.out.println("Login");
				response.sendRedirect("RegisterEmployee");
			}
			else
			{
				//System.out.println("failed");
				response.sendRedirect("../index.html");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
