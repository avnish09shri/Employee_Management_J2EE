

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dbconn;

@WebServlet("/servlet/GenerateSalDB")
public class GenerateSalDB extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p=response.getWriter();
		response.setContentType("text/html");
		String month=request.getParameter("month");
		String year=request.getParameter("year");
		int salary=1,eno=0,x=0;
		String designation="",gender="",city="";
		
		try
		{
			Dbconn db=new Dbconn();
			ResultSet rs=db.getRecords();
			while(rs.next())
			{
				 double da=1,ta=0.3,hra=0.25,gross=0,sa=0;
				 eno=Integer.parseInt(rs.getString("eno"));
				 salary=Integer.parseInt(rs.getString("salary"));
				 designation=rs.getString("designation");
				 gender=rs.getString("gender");
				 city=rs.getString("city");
			
				da=(double)salary*1.2;
				if(city.equalsIgnoreCase("Chennai")||city.equalsIgnoreCase("Mumbai")||city.equalsIgnoreCase("Delhi"))
				{
					ta=0.4; 
				}
				ta*=(double)salary;
				if(designation.equalsIgnoreCase("Manager")||designation.equalsIgnoreCase("HR"))
				{
					hra=0.35;
				}
				hra*=(double)salary;
				if(gender.equalsIgnoreCase("female")||designation.equalsIgnoreCase("Manager"))
				{
					
					sa=(double)salary*0.02;
					
				}
				gross=salary+da+ta+hra+sa;
				x=db.insertPay(eno, month, year, salary, da, ta, hra, sa, gross);
				//System.out.println(gross+"\t"+da+"\t"+ta+"\t"+hra+"\t"+sa);
				/*ResultSet r=db.getM(month, year);
				if(r.next() && month!=null && year!=null)
				{
					System.out.println("month already exists");
				}
				else
				{
					x=db.insertPay(eno, month, year, salary, da, ta, hra, sa, gross);
					
				}*/
				
				if(x<0)
					p.print("<script>alert('Unsuccessful')</script>");
			}
			if(x>0)
			{
				response.sendRedirect("Generate_Salary");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		/*try
		{
			Dbconn db=new Dbconn();
		
			response.sendRedirect("GenerateSalary");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
