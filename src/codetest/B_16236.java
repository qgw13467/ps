package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_16236 {
	static int n;
	static int[][] arr;
	static StringTokenizer stringTokenizer;
	static int size, num;
	static ArrayList<Point> size1, size2, size3, size4, size5, size6;
	static Point start;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bufferedReader.readLine());

		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());

				switch (arr[i][j]) {
				case 9:
					start = new Point(i, j);
					break;
				case 1:
					size1.add(new Point(i, j));
					break;
				case 2:
					size2.add(new Point(i, j));
					break;
				case 3:
					size3.add(new Point(i, j));
					break;
				case 4:
					size4.add(new Point(i, j));
					break;
				case 5:
					size5.add(new Point(i, j));
					break;
				case 6:
					size6.add(new Point(i, j));
					break;

				}
			}
		}
		size = 1;
		num = 0;

	}

	static int getDistance(int x, int y, int tx, int ty) {

		return Math.abs(x - tx) + Math.abs(y - ty);
	}

	static Point findCanEad(int x, int y) {
		Point temp = new Point(0, 0);
		int distane = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == x && j == y) {
					continue;
				}
				int tempDistance = getDistance(x, y, i, j);
				if (arr[i][j] <= size && distane > tempDistance) {
					distane = tempDistance;
					temp.x = i;
					temp.y = j;
				}
			}
		}
		return temp;

	}

	static class Point {

		public Point() {
			// TODO Auto-generated constructor stub
		}

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
