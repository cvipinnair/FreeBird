package kaba;
import java.lang.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.net.*;
import java.nio.file.*;
import java.nio.charset.*;

public class U2GNeighborCreator 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String line = "";
		String line1 = "";
		BufferedWriter writer = null;
        String lineSep = System.getProperty("line.separator");
        System.out.println("started....");
        
        
        
        try(BufferedWriter wr = new BufferedWriter(new FileWriter("C:\\kaba\\U2GNeighborCreated.txt", true)))
        {            
        	wr.write("SourceCellRNC,SourceCellID,TargetCellName,SourceCellAzimuth,TargetCellAzimuth,Distance,SourceCellLat,SourceCellLon,TargetCellLat,TargetCellLon,NeighborPriority");
        	wr.write(lineSep);
        	try (BufferedReader br = new BufferedReader(new FileReader("C:\\kaba\\3GPlanning.csv")))
        	{
        		br.readLine();
        		while ((line = br.readLine()) != null ) 
        		{
        			String[] lineVar1 = line.split(","); 
        			try (BufferedReader br1 = new BufferedReader(new FileReader("C:\\kaba\\2GPlanning.csv")))
        			{
        				br1.readLine();
        				while ((line1 = br1.readLine()) != null ) 
        				{
        					//System.out.println("br2");
        					String[] lineVar2 = line1.split(","); 
        					double d = distance(Double.parseDouble(lineVar1[4]),Double.parseDouble(lineVar1[5]),Double.parseDouble(lineVar2[1]),Double.parseDouble(lineVar2[2]));
        					double TargetAzimuthUpperThreshold = Double.parseDouble(lineVar1[3])+180+50;
        					double TargetAzimuthLowerThreshold = Double.parseDouble(lineVar1[3])+180-50;
        					if(TargetAzimuthUpperThreshold > 360)
        					{
        						TargetAzimuthUpperThreshold = TargetAzimuthUpperThreshold -360;
        					}
        					if(TargetAzimuthLowerThreshold > 360)
        					{
        						TargetAzimuthLowerThreshold = TargetAzimuthLowerThreshold -360;
        					}
        					
        					
        					if(TargetAzimuthUpperThreshold < 0)
        					{
        						TargetAzimuthUpperThreshold = TargetAzimuthUpperThreshold + 360;
        					}
        					if(TargetAzimuthLowerThreshold < 0)
        					{
        						TargetAzimuthLowerThreshold = TargetAzimuthLowerThreshold + 360;
        					}
        					
        					
                            double b = bearing(Double.parseDouble(lineVar1[4]),Double.parseDouble(lineVar1[5]),Double.parseDouble(lineVar2[1]),Double.parseDouble(lineVar2[2]));
        					
        					double BearingUpperThreshold = b+15;
        					double BearingLowerThreshold = b-15;
        					double BearingUpperThreshold1 = b+45;
        					double BearingLowerThreshold1 = b-45;
        					double BearingUpperThreshold2 = b+60;
        					double BearingLowerThreshold2 = b-60;
        					if(BearingUpperThreshold > 360)
        					{
        						BearingUpperThreshold = BearingUpperThreshold -360;
        					}
        					if(BearingLowerThreshold > 360)
        					{
        						BearingLowerThreshold = BearingLowerThreshold -360;
        					}
        					
        					if(BearingUpperThreshold1 > 360)
        					{
        						BearingUpperThreshold1 = BearingUpperThreshold1 -360;
        					}
        					if(BearingLowerThreshold1 > 360)
        					{
        						BearingLowerThreshold1 = BearingLowerThreshold1 -360;
        					}
        					
        					if(BearingUpperThreshold2 > 360)
        					{
        						BearingUpperThreshold2 = BearingUpperThreshold2 -360;
        					}
        					if(BearingLowerThreshold2 > 360)
        					{
        						BearingLowerThreshold2 = BearingLowerThreshold2 -360;
        					}
        					
        					
        					
        					if(BearingUpperThreshold < 0)
        					{
        						BearingUpperThreshold = BearingUpperThreshold +360;
        					}
        					if(BearingLowerThreshold < 0)
        					{
        						BearingLowerThreshold = BearingLowerThreshold +360;
        					}
        					
        					if(BearingUpperThreshold1 < 0)
        					{
        						BearingUpperThreshold1 = BearingUpperThreshold1 +360;
        					}
        					if(BearingLowerThreshold1 < 0)
        					{
        						BearingLowerThreshold1 = BearingLowerThreshold1 +360;
        					}
        					
        					if(BearingUpperThreshold2 < 0)
        					{
        						BearingUpperThreshold2 = BearingUpperThreshold2 +360;
        					}
        					if(BearingLowerThreshold2 < 0)
        					{
        						BearingLowerThreshold2 = BearingLowerThreshold2 +360;
        					}
        					
        					
        					
        					
        					if(d<=0.25)
        					{
        						
        						
        						wr.write(lineVar1[0]+","+lineVar1[3]+","+lineVar2[0]+","+lineVar1[6]+","+lineVar2[3]+","+d+","+lineVar1[4]+","+lineVar1[5]+","+lineVar2[1]+","+lineVar2[2]+","+"P1");
        						wr.write(lineSep);
            					
        						//wr.write(lineVar2[6]+" "+lineVar2[1]);
        						//wr.write("distance "+Math.round(d)+" Km------>");
        					}
        					if(d<=5 && Double.parseDouble(lineVar2[3])<TargetAzimuthUpperThreshold && Double.parseDouble(lineVar2[3])>TargetAzimuthLowerThreshold && d!=0.00 && Double.parseDouble(lineVar1[6])<BearingUpperThreshold && Double.parseDouble(lineVar1[6])>BearingLowerThreshold)
        					{
        						
        						wr.write(lineVar1[0]+","+lineVar1[3]+","+lineVar2[0]+","+lineVar1[6]+","+lineVar2[3]+","+d+","+lineVar1[4]+","+lineVar1[5]+","+lineVar2[1]+","+lineVar2[2]+","+"P2");
        						wr.write(lineSep);
        						//wr.write(lineVar2[6]+" "+lineVar2[1]);
        						//wr.write("distance "+Math.round(d)+" Km------>");
        					}
        					
        					if(d<=5 && Double.parseDouble(lineVar2[3])<TargetAzimuthUpperThreshold && Double.parseDouble(lineVar2[3])>TargetAzimuthLowerThreshold && d!=0.00 && ((Double.parseDouble(lineVar1[6])<BearingUpperThreshold1 &&Double.parseDouble(lineVar1[6])>BearingUpperThreshold) || (Double.parseDouble(lineVar1[6])>BearingLowerThreshold1&& Double.parseDouble(lineVar1[6])<BearingLowerThreshold)))
        					{
        						
        						wr.write(lineVar1[0]+","+lineVar1[3]+","+lineVar2[0]+","+lineVar1[6]+","+lineVar2[3]+","+d+","+lineVar1[4]+","+lineVar1[5]+","+lineVar2[1]+","+lineVar2[2]+","+"P3");
        						wr.write(lineSep);
        						//wr.write(lineVar2[6]+" "+lineVar2[1]);
        						//wr.write("distance "+Math.round(d)+" Km------>");
        					}
        					
        					if(d<=5 && Double.parseDouble(lineVar2[3])<TargetAzimuthUpperThreshold && Double.parseDouble(lineVar2[3])>TargetAzimuthLowerThreshold && d!=0.00 && ((Double.parseDouble(lineVar1[6])<BearingUpperThreshold2 &&Double.parseDouble(lineVar1[6])>BearingUpperThreshold1) || (Double.parseDouble(lineVar1[6])>BearingLowerThreshold2&& Double.parseDouble(lineVar1[6])<BearingLowerThreshold1)))
        					{
        						
        						wr.write(lineVar1[0]+","+lineVar1[3]+","+lineVar2[0]+","+lineVar1[6]+","+lineVar2[3]+","+d+","+lineVar1[4]+","+lineVar1[5]+","+lineVar2[1]+","+lineVar2[2]+","+"P4");
        						wr.write(lineSep);
        						//wr.write(lineVar2[6]+" "+lineVar2[1]);
        						//wr.write("distance "+Math.round(d)+" Km------>");
        					}
        					
        				}
        				//wr.write(lineSep);
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
        	wr.close();

        }
        catch (IOException e) 
		{
		    System.err.println(e);
		}
        
        System.out.println("completed....");
		
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
	
    public static double bearing(double lat1, double lon1, double lat2, double lon2)
    {
    	  double longitude1 = lon1;
    	  double longitude2 = lon2;
    	  double latitude1 = Math.toRadians(lat1);
    	  double latitude2 = Math.toRadians(lat2);
    	  double longDiff= Math.toRadians(longitude2-longitude1);
    	  double y= Math.sin(longDiff)*Math.cos(latitude2);
    	  double x=Math.cos(latitude1)*Math.sin(latitude2)-Math.sin(latitude1)*Math.cos(latitude2)*Math.cos(longDiff);
    	 
    	  return (Math.toDegrees(Math.atan2(y, x))+360)%360;
    }
		

	

}

