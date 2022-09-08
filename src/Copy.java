

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copy {
	public static final String RESET = "\u001B[0m";
	public static final String FONT_RED = "\u001B[31m";
	static int n, m;
	static int[][] map, visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int x, y, d;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		n = Integer.parseInt(stringTokenizer.nextToken());
		m = Integer.parseInt(stringTokenizer.nextToken());
		map = new int[n][m];
		visited = new int[n][m];

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		x = Integer.parseInt(stringTokenizer.nextToken());
		y = Integer.parseInt(stringTokenizer.nextToken());
		d = Integer.parseInt(stringTokenizer.nextToken());

		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < m; j++) {
				visited[i][j] = map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		visited[x][y] = 1;
		count++;
		dfs(x, y, d);

		System.out.println(count);
	}

	static void dfs(int r, int c, int d) { // 2번

//	    1. 현재 위치를 청소한다.
//	    2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
//	    a.왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
//	    b.왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
//	    c.네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
//	    d.네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.

		for (int i = 0; i < 4; i++) { // 왼쪽부터 반시계방향

			int nd = (d + 3 - i) % 4;
			int nr = r + dr[nd];
			int nc = c + dc[nd];

			if (nr < 0 || nr >= n || nc < 0 || nc >= m || map[nr][nc] == 1) { // 범위 넘어가거나 벽이면 다음 방향
				continue;
			}

			// a. 아직 청소하지 않은 공간이 존재한다면
			if (visited[nr][nc] == 0 && map[nr][nc] == 0) {
				visited[nr][nc] = 1; // 현재 위치 청소
				count++;

				System.out.println(count);
				for (int l = 0; l < n; l++) {
					for (int j = 0; j < m; j++) {

						System.out.print(visited[l][j] + " ");
					}
					System.out.println();
				}
				System.out.println();

				dfs(nr, nc, nd);
			}

		}

		int backIdx = d + 2 < 4 ? d + 2 : d - 2;
		int backr = r + dr[backIdx];
		int backc = c + dc[backIdx];
		if (0 <= backr && backr <= n && 0 <= backc && backc <= m) {
			if (map[backr][backc] == 0) { // 뒤쪽 방햑 벽 아니어서 후진할 수 있을 때
				dfs(backr, backc, d); // 한칸 후진
			} else { // 뒤쪽 방향 벽이라 후진 못할 때
				System.out.println(count);
				System.exit(backc);
			}
		}

	}

}
