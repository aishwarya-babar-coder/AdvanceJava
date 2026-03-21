package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/mylogin")
public class Login extends HttpServlet
{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		String myname = (String)req.getParameter("name1");
		
		String myemail = (String)req.getParameter("email1");
		
		String mypass = (String)req.getParameter("pass1");
		
		PrintWriter out = resp.getWriter();
		
		if(myemail.equals("ash@gmail.com") && mypass.equals("ash123") )
		{
			System.out.println("login successfully");
			out.println("login successfully");
		}
		else
		{
			System.out.println("login failed");
			out.println("login failed");
		}
		
		
	}
}
