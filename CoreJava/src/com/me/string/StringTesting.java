package com.me.string;

/*
 * Created on Jun 21, 2005
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
public class StringTesting {

	public static void main(String[] args) {
		String istr = "dev.com.hcsc";
		System.out.println (istr.substring(istr.lastIndexOf('.')+1));
		
		String tstr;
		tstr = "null";
		System.out.println(tstr);
		if (tstr == null )
		  System.out.println ("tstr is null");
		else
		System.out.println ("tstr is not null");
	}
}
