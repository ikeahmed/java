package com.me.dbmanager;

/*
 * Created on May 24, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
import java.sql.*;
/**
 * @author I264693
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SqlServerMicrosoftDriverTesting {

	public static void main(String[] args) {
		try
		 {
		   Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
		   Connection con = DriverManager.getConnection("jdbc:microsoft:sqlserver://localhost:1433;databaseName=Northwind","sa","internet");

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
