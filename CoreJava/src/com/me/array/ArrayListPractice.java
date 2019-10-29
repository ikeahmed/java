package com.me.array;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListPractice {
	public static void main(String args[]) {
		ArrayList<String> sal = new ArrayList<>();
		sal.add("Green");
		sal.add("Blue");
		sal.add("Red");
		
		
	    for (int i=0; i <sal.size(); i++)
	    	System.out.println(sal.get(i));
	    
		sal.add(1, "Pink");
	    for (int i=0; i <sal.size(); i++)
	    	System.out.println(sal.get(i));
	    
	    //another way of iterating called enhanced loop
	    for (String val:sal)
	    	System.out.println(val);
	}

}
