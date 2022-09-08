import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1 {

	static int[][] arr;
	static int all, max, min, n;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static StringTokenizer stringTokenizer;

	static ArrayList<Point> list;

	static class Point {
		public Point() {

		}

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		int x, y;
	}

	public static void main(String args[]) throws Exception {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bufferedReader.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {

			n = Integer.parseInt(bufferedReader.readLine());
			arr = new int[n][n];
			list = new ArrayList<>();
			max = 0;
			min = Integer.MAX_VALUE;
			all = 0;

			for (int i = 0; i < n; i++) {
				stringTokenizer = new StringTokenizer(bufferedReader.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
					
					if( i>0 && i<n-1 && j>0 && j<n-1 && arr[i][j] ==1 ) {
						list.add(new Point(i, j));
						all++;
					}

				}
			}

//			for (int i = 0; i < n; i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
//			System.out.println();

			fuc(0, 0);

			System.out.println("#" + test_case + " " + min);
		}

	}

	static void fuc(int start, int cnt) {

		if (all - start + cnt < max) {
			return;
		}

		if (start == all) {
			int blank = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == 2) {
						blank++;
					}
				}
			}

			if (max < cnt) {
				max = cnt;
				min = blank;
			} else if (max == cnt) {
				if (min > blank) {
					min = blank;
				}
			}

//			System.out.println("====================");
//			for (int i = 0; i < n; i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
//			System.out.println(blank + " " + max + " " + min);
//			System.out.println();

			return;

		}

		Point point = list.get(start);

		for (int d = 0; d < 4; d++) {

			if (canAppend(point.x, point.y, d) == 1) {

				setting(point.x, point.y, d, 2);
				fuc(start + 1, cnt + 1);
				setting(point.x, point.y, d, 0);
			}
		}

		fuc(start + 1, cnt);

	}

	static void setting(int x, int y, int d, int init) {
		while (true) {
			x = x + dx[d];
			y = y + dy[d];

			if (x < 0 || x >= n || y < 0 || y >= n) {
				break;
			}

			arr[x][y] = init;

		}
	}

	static int canAppend(int x, int y, int d) {
		while (true) {
			x = x + dx[d];
			y = y + dy[d];
			if (x < 0 || x >= n || y < 0 || y >= n) {
				break;
			}
			if (arr[x][y] != 0) {
				return 0;
			}
		}
		return 1;
	}

}
