package com.me.xsl;
import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

class XSLTransformer {
   public static void main(String[] args) {

    	  if (args.length < 3)
    	  {
    		  System.out.println("Usage: input file, template file, output file" );
    		  System.exit (0);
    	  }
    	  try {
    	         File sf = new File(args[0]); // input file
    	         File tf = new File(args[1]); // template file
			     File rf = new File(args[2]); // output file
    	         TransformerFactory f = TransformerFactory.newInstance();
    	         Transformer t = f.newTransformer(new StreamSource(tf));
    	         Source s = new StreamSource(sf);
    	         Result r = new StreamResult(rf);
    	         t.transform(s,r);
    	         System.out.println("Output in " + rf.getAbsolutePath());
    	      } catch (TransformerConfigurationException e) {
    	         System.out.println(e.toString());      
    	      } catch (TransformerException e) {
    	         System.out.println(e.toString());
    	      }
    	   }

   }
         
