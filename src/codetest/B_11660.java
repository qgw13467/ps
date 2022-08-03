package codetest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11660 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(stringTokenizer.nextToken());
		int m = Integer.parseInt(stringTokenizer.nextToken());

		int[][] arr = new int[n + 1][n + 1];
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

//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= n; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}

		for (int i = 0; i < m; i++) {
			stringTokenizer = new StringTokenizer(bf.readLine());
			int x1, y1, x2, y2;
			x1 = Integer.parseInt(stringTokenizer.nextToken());
			y1 = Integer.parseInt(stringTokenizer.nextToken());
			x2 = Integer.parseInt(stringTokenizer.nextToken());
			y2 = Integer.parseInt(stringTokenizer.nextToken());
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
			System.out.println(sum);
		}

	}
}
