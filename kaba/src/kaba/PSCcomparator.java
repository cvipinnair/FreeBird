package kaba;
import java.lang.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.net.*;
import java.nio.file.*;
import java.nio.charset.*;

public class PSCcomparator 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		System.out.println("started....");
				
		String line= "";
		String line1= "";
		double d;
		
		String lineSep = System.getProperty("line.separator");
		
		try(BufferedWriter wr = new BufferedWriter(new FileWriter("C:\\JavaProjects\\kaba\\PSCExtractor1.txt", true)))
	    {            
	        	try (BufferedReader br = new BufferedReader(new FileReader("C:\\JavaProjects\\kaba\\PSCExtractor.txt")))
	        	{
	        		while ((line = br.readLine()) != null ) 
	        		{
	        			String[] lineVar1 = line.split(","); 
	        			try (BufferedReader br1 = new BufferedReader(new FileReader("C:\\JavaProjects\\kaba\\configurationOriginal.csv")))
	        			{
	        				while ((line1 = br1.readLine()) != null ) 
	        				{
	        					String[] lineVar2 = line1.split(","); 
	        					if(lineVar1[0].equals(lineVar2[6]) && lineVar1[1].equals(lineVar2[1]))
	        					{
					    			//out1.write("found"+"\n");
					    			//System.out.println("found");
	        						wr.write(lineVar1[0]+","+lineVar1[1]+","+lineVar1[2]+","+lineVar2[3]+","+lineVar2[4]);
	        						wr.write(lineSep);
					    		}
	        				}
	        				
	        			}
					    catch (IOException e) 
						{
						    System.err.println(e);
						}
	        		}
	        	}
	        	catch (IOException e) 
				{
				    System.err.println(e);
				}
	        	
	        	
	        	
	     }   		
		catch (IOException e) 
		{
		    System.err.println(e);
		}
		
		
		
		
		
		 try(BufferedWriter wr = new BufferedWriter(new FileWriter("C:\\JavaProjects\\kaba\\PSCcomparator.txt", true)))
	     {            
	        	try (BufferedReader br = new BufferedReader(new FileReader("C:\\JavaProjects\\kaba\\PSCExtractor1.txt")))
	        	{
	        		while ((line = br.readLine()) != null ) 
            		{
	        			String[] lineVar1 = line.split(","); 
	        			try (BufferedReader br1 = new BufferedReader(new FileReader("C:\\JavaProjects\\kaba\\PSCExtractor1.txt")))
	        			{
	        				while ((line1 = br1.readLine()) != null ) 
	        				{
	        					String[] lineVar2 = line1.split(","); 
	        					if((lineVar1[2].equals(lineVar2[2]))&&!(lineVar1[1].equals(lineVar2[1]))) 
	        					{

	            					d = distance(Double.parseDouble(lineVar1[3]),Double.parseDouble(lineVar1[4]),Double.parseDouble(lineVar2[3]),Double.parseDouble(lineVar2[4]));
	            					wr.write(lineVar1[0]+","+lineVar1[1]+","+lineVar1[2]+","+lineVar1[3]+","+lineVar1[4]+"---->"+lineVar2[0]+","+lineVar2[1]+","+lineVar2[2]+","+lineVar2[3]+","+lineVar2[4]+"--->"+Math.round(d)+"Km");
	            					
	            					wr.write(lineSep);
					    		}
	        				}
	        				
	        			}
					    catch (IOException e) 
						{
						    System.err.println(e);
						}
	        			
		     	
            		    	
            			
            		    
            			
            		}
	        		
	        		
	        	}
	        	catch (IOException e) 
				{
				    System.err.println(e);
				}
	        	
	     }
		 catch (IOException e) 
		 {
			    System.err.println(e);
		 }
	

		 
		 
		
		 
		 
		 System.out.println("closed....");
			
		

	}
	
	
	
	
	 
	 
	public static double distance(double lat1, double lon1, double lat2, double lon2) 
    {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		dist = dist * 1.609344;
		

		return (dist);
	}

	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::	This function converts decimal degrees to radians						 :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    public static double deg2rad(double deg) 
    {
		return (deg * Math.PI / 180.0);
	}

	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::	This function converts radians to decimal degrees						 :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    public static double rad2deg(double rad) 
    {
		return (rad * 180 / Math.PI);
	}
		

}
