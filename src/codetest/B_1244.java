package codetest;


import java.util.Scanner;

public class B_1244 {
	static int[] arr = new int[101];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		for (int i = 1; i <= n; i++) {
			arr[i] = scanner.nextInt();

		}
//		for (int l = 1; l <= n; l++) {
//			System.out.print(arr[l] + " ");
//		}
//		System.out.println();
		int m = scanner.nextInt();

		for (int i = 1; i <= m; i++) {
			int gen = scanner.nextInt();
			int num = scanner.nextInt();

			if (gen == 1) {
				for (int j = 1; j <= n; j++) {
					if (j % num == 0) {
						swap(j);
					}
				}
			}

			else {
				int k = 1;
				swap(num);
				while (arr[num - k] >= 0 && arr[num + k] <= n - 1) {
					if (arr[num - k] != arr[num + k]) {
						break;
					}
					swap(num - k);
					swap(num + k);
					k++;

				}
			}
//			for (int l = 1; l <= n; l++) {
//				System.out.print(arr[l] + " ");
//			}
//			System.out.println();
		}

		for (int i = 1; i <= n; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	static void swap(int i) {
		if (arr[i] == 1) {
			arr[i] = 0;
		} else {
			arr[i] = 1;
		}
	}

}
