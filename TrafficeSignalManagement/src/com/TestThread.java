package com;



public class TestThread {

	public static void main(String args[]) {
		// int expectedGreenTime = 13;

		
		ThreadDemo T1 = new ThreadDemo("Thread-1");
		T1.start();

		// ThreadDemo T2 = new ThreadDemo("Thread-2");
		// T2.start();
	}
}
