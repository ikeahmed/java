package com.me.exceptions;

public class NullPointerException {

	public static void main(String[] args) {
		String[] students = {"Tom", "Dick", null};
		System.out.println(students[2].length());

	}

}
