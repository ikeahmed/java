package com.me.inherritance.employee;

public class Office {

	public static void main(String[] args) {
		Programmer prog = new Programmer();
		prog.accessBaseClassMembers();
		System.out.println(prog.name);

	}

}
