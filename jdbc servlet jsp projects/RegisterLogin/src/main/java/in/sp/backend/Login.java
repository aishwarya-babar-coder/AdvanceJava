package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/loginform")
public class Login extends HttpServlet 
{
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException
	{
		String myemail = req.getParameter("email1");
		String mypass = req.getParameter("pass1");
		
		PrintWriter out = resp.getWriter();
	     
	    resp.setContentType("text/html");
		
        try {
			
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		
    	    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db1","root","root");
    	   
		    System.out.println("connection created");
		    
		    PreparedStatement ps = con.prepareStatement("select * from register where email = ? and pass = ?");

		    ps.setString(1, myemail);
		    ps.setString(2, mypass);
		    
		    ResultSet rs = ps.executeQuery();
		   
		   if(rs.next())
		   {
			   HttpSession session = req.getSession();
			   
			   session.setAttribute("session_name", rs.getString("name")); 
			   out.println("<h1 style = 'color:green'>Login Successfully!!!</h1>");
			   
			   RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
			   
			   rd.include(req, resp);
		   }
		   else
		   {   
			   out.println("<h1 style = 'color:red'>email and password mismatched</h1>");
			   
			   RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			   
			   rd.include(req, resp);
			
		   }
       } 
       catch (Exception e)
       {
			e.printStackTrace();
			   
		    out.println("<h1 style = 'color:red'>unable to login due to exception occured "+e.getMessage()+"</h1>");
			   
		    RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			   
		    rd.include(req, resp);
	   }
	}
}
