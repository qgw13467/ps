package codetest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001 {
	static int[][] arr = new int[16][16];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());

		int cy = Integer.parseInt(stringTokenizer.nextToken());

		for (int tc = 1; tc <= cy; tc++) {
			stringTokenizer = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(stringTokenizer.nextToken());
			int m = Integer.parseInt(stringTokenizer.nextToken());

			for (int i = 1; i <= n; i++) {
				stringTokenizer = new StringTokenizer(bf.readLine());
				for (int j = 1; j <= n; j++) {
					arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
				}
			}

			for (int i = 1; i <= n; i++) {
				for (int j = 2; j <= n; j++) {
					arr[i][j] += arr[i][j - 1];
				}
			}

			for (int i = 2; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					arr[i][j] += arr[i - 1][j];
				}
			}

//			for (int i = 1; i <= n; i++) {
//				for (int j = 1; j <= n; j++) {
//					System.out.print(arr[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			int max = 0;
			for (int x2 = m; x2 <= n; x2++) {
				for (int y2 = m; y2 <= n; y2++) {
					int x1 = x2 - m + 1;
					int y1 = y2 - m + 1;
					int sum = 0;
					if (x1 > 1 && x2 > 1 && y1 > 1 && y2 > 1) {
						sum = arr[x2][y2] - arr[x1 - 1][y2] - arr[x2][y1 - 1] + arr[x1 - 1][y1 - 1];
					} else if (x1 > 1 && y1 == 1) {
						sum = arr[x2][y2] - arr[x1 - 1][y2];
					} else if (x1 == 1 && y1 > 1) {
						sum = arr[x2][y2] - arr[x2][y1 - 1];
					} else if (x1 == 1 && y1 == 1) {
						sum = arr[x2][y2];
					}

					if (max < sum) {
						max = sum;
					}

				}
			}

			System.out.println("#" + tc + " " + max);

		}

	}
}
