package in.sp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDemo 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db1","root","root");
	   
	    System.out.println("connection created");
	    
	    PreparedStatement ps = con.prepareStatement("insert into register values('ash','ash@gmail.com','ash123','female','pune')");

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
