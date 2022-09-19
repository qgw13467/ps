import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B_21608 {
	static int[][] map;
	static StringTokenizer stringTokenizer;
	static int N;
	static HashMap<Integer, HashSet<Integer>> list = new HashMap<>();

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int answer = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bufferedReader.readLine());

		map = new int[N + 1][N + 1];

		for (int i = 0; i < N * N; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int num = Integer.parseInt(stringTokenizer.nextToken());
			HashSet<Integer> tempSet = new HashSet<>();
			
			for (int k = 0; k < 4; k++) {
				tempSet.add(Integer.parseInt(stringTokenizer.nextToken()));
			}

			list.put(num, tempSet);


			int rx = 0;
			int ry = 0;
			int near = -1;
			int empty = -1;	
			
			for (int j = 1; j <= N; j++) {
				

				
				for (int k = 1; k <= N; k++) {
					int tempNear = 0;
					int tempEmpty = 0;
					if (map[j][k] != 0) {
						continue;
					}
					for (int z = 0; z < 4; z++) {
						int x = j + dx[z];
						int y = k + dy[z];
						if (x <= 0 || x > N || y <= 0 || y > N) {
							continue;
						}

						if (map[x][y] > 0 && check(tempSet, map[x][y])) {
							tempNear++;
						} else if (map[x][y] == 0) {
							tempEmpty++;
						}
					}
					if (tempNear > near) {
						near = tempNear;
						empty = tempEmpty;
						rx = j;
						ry = k;
					} else if (tempNear == near && tempEmpty > empty) {
						near = tempNear;
						empty = tempEmpty;
						rx = j;
						ry = k;
					}
				}
			}
			

			map[rx][ry] = num;
			
			for(int k=1;k<=N;k++) {
				System.out.println(Arrays.toString(map[k]));
			}
			System.out.println();

		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					int x = i + dx[k];
					int y = j + dy[k];
					if (x <= 0 || x > N || y <= 0 || y > N) {
						continue;
					}
					if (list.get(map[i][j]).contains(map[x][y])) {
						cnt++;
					}
				}

				if (cnt == 0) {
					answer += 0;
				} else if (cnt == 1) {
					answer += 1;
				} else if (cnt == 2) {
					answer += 10;
				} else if (cnt == 3) {
					answer += 100;
				} else if (cnt == 4) {
					answer += 1000;
				}

			}

		}
		System.out.println(answer);
	}

	static boolean check(HashSet<Integer> set, int num) {
		for (Integer integer : set) {
			if (integer == num) {
				return true;
			}
		}
		return false;
	}

}
