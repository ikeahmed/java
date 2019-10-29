/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.dbmanager;

import java.sql.Clob;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author iahmed
 */
public class ClobCopyProdToDev {
    public static void main (String[] args) throws ClassNotFoundException, SQLException
    {
    String dusername = "remmetadev";
    String dpassword = "rempass";
    String dhost = "192.168.81.52";
    String ddatabaseName = "REMDEV";
    
    String pusername = "rmxmeta";
    String ppassword = "devilsthumb";
    String phost = "larry.kbm1.com";
    String pdatabaseName = "REMIX";
    Connection pconn = null;
    Connection dconn = null;
    Statement pstmt = null;
    PreparedStatement dstmt = null;
    ResultSet prs = null;
    String clob;
    int order_id;
    int order_value_id;
    String userid;
    String value_type;


    String driver = "oracle.jdbc.driver.OracleDriver";
    String durl = "jdbc:oracle:thin:@" + dhost + ":1521:" + ddatabaseName;
    String purl = "jdbc:oracle:thin:@" + phost + ":1521:" + pdatabaseName;
    try
      {
     Class.forName(driver); // load Oracle driver
     dconn = DriverManager.getConnection(durl, dusername, dpassword);
     pconn = DriverManager.getConnection(purl, pusername, ppassword);

     dstmt = dconn.prepareStatement("insert into ds_order_value (DS_ORDER_ID, DS_ORDER_VALUE_ID, CREATED_USERID, VALUE_TYPE_CD, VALUE) VALUES (?,?,?,?,?)");
     pstmt = pconn.createStatement();
     prs = pstmt.executeQuery("select ds_order_id, DS_ORDER_value_ID, created_userid, value_type_cd, VALUE  from ds_order_value where ds_order_id in (1685)  order by updated_timestamp desc");

	while(prs.next())
        {
         order_id = prs.getInt(1);
         order_value_id = prs.getInt(2);
         userid = prs.getString(3);
         value_type = prs.getString(4);
         clob = prs.getString(5);
         System.out.println("ds_order_id: "+ order_id + " ds_order_value_id: "+ order_value_id  + " clob: "+ clob);
         dstmt.setInt(1, order_id);
         dstmt.setInt(2, order_value_id);
         dstmt.setString(3, userid);
         dstmt.setString(4, value_type);
         dstmt.setString(5, clob);
         dstmt.executeUpdate();
         }

        }
    finally
       {
       if (prs != null)   prs.close();
       if (pstmt != null) pstmt.close();
       if (pconn != null) pconn.close();

       if (dstmt != null) dstmt.close();
       if (dconn != null) dconn.close();
       }
    }

  
}
