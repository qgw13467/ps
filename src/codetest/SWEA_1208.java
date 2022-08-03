package codetest;

import java.util.Scanner;

public class SWEA_1208 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {

			int[] arr = new int[101];
			int n = scanner.nextInt();

			for (int l = 1; l <= 100; l++) {
				arr[l] = scanner.nextInt();
			}

			for (int l = 0; l < n; l++) {

				int min = arr[0];
				int max = arr[0];
				int minx = 0;
				int maxx = 0;
				for (int i = 1; i <= 100; i++) {
					if (min > arr[i]) {
						min = arr[i];
						minx = i;
					}
					if (max < arr[i]) {
						max = arr[i];
						maxx = i;
					}
				}

				arr[maxx] -= 1;
				arr[minx] += 1;

			}
			int result = Integer.MAX_VALUE;
			for (int l = 1; l <= 100; l++) {
				int min = arr[0];
				int max = arr[0];
				for (int i = 1; i <= 100; i++) {
					if (min > arr[i]) {
						min = arr[i];
					}
					if (max < arr[i]) {
						max = arr[i];
					}
				}

				if (result > (max - min)) {
					result = (max - min);
				}

			}
			System.out.println("#" + test_case + " " + (result - 1));

		}

	}
}
