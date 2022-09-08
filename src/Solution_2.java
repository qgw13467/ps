import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2 {
	static int[][] arr, visit;
	static HashSet<Integer>[][] nujuck;
	static int n, result;
	static ArrayList<int[]> list, first,second;
	static StringTokenizer stringTokenizer;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String args[]) throws Exception {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bufferedReader.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			n = Integer.parseInt(stringTokenizer.nextToken());

			arr = new int[31][31];

			list = new ArrayList<>();

			nujuck = new HashSet[31][31];
			result = Integer.MAX_VALUE;

			for (int i = 0; i < 31; i++) {
				for (int j = 0; j < 31; j++) {
					nujuck[i][j] = new HashSet<Integer>();
				}
			}

			for (int k = 0; k < n; k++) {
				stringTokenizer = new StringTokenizer(bufferedReader.readLine());
				int x = Integer.parseInt(stringTokenizer.nextToken());
				int y = Integer.parseInt(stringTokenizer.nextToken());
				int dis = Integer.parseInt(stringTokenizer.nextToken());

				x += 15;
				y += 15;
				arr[x][y] = 1;
				list.add(new int[] { x, y, dis });

			}

			for(int i=0;i<31;i++) {
				System.out.println(Arrays.toString(arr[i]));
			}
			System.out.println();

//			for (int i = 0; i < 31; i++) {
//				for (int j = 0; j < 31; j++) {
//					int temp = checkCanOneCharge(i, j);
//					if (result < temp) {
//						result = temp;
//
//					}
//				}
//			}
			
			for(int k=1;k<=list.size();k++) {
				int[] temp = list.get(k-1);
				
				bfs(temp[0], temp[1], 0, temp[2], k);
			}
			
			
			for(int i=0;i<31;i++) {
				for(int j=0;j<31;j++) {
					if(nujuck[i][j].size() == list.size()) {
						result = checkCanOneCharge(i, j);
					}
				}
			}
			
			System.out.println("#" + test_case+" "+result);
		}

	}

	public static int checkCanOneCharge(int x, int y) {
		int sum = 0;
		for (int[] ints : list) {

			int distance = getDistance(x, y, ints[0], ints[1]);
			if (ints[2] > distance) {
				return Integer.MAX_VALUE;
			} else {
				sum += distance;
			}

		}

		return sum;

	}

//	public static void combination(int cnt, int start) {
//
//		if (cnt == 2) {
//			System.out.println(Arrays.toString(selected));
//			
//			return;
//		}
//
//		for (int i = start; i < 31 * 31; i++) {
//			int x = i / 31;
//			int y = i % 31;
//			selected[cnt] = element[i];
//			combination(cnt + 1, i + 1);
//		}
//
//	}

	static void bfs(int x, int y, int cnt, int d, int id) {

		visit = new int[31][31];
		visit[x][y] = 1;
		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[] { x, y, cnt++ });

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();

			if (visit[temp[0]][temp[1]] == 1) {
				continue;
			}

			if (temp[2] == d) {
				visit[temp[0]][temp[1]] = 1;
				nujuck[temp[0]][temp[1]].add(id);
			} else if (temp[2] < d) {
				visit[temp[0]][temp[1]] = 1;
				nujuck[temp[0]][temp[1]].add(id);

				for (int direc = 0; direc < 4; direc++) {
					int delx = temp[0] + dx[direc];
					int dely = temp[1] + dy[direc];

					if (delx < 0 || delx > 30 || dely < 0 || dely > 30 || visit[delx][delx] == 1) {
						continue;
					}

					queue.add(new int[] { delx, dely, cnt++ });

				}

			}

		}

	}

	static int getDistance(int x1, int y1, int x2, int y2) {

		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}
