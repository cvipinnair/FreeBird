import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;  
public class Database_Loader 
{

	public static void main(String[] args) 
	{
		String line = "";
		//String line1 = "";
		
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");  
		  	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","root");  
		 	
		 	try (BufferedReader br = new BufferedReader(new FileReader("C:\\FreeBird\\pmresult_67109395_60_201511290000_201511290100.csv")))
        	{
		 		System.out.println("read file");
		 		br.readLine();
		 		br.readLine();
		 		String sqlinsert = "INSERT INTO 67109395_60 (DATETIME,GRANULARITYPERIOD,SOURCERNCNAME,SOURCERNCID,SOURCECELLNAME,SOURCECELLID,TARGETRNCID,TARGETCELLID,COUNTER_67183491,COUNTER_67183492,COUNTER_67183493,COUNTER_67183494,COUNTER_67189909,COUNTER_67189910,COUNTER_67189911 )VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    			PreparedStatement pstmt=con.prepareStatement(sqlinsert);
        		while ((line = br.readLine()) != null ) 
        		{
        			String[] lineVar1 = line.split(",");
        			lineVar1[0]=lineVar1[0].replace("'", "");
        			lineVar1[0]=lineVar1[0]+":00";
        			pstmt.setString(1, lineVar1[0]);
        			pstmt.setInt(2, Integer.parseInt(lineVar1[1]));
        			String[] lineVar100 =lineVar1[2].split("_");
        			lineVar100[0] = lineVar100[0].replaceAll("[^a-zA-Z0-9]+","");
        			pstmt.setString(3, lineVar100[0]);
        			if(lineVar100[0].equals("KKRBL02"))
        			{
        				pstmt.setInt(4, 403);
        			}
        			String[] lineVar101 =lineVar1[2].split("=");
        			pstmt.setString(5, lineVar101[1]);
        			String[] lineVar102 =lineVar1[3].split("/");
        			String[] lineVar1020=lineVar102[0].split("=");
        			pstmt.setInt(6, Integer.parseInt(lineVar1020[1]));
        			String[] lineVar103 =lineVar1[3].split(":");
        			String[] lineVar104 =lineVar103[1].split("/");
        			pstmt.setInt(7, Integer.parseInt(lineVar104[0]));
        			String[] lineVar105 =lineVar1[3].split(":");
        			lineVar105[2]= lineVar105[2].replaceAll("[^0-9]", "");
        			pstmt.setInt(8, Integer.parseInt(lineVar105[2])); 
        			pstmt.setString(9, lineVar1[5]);
        			pstmt.setString(10, lineVar1[6]);
        			pstmt.setString(11, lineVar1[7]);
        			pstmt.setString(12, lineVar1[8]);
        			pstmt.setString(13, lineVar1[9]);
        			pstmt.setString(14, lineVar1[10]);
        			pstmt.setString(15, lineVar1[11]);
        			
        			pstmt.executeUpdate();
        		}
        		System.out.println("finished inserting to database");
        		ResultSet rs=pstmt.executeQuery("select * from complete_database");  
      		   	//while(rs.next())  
    		 		//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5));  
    		
        	}
		 	catch (IOException e) 
			{
			    System.err.println(e);
			}
		 	con.close();  
		  
		}
		catch(Exception e)
		{ System.out.println(e);
		}  
		  
		 
		  

	}

}
