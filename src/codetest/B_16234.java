package codetest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B_16234 {
	class Point {
		int x, y;
	}

	static int[][] arr = new int[51][51];
	static int[][] organ = new int[51][51];
	static HashMap<Integer, Integer> map = new HashMap<>();
	static int n;
	static int or = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(stringTokenizer.nextToken());
		int min = Integer.parseInt(stringTokenizer.nextToken());
		int max = Integer.parseInt(stringTokenizer.nextToken());

		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
				organ[i][j] = 0;
			}
		}

		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (organ[i][j] == 0) {
					temp = 0;
					temp = changOrgan(min, max, i, j);

					or++;
				}

			}
			System.out.println(temp);
		}

		for (int k = 0; k < n; k++) {
			for (int l = 0; l < n; l++) {
				System.out.print(organ[k][l] + " ");
			}
			System.out.println();
		}

	}

	static int changOrgan(int min, int max, int x, int y) {
		int sum = arr[x][y];
		if ((x - 1 > -1) && organ[x - 1][y] == 0) {
			int temp = arr[x][y] - arr[x - 1][y];
			temp = Math.abs(temp);
			if (temp >= min && temp <= max) {
				organ[x][y] = or;
				organ[x - 1][y] = or;
				sum += changOrgan(min, max, x - 1, y);

			}
		}
		if ((x + 1) < n && organ[x + 1][y] == 0) {

			int temp = arr[x][y] - arr[x + 1][y];
			temp = Math.abs(temp);
			if (temp >= min && temp <= max) {
				organ[x][y] = or;
				organ[x + 1][y] = or;
				sum += changOrgan(min, max, x + 1, y);
			}
		}
		if ((y - 1) > -1 && organ[x][y - 1] == 0) {

			int temp = arr[x][y] - arr[x][y - 1];
			temp = Math.abs(temp);
			if (temp >= min && temp <= max) {
				organ[x][y] = or;
				organ[x][y - 1] = or;
				sum += changOrgan(min, max, x, y - 1);
			}
		}
		if ((y + 1) < n && organ[x][y + 1] == 0) {

			int temp = arr[x][y] - arr[x][y + 1];
			temp = Math.abs(temp);
			if (temp >= min && temp <= max) {
				organ[x][y] = or;
				organ[x][y + 1] = or;
				sum += changOrgan(min, max, x, y + 1);
			}
		}

		return sum;

	}

}
