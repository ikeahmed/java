/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.dbmanager;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author iahmed
 */
public class oracleTesting {
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {

//    String username = "remmetadev";
//    String password = "rempass";
//    String host = "192.168.81.52";
//    String databaseName = "REMDEV";


    String username = "rmxmeta";
    String password = "devilsthumb";
    String host = "larry.kbm1.com";
    String databaseName = "REMIX";

    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@" + host + ":1521:" + databaseName;

    Class.forName(driver); // load Oracle driver
    Connection conn = DriverManager.getConnection(url, username, password);

    }

}
