package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_21610 {
	static int[][] arr;
	static int[][] command = new int[2][];
	static boolean[][] visited;
	static int r, c;
	static StringTokenizer stringTokenizer;
	static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static ArrayList<Cloud> clouds = new ArrayList<>();
	static ArrayList<Cloud> preClouds = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		r = Integer.parseInt(stringTokenizer.nextToken());
		c = Integer.parseInt(stringTokenizer.nextToken());
		command = new int[2][c];
		arr = new int[r][r];
		visited = new boolean[r][r];
		for (int i = 0; i < r; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < r; j++) {
				arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

//		for (int i = 0; i < r; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
//		System.out.println();

		for (int i = 0; i < c; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			command[0][i] = Integer.parseInt(stringTokenizer.nextToken());
			command[1][i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		Cloud cloud = new Cloud();
		cloud.x = r - 1;
		cloud.y = 0;
		clouds.add(cloud);
		cloud = new Cloud();
		cloud.x = r - 1;
		cloud.y = 1;
		clouds.add(cloud);
		cloud = new Cloud();
		cloud.x = r - 2;
		cloud.y = 0;
		clouds.add(cloud);
		cloud = new Cloud();
		cloud.x = r - 2;
		cloud.y = 1;
		clouds.add(cloud);

//		System.out.println(clouds);
//		System.out.println();

		for (int k = 0; k < c; k++) {
			int temp = clouds.size();
			for (int p = 0; p < temp; p++) {
				cloud = clouds.get(0);
				cloud.x = (cloud.x + (dx[command[0][k] - 1] * command[1][k] % r) + r) % r;
				cloud.y = (cloud.y + (dy[command[0][k] - 1] * command[1][k] % r) + r) % r;
//				System.out.println("dx[command[0][k] - 1]: " + dx[command[0][k] - 1] + ", dy[command[0][k] - 1]: "
//						+ dy[command[0][k] - 1]);
//				System.out.println("cloud.x :" + cloud.x + ", cloud.y :" + cloud.y);

				clouds.remove(0);
				clouds.add(cloud);
			}

			// 구름 있는 칸 1씩증가
			for (int p = 0; p < clouds.size(); p++) {
				arr[clouds.get(p).x][clouds.get(p).y]++;
			}

			// 대각선에 숫자 있으면 증가
			for (int p = 0; p < clouds.size(); p++) {
				int sum = 0;
				if (clouds.get(p).x - 1 >= 0 && clouds.get(p).y - 1 >= 0
						&& arr[clouds.get(p).x - 1][clouds.get(p).y - 1] > 0) {
					sum++;
				}
				if (clouds.get(p).x - 1 >= 0 && clouds.get(p).y + 1 < r
						&& arr[clouds.get(p).x - 1][clouds.get(p).y + 1] > 0) {
					sum++;
				}
				if (clouds.get(p).x + 1 < r && clouds.get(p).y - 1 >= 0
						&& arr[clouds.get(p).x + 1][clouds.get(p).y - 1] > 0) {
					sum++;
				}
				if (clouds.get(p).x + 1 < r && clouds.get(p).y + 1 < r
						&& arr[clouds.get(p).x + 1][clouds.get(p).y + 1] > 0) {
					sum++;
				}

				arr[clouds.get(p).x][clouds.get(p).y] += sum;
			}

//			for (int i = 0; i < r; i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}

			// 이전 구름위치 지움
//			temp = preClouds.size();
//			for (int i = 0; i < temp; i++) {
//				preClouds.remove(0);
//			}

			// 현재의 구름을 이전 구름위치로 저장
			temp = clouds.size();
			for (int i = 0; i < temp; i++) {
				preClouds.add(clouds.get(i));
				visited[clouds.get(i).x][clouds.get(i).y] = true;
			}
			clouds.clear();

			// arr을 돌면서 구름을 생성하고 저장
			for (int i = 0; i < r; i++) {
				tag: for (int j = 0; j < r; j++) {
					if (arr[i][j] >= 2) {
						cloud = new Cloud();
						cloud.x = i;
						cloud.y = j;

						if (visited[cloud.x][cloud.y] == true) {

							continue tag;
						}
						arr[i][j] -= 2;
						clouds.add(cloud);
					}
				}
			}

			for (int i = 0; i < preClouds.size(); i++) {
				visited[preClouds.get(i).x][preClouds.get(i).y] = false;
			}

			preClouds.clear();

//			System.out.println();
//
//			System.out.println(clouds);
//			System.out.println("================================");

		}
		int result = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < r; j++) {
				result += arr[i][j];
			}
		}

		System.out.println(result);

	}
}

class Cloud {
	int x, y;

	public Cloud() {
	}

	public Cloud(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return x + " " + y;
	}
}
