

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/Footer")
public class Footer extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String footer1=(String)request.getAttribute("footer1");
		PrintWriter p=response.getWriter();
		response.setContentType("text/html");
		p.print("<footer>");
		p.print("<div class='container mt-5'>");
    	p.print("<p class='text-center'>&copy;"+ footer1 +"</p>");
       p.print("</footer>");
	}

}
