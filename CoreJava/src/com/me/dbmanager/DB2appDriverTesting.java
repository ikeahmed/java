package com.me.dbmanager;

/*
 * Created on May 27, 2005
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
public class DB2appDriverTesting {

	public static void main(String[] args) {
		try
		 {
		   Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
		   Connection con = DriverManager.getConnection("jdbc:db2:frameng","db2inst1","db2inst1");
			System.out.println("Demo Text");
			Statement stmt = con.createStatement();
			//ResultSet rs = stmt.executeQuery("select * from  propserv.cntxt");
			ResultSet rs = stmt.executeQuery("select tbl_nm, incrmt_qty from tbl_key where tbl_nm =  'trk_click'");
			int i = 0;
			while(rs.next() && i < 50)
			{
				System.out.println("Output: "+rs.getString(2));
				i++;
			}


		 }   
		 catch(Exception sqex) { System.out.println(sqex.getMessage());
		  }	
		
	}
}
