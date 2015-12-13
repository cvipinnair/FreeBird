import java.lang.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.net.*;
import java.nio.file.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.nio.charset.*;

public class CM_Extractor_Loader 
{

	public static void main(String[] args) 
	{
		String line= "";
		String line1= "";
		
		boolean a,b;
		String lineSep = System.getProperty("line.separator");
		
		try
	    {      
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","root");        
		
	        	try (BufferedReader br = new BufferedReader(new FileReader("C:\\FreeBird\\CMExport_KKRBL02_White Field_10.89.40.221_2015102601.xml")))
	        	{

					String sqlinsert = "INSERT INTO NEIGHBOR_DEFINED (SOURCERNCID,SOURCECELLID,TARGETRNCID,TARGETCELLID)VALUES (?,?,?,?)";
	    			PreparedStatement pstmt=con.prepareStatement(sqlinsert);
					
	    			System.out.println("Started...");
	        		
	        		while ((line = br.readLine()) != null ) 
            		{
	        			
	        			a = line.indexOf("MO className") >0;
            			b = line.indexOf("INTRAFREQNCELL=") > 0;
            		    if (a&&b)
            			{
            		    	
            		    	 //String str = "abcd=0; efgh=1";
            		    	 line = line.replaceAll("[^a-zA-Z0-9]", ",");
            		    	 //String replacedStr2 = line.replaceAll("">", "_");
            		    	 String[] lineVar1 = line.split(","); 
            		    	 //wr.write(line);
            		    	 //wr.write(lineSep);
            				//wr.write(lineVar1[19]+","+lineVar1[20]+","+lineVar1[21]+","+lineVar1[22]);
    						//wr.write(lineSep);
            		    	 
            		    	 
            		    	pstmt.setString(1, lineVar1[22]);
                 			pstmt.setString(2, lineVar1[19]);
                 			pstmt.setString(3, lineVar1[21]);
                 			pstmt.setString(4, lineVar1[20]);
                 			
                 			pstmt.executeUpdate();
    						
            			}
            			
            		}
	        		System.out.println("Inserted to Neighbor_defined...");
	        		
	        		String sql5 = "INSERT INTO NEIGHBOR_TO_BE_DEFINED (SOURCERNCID,SOURCECELLID,TARGETRNCID,TARGETCELLID,NUMBER_EVENTS)SELECT 67109395_60.SOURCERNCID,67109395_60.SOURCECELLID,67109395_60.TARGETRNCID,67109395_60.TARGETCELLID,67109395_60.COUNTER_67183491 FROM 67109395_60 LEFT OUTER JOIN neighbor_defined ON  (67109395_60.SOURCERNCID=NEIGHBOR_DEFINED.SOURCERNCID and 67109395_60.SOURCECELLID=NEIGHBOR_DEFINED.SOURCECELLID) and (67109395_60.TARGETRNCID!=NEIGHBOR_DEFINED.TARGETRNCID or 67109395_60.TARGETCELLID!=NEIGHBOR_DEFINED.TARGETCELLID)     WHERE NEIGHBOR_DEFINED.SOURCERNCID IS NULL; ";
	    			PreparedStatement pstmt5=con.prepareStatement(sql5);
	    			pstmt5.executeUpdate();
	    			System.out.println("INSERT INTO NEIGHBOR_TO_BE_DEFINED completed...");
	    			
	        		String sql0 = "drop table z1";
	    			PreparedStatement pstmt0=con.prepareStatement(sql0);
	    			pstmt0.executeUpdate();
	    			System.out.println("drop z1...");
					String sql1 = "create table z1 (SOURCERNCID int, SOURCECELLID int, COUNT_OF_NEIGHBOR int)";
	    			PreparedStatement pstmt1=con.prepareStatement(sql1);
	    			pstmt1.executeUpdate();
	    			String sql2 = "insert into z1(SOURCERNCID,SOURCECELLID,COUNT_OF_NEIGHBOR) select NEIGHBOR_DEFINED.SOURCERNCID,NEIGHBOR_DEFINED.SOURCECELLID , count(NEIGHBOR_DEFINED.SOURCECELLID) as COUNT_OF_NEIGHBOR from NEIGHBOR_DEFINED group by NEIGHBOR_DEFINED.SOURCECELLID";
	    			PreparedStatement pstmt2=con.prepareStatement(sql2);
	    			pstmt2.executeUpdate();
	    			System.out.println("insert into z1...");
	    			String sql3 = "update neighbor_to_be_defined set neighbor_to_be_defined.COUNT_OF_NEIGHBOR=(select z1.COUNT_OF_NEIGHBOR from  z1 where ( (neighbor_to_be_defined.SOURCERNCID=z1.SOURCERNCID and neighbor_to_be_defined.SOURCECELLID=z1.SOURCECELLID)))";
	    			PreparedStatement pstmt3=con.prepareStatement(sql3);
	    			pstmt3.executeUpdate();
	    			System.out.println("update neighbor to be defined...");	        		
	    			String sql4 = "drop table z1";
	    			PreparedStatement pstmt4=con.prepareStatement(sql4);
	    			pstmt4.executeUpdate();
	    			System.out.println("completed...");	
	        	}
	        	catch (IOException e) 
				{
				    System.err.println(e);
				}
	        //	wr.close();
	        	con.close();  
	     }
		 catch (Exception e) 
		 {
			    System.err.println(e);
		}
	

	}

}
