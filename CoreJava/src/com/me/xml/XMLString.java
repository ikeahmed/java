/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;




/**
 *
 * @author iahmed
 */
public class XMLString {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
    {
     //String xmlString =  "&lt;?xml version=&quot;1.0&quot;?&gt;&lt;ROW&gt;&lt;PHONE_NUM&gt;3132044767&lt;/PHONE_NUM&gt;&lt;LVL_CD&gt;Billing&lt;/LVL_CD&gt;&lt;BILLING_SYSTEM_NM&gt;TELEGENCE&lt;/BILLING_SYSTEM_NM&gt;&lt;ACCT_ID&gt;123962965&lt;/ACCT_ID&gt;&lt;SUBSCRIBER_ID&gt;191420305&lt;/SUBSCRIBER_ID&gt;&lt;ACCT_NUM&gt;235185532&lt;/ACCT_NUM&gt;&lt;ADDRESS_LINE_1&gt;230 S YORK ST&lt;/ADDRESS_LINE_1&gt;&lt;ADDRESS_LINE_2&gt;&lt;/ADDRESS_LINE_2&gt;&lt;ADDRESS_LINE_3&gt;&lt;/ADDRESS_LINE_3&gt;&lt;CITY&gt;DEARBORN&lt;/CITY&gt;&lt;STATE_CD&gt;MI&lt;/STATE_CD&gt;&lt;ZIP5&gt;48124&lt;/ZIP5&gt;&lt;ZIP4&gt;1440&lt;/ZIP4&gt;&lt;CONTACT_PHONE_NUM&gt;&lt;/CONTACT_PHONE_NUM&gt;&lt;BILLING_FULL_NM&gt;LINELL JENKS&lt;/BILLING_FULL_NM&gt;&lt;FIRST_NM&gt;LINELL&lt;/FIRST_NM&gt;&lt;LAST_NM&gt;JENKS&lt;/LAST_NM&gt;&lt;LISTED_NM&gt;&lt;/LISTED_NM&gt;&lt;PRIMARY_EMAIL&gt;BRUCE230@AOL.COM&lt;/PRIMARY_EMAIL&gt;&lt;SECONDARY_EMAIL&gt;&lt;/SECONDARY_EMAIL&gt;&lt;SUBSCRIPTION_IN_SERVICE_DT&gt;2006-06-23&lt;/SUBSCRIPTION_IN_SERVICE_DT&gt;&lt;ACCT_IN_SERVICE_DT&gt;2004-12-06&lt;/ACCT_IN_SERVICE_DT&gt;&lt;DT_OF_BIRTH&gt;9999-12-31&lt;/DT_OF_BIRTH&gt;&lt;CUST_CD&gt;&lt;/CUST_CD&gt;&lt;TREATMENT_CD&gt;&lt;/TREATMENT_CD&gt;&lt;TOLL_RESTRICTION_IND&gt;N&lt;/TOLL_RESTRICTION_IND&gt;&lt;COLLECT_CALL_BLOCK_IND&gt;N&lt;/COLLECT_CALL_BLOCK_IND&gt;&lt;BILL_TO_TP_BLOCK_IND&gt;N&lt;/BILL_TO_TP_BLOCK_IND&gt;&lt;BILL_BLOCK&gt;N&lt;/BILL_BLOCK&gt;&lt;SUSPEND_FOR_NON_PYMT_IND&gt;N&lt;/SUSPEND_FOR_NON_PYMT_IND&gt;&lt;ACCT_STATUS_DESC&gt;Open&lt;/ACCT_STATUS_DESC&gt;&lt;ACCT_STATUS_CD&gt;A&lt;/ACCT_STATUS_CD&gt;&lt;FOREIGN_LANG_IND&gt;&lt;/FOREIGN_LANG_IND&gt;&lt;HEARING_IMPAIRED_IND&gt;&lt;/HEARING_IMPAIRED_IND&gt;&lt;PURCHASE_BLOCK_CD&gt;&lt;/PURCHASE_BLOCK_CD&gt;&lt;/ROW&gt;";
        String xmlString = "<?xml version=\"1.0\"?><ROW><PHONE_NUM>3132044767</PHONE_NUM><LVL_CD>Billing</LVL_CD><BILLING_SYSTEM_NM>TELEGENCE</BILLING_SYSTEM_NM><ACCT_ID>123962965</ACCT_ID><SUBSCRIBER_ID>191420305</SUBSCRIBER_ID><ACCT_NUM>235185532</ACCT_NUM><ADDRESS_LINE_1>230 S YORK ST</ADDRESS_LINE_1><ADDRESS_LINE_2></ADDRESS_LINE_2><ADDRESS_LINE_3></ADDRESS_LINE_3><CITY>DEARBORN</CITY><STATE_CD>MI</STATE_CD><ZIP5>48124</ZIP5><ZIP4>1440</ZIP4><CONTACT_PHONE_NUM></CONTACT_PHONE_NUM><BILLING_FULL_NM>LINELL JENKS</BILLING_FULL_NM><FIRST_NM>LINELL</FIRST_NM><LAST_NM>JENKS</LAST_NM><LISTED_NM></LISTED_NM><PRIMARY_EMAIL>BRUCE230@AOL.COM</PRIMARY_EMAIL><SECONDARY_EMAIL></SECONDARY_EMAIL><SUBSCRIPTION_IN_SERVICE_DT>2006-06-23</SUBSCRIPTION_IN_SERVICE_DT><ACCT_IN_SERVICE_DT>2004-12-06</ACCT_IN_SERVICE_DT><DT_OF_BIRTH>9999-12-31</DT_OF_BIRTH><CUST_CD></CUST_CD><TREATMENT_CD></TREATMENT_CD><TOLL_RESTRICTION_IND>N</TOLL_RESTRICTION_IND><COLLECT_CALL_BLOCK_IND>N</COLLECT_CALL_BLOCK_IND><BILL_TO_TP_BLOCK_IND>N</BILL_TO_TP_BLOCK_IND><BILL_BLOCK>N</BILL_BLOCK><SUSPEND_FOR_NON_PYMT_IND>N</SUSPEND_FOR_NON_PYMT_IND><ACCT_STATUS_DESC>Open</ACCT_STATUS_DESC><ACCT_STATUS_CD>A</ACCT_STATUS_CD><FOREIGN_LANG_IND></FOREIGN_LANG_IND><HEARING_IMPAIRED_IND></HEARING_IMPAIRED_IND><PURCHASE_BLOCK_CD></PURCHASE_BLOCK_CD></ROW>";
     //get the factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                dbf.setNamespaceAware(true);



			//Using factory get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();
                        InputStream is = new ByteArrayInputStream(xmlString.getBytes("UTF-8"));
                        //org.w3c.dom.Document doc = db.parse("att.xml");
                        // org.w3c.dom.Document doc = db.parse(is);

                        org.w3c.dom.Document doc = db.parse(new InputSource(new StringReader(xmlString)));





                          System.out.println(doc.getDocumentURI());
                        NodeList el = doc.getElementsByTagName("PHONE_NUM");
                        Node firstChild = el.item(0).getFirstChild();
                        System.out.println(firstChild.getNodeValue());
                       

        
    }


}


