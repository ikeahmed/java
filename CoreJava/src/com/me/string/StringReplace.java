/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.string;

/**
 *
 * @author iahmed
 */
public class StringReplace {
    public static void main(String[] args)
    {
     String str1 = "<id>213</id>\n<name>STR2</name>\n<mainframe_name>STR2</mainframe_name>";
     System.out.println(str1);
     boolean match= str1.indexOf("STR2") > 0;
     System.out.println ("STR2 found  in " + str1 + " : " + match);
     String str2 = str1.replace("STR2", "APT");
     System.out.println(str2);
    }

}
