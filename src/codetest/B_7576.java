package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_7576 {
	static int[][] arr;
	static int r, c, time = 0;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int minumCount = 0;
	static int full = 0;
	static StringTokenizer stringTokenizer;
	static ArrayList<Point> points;
	static ArrayList<Point> newPoints;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		c = Integer.parseInt(stringTokenizer.nextToken());
		r = Integer.parseInt(stringTokenizer.nextToken());

		arr = new int[r][c];
		points = new ArrayList<>();
		newPoints = new ArrayList<>();

		for (int i = 0; i < r; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < c; j++) {
				arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
				if (arr[i][j] == 1) {
					points.add(new Point(i, j));
				}
				if (arr[i][j] == -1) {
					minumCount++;
				}

			}
		}

//		for (int i = 0; i < r; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}

		do {
			time++;
			newPoints = new ArrayList<>();
			for (int d = 0; d < 4; d++) {
				int pointsSize = points.size();
				for (int i = 0; i < pointsSize; i++) {
					Point point = points.get(i);
					if (point.x + dx[d] >= 0 && point.x + dx[d] < r && point.y + dy[d] >= 0 && point.y + dy[d] < c
							&& arr[point.x + dx[d]][point.y + dy[d]] == 0) {
						arr[point.x + dx[d]][point.y + dy[d]] = 1;
						newPoints.add(new Point(point.x + dx[d], point.y + dy[d]));
					}

				}

			}

			full += points.size();
			points.clear();
			points = newPoints;

//			System.out.println(newPoints);
//			System.out.println(full + " " + minumCount + " " + time);
//			System.out.println();

		} while (points.size() != 0);

		if ((full + minumCount) != r * c) {
			System.out.println(-1);
		} else {
			System.out.println(time - 1);

		}

	}

	static class Point {
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		int x, y;

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return x + " " + y;
		}
	}

}
