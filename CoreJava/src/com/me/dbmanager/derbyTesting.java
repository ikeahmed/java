/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.dbmanager;

/**
 *
 * @author iahmed
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Properties;

public class derbyTesting {
   public static void main(String[] args)
   {
      try {
         String driver = "org.apache.derby.jdbc.EmbeddedDriver";

         Class.forName(driver).newInstance();
         Connection conn = null;
         conn = DriverManager.getConnection("jdbc:derby:DerbyTestDB");
         Statement s = conn.createStatement();
         ResultSet rs = s.executeQuery("SELECT city, state, zipcode FROM zipcodes");

         while(rs.next()) {
            System.out.println("City   : "+ rs.getString(1));
            System.out.println("State  : "+ rs.getString(2));
            System.out.println("Zipcode: "+ rs.getString(3));
            System.out.println();
         }

         rs.close();
         s.close();
         conn.close();
      } catch(Exception e) {
         System.out.println("Exception: "+ e);
         e.printStackTrace();
      }
   }
}


