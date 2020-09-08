
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dbconn;

@WebServlet("/servlet/ShowSalarySheetDB")
public class ShowSalarySheetDB extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String month=request.getParameter("month");
		String year=request.getParameter("year");
		double da,hra,gross,ta,sa,sumgross=0;
		da=hra=gross=0;
		int sumsa=0,sumta=0,sumda=0,sumhra=0,sum=0,salary=0,count=0;
		PrintWriter p=response.getWriter();
		response.setContentType("text/html");
		
		try
		{
			
			Dbconn d=new Dbconn();
			ResultSet rs=d.getPay(month,year);
			p.print("<link rel=stylesheet href='../css/bootstrap.css'></link>");
			p.print("<div class='container'>");
			p.print("<table class='table table-hover table-striped mt-4'>");
			p.print("<tr><td>Eno<td>Ename<td>salary<td>Designation<td>Department<td>Da<td>Ta<td>"
					+ "hra<td>Sa<td>Gross");
			while(rs.next())
			{
				p.print("<tr><td>"+rs.getString(1)+"<td>"+rs.getString(2)+"<td>"+rs.getString(3)+"<td>"+rs.getString(4)+"<td>"
						+rs.getString(5)+"<td>"+rs.getString(6)+"<td>"
						+rs.getString(7)+"<td>"+rs.getString(8)+"<td>"+rs.getString(9)+"<td>"+rs.getString(10));
			
				salary=rs.getInt(3);
				sum+=salary;
				da=rs.getInt(6);
				sumda+=da;
				ta=rs.getInt(7);
				sumta+=ta;
				hra=rs.getInt(8);
				sumhra+=hra;
				sa=rs.getInt(9);
				sumsa+=sa;
				gross=rs.getDouble(10);
				sumgross+=gross;
			}
			p.print("<tr><td><td><td>"+sum+"<td><td><td>"+sumda+"<td>"+sumta+"<td>"+sumhra+"<td>"+sumsa+"<td>"+sumgross);
			p.print("</table>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		String sumgros=sumgross+"";
		String[] x =sumgros.split("\\.");
		int n=Integer.parseInt(x[0]);
		int m=Integer.parseInt(x[1]);
		int t=0;
		String word="";
		if(n>0)
		  {		t=n/10000000;
				if(t>0)
					word+=getword(t)+"Crore ";
					n%=10000000;
	  
			  t=n/100000;
			  if(t>0)
				  word+=getword(t)+"Lakh ";
			      n%=100000;
			 
			t=n/1000;
			if(t>0)
			 word+=getword(t)+"Thousand ";
			 n%=1000;
			 
			 t=n/100;
			 if(t>0)
			 word+=getword(t)+"Hundred ";
			 
			 n%=100;
			 if(n>0)
			 word+=getword(n)+" rupees "+getword(m)+" paise ";
		  }
		else word="zero";
		//return(word+"only");
		p.print( word +" only ");
	}
	
	static String getword(int t)
		{
		String[] d= new String[91];
		d[0]="zero";d[1]="one";
		d[2]="two";d[3]="three";
		d[4]="four";d[5]="five";
		d[6]="six"; d[7]="seven";

		d[8]="eight";d[9]="nine";
		d[10]="Ten";d[11]="eleven";
		d[12]="twelve";d[13]="thirteen";
		d[14]="fourteen";d[15]="fifteen";
		d[16]="sixteen";d[17]="seventeen";
		d[18]="eighteen";d[19]="nineteen";
		d[20]="Twenty";d[30]="Thirty";
		d[40]="Forty";d[50]="Fifty";
		d[60]="Sixty";d[70]="Seventy";
		d[80]="Eighty";d[90]="Ninety";
		
		String w="";
		if(t<=20||t%10==0)
			w=d[t];
		else
			w=d[t/10*10]+""+d[t%10];
		return w;
	}

}
