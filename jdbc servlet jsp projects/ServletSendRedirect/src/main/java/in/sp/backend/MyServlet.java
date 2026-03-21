package in.sp.backend;

import java.io.IOException;

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
		String mysearch1 = req.getParameter("search1");
		
		resp.sendRedirect("https://www.google.com/search?q="+mysearch1);
	}
}
