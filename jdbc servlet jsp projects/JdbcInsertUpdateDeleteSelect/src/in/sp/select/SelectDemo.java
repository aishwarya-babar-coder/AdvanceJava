package in.sp.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectDemo 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{	
        Class.forName("com.mysql.cj.jdbc.Driver");
		
	    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db1","root","root");
	   
	    System.out.println("connection created");
	    
	    PreparedStatement ps = con.prepareStatement("select * from register");

	    ResultSet rs = ps.executeQuery();
		   
		   while(rs.next())
		   {
			   String name1 = rs.getString("name");
			   System.out.println("name = "+name1);
			   
			   String email1 = rs.getString("email");
			   System.out.println("email = "+email1);
			   
			   String pass1 = rs.getString("pass");
			   System.out.println("pass = "+pass1);
			   
			   String gender1 = rs.getString("gender");
			   System.out.println("gender = "+gender1);
			   
			   String address1 = rs.getString("address");
			   System.out.println("address = "+address1);
			   
			   System.out.println("---------------------------");
			 
		   }
		   
		   
		   con.close();
	}
}
