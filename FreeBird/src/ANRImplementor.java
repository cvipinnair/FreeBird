import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;  

public class ANRImplementor 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");  
		  	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","root");  
		  	
		  	Statement pstmt=con.createStatement();
		  	

    		ResultSet rs=pstmt.executeQuery("select * from neighbor_to_be_defined where NUMBER_EVENTS > 2000 order  by NUMBER_EVENTS DESC");  
  		   	while(rs.next())  
  		   	{
		 		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getDouble(4)+"  "+rs.getDouble(5));  
		
  		   	}
		  	
  		  String command1="netstat";
  		 
  		  try 
  		  {
  			Process process = Runtime.getRuntime().exec(command1);
  			
  	        System.out.println("the output stream is "+process.getOutputStream());
  	
  	        BufferedReader reader=new BufferedReader( new InputStreamReader(process.getInputStream()));
  	        String s; 
  	        while ((s = reader.readLine()) != null){
  	            System.out.println("The inout stream is " + s);
  	        }                   
  		  } 
  		  catch (IOException e) {
  	        e.printStackTrace();
  		  }
  		
  		  String command2="ping google.com";
  		  try 
  		  {
  			Process process = Runtime.getRuntime().exec(command2);
  			
  	        System.out.println("the output stream is "+process.getOutputStream());
  	      
  	        BufferedReader reader=new BufferedReader( new InputStreamReader(process.getInputStream()));
  	        String s; 
  	        while ((s = reader.readLine()) != null){
  	            System.out.println("The inout stream is " + s);
  	        }                   
  		  } 
  		  catch (IOException e) {
  	        e.printStackTrace();
  		  }
  		   	
  		   	
		  	

		  	con.close(); 
		  	 
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		}

	}

}
