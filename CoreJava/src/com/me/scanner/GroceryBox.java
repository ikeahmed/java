package com.me.scanner;
//usage of % operator
import java.util.*;
public class GroceryBox {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numApples, numRemainingApples, numBoxes;
		//prompt the user to enter the required info
		System.out.println("Please enter the number of apples to be packed :" );
		numApples = input.nextInt(); //get user's input & assign that value to the variable numApples
		numBoxes = numApples / 12; // using / operator to find how many dozens are in the user's input
		numRemainingApples = numApples % 12; //using % operator to find the remainder (loose) apples
		System.out.println("You need " + numBoxes + " box(es) to pack." );
		System.out.println("You have " + numRemainingApples + " apple(s) that will be left out." );
		input.close();
	}
}