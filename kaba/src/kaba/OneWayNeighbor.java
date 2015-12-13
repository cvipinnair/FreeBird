package kaba;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OneWayNeighbor 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		String line = "";
		String line1 = "";
		//BufferedWriter writer = null;
        String lineSep = System.getProperty("line.separator");
        try(BufferedWriter wr = new BufferedWriter(new FileWriter("C:\\JavaProjects\\kaba\\myfile.txt", true)))
        {            
        	try (BufferedReader br = new BufferedReader(new FileReader("C:\\JavaProjects\\kaba\\input.txt")))
        	{
        		while ((line = br.readLine()) != null ) 
        		{
        			String[] lineVar1 = line.split(","); 
        			for (String str : lineVar1) 
        			{
        				//System.out.println(str);
        				wr.write(str);
        				wr.write(" ");
           			}
        			//wr.write(lineSep);
        			//System.out.println("started");
        			try (BufferedReader br1 = new BufferedReader(new FileReader("C:\\JavaProjects\\kaba\\input.txt")))
        			{
        				while ((line1 = br1.readLine()) != null ) 
        				{
        					//System.out.println("br2");
        					String[] lineVar2 = line1.split(","); 
        					if(lineVar1[0].equals(lineVar2[2]) && lineVar1[1].equals(lineVar2[3])&& lineVar1[2].equals(lineVar2[0])&& lineVar1[3].equals(lineVar2[1]) )
        					{
				    			//out1.write("found"+"\n");
				    			//System.out.println("found");
				    			wr.write("   found");
				    			wr.write(lineSep);
				    		}
		   
        				}
        				wr.write(lineSep);
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
        


		
		
		
		
		
	}

}
