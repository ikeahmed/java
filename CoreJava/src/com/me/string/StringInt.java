/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.string;

/**
 *
 * @author iahmed
 */
public class StringInt {

public static void main(String[] args)
    {
    int iDuration;
    String sDuration;
        //convert string to int
        sDuration = "10";
        iDuration = Integer.valueOf(sDuration);
        System.out.println(iDuration);

        //now convert int to string
        iDuration = 20;
        sDuration = Integer.toString(iDuration);
        System.out.println(sDuration);
        

    }

}
