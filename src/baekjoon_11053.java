

import java.util.Scanner;

public class baekjoon_11053 {
	final static boolean DEBUG = true;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[1001];
		int[] check = new int[1001];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 1; i < n; i++) {
			if (arr[i - 1] < arr[i]) {
				int maxTmp = 0;
				for (int k = 0; k < i; k++) {
					if (maxTmp < check[k]) {
						maxTmp = check[k];
					}
				}
				check[i] = maxTmp + 1;

			}
		}

		int max = check[0];

		for (int i = 0; i < n; i++) {
			if (max < check[i]) {
				max = check[i];
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(check[i] + " ");
		}

		System.out.println(max + 1);

	}

}
