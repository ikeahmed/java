package com.me.thread;




public class ThreadTestingImplementsRunnable implements Runnable {
	public void run() {
		System.out.println("Important job running in MyThread");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadTestingImplementsRunnable obj = new ThreadTestingImplementsRunnable();
                Thread t = new Thread(obj);
                t.start();
		

	}

}
