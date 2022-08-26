package codetest;


import java.util.Scanner;

public class SWEA_1954 {
	public static void main(String[] args) {

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		for (int tc = 1; tc <= n; tc++) {
			int k = scanner.nextInt();
			int[][] arr = new int[k][k];

			int num = 1;
			int x = 0;
			int y = 0;
			int vector = 0;
			while (true) {
				if (num == k * k + 1) {
					break;
				}

				if ((x + dx[vector]) < 0 || (x + dx[vector]) > (k - 1) || (y + dy[vector]) < 0
						|| (y + dy[vector]) > (k - 1) || arr[x + dx[vector]][y + dy[vector]] != 0) {
					vector++;
					if (vector > 3) {
						vector = 0;
					}
				}

				arr[x][y] = num;
				x = x + dx[vector];
				y = y + dy[vector];

				num++;
			}

			System.out.println("#" + tc);
			for (int i = 0; i < k; i++) {
				for (int j = 0; j < k; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}

	}
}
