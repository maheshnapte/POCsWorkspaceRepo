package com;

import java.util.Arrays;

public class ExecuteTrafficSignalManagement {

	public static void main(String args[]) {
		System.out.println("Hi Mahesh, Welcome to programming again ... ");
		int expectedGreenTime = 13;
		int signalNumber = 3;
//		System.out.println("Actual signal green time : " + Arrays.toString(signalsGreentime));
		System.out.println("input signal density/ expectedGreenTime : " + expectedGreenTime);
		for (int j = 0; j <= 10; j++) {
			for (int i = 0; i <= 3; i++) {
				signalNumber =i;
				int greenSignalTime = TrafficSignalManagement.getGreenSignalTime(expectedGreenTime, signalNumber);
				System.out.println("Green signal time for signal " + signalNumber + " is: " + greenSignalTime);
//				System.out.println("Current signal green time : " + Arrays.toString(signalsGreentime));
			}
		}
	}
}
