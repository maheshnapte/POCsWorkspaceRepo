package com;

import java.util.Random;

class ThreadDemo extends Thread {

	private Thread t;
	private String threadName;
	int signalNumber = -1;

	ThreadDemo(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	private int getNextSignalNumber(int currentSignalNumber) {
		// System.out.println("*** " + currentSignalNumber);
		if (currentSignalNumber == 3) {
			return 0;
		} else {
			return currentSignalNumber + 1;
		}
	}

	public void run() {

		while (true) {
			Random rand = new Random();
			int expectedGreenTime = rand.nextInt(19);
			System.out.println("expectedGreenTime :" + expectedGreenTime);
			signalNumber = getNextSignalNumber(signalNumber);
			System.out.println("Current signal number : " + signalNumber);
			System.out.println("Current signal expectedGreenTime : " + expectedGreenTime);

			int greenSignalTime = TrafficSignalManagement.getGreenSignalTime(expectedGreenTime, signalNumber);
			System.out.println("greenSignalTime : " + greenSignalTime);
			System.out.println("Thread is sleeping for " + greenSignalTime + " seconds");
			try {
				Thread.sleep(greenSignalTime*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("sleep exception occured : " + 1);
				e.printStackTrace();
			}
			System.out.println("------------------------------------------------------");
			// System.out.println("Running " + threadName);
		}

	}

	public void start() {
		System.out.println("In run (start) : " + signalNumber);
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
}
