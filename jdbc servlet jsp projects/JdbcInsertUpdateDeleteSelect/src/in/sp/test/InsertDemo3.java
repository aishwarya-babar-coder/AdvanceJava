package in.sp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDemo3 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		String name1 = "kavya";
		
		String email1 ="kavya@gmail.com";
		
		String pass1 = "kavya123";
		
		String gender1 = "female";
		
		String city1 = "mumbai";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db1","root","root");
	   
	    System.out.println("connection created");
	    
	    PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?)");

	    ps.setString(1, name1);
	    ps.setString(2, email1);
	    ps.setString(3, pass1);
	    ps.setString(4, gender1);
	    ps.setString(5, city1);
	    
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
