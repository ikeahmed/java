package com.me.thread;


public class ThreadTestingExtendsThread extends Thread {
	public void run() {
		System.out.println("Important job running in MyThread");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadTestingExtendsThread t = new ThreadTestingExtendsThread();
		t.start();

	}

}
