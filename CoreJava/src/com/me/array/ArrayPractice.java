package com.me.array;

public class ArrayPractice {
	public static void main(String[] args) {
	    String[] sa = { "Green", "Blue", "Red" }; 
	    System.out.println("sa = " + sa[1]); 
	    
	    String[] isa; //declare
	    isa = new String[3]; //allocate
	    isa[0] = "Green"; //initialize
	    isa[1] = "Blue";
	    isa[2] = "Red";
	    System.out.println("isa = " + isa[1]); 
	    
	    
	    for (int i=0; i <sa.length; i++)
	    	System.out.println(sa[i]);
	    
	    for (int i=0; i <isa.length; i++)
	    	System.out.println(isa[i]);
	    
	    //write table
//	    int intArray[];
//	    intArray = new int[10];
//	    for (int i=0; i<intArray.length; i++) 
//	    intArray[i] = 2*i;
//	    
//	    for (int i=0; i<intArray.length; i++) 
//		    System.out.println(intArray[i]);
//	    

	    
	}
	

}
