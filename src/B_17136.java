import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_17136 {
	static int[][] map = new int[10][10];
	static int N;
	static StringTokenizer stringTokenizer;
	static int[] remain = { 0, 5, 5, 5, 5, 5 };
	static int answer = 26;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 10; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		fuc(0, 0, 0);

		if (answer != 26) {
			System.out.println(answer);
		} else {
			System.out.println(-1);
		}
	}

	static void fuc(int r, int c, int cnt) {
		if (r >= 9 && c > 9) {
			if (answer > cnt) {
				answer = cnt;
			}
			return;
		}

		if (answer <= cnt) {
			return;
		}

		if (c > 9) {
			fuc(r + 1, 0, cnt);
			return;
		}

		if (map[r][c] == 1) {
			for (int i = 5; i > 0; i--) {
				if (remain[i] > 0 && check(r, c, i)) {
					setting(r, c, i, 0);
					remain[i]--;
					fuc(r, c + 1, cnt + 1);
					setting(r, c, i, 1);
					remain[i]++;
				}
			}
		} else {
			fuc(r, c + 1, cnt);
		}

	}

	static boolean check(int r, int c, int size) {

		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if ( i >= 10 ||  j >= 10 || map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	static void setting(int r, int c, int size, int num) {

		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (i >= 0 && i < 10 && j >= 0 && j < 10) {
					map[i][j] = num;
				}
			}
		}
	}
}
