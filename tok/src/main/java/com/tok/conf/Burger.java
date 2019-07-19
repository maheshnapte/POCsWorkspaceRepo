package com.tok.conf;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Burger {

	public static void main(String[] args) {
		/*
		 * Scanner scanner = new Scanner(System.in); String str = scanner.nextLine();
		 * String strArr[] = str.split(" "); int[] coinArray = new int[strArr.length];
		 * for(int i=0;i<strArr.length;i++) coinArray[i] = Integer.parseInt(strArr[i]);
		 */

		int arr[] = { 5, 5, 20, 5 };
		System.out.print(getBurger(arr));
	}
	// modify the prototype of method getBurger as per problem statement.

	public static String getBurger(int[] customerAmount) {
		for (int i = 0; i < customerAmount.length; i++) {
			int sum = getSum(customerAmount, i);
			System.out.println(sum);
			int j = (i + 1) * 5;
			boolean st = j >= sum;
			System.out.println("st: "+st);
			if (!st) {
				return "false";
			}
		}
		return "true";
	}

	static int getSum(int[] inp, int index) {
		int sum = 0;
		for (int i = 0; i <= index; i++) {
			sum = sum + inp[i];
		}
		return sum;
	}
}