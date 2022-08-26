package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class B_10026 {
	static int n;
	static int[][] color, noncolor;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int st, nst;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bufferedReader.readLine());
		color = new int[n][n];
		noncolor = new int[n][n];

		for (int i = 0; i < n; i++) {
			String string = bufferedReader.readLine();
			for (int j = 0; j < n; j++) {
				char c = string.charAt(j);
				color[i][j] = c - 'A';

				if (c == 'R') {
					noncolor[i][j] = 'G' - 'A';
				} else {
					noncolor[i][j] = c - 'A';
				}

			}
		}

//		for (int l = 0; l < n; l++) {
//			System.out.println(Arrays.toString(color[l]));
//		}
//		System.out.println();

//		for (int l = 0; l < n; l++) {
//			System.out.println(Arrays.toString(noncolor[l]));
//		}
//		System.out.println();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (color[i][j] != 0) {
//					System.out.println(i + " " + j);
					fuc(i, j, color[i][j]);

//					System.out.println();
//					for (int l = 0; l < n; l++) {
//						System.out.println(Arrays.toString(color[l]));
//					}
//					System.out.println();
				}

				if (noncolor[i][j] != 0) {
					fuc2(i, j, noncolor[i][j]);
//					for (int l = 0; l < n; l++) {
//						System.out.println(Arrays.toString(noncolor[l]));
//					}
//					System.out.println();

				}
			}
		}

		System.out.println(st + " " + nst);

	}

	static void fuc(int x, int y, int RGB) {

		st++;

		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y));
		color[x][y] = 0;
		while (!queue.isEmpty()) {
//			System.out.println(queue);
			Point point = queue.poll();
			int startx = point.x, starty = point.y;
			

			for (int d = 0; d < 4; d++) {

				if (startx + dx[d] >= 0 && startx + dx[d] < n && starty + dy[d] >= 0 && starty + dy[d] < n
						&& color[startx + dx[d]][starty + dy[d]] != 0
						&& RGB == color[startx + dx[d]][starty + dy[d]]) {
//					System.out.println("start: " + startx + " " + starty);
					color[startx + dx[d]][starty + dy[d]] = 0;
					Point temp = new Point(startx + dx[d], starty + dy[d]);
					queue.add(temp);

				}

			}
		}

	}

	static void fuc2(int x, int y, int RGB) {

		nst++;

		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y));
		noncolor[x][y] = 0;
		while (!queue.isEmpty()) {
//			System.out.println(queue);
			Point point = queue.poll();
			int startx = point.x, starty = point.y;
			noncolor[startx][starty] = 0;

			for (int d = 0; d < 4; d++) {

				if (startx + dx[d] >= 0 && startx + dx[d] < n && starty + dy[d] >= 0 && starty + dy[d] < n
						&& noncolor[startx + dx[d]][starty + dy[d]] != 0
						&& RGB == noncolor[startx + dx[d]][starty + dy[d]]) {
//					System.out.println("start: " + startx + " " + starty);
					noncolor[startx + dx[d]][starty + dy[d]] = 0;
					Point temp = new Point(startx + dx[d], starty + dy[d]);
					queue.add(temp);

				}

			}
		}

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
