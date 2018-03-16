package org.me;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

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
public class DateTimeCalendarTest {

	public static void main(String[] args) throws DatatypeConfigurationException, ParseException {
            Date date = new Date();
            System.out.println("current time from Date : " + date.getTime());
            GregorianCalendar cal = new GregorianCalendar();
            System.out.println("current time from gerogrian calendar is " + cal.getTime());

            GregorianCalendar gcal = (GregorianCalendar) GregorianCalendar.getInstance();
            System.out.println("current time from gerogrian calendar getinstance is " + cal.getTime());

            XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
            System.out.println("current date and time from xml gregorian calendar is " +xgcal);
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date javaUtilDate = dateFormat.parse(xgcal.toString());
            long javaMilliseconds = javaUtilDate.getTime();
            System.out.println("current date from xgcal->Date " + javaMilliseconds);
            System.out.println(new Date(javaMilliseconds));
            
            





	
    }

	
}
