package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/SubmitForm")
public class MyServlet extends HttpServlet 
{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		String Myname = req.getParameter("name1");
		
		String Myemail = req.getParameter("email1");
		
		System.out.println("Name = "+Myname);
		
		System.out.println("Email = "+Myemail);
		
		PrintWriter out = resp.getWriter();
		
		out.println("Name = "+Myname);
		out.println("Email = "+Myemail);
	}
}
