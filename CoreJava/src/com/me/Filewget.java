package com.me;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Filewget {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
          if (args.length == 0)  
          {
              System.out.println("Usage: Filewget [test | prod] inputfile(s)");
              return;
          }
          if (args[0].equalsIgnoreCase("test")==false && args[0].equalsIgnoreCase("prod")== false )
          {
              System.out.println("Usage: Filewget [test | prod] inputfile(s)");
              return;
          }
          if (args.length == 1)
          {
           System.out.println("No input files to process");
           return;
          }
     String strFile;
     for (int i=1; i < args.length; i++)
        {
        strFile = args[i];
        System.out.println(strFile);
        BufferedReader br = new BufferedReader(new FileReader(strFile));

	}
    }
}
