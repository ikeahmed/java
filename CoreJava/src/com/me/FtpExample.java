package com.me;


import java.io.*;
import java.net.URL;
import java.net.URLConnection;


public class FtpExample {

  public static void main(String args[]) throws Exception {
//         FtpClient fc;

        

        URL url = new URL("ftp://user01:pass1234@ftp.foo.com/README.txt;type=i");
        URLConnection urlc = url.openConnection();
        InputStream is = urlc.getInputStream(); // To download
        OutputStream os = urlc.getOutputStream(); // To upload





  }
}
