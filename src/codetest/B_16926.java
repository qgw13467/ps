package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_16926 {
	static int[][] arr;
	static int[][] result;
	static int n, m, round;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		n = Integer.parseInt(stringTokenizer.nextToken());
		m = Integer.parseInt(stringTokenizer.nextToken());
		round = Integer.parseInt(stringTokenizer.nextToken());
		arr = new int[n][m];
		result = new int[n][m];
		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}
		for (int l = 0; l < round; l++) {
			fuc(0, 0, 0);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = result[i][j];
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void fuc(int cnt, int x, int y) {
		if (cnt == n / 2 || cnt == m / 2) {

			return;
		}

		for (int i = n - 1 - cnt; i > x; i--) {
			result[i][y] = arr[i - 1][y];
		}

		for (int j = m - 1 - cnt; j > y; j--) {
			result[n - 1 - cnt][j] = arr[n - 1 - cnt][j - 1];
		}

		for (int i = x; i < n - 1 - cnt; i++) {
			result[i][m - 1 - cnt] = arr[i + 1][m - 1 - cnt];
		}

		for (int j = x; j < m - 1 - cnt; j++) {
			result[x][j] = arr[x][j + 1];
		}

		fuc(cnt + 1, x + 1, y + 1);

	}

}
