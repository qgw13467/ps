package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2630 {
	static int[][] arr;
	static int n;
	static StringTokenizer stringTokenizer;
	static int wCount, bCount;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		n = Integer.parseInt(stringTokenizer.nextToken());
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		fuc(n, 0, 0);

		System.out.println(wCount);
		System.out.println(bCount);

	}

	static void fuc(int n, int x, int y) {
		if (n == 1) {
			if (arr[x][y] == 1) {
				bCount++;
			}

			if (arr[x][y] == 0) {
				wCount++;
			}
			return;
		}

		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum += arr[x + i][y + j];
			}
		}
		if (sum == n * n) {
			bCount++;
			return;
		}
		if (sum == 0) {
			wCount++;
		}

		if (sum != 0) {
			fuc(n / 2, x, y);
			fuc(n / 2, x + (n / 2), y);
			fuc(n / 2, x, y + (n / 2));
			fuc(n / 2, x + (n / 2), y + (n / 2));

		}

	}
}
