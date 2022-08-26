package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class SWEA_7699 {
	static int t, r, c;
	static char[][] arr;
	static int count;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static LinkedHashSet<Character> set;
	static StringTokenizer stringTokenizer;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(bufferedReader.readLine());

		for (int tc = 1; tc <= t; tc++) {

			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			r = Integer.parseInt(stringTokenizer.nextToken());
			c = Integer.parseInt(stringTokenizer.nextToken());

			arr = new char[r][c];
			set = new LinkedHashSet<>();
			count = 0;

			for (int i = 0; i < r; i++) {
				String string = bufferedReader.readLine();
				for (int j = 0; j < c; j++) {
					arr[i][j] = string.charAt(j);
				}
			}

//			for (int i = 0; i < r; i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
//			System.out.println();

			fuc(0, 0);

//			System.out.println(set);
			System.out.println("#" + tc + " " + count);
//			System.out.println();

		}

	}

	static void fuc(int x, int y) {

		for (int d = 0; d < 4; d++) {
			
			if (set.contains(arr[x][y])) {
				continue;
			}
			set.add(arr[x][y]);
			if (set.size() > count) {
				count = set.size();
			}
			if (x + dx[d] >= 0 && x + dx[d] < r && y + dy[d] >= 0 && y + dy[d] < c) {


//				System.out.println(set);
				fuc(x + dx[d], y + dy[d]);

			}
			set.remove(arr[x][y]);
		}

	}
}
