package in.sp.backend;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MyServlet extends HttpServlet
{

	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		System.out.println("in doGet method");
		
		PrintWriter out = resp.getWriter();
		
		out.print("i am in doGET method");
	}
	
}
