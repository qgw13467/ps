package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SWEA_2819 {
	static StringTokenizer stringTokenizer;
	static int[][] arr;
	static int tc;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static HashSet<String> hashSet = new HashSet<>();
	static int[] num = new int[7];

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		tc = Integer.parseInt(stringTokenizer.nextToken());

		for (int t = 1; t <= tc; t++) {
			hashSet.clear();
			num = new int[7];
			arr = new int[4][4];
			for (int i = 0; i < 4; i++) {
				stringTokenizer = new StringTokenizer(bufferedReader.readLine());
				for (int j = 0; j < 4; j++) {
					arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());

				}
			}

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					fuc(i, j, 0);
				}
			}

			System.out.println("#" + t + " " + hashSet.size());

		}

	}

	static void fuc(int x, int y, int cnt) {
		if (cnt == 7) {
			StringBuilder stringBuilder = new StringBuilder();
			for (int i = 0; i < 7; i++) {
				stringBuilder.append(num[i]);
			}
			hashSet.add(stringBuilder.toString());
			return;
		}
		num[cnt] = arr[x][y];
		for (int d = 0; d < 4; d++) {
			if (x + dx[d] >= 0 && x + dx[d] < 4 && y + dy[d] >= 0 && y + dy[d] < 4)
				fuc(x + dx[d], y + dy[d], cnt + 1);
		}
	}

}
