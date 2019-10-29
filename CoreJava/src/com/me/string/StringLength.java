/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.string;

/**
 *
 * @author iahmed
 */
public class StringLength {
    public static void main(String[] args)
    {

    String str1 = "";
    String str2 = "Hello";
    String str3 = new String("Hi");
    String str4 = null;

    System.out.println(str1.length() == 0);
    System.out.println(str2.length() == 0);
    System.out.println(str3.length() == 0);
    System.out.println(str4 == null || str4.length() == 0);
    }


}
