package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/aaa")
public class MyServlet extends HttpServlet
{
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		System.out.println("in service method");
		
		PrintWriter out = resp.getWriter();
		
		out.println("in service method");
	}
}
