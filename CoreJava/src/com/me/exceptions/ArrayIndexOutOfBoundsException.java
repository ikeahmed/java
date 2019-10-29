package com.me.exceptions;

public class ArrayIndexOutOfBoundsException {

	public static void main(String[] args) {
		try {
		String[] students = {"Tom", "Dick", null};
		System.out.println(students[4].length());
	}
	catch (Exception e) {
			
		System.out.println("hey i myself caught it" );
		throw e;
	}

	}

}
