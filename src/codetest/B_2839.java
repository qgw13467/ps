package codetest;
import java.util.Arrays;
import java.util.Scanner;

public class B_2839 {
	static int[] arr;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int count = 0;
		arr = new int[5001];

		arr[3] = 1;

		arr[5] = 1;

		for (int i = 6; i < n + 1; i++) {

			if (arr[i - 3] == 0 && arr[i - 5] != 0) {
				arr[i] = arr[i - 5] + 1;
				continue;
			}

			if (arr[i - 3] != 0 && arr[i - 5] == 0) {
				arr[i] = arr[i - 3] + 1;
				continue;
			}

			if (arr[i - 3] != 0 && arr[i - 5] != 0) {
				if (arr[i - 3] >= arr[i - 5]) {
					arr[i] = arr[i - 5] + 1;
				} else {
					arr[i] = arr[i - 3] + 1;
				}

			}
		}
//		System.out.println(Arrays.toString(arr));

		if (arr[n] != 0) {
			System.out.println(arr[n]);
		} else {
			System.out.println(-1);
		}
	}
}
