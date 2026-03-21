package in.sp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDemo2 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		String name1 = "kamal";
		
		String email1 ="kamal@gmail.com";
		
		String pass1 = "kamal123";
		
		String gender1 = "female";
		
		String city1 = "pune";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db1","root","root");
	   
	    System.out.println("connection created");
	    
	    PreparedStatement ps = con.prepareStatement("insert into register values('"+name1+"','"+email1+"','"+pass1+"','"+gender1+"','"+city1+"')");

	   int i = ps.executeUpdate();
	   
	   if(i>0)
	   {
		   System.out.println("Success");
	   }
	   else
	   {
		   System.out.println("Fail");
	   }
	}
}
