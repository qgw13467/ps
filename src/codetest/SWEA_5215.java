package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_5215 {
	static int N, L;
	static int[] visit;
	static int[][] arr;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int tc = Integer.parseInt(stringTokenizer.nextToken());
		for (int l = 1; l <= tc; l++) {

			max = 0;
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			N = Integer.parseInt(stringTokenizer.nextToken());
			L = Integer.parseInt(stringTokenizer.nextToken());

			arr = new int[2][N];
			visit = new int[N];

			for (int i = 0; i < N; i++) {
				stringTokenizer = new StringTokenizer(bufferedReader.readLine());

				arr[0][i] = Integer.parseInt(stringTokenizer.nextToken());
				arr[1][i] = Integer.parseInt(stringTokenizer.nextToken());
			}
//			System.out.println(N + " " + L);
//			System.out.println(Arrays.toString(arr[0]));
//			System.out.println(Arrays.toString(arr[1]));
//			System.out.println();

			fuc(0, 0, 0);
			System.out.println("#" + l + " " + max);
		}

	}

	static void fuc(int cnt, int point, int cal) {

		if (cal > L) {
			return;
		}

		if (cnt == N) {
//			System.out.println(point + " " + cal);
			if (max < point) {
				max = point;
			}
			return;
		}

		fuc(cnt + 1, point + arr[0][cnt], cal + arr[1][cnt]);
		fuc(cnt + 1, point, cal);
	}
}
