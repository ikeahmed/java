package com.me.inherritance.thisandsuper;

public class UsingThisAndSuper {

	public static void main(String[] args) {
		Programmer programmer = new Programmer();
		System.out.println(programmer.name);
		programmer.setNames();
		System.out.println(programmer.name);

		Employee employee1 = new Employee();
		System.out.println(employee1.name);
		
		Employee employee2 = programmer; //object casting.  
		System.out.println(employee2.name);
		

	}

}
