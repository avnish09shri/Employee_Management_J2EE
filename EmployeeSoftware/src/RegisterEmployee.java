

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

//@WebServlet("/servlet/RegisterEmployee")
public class RegisterEmployee extends HttpServlet {
	
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
		request.setAttribute("footer1", footer1);
		
		p.print("<head><link rel='stylesheet' href='../css/bootstrap.css' /></head>");
		
		
		p.print("<body>");
		rd.include(request, response);
		
		
		p.print("<link rel=stylesheet href='../css/bootstrap.css'></link>");
		p.print("<div class='container mt-5'>");
		p.print("<form action='EmpRegisterDB' method='post'>");
			p.print("<div class='row'>");
			    p.print("<div class='col-md-4 mt-4'>");
			    p.print("<input type='text' name='eno' placeholder='Eno' required class='form-control' />");
			    p.print("</div>");
			    p.print("<div class='col-md-4 mt-4'>");
			    p.print("<input type='text' name='ename' placeholder='Name' required class='form-control' />");
			    p.print("</div>");
			    p.print("<div class='col-md-4 mt-4'>");
			    p.print("<input type='date' name='DOB' placeholder='DOB' required class='form-control' />");
			    p.print("</div>");
			    p.print("</div>");
			p.print("<div class='row'>");
			    p.print("<div class='col-md-4 mt-4'>");
			    p.print("<select class='form-control' name='gender'>");
			    p.print("<option value='Male'>Male</option><option value='Female'>Female</option>");    
			    p.print("</select>");
			    p.print("</div>");
			    p.print("<div class='col-md-4 mt-4'>");
				p.print("<input type='text' name='address' required class='form-control' placeholder='Address' />");
				p.print("</div>");
				p.print("<div class='col-md-4 mt-4'>");
				p.print("<input type='email' name='email' required class='form-control' placeholder='Email' />");
				p.print("</div>");
			p.print("</div>");
			p.print("<div class='row'>");
				p.print("<div class='col-md-4 mt-4'>");
				p.print("<input type='password' name='password' required class='form-control' placeholder='Password' />");
				p.print("</div>");
				p.print("<div class='col-md-4 mt-4'>");
				p.print("<input type='text' name='mobileno' required class='form-control' placeholder='Mobileno' />");
				p.print("</div>");
			    p.print("<div class='col-md-4 mt-4'>");
			    p.print("<input list='city1' class='form-control' required placeholder='select city' name='city' />");
			    p.print("<datalist id='city1'>");
			    p.print("<option value='Chennai'></option><option value='Mumbai'></option>"
			    		+ "<option value='Delhi'></option><option value='Bhopal'></option><option value='Indore'></option>");    
			    p.print("</datalist>");
			    p.print("</div>");
		    p.print("</div>");
		    p.print("<div class='row'>");
			    p.print("<div class='col-md-4 mt-4'>");
			    p.print("<input list='state1' class='form-control' required placeholder='select state' name='state' />");
			    p.print("<datalist id='state1'>");
			    p.print("<option value='TamilNadu'></option><option value='Maharashtra'></option>"
			    		+ "<option value='Delhi'></option><option value='Madhya Pradesh'></option>");    
			    p.print("</datalist>");
			    p.print("</div>");
			    p.print("<div class='col-md-4 mt-4'>");
				p.print("<input type='text' name='salary' required class='form-control' placeholder='Salary' />");
				p.print("</div>");
				p.print("<div class='col-md-4 mt-4'>");
			    p.print("<select class='form-control' name='designation'>");
			    try
			    {
			    	Dbconn d=new Dbconn();
			    	ResultSet rs=d.getDesignation();
			    	while(rs.next())
			    	{
			    		p.print("<option value='"+rs.getString(1)+"'>"+rs.getString(1)+"</option>");
			    	}
			    }
			    catch(Exception e)
			    {
			    	e.printStackTrace();
			    }
			    p.print("</select>");
			    p.print("</div>");
			p.print("</div>");   
			p.print("<div class='row'>");
			    p.print("<div class='col-md-4 mt-4'>");
			    p.print("<select class='form-control' name='dept'>");
			    try
			    {
			    	Dbconn d=new Dbconn();
			    	ResultSet rs=d.getDept();
			    	while(rs.next())
			    	{
			    		p.print("<option value='"+rs.getString(1)+"'>"+rs.getString(1)+"</option>");
			    	}
			    }
			    catch(Exception e)
			    {
			    	e.printStackTrace();
			    }    
			    p.print("</select>");
			    p.print("</div>");
			    p.print("<div class='col-md-4 mt-4'>");
				p.print("<input type='file' name='photo' required class='form-control-file' />");
				p.print("</div>");
			p.print("</div>");
			p.print("<div class='row'>");
				p.print("<div class='col-md-4 mt-4'>");
				p.print("</div>");
				p.print("<div class='col-md-4 mt-5'>");
		        	p.print("<input type='submit' value='Insert' class='btn btn-success' style='padding:6px 24px;' />");
		        p.print("</div>");
		        p.print("<div class='col-md-4 mt-4'>");
		     	p.print("</div>");
	     	p.print("</div>");
	    p.print("</form>");
	    
		RequestDispatcher rd1=request.getRequestDispatcher("Footer");
		request.setAttribute("footer1", footer1);
		rd1.include(request, response);
	}

}
