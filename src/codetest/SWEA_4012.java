package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4012 {

	static int N;
	static int[][] arr = new int[N][N];
	static int[] visit;

	static int food1, food2;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int tc = Integer.parseInt(stringTokenizer.nextToken());
		for (int l = 1; l <= tc; l++) {

			min = Integer.MAX_VALUE;

			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			N = Integer.parseInt(stringTokenizer.nextToken());
			arr = new int[N][N];
			visit = new int[N];
			for (int i = 0; i < N; i++) {
				stringTokenizer = new StringTokenizer(bufferedReader.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
				}
			}

			fuc(0, N / 2);

			System.out.println("#" + l + " " + min);
		}
	}

	static void fuc(int cnt, int n) {
		if (n == 0) {
			fuc2();
//			System.out.println(Arrays.toString(visit));
//			System.out.println(food1 + " " + food2);
//			System.out.println(min);
			return;
		}

		if (cnt == N) {
			return;
		}

		visit[cnt] = 1;
		fuc(cnt + 1, n - 1);
		visit[cnt] = 0;
		fuc(cnt + 1, n);

	}

	static void fuc2() {
		food1 = 0;
		food2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i] == 1 && visit[j] == 1) {
					food1 += arr[i][j];
				}
				if (visit[i] == 0 && visit[j] == 0) {
					food2 += arr[i][j];
				}
			}
		}
		int temp = Math.abs(food1 - food2);
		if (min > temp) {
			min = temp;
		}
	}
}
