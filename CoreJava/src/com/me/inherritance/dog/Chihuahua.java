package com.me.inherritance.dog;


public class Chihuahua extends Dog {
    
	/**
	 * @param args
	 */
	String dogtype = "Chihuahua";
	public void bark() {
		System.out.println("yip");
	}
	public static void main(String[] args) {
		Dog rover = new Dog();
		System.out.println("rover:");
		rover.bark();
		System.out.println(rover.dogtype);
		
		Chihuahua chichi = new Chihuahua();
		System.out.println("chichi:");
		chichi.bark();
		System.out.println(chichi.dogtype);		

		Dog confused = new Chihuahua();
		System.out.println("confused:");
		confused.bark();
		System.out.println(confused.dogtype);
		
        //will result in compilation error: 
		//Type mismatch: cannot convert from Dog to Chihuahua

		//Chihuahua confused2 = new Dog();

	}

}
