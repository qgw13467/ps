package codetest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1227 {
	static int[][] arr = new int[100][100];
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int result;

	static Queue<Point> queue = new LinkedList<Point>();

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer;

		int startx = 0, starty = 0;

		for (int tc = 1; tc <= 10; tc++) {
			result = 0;
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			for (int i = 0; i < 100; i++) {
				stringTokenizer = new StringTokenizer(bufferedReader.readLine());
				String temp = stringTokenizer.nextToken();
				for (int j = 0; j < 100; j++) {
					arr[i][j] = temp.charAt(j) - '0';

					if (arr[i][j] == 2) {
						startx = i;
						starty = j;
					}
				}
			}

//			for(int i=0;i<100;i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}

			fuc(startx, starty);
			System.out.println("#" + tc + " " + result);

		}

	}

	static void fuc(int x, int y) {
		if (arr[x][y] == 3) {
			result = 1;
			return;
		}
		arr[x][y] = 1;

		for (int i = 0; i < 4; i++) {
			if (x + dx[i] >= 0 && x + dx[i] < 100 && y + dy[i] >= 0 && y + dy[i] < 100
					&& arr[x + dx[i]][y + dy[i]] != 1) {

				Point point = new Point();
				point.x = x + dx[i];
				point.y = y + dy[i];
				queue.add(point);
			}
		}

//		for (Point point : queue) {
//			System.out.println(point.x + " " + point.y);
//		}
//		System.out.println("************************");

		while (!queue.isEmpty()) {
			Point point = queue.poll();
			fuc(point.x, point.y);
		}

	}

	static class Point {
		int x, y;
	}

}
