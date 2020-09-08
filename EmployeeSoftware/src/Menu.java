
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/Menu")
public class Menu extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter p=response.getWriter();
		response.setContentType("text/html");			
		
		
		
		String heading1=(String)request.getAttribute("heading1");
		String heading2=(String)request.getAttribute("heading2");
		String url1=(String)request.getAttribute("url1");
		String url2=(String)request.getAttribute("url2");
		String heading3=(String)request.getAttribute("heading3");
		String heading4=(String)request.getAttribute("heading4");
		String url3=(String)request.getAttribute("url3");
		String url4=(String)request.getAttribute("url4");
		String heading5=(String)request.getAttribute("heading5");
		String heading6=(String)request.getAttribute("heading6");
		String url5=(String)request.getAttribute("url5");
		String url6=(String)request.getAttribute("url6");
		String heading7=(String)request.getAttribute("heading7");
		String heading8=(String)request.getAttribute("heading8");
		String url7=(String)request.getAttribute("url7");
		String url8=(String)request.getAttribute("url8");
		
		p.print("<head><link rel='stylesheet' href='../css/bootstrap.css'>");
		p.print("<style>");
		p.print("#links { color:#eee; font-weight:300;}");
		p.print("#brand1 { color:#f60; font-weight:500; text-transform:uppercase;}");
		p.print("span{ color:white;}");	
		p.print("#links:hover{ color:#f60; }");
		p.print("</style>");
        p.print("</head>");
        p.print("<body>");
		p.print("<div class='container-fluid p-0'>"); 
        p.print("<nav class='navbar navbar-expand-sm navbar-dark bg-dark'>");
            p.print("<a class='navbar-brand' href='#' id='brand1'>Employee<span> Information</span></a>");
            p.print("<button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#ResponsiveNavbar'>");
                p.print("<span class='navbar-toggler-icon'></span>");
              p.print("</button>");
              p.print("<div class='collapse navbar-collapse justify-content-end' id='ResponsiveNavbar'>");
                p.print("<ul class='navbar-nav'>");
                    p.print("<li  class='nav-item'>");
                        p.print("<a class='nav-link' href='"+url1+"' id='links'>"+heading1+"</a>");
                    p.print("</li>");
                    p.print("<li  class='nav-item'>");
                        p.print("<a class='nav-link' href='"+url2+"' id='links'>"+heading2+"</a>");
                    p.print("</li>");
                    p.print("<li  class='nav-item'>");
                    	p.print("<a class='nav-link' href='"+url3+"' id='links'>"+heading3+"</a>");
                    p.print("</li>");
                    p.print("<li  class='nav-item'>");
                    	p.print("<a class='nav-link' href='"+url4+"' id='links'>"+heading4+"</a>");
                    p.print("</li>");
                    p.print("<li  class='nav-item'>");
                    	p.print("<a class='nav-link' href='"+url5+"' id='links'>"+heading5+"</a>");
                    p.print("</li>");
                    p.print("<li  class='nav-item'>");
                    	p.print("<a class='nav-link' href='"+url6+"' id='links'>"+heading6+"</a>");
                    p.print("</li>");
                    p.print("<li  class='nav-item'>");
                    	p.print("<a class='nav-link' href='"+url7+"' id='links'>"+heading7+"</a>");
                    p.print("</li>");
                    p.print("<li  class='nav-item'>");
                    	p.print("<a class='nav-link' href='"+url8+"' id='links'>"+heading8+"</a>");
                    p.print("</li>");
                p.print("</ul>");
              p.print("</div>");
        p.print("</nav>");
        
        p.print("<script src='../js/jquery.min.js'></script>");
        p.print("<script src='../js/popper.min.js'></script>");
        p.print("<script src='../js/bootstrap.js'></script>");
        p.print("<script src='../js/bootstrap.min.js'></script>");
	}

}
