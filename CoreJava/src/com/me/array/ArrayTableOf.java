package com.me.array;

public class ArrayTableOf {

	public static void main(String[] args) {
		int intArray[];
		intArray = new int[20];
		int tableOf = 3;
		for (int i=0; i<intArray.length; i++) 
			intArray[i] = tableOf * (i+1);
	
		  
		for (int i=0; i<intArray.length; i++)
			System.out.println(intArray[i]);
		

	}

}
