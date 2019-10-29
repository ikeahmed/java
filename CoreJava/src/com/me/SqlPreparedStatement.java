package com.me;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Created on May 3, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author I264693
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SqlPreparedStatement {

	public static void main(String[] args) throws SQLException {
        String[] sa = { "Green", "Blue", "Red" };
        Connection con = null;
        String updateOutreachResult = "update AEA_MART.WEB_SVC_LEAD_TXN " +
        " set  CALL_RESULT = ?, ADDR1_USED = ?, ADDR2_USED = ?, CALL_TIME = ?, DURATION = ?, PHONE_USED = ?, " +
        " CITY_USED = ?, STATE_USED =?, ZIP_USED =?, EMAIL_RESULT =?, EMAIL_BOUNCE_RSN =? where TRANS_ID = ?";
        prepareStatement(con, updateOutreachResult, sa);

    }

  public static PreparedStatement prepareStatement(Connection connection, String sql, String[] values) throws SQLException
  {
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      for (int i = 0; i < values.length; i++) {
          preparedStatement.setObject(i + 1, values[i]);
      }
      System.out.println(sql + " " + Arrays.asList(values));
      return preparedStatement;
  }
}
