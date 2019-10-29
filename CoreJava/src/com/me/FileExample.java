package com.me;

import java.io.File;
import java.io.FileOutputStream;

public class FileExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	try{
	String pathname = "c://temp//javaoutputfile.txt";
	FileOutputStream fos = new FileOutputStream(pathname);
	fos.write(0x31);
	File f = new File(pathname);
	System.out.println(f.getAbsolutePath());
	}
	catch (Exception e)
	{
	System.out.println(e.getMessage());	
	}
	}

}
