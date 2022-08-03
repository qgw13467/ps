package codetest;

import java.util.Arrays;
import java.util.Scanner;

public class B_20055 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int n2 = n * 2;
		int[] arr = new int[n * 2];
		int[] robot = new int[2 * n];
		for (int i = 0; i < 2 * n; i++) {
			arr[i] = scanner.nextInt();

		}

		int round = 0;
		int count = 0;
		int start = 0;
		while (true) {

			if (start < 0) {
				start = (start + n2) % n2;
			}

			System.out.println(Arrays.toString(arr));
			System.out.println(Arrays.toString(robot));
			System.out.println();

			for (int i = n2 - 1; i >= 0; i--) {
				if (robot[(start + i) % n2] == 1 && arr[(start + i + 1) % n2] > 0) {
					robot[(start + i) % n2] = 0;
					robot[(start + i + 1) % n2] = 1;
					arr[(start + i + 1) % n2] -= 1;
				}

				if (arr[(start + i + 1) % n2] == 0) {
					count++;
				}
			}

			System.out.println(Arrays.toString(arr));
			System.out.println(Arrays.toString(robot));
			System.out.println();

			if (robot[start] == 0 && arr[start] > 0) {
				robot[start] = 1;
				arr[start] -= 1;
				if (arr[start] == 0) {
					count++;
				}
			}

			System.out.println(Arrays.toString(arr));
			System.out.println(Arrays.toString(robot));
			System.out.println();
			System.out.println();
			System.out.println();
			round++;
			start--;
			if (count == k) {
				break;

			}

			if (round == 5) {
				break;
			}
		}

		System.out.println(round);
	}
}
