package com.me.inherritance.dog;


public class Dog {
	String dogtype = "Dog";
	public Dog() {}
	public Dog (String s){}
 public void bark()
 {
	 System.out.println("bark");
 }
 public void bark (int c)
 {
	 for (int i=0;i<c;i++)
		 System.out.println("bark");
 }
 public void bark (String s)
 {
	 System.out.println(s);
 }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Dog d = new Dog();
        d.bark();
        d.bark(3);
        d.bark("woof");
	}

}
