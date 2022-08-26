package codetest;


import java.util.Scanner;

public class B_14501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] t = new int[20];
		int[] p = new int[20];

		int[] arr = new int[20];
		int[] check = new int[20];
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}

		for (int i = 0; i < n + 1; i++) {
			System.out.print(t[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < n + 1; i++) {
			System.out.print(p[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < n; i++) {

			if (check[i] == 1) {
				continue;
			}

			int max = 0;
			for (int j = 0; j < i; j++) {
				if (max < arr[j]) {
					max = arr[j];
				}
			}

			check[i] = 1;

			arr[i + t[i] - 1] += max;
			arr[i + t[i] - 1] += p[i];
			if (p[i + t[i] - 1] >= arr[i + t[i] - 1]) {

				arr[i + t[i] - 1] = p[i];
			}

			System.out.println(max);
			for (int k = 0; k < n + 1; k++) {
				System.out.print(arr[k] + " ");
			}
			System.out.println();
		}

	}
}
