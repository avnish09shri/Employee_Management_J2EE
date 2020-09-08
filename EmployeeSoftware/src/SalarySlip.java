
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet/SalarySlip")
public class SalarySlip extends HttpServlet {
	

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
			response.sendRedirect("../index.html");
		
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
		
		p.print("<link rel=stylesheet href='../css/bootstrap.css'></link>");
		p.print("<div class='container mt-5'>");
		p.print("<form>");
		p.print("<div class='row'>");
		p.print("<div class='col-md-4'>");
		p.print("</div>");
		p.print("<div class='col-md-4 p-4' style='background-color:#eee;border-radius:20px;'>");
		p.print("Month:<select name='month' class='form-control mt-3'><option value='1'>1</option>"
				+ "<option value='2'>2</option><option value='3'>3</option>"
				+ "<option value='4'>4</option><option value='5'>5</option>"
				+ "<option value='6'>6</option><option value='7'>7</option>"
				+ "<option value='8'>8</option><option value='9'>9</option>"
				+ "<option value='10'>10</option><option value='11'>11</option><option value='12'>12</option></select>");
		p.print("&nbsp;&nbsp;Year:<select name='year' class='form-control mt-3'><option value='2020'>2020</option><option value='2019'>2019</option>"
				+ "<option value='2018'>2018</option></select>");
		p.print("<center><input type='submit' name=s1 value='Generate Salary Slip' class='btn btn-secondary mt-3'></center>");
		p.print("</div>");
		p.print("</div>");
		p.print("</form>");
		
		RequestDispatcher rd1=request.getRequestDispatcher("SalarySlipDB");
		rd1.include(request, response);
		
		RequestDispatcher rd2=request.getRequestDispatcher("Footer");
		request.setAttribute("footer1", footer1);
		rd2.include(request, response);
		
	}

}
