package com.me.dbmanager;

import java.sql.*;
public class SqlServerDataDirectDriverTesting {

		public static void main(String[] args) {
			try
			 {
			   Class.forName("com.ibm.websphere.jdbc.sqlserver.SQLServerDriver");
			   Connection con = DriverManager.getConnection("jdbc:ibm:sqlserver://localhost:1433;databaseName=Northwind","sa","internet");
				System.out.println("Demo Text");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select ProductName from products");
				while(rs.next())
				  System.out.println("Output: "+rs.getString(1));

			 }   
			 catch(Exception sqex) { System.out.println(sqex.getMessage());
			  }	
	 		
		}
	}



