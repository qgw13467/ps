package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_3055 {
	static int[][] arr;
	static int r, c, time;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static StringTokenizer stringTokenizer;
	static Point target, start;
	static Queue<Point> water;
	static ArrayList<Point> rock;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		r = Integer.parseInt(stringTokenizer.nextToken());
		c = Integer.parseInt(stringTokenizer.nextToken());

		arr = new int[r][c];
		water = new LinkedList<>();
		rock = new ArrayList<>();
		time = -1;

		for (int i = 0; i < r; i++) {
			String string = bufferedReader.readLine();
			for (int j = 0; j < c; j++) {
				char temp = string.charAt(j);

				switch (temp) {
				case 'D':
					arr[i][j] = -2;
					target = new Point(i, j);
					break;
				case '.':
					arr[i][j] = Integer.MAX_VALUE;
					break;
				case '*':
					arr[i][j] = 1;
					water.add(new Point(i, j));
					break;
				case 'S':
					arr[i][j] = Integer.MAX_VALUE;
					start = new Point(i, j);
					break;
				case 'X':
					arr[i][j] = -3;
					rock.add(new Point(i, j));
					break;

				}

			}
		}

//		System.out.println(water);
//		System.out.println();

//		for (int i = 0; i < r; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
//		System.out.println();



		run(start.x, start.y, 0);

//		for (int i = 0; i < r; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
//		System.out.println();
		
		
		if (result == Integer.MAX_VALUE) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(result);
		}

	}

	static void run(int x, int y, int cnt) {
		waterSetting();
		if (x == target.x && y == target.y && result > cnt) {
			result = cnt;
		}

		for (int d = 0; d < 4; d++) {

			if (x + dx[d] >= 0 && x + dx[d] < r && y + dy[d] >= 0 && y + dy[d] < c && arr[x + dx[d]][y + dy[d]] != -3
					&& (arr[x + dx[d]][y + dy[d]] > cnt + 1 || arr[x + dx[d]][y + dy[d]] == -2)) {
				run(x + dx[d], y + dy[d], cnt + 1);
			}

		}

	}

	static void waterSetting() {

		if (water.isEmpty()) {
			return;
		}

		time++;

		int waterSize = water.size();
		for (int i = 0; i < waterSize; i++) {
			Point point = water.poll();
			if (arr[point.x][point.y] > time) {
				arr[point.x][point.y] = time;
			}

			for (int d = 0; d < 4; d++) {
				if (point.x + dx[d] >= 0 && point.x + dx[d] < r && point.y + dy[d] >= 0 && point.y + dy[d] < c
						&& arr[point.x + dx[d]][point.y + dy[d]] > time) {
					water.add(new Point(point.x + dx[d], point.y + dy[d]));
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
