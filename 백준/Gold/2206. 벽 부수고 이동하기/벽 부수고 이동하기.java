import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[][][] isVisit;
	static int R;
	static int C;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().trim().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);

		map = new int[R][C];
		isVisit = new int[R][C][2];
		for (int i = 0; i < R; i++) {
			map[i] = Arrays.stream(br.readLine().trim().split("")).mapToInt(Integer::parseInt).toArray();
		}

		bfs();
	}

	static void bfs() {
		Queue<int[]> que = new ArrayDeque<>();
		que.add(new int[] { 0, 0, 0 });
		isVisit[0][0][0] = 1;

		while (!que.isEmpty()) {
			int[] now = que.poll();
			int cnt = isVisit[now[0]][now[1]][now[2]];
			int wall = now[2];
			if (now[0] == R - 1 && now[1] == C - 1) {
				System.out.println(cnt);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int y = now[0] + dy[i];
				int x = now[1] + dx[i];
				if (y < 0 || y >= R || x < 0 || x >= C)
					continue;

				// 그냥 들어가도 되면
				if (map[y][x] == 0 && isVisit[y][x][wall] == 0) {
					que.add(new int[] { y, x, wall });
					isVisit[y][x][wall] = cnt + 1;
				}

				// 벽을 뚫고 지나가야 되면
				if (map[y][x] == 1 && wall == 0 && isVisit[y][x][wall] == 0) {
					que.add(new int[] { y, x, wall + 1 });
					isVisit[y][x][wall + 1] = cnt + 1;
				}
			}
			
				
//			System.out.println(cnt);
//			for(int i=0;i<R;i++) {
//				for(int j=0;j<C;j++) {
//					System.out.print(isVisit[i][j][0]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//			
//			for(int i=0;i<R;i++) {
//				for(int j=0;j<C;j++) {
//					System.out.print(isVisit[i][j][1]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		System.out.println(-1);

	}

	static class Dst {

		public Dst() {
		}

		public Dst(int dst, int check) {
			this.check = check;
			this.dst = dst;
		}

		int dst, check;
	}

	static class Point {
		int x, y, check;

		public Point() {
			// TODO Auto-generated constructor stub
		}

		public Point(int x, int y, int check) {
			this.check = check;
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return x + " " + y + " " + check;
		}
	}
}
