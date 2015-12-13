package kaba;
import java.lang.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.net.*;
import java.nio.file.*;
import java.nio.charset.*;

public class PSCExtractor 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
				
		String line= "";
		String line01,line02,line03,line04,line05,line06,line07,line08,line09,line010,line011,line012,line013,line014,line015,line016,line017,line018,line019="",line020="";
		String line1= "";
		
		boolean a,b,c,d;
		String lineSep = System.getProperty("line.separator");
		
		 try(BufferedWriter wr = new BufferedWriter(new FileWriter("C:\\JavaProjects\\kaba\\PSCExtractor.txt", true)))
	     {            
	        	try (BufferedReader br = new BufferedReader(new FileReader("C:\\JavaProjects\\kaba\\CMExport_KKRBL13_White Filed 5_10.162.53.247_2015100808.xml")))
	        	{
	        		while ((line = br.readLine()) != null ) 
            		{
	        			
	        			a = line.indexOf("CELLID") >0;
	        			
            			b = line.indexOf("PSCRAMBCODE") > 0;
            			c = line020.indexOf("CELLID") >0;
            			d = line020.indexOf("NCELLID") >0;
            		    if (a)
            			{
            		    	line01=line;
            		    	line02=line01;
            		    	line03=line02;
            		    	line04=line03;
            		    	line05=line04;
            		    	line06=line05;
            		    	line07=line06;
            		    	line08=line07;
            		    	line09=line08;
            		    	line010=line09;
            		    	line011=line010;
            		    	line012=line011;
            		    	line013=line012;
            		    	line014=line013;
            		    	line015=line014;
            		    	line016=line015;
            		    	line017=line016;
            		    	line018=line017;
            		    	line019=line018;
            		    	line020=line019;
            		    	 //String str = "abcd=0; efgh=1";
            		    	 //line = line.replaceAll("[^a-zA-Z0-9]", ",");
            		    	 //String replacedStr2 = line.replaceAll("">", "_");
            		    	 //String[] lineVar1 = line.split(","); 
            		    	
            		    	 //wr.write(line);
            		    	 //wr.write(line01);
            		    	 //wr.write(lineSep);
            		    	
            				//wr.write(lineVar1[19]+","+lineVar1[20]+","+lineVar1[21]+","+lineVar1[22]);
    						//wr.write(lineSep);
            		    	//continue;
            		    	
            			}
            		    if ((b)&&(c)&&!(d))
            			{
            		    	
            		    	 //String str = "abcd=0; efgh=1";
            		    	 //line = line.replaceAll("[^a-zA-Z0-9]", ",");
            		    	 //String replacedStr2 = line.replaceAll("">", "_");
            		    	 //String[] lineVar1 = line.split(","); 
            		    	//wr.write(line019);
            		    	
            		    	
            		    	
            		    	//String str = "abcd=0; efgh=1";
           		    	 line = line.replaceAll("[^a-zA-Z0-9]", ",");
           		    	line020 = line020.replaceAll("[^a-zA-Z0-9]", ",");
           		    	 //String replacedStr2 = line.replaceAll("">", "_");
           		    	 String[] lineVar1 = line.split(","); 
           		    	String[] lineVar2 = line020.split(","); 
           		    	 
           		    	//wr.write(line020);
        		    	//wr.write(line);
        		    	wr.write(lineSep);
           		    	 //wr.write(line);
           		    	 //wr.write(lineSep);
           				wr.write(lineVar2[18]+","+lineVar1[18]);
   						//wr.write(lineSep);
            				//wr.write(lineVar1[19]+","+lineVar1[20]+","+lineVar1[21]+","+lineVar1[22]);
    						//wr.write(lineSep);
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
	

		
		

	}

}
