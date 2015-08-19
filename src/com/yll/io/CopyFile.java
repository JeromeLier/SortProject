package com.yll.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
	
	
	
	
	public static void main(String[] args) throws IOException {
		
		String filePath = "D:/dri/file1.txt";
		File file1 = new File(filePath);
		
		try {
			FileInputStream input = new FileInputStream(file1);
			//FileInputStream input1 = new File(pathname);
			FileOutputStream out = new FileOutputStream("D:/dri/dom/1.txt");
			byte[] buff = new byte[255];
			int len = 0;
			while((len = input.read(buff)) > 0){
				out.write(buff, 0, len);
			}
			input.close();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
