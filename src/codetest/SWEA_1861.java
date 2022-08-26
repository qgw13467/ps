package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1861 {
	static int[][] arr;
	static int t;
	static int n;
	static int x, y, max;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		t = Integer.parseInt(stringTokenizer.nextToken());

		for (int tc = 1; tc <= t; tc++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			n = Integer.parseInt(stringTokenizer.nextToken());

			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				stringTokenizer = new StringTokenizer(bufferedReader.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
				}
			}

//			for (int i = 0; i < n; i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
//			System.out.println();
			max = 0;
			int result = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int temp = fuc(i, j);
					if (max < temp) {

						result = arr[i][j];
						max = fuc(i, j);
					} else if (max == temp && result > arr[i][j]) {
						result = arr[i][j];
					}
				}
			}

			System.out.println("#" + tc + " " + result + " " + max);

		}

	}

	static int fuc(int x, int y) {
		int result = 0;

		result += 1;

		for (int i = 0; i < 4; i++) {

			if (x + dx[i] >= 0 && x + dx[i] < n && arr[x + dx[i]][y] == (arr[x][y] + 1)) {
				result += fuc(x + dx[i], y);
			}

			else if (y + dy[i] >= 0 && y + dy[i] < n && arr[x][y + dy[i]] == (arr[x][y] + 1)) {
				result += fuc(x, y + dy[i]);
			}

		}

		return result;

	}

}
