package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/regform")
public class register extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		PrintWriter out = resp.getWriter();
		
		String myname = req.getParameter("name1");
		
		String myemail = req.getParameter("email1");
		
		String mypass = req.getParameter("pass1");
		
		String mygender = req.getParameter("gender1");
		
		String mycity = req.getParameter("city1");
		
        try {
			
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		
    	    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db1","root","root");
    	   
		    System.out.println("connection created");
		    
		    PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?)");
	
		    ps.setString(1, myname);
		    ps.setString(2, myemail);
		    ps.setString(3, mypass);
		    ps.setString(4, mygender);
		    ps.setString(5, mycity);
		    
		   int count = ps.executeUpdate();
		   
		   if(count>0)
		   {
			   resp.setContentType("text/html");
			   
			   out.println("<h1 style = 'color:green'>Registered Successfully");
			   
			   RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
			   
			   rd.include(req, resp);
		   }
		   else
		   {
			   resp.setContentType("text/html");
			   
			   out.println("<h1 style = 'color:red'>User not registered due to some error</h1>");
			   
			   RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
			   
			   rd.include(req, resp);
			
		   }
       } 
       catch (Exception e)
       {
			e.printStackTrace();
			
			resp.setContentType("text/html");
			   
		    out.println("<h1 style = 'color:red'>User not registered due to exception occured</h1>");
			   
		    RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
			   
		    rd.include(req, resp);
	   }
	}
}
