

import java.util.Scanner;

public class SwitchTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N];
		int[] sw = new int[M];
		for (int i = 0; i < M; i++) {
			sw[i] = sc.nextInt();
		}

		for (int i = 0; i < sw.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if ((j+1) % sw[i] == 0) {
					if (arr[j] == 1) {
						arr[j] = 0;

					} else {
						arr[j] = 1;
					}
				}

			}
		}

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}
