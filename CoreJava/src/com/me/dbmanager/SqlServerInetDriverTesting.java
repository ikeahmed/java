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
public class SqlServerInetDriverTesting {

	public static void main(String[] args) {
		try
		 {
		   Class.forName("com.inet.tds.TdsDriver");
		   Connection con = DriverManager.getConnection("jdbc:inetdae7a:localhost:1433?database=Northwind","sa","internet");
			System.out.println("Demo Text");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from products");
			while(rs.next())
			System.out.println("Output: "+rs.getString(1));

		 }   
		 catch(Exception sqex) { System.out.println(sqex.getMessage());
		  }	
 		
	}
}
