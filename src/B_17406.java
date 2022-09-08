
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_17406 {

	static int N, M, K;
	static int[][] arr;
	static int[][] result;
	static int[][] RCSs;
	static int r, c, s;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		N = Integer.parseInt(stringTokenizer.nextToken());
		M = Integer.parseInt(stringTokenizer.nextToken());
		K = Integer.parseInt(stringTokenizer.nextToken());
		System.out.println("" + N + M + K);
		arr = new int[N + 1][M + 1];
		for (int i = 1; i < N + 1; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 1; j < M + 1; j++) {
				arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());

			}
		}

		for (int i = 1; i < N + 1; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}

		RCSs = new int[3][K];
		for (int l = 0; l < K; l++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

			RCSs[0][l] = Integer.parseInt(stringTokenizer.nextToken());
			RCSs[1][l] = Integer.parseInt(stringTokenizer.nextToken());
			RCSs[2][l] = Integer.parseInt(stringTokenizer.nextToken());

		}
		fuc(0);

	}

	static void fuc(int cnt) {
		if (cnt == K) {
			result = new int[N + 1][M + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					result[i][j] = arr[i][j];
				}
			}
			for (int l = 0; l < K; l++) {
				System.out.println("" + RCSs[0][l] + " " + RCSs[1][l] + " " + RCSs[2][l]);
			}
			return;

		}

		for (int l = cnt; l < K; l++) {
			int tempr = RCSs[0][cnt];
			int tempc = RCSs[1][cnt];
			int temps = RCSs[2][cnt];
			RCSs[0][cnt] = RCSs[0][l];
			RCSs[1][cnt] = RCSs[1][l];
			RCSs[2][cnt] = RCSs[2][l];
			RCSs[0][l] = tempr;
			RCSs[1][l] = tempc;
			RCSs[2][l] = temps;
			fuc(cnt + 1);
			tempr = RCSs[0][cnt];
			tempc = RCSs[1][cnt];
			temps = RCSs[2][cnt];
			RCSs[0][cnt] = RCSs[0][l];
			RCSs[1][cnt] = RCSs[1][l];
			RCSs[2][cnt] = RCSs[2][l];
			RCSs[0][l] = tempr;
			RCSs[1][l] = tempc;
			RCSs[2][l] = temps;

		}
	}

	static void cir(int x, int y, int dis) {
		if (dis == 1) {
			return;
		}

		int temp1 = result[x - s][y - s];

		for (int i = x - dis; i < x + dis; i++) {
			result[i][y - s] = result[i + 1][y - s];
		}

		for (int j = y - s; j < y + s; j++) {
			result[x + s][j] = result[x + s][j + 1];
		}

		for (int i = x + s; i > x - s; i--) {
			result[i][y + s] = result[i - 1][y + s];
		}

		for (int j = y + s; j > y - s; j--) {
			result[x - s][j] = result[x - s][j - 1];
		}

		result[x - s][y - s + 1] = temp1;

		cir(x, y, dis - 1);
	}
}
