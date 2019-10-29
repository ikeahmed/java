package com.me.datatypes;


public class IntegerTest {
	 public static void main(String[] args) {
	        int i = 10;
	        float f = 4.6f;
	        int result = (int) (i + f);
	       System.out.println(result );
               
               //another test
               int a = 10;
               a = ++a + a + --a - --a + a++;
               
               System.out.println (a);
	 }
}
