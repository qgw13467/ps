import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_16234 {
	static int n, r, l;
	static StringTokenizer stringTokenizer;
	static int[][] map, check;
	static ArrayList<int[]> list;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		n = Integer.parseInt(stringTokenizer.nextToken());
		l = Integer.parseInt(stringTokenizer.nextToken());
		r = Integer.parseInt(stringTokenizer.nextToken());

		map = new int[n][n];
		check = new int[n][n];

		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		System.out.println(fuc());

	}

	static int fuc() {
		int result = 0;
		while (true) {
			check = new int[n][n];
			boolean isMove = false;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (check[i][j] == 0) {
						
						
						int sum = fuc2(i, j);
						if (list.size() > 1) {
							
							System.out.println("======================");
							changeMap(sum);
							
							for(int l=0;l<n;l++) {
								System.out.println(Arrays.toString(map[i]));
							}
							System.out.println();
							
							isMove = true;
						}
					}
				}
			}
			if (!isMove)
				return result;
			result++;
		}

	}

	static void changeMap(int sum) {
		int avg = sum / list.size();
		for (int i = 0; i < list.size(); i++) {
			int x = list.get(i)[0];
			int y = list.get(i)[1];
			map[x][y] = avg;
		}
	}

	static int fuc2(int x, int y) {
		
		list = new ArrayList<>();
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { x, y });
		list.add(new int[] { x, y });
		check[x][y] = 1;
		int sum = map[x][y];

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					if (check[nx][ny] == 0) {
						int tmp = Math.abs(map[temp[0]][temp[1]] - map[nx][ny]);
						if (tmp >= l && tmp <= r) {
							check[nx][ny] = 1;
							queue.add(new int[] { nx, ny });
							list.add(new int[] { nx, ny });
							sum += map[nx][ny];
						}

					}
				}
			}
		}
		
		
		
		return sum;
	}
}
