package com.me.ifelse;

import java.util.*;
public class IfElse {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter my name: " );
		String name = input.next();
		if (name.equals("Ike"))
          System.out.println ("you got it"); 
	    else if (name.equals("Ikhlas"))
          System.out.println("Cool, you used my full name");
        else
         System.out.println("Not really");
		input.close();
	}
}