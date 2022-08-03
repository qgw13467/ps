package codetest;

import java.util.ArrayList;

public class fino {
	public static void main(String[] args) {

		ArrayList<Integer> arr = new ArrayList<>();

		System.out.println(((-1) % 8) + 8);
		int sumToNine = sum1to9(9);
		System.out.println(sumToNine);

	}

	static int sum1to9(int n) {

		if (n == 1) {
			return 1;
		}
		int result = n + sum1to9(n - 1);
		return result;
	}

}
