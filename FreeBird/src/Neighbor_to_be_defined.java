
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.sql.*;  

public class Neighbor_to_be_defined 
{

	public static void main(String[] args) 
	{
		
		
		 final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		 scheduler.scheduleAtFixedRate(runnable, 0, 24, TimeUnit.HOURS);
	}
	
	
	 static Runnable runnable = new Runnable() 
	 {
	        public void run()
	        {
	            // do something;
	        	System.out.println("started");
	        	
	        	     	
	        	
	    		//return null;
	        	
	        	
	        	try
	        	{
	        	   
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","root");        
			

        		String sql5 = "INSERT INTO NEIGHBOR_TO_BE_DEFINED (SOURCERNCID,SOURCECELLID,TARGETRNCID,TARGETCELLID,NUMBER_EVENTS,INSERTDATE)SELECT 67109395_60.SOURCERNCID,67109395_60.SOURCECELLID,67109395_60.TARGETRNCID,67109395_60.TARGETCELLID,67109395_60.COUNTER_67183491,curdate() FROM 67109395_60 LEFT OUTER JOIN neighbor_defined ON  (67109395_60.SOURCERNCID=NEIGHBOR_DEFINED.SOURCERNCID and 67109395_60.SOURCECELLID=NEIGHBOR_DEFINED.SOURCECELLID and neighbor_defined.INSERTDATE=curdate()) and (67109395_60.TARGETRNCID!=NEIGHBOR_DEFINED.TARGETRNCID or 67109395_60.TARGETCELLID!=NEIGHBOR_DEFINED.TARGETCELLID)     WHERE NEIGHBOR_DEFINED.SOURCERNCID IS NULL ; ";
    			PreparedStatement pstmt5=con.prepareStatement(sql5);
    			pstmt5.executeUpdate();
    			System.out.println("INSERT INTO NEIGHBOR_TO_BE_DEFINED completed...");
    			
        		//String sql0 = "drop table z1";
    			//PreparedStatement pstmt0=con.prepareStatement(sql0);
    			//pstmt0.executeUpdate();
    			//System.out.println("drop z1...");
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
	        	
	           	con.close();  
		     }
			 catch (Exception e) 
			 {
				    System.err.println(e);
			}
	        	
	        }
	  };

}
