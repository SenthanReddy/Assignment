package exercise;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import exercise01.*;
import exercise02.*;
import exercise03.*;

public class Exercise {

	public void getInput() throws Exception {

	}

	public void execute() {

	}

	public void write(String str) {
			System.out.println(str);
	}
	public void write(File resultFile,String str) throws IOException
	{
		
		FileWriter writer = new FileWriter(resultFile, true);
	    writer.write(str);
	    writer.flush();
	    writer.close();
		
	}
	public void writeOutput() throws IOException
	{
	
	}
	
}
