package com.me.exceptions;

public class StackOverflowException {

	public static void main(String[] args) {
		myMethod();
		}
	public static void myMethod() {
		myMethod();
	}

}
