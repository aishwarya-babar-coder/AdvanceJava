package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/Login")
public class Login extends HttpServlet
{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String myemail = req.getParameter("email1");
		
		String mypass = req.getParameter("pass1");
		
		PrintWriter out = resp.getWriter();
		
		if(myemail.equals("ash@gmail.com") && mypass.equals("ash123"))
		{
			req.setAttribute("name_key", "aishwarya babar");
			
			out.println("credentials matched!!!");
			
			RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
			
			rd.forward(req, resp);
		}
		else
		{
			resp.setContentType("text/html");
			
			out.println("<h3 style = 'color:red'>wrong credentials!!!<h3>");
			
			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			
			rd.include(req, resp); 
		}
	}
}
