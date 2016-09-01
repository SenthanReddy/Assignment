package exercise03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import exercise.Exercise;
import exercise.*;
public class Folder extends Exercise{
	private File src, dest,result;
	private String charToSearch=null;
	public void input()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the source folder path");
		String srcName=scan.next();
		src=new File(srcName);
		System.out.println("Enter the destination folder path");
		String destName=scan.next();
		dest=new File(destName);
		System.out.println("Enter the result file path");
		String resultName=scan.next();
		result=new File(resultName);
	
		if (result.isDirectory())
		{
			write("invalid file name");
		}
		System.out.println("Enter 1 to search for files that start with a particular letter");
		if(scan.nextInt()==1)
		{
			System.out.print("enter the character");
			charToSearch=scan.next();
		
		}
	}
	public File getSource()
	{
		return this.src;
	}
	public File getDestination()
	{
		return this.dest;
	}
	public File getResultFile()
	{
		return this.result;
	}
	public String getCharToSearch()
	{
		return charToSearch;
	}
	 public static void copyFolder(File src,File dest)
     {
     	if(src.isDirectory()){
     		if(!dest.exists()){
     			dest.mkdir();
     		}

     		String files[] = src.list();
     		ExecutorService pool = Executors.newFixedThreadPool(10);
     		
	            Runnable r = new Runnable(){
	                public void run() {
	                	for (String file : files) {
	             			File srcFile = new File(src, file);
	             			File destFile = new File(dest, file);
	             			copyFolder(srcFile,destFile);
	             		}
	                  
	                  
	                }
	               
	               
	            };
	            pool.execute(r);
	        
     		
     	}
     	else
     	{
     		copyFile(src,dest);
     	}

     }
	 public static void copyFile(File src, File dest)
     {
     	byte[] buffer = new byte[1024];
     	int length;
     	try{
     	InputStream in = new FileInputStream(src);
	        OutputStream out = new FileOutputStream(dest);
	        while ((length = in.read(buffer)) > 0){
	    	   out.write(buffer, 0, length);
	        }
	        in.close();
	        out.close();
	        }
	        catch(Exception e)
	        {
	        	System.out.println(e);
	        }
	        
     }
	
}
