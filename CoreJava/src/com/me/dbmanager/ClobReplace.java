/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author iahmed
 */
public class ClobReplace {
public static void main (String[] args) throws ClassNotFoundException, SQLException
    {
    String username = "rmxmeta";
    String password = "devilsthumb";
    String host = "larry.kbm1.com";
    String databaseName = "REMIX";

    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String clob;
    String replacedClob = null;
    String oldStr = "<id>213</id>\n      <name>STR2</name>\n      <mainframe_name>STR2</mainframe_name>";
    //String oldStr = "STR2";
    String newStr = "<id>222</id>\n      <name>APT</name>\n      <mainframe_name>APT</mainframe_name>";
    boolean oldStrFound;



    int order_id;
    int order_value_id;
    String userid;
    String value_type;

    String driver = "oracle.jdbc.driver.OracleDriver";
    String durl = "jdbc:oracle:thin:@" + host + ":1521:" + databaseName;

    
     try {
     Class.forName(driver); // load Oracle driver
     conn = DriverManager.getConnection(durl, username, password);
     stmt = conn.createStatement();
     
     String selectSql = "select ds_order_id, DS_ORDER_value_ID, created_userid, value_type_cd, VALUE  from ds_order_value where  VALUE LIKE '%<name>STR2</name>%'";
     System.out.println(selectSql);
     rs = stmt.executeQuery(selectSql);
     pstmt = conn.prepareStatement("update ds_order_value set VALUE = ? where DS_ORDER_ID = ? and DS_ORDER_VALUE_ID = ?");
     while(rs.next())
        {
         order_id = rs.getInt(1);
         order_value_id = rs.getInt(2);
         userid = rs.getString(3);
         value_type = rs.getString(4);
         clob = rs.getString(5);
         oldStrFound = clob.indexOf(oldStr) > 0;

         replacedClob = clob.replace(oldStr, newStr);
         //System.out.println("=>ds_order_id: "+ order_id + " ds_order_value_id: "+ order_value_id  + " clob: "+ clob + " replacedClob: " + replacedClob);
         System.out.println("=>ds_order_id: "+ order_id + " ds_order_value_id: "+ order_value_id  + " oldStrFound: "+ oldStrFound);
         pstmt.setString(1, replacedClob);
         pstmt.setInt(2, order_id);
         pstmt.setInt(3,order_value_id);
         pstmt.executeUpdate();
         }
 
    }
     finally
     {
      if (rs != null)   rs.close();
      if (stmt != null) stmt.close();
      if (pstmt != null) pstmt.close();
      if (conn != null) conn.close();
     }
  }

}
