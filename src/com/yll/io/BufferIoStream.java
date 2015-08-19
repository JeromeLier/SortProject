package com.yll.io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BufferIoStream  	{
	
	public static void main(String[] args) throws IOException {
		OutputStream os;
		try {
			os = new FileOutputStream("1.txt");
			BufferedOutputStream bos = new BufferedOutputStream(os); 
			bos.write("http://www.google.com".getBytes());  
			bos.close(); 
			os.close();  
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}


}
