import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_4963 {

	static int n, m;
	static int arr[][];
	static int visit[][];
	static int count;
	static StringTokenizer stringTokenizer;
	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

	static Queue<Island> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			n = Integer.parseInt(stringTokenizer.nextToken());
			m = Integer.parseInt(stringTokenizer.nextToken());
			if (n == 0 && m == 0) {
				break;
			}

			arr = new int[m][n];
			visit = new int[m][n];

			for (int i = 0; i < m; i++) {
				stringTokenizer = new StringTokenizer(bufferedReader.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
				}
			}

//			for (int[] ints : arr) {
//				System.out.println(Arrays.toString(ints));
//			}
//			System.out.println();
			
			
			count = 0;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == 1 && visit[i][j] == 0) {
						
						bfs(i, j);
						count++;
//						System.out.println(count);
					}
				}
			}
//			System.out.println();
			System.out.println(count);
//			System.out.println();

		}
	}

	static void bfs(int x, int y) {

		if (arr[x][y] == 1 && visit[x][y] == 0) {
			visit[x][y] = 1;
			for (int i = 0; i < 8; i++) {
				if (x + dx[i] >= 0 && x + dx[i] < m && y + dy[i] >= 0 && y + dy[i] < n && arr[x + dx[i]][y + dy[i]] == 1
						&& visit[x + dx[i]][y + dy[i]] == 0) {
					Island island = new Island();
					island.x = x + dx[i];
					island.y = y + dy[i];
					queue.add(island);

					
				}
			}
		}

		while (!queue.isEmpty()) {
			Island island = queue.poll();
//			System.out.println(island);
			bfs(island.x, island.y);
		}
	}
}

class Island {
	int x, y;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return x + " " + y;
	}
}