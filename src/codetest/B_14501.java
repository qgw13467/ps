package codetest;

import java.util.Scanner;

public class B_14501 {
	final static boolean debug = false;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] t = new int[21];
		int[] p = new int[21];

		int[] arr = new int[21];
		int n = sc.nextInt();
		int result = 0;
		for (int i = 1; i <= n; i++) {

			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}

		if (debug) {
			for (int i = 1; i <= n + 1; i++) {
				System.out.print(t[i] + " ");
			}
			System.out.println();

			for (int i = 1; i <= n + 1; i++) {
				System.out.print(p[i] + " ");
			}
			System.out.println();
		}

		for (int i = 1; i <= n; i++) {
			arr[i + 1] = Math.max(arr[i + 1], arr[i]);
			arr[i + t[i]] = Math.max(arr[i + t[i]], arr[i] + p[i]);

		}

		if (debug) {
			for (int i = 1; i <= n + 1; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}

		for (int i = 1; i <= n + 1; i++) {
			if (result < arr[i]) {
				result = arr[i];
			}
		}

		System.out.println(result);

	}
}