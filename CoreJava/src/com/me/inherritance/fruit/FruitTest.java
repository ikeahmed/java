package com.me.inherritance.fruit;


public class FruitTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	
		Fruit fruit = new Fruit();
		Apple apple = new Apple();
		Orange orange = new Orange();
		GrannySmith granny = new GrannySmith();
		System.out.println(fruit.name);
		System.out.println(orange.name);
		System.out.println(apple.name);		
		System.out.println(granny.name);
		fruit = granny;
		apple = granny;
		System.out.println(fruit.name);
		System.out.println(apple.name);
		
		
	}

}
