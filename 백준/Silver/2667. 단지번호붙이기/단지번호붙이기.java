import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static boolean[][] visited;
	static StringTokenizer stringTokenizer;
	static int n;
	static int count;
	static int danziSize;
	static ArrayList<Integer> list = new ArrayList<>();
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static Queue<Point> queue = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bufferedReader.readLine());

		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			String string = bufferedReader.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = string.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (arr[i][j] == 1) {

					count++;
					danziSize = 0;
					queue = new LinkedList<>();

					fuc(i, j);
					list.add(danziSize);
				}

			}
		}
		
		Collections.sort(list);
		System.out.println(count);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	static void fuc(int x, int y) {
		arr[x][y] = 0;
		danziSize++;

		for (int d = 0; d < 4; d++) {
			if (x + dx[d] >= 0 && x + dx[d] < n && y + dy[d] >= 0 && y + dy[d] < n && arr[x + dx[d]][y + dy[d]] == 1) {
				arr[x + dx[d]][y + dy[d]] = 0;
				queue.add(new Point(x + dx[d], y + dy[d]));

			}
		}
		
//		System.out.println(queue);

		while(!queue.isEmpty()) {
			Point point = queue.poll();
			fuc(point.x, point.y);
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
