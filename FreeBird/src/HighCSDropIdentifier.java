import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;  

public class HighCSDropIdentifier 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");  
		  	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","root");  
		  	
		  	Statement pstmt=con.createStatement();
		  	

    		ResultSet rs=pstmt.executeQuery("SELECT * FROM complete_database ORDER BY Counter_002 DESC");  
  		   	while(rs.next())  
		 		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getDouble(4)+"  "+rs.getDouble(5));  
		
		  	
		  	
		  	

		  	con.close(); 
		  	 
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		}
	
	}

}
