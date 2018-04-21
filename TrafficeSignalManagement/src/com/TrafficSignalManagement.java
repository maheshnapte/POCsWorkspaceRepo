package com;

import java.util.Arrays;

public class TrafficSignalManagement {
	public static int idealGreenTime = 10;
	public static int signalsGreentime[] = { 15, 5, 10, 5 };

	static int getAdditionOfLastThreeSignalsGreenTime(int signalNumber) {
		int sum = 0;
		for (int s : signalsGreentime) {
			sum = sum + s;
		}
		return sum - signalsGreentime[signalNumber];
	}

	static int getGreenSignalTime(int expectedGreenTime, int signlNumber) {
		int newGreenTime = idealGreenTime;
		// System.out.println(signalsGreentime[signlNumber]);
		System.out.println(Arrays.toString(signalsGreentime));
		if (expectedGreenTime > idealGreenTime) {
			int additionOfLastThreeSignalsGreenTime = getAdditionOfLastThreeSignalsGreenTime(signlNumber);
			System.out.println("additionOfLastThreeSignalsGreenTime : " + additionOfLastThreeSignalsGreenTime);
			if (additionOfLastThreeSignalsGreenTime < 3 * idealGreenTime) {
				int term1 = (3 * idealGreenTime) - additionOfLastThreeSignalsGreenTime;
				System.out.println("term1 : " + term1);
				int term2 = idealGreenTime + term1;
				System.out.println("term2 : " + term2);
//				System.out.println("expectedGreenTime : " + expectedGreenTime);
				newGreenTime = Math.min(expectedGreenTime, term2);
				// newGreenTime = Math.abs(expectedGreenTime - term2);
				signalsGreentime[signlNumber] = newGreenTime;
				return newGreenTime;
			} else {
				signalsGreentime[signlNumber] = newGreenTime;
				return newGreenTime;
			}
		} else if (expectedGreenTime < idealGreenTime) {
			newGreenTime = expectedGreenTime;
			signalsGreentime[signlNumber] = newGreenTime;
//			System.out.println("Here we are (Newgren time): " + newGreenTime);
			return newGreenTime;
		} else if (expectedGreenTime == idealGreenTime) {
			return newGreenTime;
		}
		System.out.println("code should not printhis line ...");
		return newGreenTime;
	}

}
