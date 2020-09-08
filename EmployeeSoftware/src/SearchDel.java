

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

//@WebServlet("/servlet/SearchDel")
public class SearchDel extends HttpServlet {

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
		
		String eno="",ename="",city="",salary="",DOB="",gender="",address="",email="",password="",mobileno="",state="",dept=""
				,designation="",photo="";
		p.print("<link rel=stylesheet href='../css/bootstrap.css'></link>");
		p.print("<div class='container mt-4'>");
		p.print("<div class='row'>");
		p.print("<div class='col-md-4'>");
		p.print("</div>");
		p.print("<div class='col-md-4'>");
		p.print("<form>");
		p.print("<input type=text name=eno placeholder='Eno' class='form-control' />");
		p.print("<center><input type='submit' name=s1 value='Search' class='btn btn-primary mt-2'></center>");
		p.print("</form>");
		p.print("</div>");
		p.print("</div>");
		
		if(request.getQueryString()!=null)
		{
			eno=request.getParameter("eno");
			try
			{
				Dbconn d=new Dbconn();
				ResultSet rs=d.getEmployee(Integer.parseInt(eno));
				if(rs.next())
				{
					ename=rs.getString("ename");
					DOB=rs.getString("DOB");
					gender=rs.getString("gender");
					address=rs.getString("address");
					email=rs.getString("email");
					password=rs.getString("password");
					mobileno=rs.getString("mobileno");
					city=rs.getString("city");
					state=rs.getString("state");
					salary=rs.getString("salary");
					designation=rs.getString("designation");
					dept=rs.getString("dept");
					photo=rs.getString("photo");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		p.print("<form action='EmpDeleteDB' method='post'>");
		p.print("<div class='row'>");
		p.print("<div class='col-md-4'>");
		p.print("</div>");
		p.print("<div class='col-md-4 p-4' style='background-color:#eee;border-radius:20px;'>");
		p.print("Eno:<input type=text class='form-control' name=eno value="+eno+" />");
		p.print("Ename:<input type=text class='form-control mt-2' name=ename value="+ename+" />");
		p.print("DOB:<input type=text class='form-control mt-2' name=DOB value="+DOB+" />");
		p.print("Gender:<input type=text class='form-control mt-2' name=gender value="+gender+" />");
		p.print("Address:<input type=text class='form-control mt-2' name=address value="+address+" />");
		p.print("Email:<input type=text class='form-control mt-2' name=email value="+email+" />");
		p.print("Password:<input type=text class='form-control mt-2' name=password value="+password+" />");
		p.print("Mobileno:<input type=text class='form-control mt-2' name=mobileno value="+mobileno+" />");
		p.print("City:<select class='form-control mt-2' required name='city' />");
	    p.print("<option value='"+city+"'>"+city+"</option>");
	    p.print("<option value='Chennai'>Chennai</option><option value='Mumbai'>Mumbai</option>"
	    		+ "<option value='Delhi'>Delhi</option><option value='Bhopal'>Bhopal</option><option value='Indore'>Indore</option>");    
	    p.print("</select>");
		p.print("State:<select class='form-control mt-2' required name='state' />");
	    p.print("<option value='"+state+"'>"+state+"</option>");
	    p.print("<option value='TamilNadu'>TamilNadu</option><option value='Maharashtra'>Maharashtra</option>"
	    		+ "<option value='Delhi'>Delhi</option><option value='Madhya Pradesh'>Madhya Pradesh</option>");    
	    p.print("</select>");
		p.print("Salary:<input type=text class='form-control mt-2' name=salary value="+salary+" />");
		p.print("Designation:<select class='form-control mt-2' name='designation'><option value='"+designation+"'>"+designation+"</option>");
	    try
	    {
	    	Dbconn d=new Dbconn();
	    	ResultSet rs=d.getDesignation();
	    	while(rs.next())
	    	{
	    		p.print("");
	    		p.print("<option value='"+rs.getString(1)+"'>"+rs.getString(1)+"</option>");
	    	}
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    p.print("</select>");
	    p.print("Department:<select class='form-control mt-2' name='dept'><option value='"+dept+"'>"+dept+"</option>");
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
		//p.print("Department:<input type=text class='form-control mt-2' name=dept value="+dept+" />");
		p.print("<img  class='mt-2' width=100px height=100px src=../photo/"+ photo+" />");
		p.print("<center><input type='submit' name=s1 class='btn btn-danger mt-3' value='Delete'></center>");
		p.print("</div>");
		p.print("</div>");
		p.print("</form>");
		
		RequestDispatcher rd1=request.getRequestDispatcher("Footer");
		request.setAttribute("footer1", footer1);
		rd1.include(request, response);
	}

}
