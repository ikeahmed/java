package com.me.whileloop;

public class DoWhileLoopTest {

	public static void main(String[] args) {
		boolean flag= true;
		int val = 20;
		
		while (flag) {
			System.out.println(val);
			if (val <= 15)
				flag = false;
			val--;
		}
	}
}
