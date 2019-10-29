package com.me;

/*-----------------------------------------------------------------------------
*
*   File Name - SQLAnalyzer.java
*   Description -
*   Comment -
*
*----------------------------------------------------------------------------*/
/*
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.util.*;

import java.sql.*;
import java.text.NumberFormat;

*/

	public class SQLAnalyzer {}
/*	
	public class SQLAnalyzer extends HttpServlet {
	static String servletName = "SQLAnalyzer";
  SetProperty Init = new SetPropery();
  Properties properties = Init.InitProperties();
  ConnectionPool m_conPool = new ConnectionPool( properties );

  public void init(ServletConfig _config)
	    throws ServletException  {
    super.init(_config);
  }
  public void destroy() {
    super.destroy();
    System.out.println("killing Servlet " + servletName);
  }
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
    	throws ServletException, IOException {
    this.doPost(request,response);
  }

  public void doPost(HttpServletRequest _request,
                    HttpServletResponse _response)
    	throws javax.servlet.ServletException, java.io.IOException
  {
    _response.setContentType("text/html");
    _response.setHeader("Pragma", "no-cache");

    Thread.currentThread().setName(servletName);

    javax.servlet.ServletOutputStream out = _response.getOutputStream();

    String mach_id = _request.getParameter("M");
    String inst_id = _request.getParameter("I");
    String mach_name = _request.getParameter("N");
    String inst_name = _request.getParameter("O");

    //Begin the HTML output
    out.println("<html>");

    //Create and print the <HEAD> portion
		HtmlHead head = new HtmlHead("SQLAnalyzer SQL Submission Utility");
		head.addStyle("TD","text-align:center; height:15; font-family:Verdana,Arial,Helvetica,sans-serif; font-size:12; color:#000080");
		out.println(head.getHtml());

		//Create and print the top of the page
		JeemHeader jeemHead = new JeemHeader(inst_name, mach_name, "\"document.DBCommand.SQLCode.focus()\"");
		out.println(jeemHead.getHtml());

		//Create and print the menu
//		NavigationBar navBar = new NavigationBar(mach_id, inst_id, mach_name, inst_name);
		MenuBar menuBar = new MenuBar(mach_id, inst_id, mach_name, inst_name);
		//menuBar.addDestination("Databaseinfo", "Home.gif", "Home");
		//menuBar.addDestination("AlertLog", "AlertLog.gif", "Alert Log");
		//menuBar.addDestination("RedoInfo", "LogMemb.gif", "RedoInfo");
		//menuBar.addDestination("RedoParam", "Parameter.gif", "RedoParam");
		menuBar.addMenuItems(new int[] {MenuBar.DATABASEINFO,
					                        MenuBar.ALERTLOG,
					                        MenuBar.REDOINFO,
					                        MenuBar.REDOPARAM} );

		out.println(menuBar.getHtml());

		//Get the SQL that the user entered,
		//or set it to blank if this is the first time on this page.
		String sqlRequest;
		try {
	    sqlRequest = (_request.getParameter("SQLCode")).trim();
	    if (sqlRequest == null) {
				sqlRequest = "";
			}
		} catch (Exception e) {
			sqlRequest = "";
		}


		//Display the text box for the SQL
		out.println("<div align=\"center\"><center>");
		out.println("Enter your query below.  Multiple queries must be separated by a semicolon (;) or slash (/).");
		String machInstInfo = "M=" + mach_id + "&I=" + inst_id + "&N=" + mach_name + "&O=" + inst_name;
		out.println("<form name=\"DBCommand\" action=\"SQLAnalyzer?" + machInstInfo + "\" method=\"POST\">");
		out.println("<textarea cols=60 rows=6 name=\"SQLCode\">");
		out.println(sqlRequest);
		out.println("</textarea>");

		out.println("<br><input type=\"submit\">&nbsp&nbsp<input type=\"reset\">");

		out.println("</form>");

		if (sqlRequest != "") {
			Connection con;
			try {
				con = m_conPool.getConnection();

				if (con == null) {
					// Error Checking 
					out.println("<h1>Error - Unable to connect to database");
					out.println("</h1></body></html>");
					out.flush();
					out.close();
					return;
				};
			} catch (Exception _e) {
				_e.printStackTrace();
				out.println("<h1>Error 000: " + _e);
				out.println("</h1></body></html>");
				out.flush();
				out.close();
				return;
			};

			Instance siteConnect = new Instance(con);
			Connection con2 = siteConnect.getConnection(mach_id, inst_id);

			if (con2 == null) {
				 log("SQLAnalyzer : No connection returned for " + mach_id + " " + inst_id);
				 log("Instance Status: " + siteConnect.getStatus());
				out.flush();
				out.close();
				 return;
			} else {
				 log("DBSpace : Connected to 2nd database was returned for SQLAnalyzer");
			};

			m_conPool.release(con);

			PreparedStatement sql_stmt = null;
			String sql_string;

			//Parse statement to see if there are multiple SELECT's, then loop through the queries.

			StringTokenizer st = new StringTokenizer(sqlRequest,";/");
			while (st.hasMoreTokens()) {
			  sql_string = st.nextToken().trim();

			// IKE did on 11-10-2002
				if (    (sql_string.toUpperCase()).startsWith("SELECT ")
				     || (sql_string.toUpperCase()).startsWith("INSERT ")
				     || (sql_string.toUpperCase()).startsWith("UPDATE ")
				     || (sql_string.toUpperCase()).startsWith("DELETE "))
				     ;  //do nothing and keep processing
                                 else
				
				  {
					out.println("<h1>Error - The statement must begin with SELECT, INSERT, UPDATE or DELETE");
					out.println("</h1></body></html>");
					out.flush();
					out.close();
					return;
				};
                      

				log("Sql: " + sql_string);

				try {
				 sql_stmt = con2.prepareStatement(sql_string);


				} catch (SQLException _e) {
				 out.println("<h1>Error 001: " + _e);
				 out.println("</h1></body></html>");
				 _e.printStackTrace();
				 out.flush();
				 out.close();
				 return;
				} finally {
				};

				try {
				 
				 //if it is not select statement, we are done and no need to show tables and results
                                 if (   (sql_string.toUpperCase()).startsWith("INSERT ")
				     || (sql_string.toUpperCase()).startsWith("UPDATE ")
				     || (sql_string.toUpperCase()).startsWith("DELETE "))
				     {
				     	 int rows = sql_stmt.executeUpdate();
				    	 out.println("<h1>Query Executed Successfully. "+ rows + " row(s) affected");
					 out.println("</h1></body></html>");
					 out.flush();
					 out.close();
					 return;  	
				     }
				 sql_stmt.executeQuery();    
				 ResultSet rs0 = sql_stmt.getResultSet();

				 if (rs0 == null || rs0.next() == false) {
					 out.println("<h1>Error 002: No Rows Found!");
					 out.println("</h1></body></html>");
					 out.flush();
					 out.close();
					 return;
				 } else {
					 //Get the result set information
					 ResultSetMetaData rsm = rs0.getMetaData();

					 int colCount = rsm.getColumnCount();
					 int currentCol;

					 //Display the head of the table

					 out.println("<table border=1 bordercolor=#000000>");
					 out.println("<tr bgcolor=#9999FF>");
					 //Loop through the column headings
					 for (currentCol = 1; currentCol <= colCount; currentCol++) {
						 out.println("<th><b><font face=\"Verdana,Arial,Helvetica,sans-serif\" size=2>");
						 out.println(rsm.getColumnLabel(currentCol));
						 out.println("</font></b></th>");
					 }
					 out.println("</tr>");
					 do {
						 out.println("<tr>");
					 //Loop through the columns
						 for (currentCol = 1; currentCol <= colCount; currentCol++) {
							out.println("<td>" + rs0.getString(currentCol) + "</td>");
						 }
						 out.println("</tr>");
					 } while (rs0.next());
					 out.println("</table><br>");

				 };
				} catch (SQLException _e) {
				 out.println("<h1>Error 003: " + _e);
				 out.println("</h1></body></html>");
				 _e.printStackTrace();
				 out.flush();
				 out.close();
				 return;
				} finally {
				 //Removed con2.close()
				}
			}
			try {
				con2.close();
			} catch(Exception _e) {
			}
		}

		out.println("</center></div>");
    out.println("</body>");
    out.println("</html>");
    out.flush();
    out.close();
  }

}
*/