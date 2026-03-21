package in.sp.Delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDemo
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		String email1 = "kavya@gmail.com";
		
	    Class.forName("com.mysql.cj.jdbc.Driver");
		
	    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db1","root","root");
	   
	    System.out.println("connection created");
	    
	    PreparedStatement ps = con.prepareStatement("delete from register where email = ?");
	
	    ps.setString(1, email1);
	    
	    int i = ps.executeUpdate();
		   
	   if(i>0)
	   {
		   System.out.println("update successful");
	   }
	   else
	   {
		   System.out.println("update Fail");
	   }
	   
	   con.close();

	}
}