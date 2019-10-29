package com.me;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

//import java.net.URLConnection;
//import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;

public class URLTester {

  public URLTester() {
  }

  public void URLtest(String urlName)
  throws MalformedURLException, IOException
  {
//     URL url = new URL(urlName);
//     URLConnection urlConnection = url.openConnection();
//     InputStream is = urlConnection.getInputStream();
  }

  public static void main(String[] args) {
     if ( args.length < 1 )
     {
        System.out.println("Usage: java URLTester urlname");
        System.exit(1);
     }

     URLTester urlTester = new URLTester();
     try
     {
        urlTester.URLtest(args[0]);
        System.out.println("Web Site you enter " + args[0] + " is up");

     }
     catch (MalformedURLException mue)
     {
        mue.printStackTrace();
        System.exit(1);
     }
     catch (IOException ioe)
     {
        System.out.println("Web Site you enter " + args[0] + " is down");
        System.exit(1);
     }
  }
}