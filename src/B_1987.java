import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B_1987 {

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static char[][] arr;
	static StringTokenizer stringTokenizer;
	static int n, c;
	static Set<Character> set = new HashSet<Character>();
	static int max;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		n = Integer.parseInt(stringTokenizer.nextToken());
		c = Integer.parseInt(stringTokenizer.nextToken());

		arr = new char[n][c];

		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			String temp = stringTokenizer.nextToken();
			for (int j = 0; j < c; j++) {
				arr[i][j] = temp.charAt(j);
			}
		}

//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}

		fuc(0, 0);

		System.out.println(max);

	}

	static void fuc(int x, int y) {
		if (set.contains(arr[x][y])) {
			return;
		}

		set.add(arr[x][y]);
		max = Math.max(max, set.size());

		for (int i = 0; i < 4; i++) {

			int delx = x + dx[i];
			int dely = y + dy[i];
			if (delx >= 0 && delx < n && dely >= 0 && dely < c) {

				if (set.contains(arr[delx][dely]))
					continue;

				if (delx >= 0 && delx < n && dely >= 0 && dely < c) {
					fuc(delx, dely);
					set.remove(arr[delx][dely]);
				}

			}

		}
	}

}
