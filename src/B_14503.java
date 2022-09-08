

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;

public class B_14503 {
	public static final String RESET = "\u001B[0m";
	public static final String FONT_RED = "\u001B[31m";
	static int n, m;
	static int[][] arr, v;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int x, y, d;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		n = Integer.parseInt(stringTokenizer.nextToken());
		m = Integer.parseInt(stringTokenizer.nextToken());
		arr = new int[n][m];
		v = new int[n][m];

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		x = Integer.parseInt(stringTokenizer.nextToken());
		y = Integer.parseInt(stringTokenizer.nextToken());
		d = Integer.parseInt(stringTokenizer.nextToken());

		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < m; j++) {
				v[i][j] = arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		v[x][y] = 1;
		count++;
		fuc1(x, y, d);

		System.out.println(count);
	}

	static void fuc1(int x, int y, int d) {

		for (int l = 1; l <= 4; l++) {
			int tempd = (d + 4 - l) % 4;
			int tempx = x + dx[tempd];
			int tempy = y + dy[tempd];
			if (tempx < 0 || tempx >= n || tempy < 0 || tempy >= m || arr[tempx][tempy] == 1) {
				continue;
			}

			if (arr[tempx][tempy] == 0 && v[tempx][tempy] == 0) {
				v[tempx][tempy] = 1;
				count++;

				System.out.println(count);
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {

						System.out.print(v[i][j] + " ");
					}
					System.out.println();
				}
				System.out.println();

				fuc1(tempx, tempy, tempd);
			}

		}

		int bx = x + dx[(d + 2) % 4];
		int by = y + dy[(d + 2) % 4];
		if (bx >= 0 && bx < n && by >= 0 && by < m) {
			if (arr[bx][by] == 0) {
				fuc1(bx, by, d);
			} else {
				System.out.println(count);
				System.exit(0);
			}
		}

	}
}
