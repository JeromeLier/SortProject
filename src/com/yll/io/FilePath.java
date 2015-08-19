package com.yll.io;

import java.io.File;
import java.io.IOException;

import sun.dc.pr.PathFiller;

public class FilePath {
	
	
	public static void main(String[] args) {
		String filePath = "D:/dri/file1.txt";
		File file1 = new File(filePath);
		if(!file1.exists()) {
			System.out.println("文件不存在 crate file" + filePath);
			try {
				file1.createNewFile();
			} catch (IOException e) {
				System.out.println("文件创建失败");
				e.printStackTrace();
			}
		}
		
		String dirStr = "D:/dri"; 
		File dir = new File(dirStr);
		if(dir.isDirectory()) {
			String[] fileList = dir.list();
			for(String pathFile : fileList) {
				System.out.println(pathFile);
				File f = new File(dir.getPath() + File.separator + pathFile);
				if(f.isFile()) {
					System.out.println("file: " + f.getName()) ;
				} else if(f.isDirectory()) {
					System.out.println("dir: " + f.getName());
					
				}
			}
			
			
		}
		
	}

}
