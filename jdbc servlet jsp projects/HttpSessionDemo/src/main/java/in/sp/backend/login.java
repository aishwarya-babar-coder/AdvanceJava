package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/login")
public class login extends HttpServlet 
{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		String myemail = req.getParameter("email1");
		String mypass  = req.getParameter("pass1");
		
		PrintWriter out = resp.getWriter();
		
		if(myemail.equals("ash@gmail.com") && mypass.equals("ash123"))
		{
			//req.setAttribute("name_key", "ash babar");
			
			HttpSession session = req.getSession();
			
			session.setAttribute("name_key", "ash babar");
			
			RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
			
			rd.forward(req, resp);
			
		}
		else
		{
			resp.setContentType("text/html");
			
			out.println("<h3 style = 'color:red'>credentials wrong</h3>");
			
			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			
			rd.include(req, resp);
		}
	}
}
