package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SWEA_7465 {
	static StringTokenizer stringTokenizer;
	static int[] arr;
	static int n, m;
	static HashSet<Integer> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int t = Integer.parseInt(stringTokenizer.nextToken());

		for (int tc = 1; tc <= t; tc++) {
			set = new HashSet<>();
			int result = 0;
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			n = Integer.parseInt(stringTokenizer.nextToken());
			m = Integer.parseInt(stringTokenizer.nextToken());

			arr = new int[n + 1];
			for (int k = 0; k < n + 1; k++) {
				arr[k] = k;
			}

			for (int k = 0; k < m; k++) {
				stringTokenizer = new StringTokenizer(bufferedReader.readLine());
				int x = Integer.parseInt(stringTokenizer.nextToken());
				int y = Integer.parseInt(stringTokenizer.nextToken());

				union(x, y);
				System.out.println(Arrays.toString(arr));
			}

			for (int k = 1; k < n + 1; k++) {
				if (arr[k] == k) {
					result++;
				}
			}

			System.out.println("#" + tc + " " + result);
		}
	}

	static int findSet(int x) {
		int result = 0;
		if (arr[x] == x) {
			return x;
		}

		result = findSet(arr[x]);
		arr[x] = findSet(result);

		return result;

	}

	static void union(int x, int y) {
		if (findSet(x) == findSet(y)) {
			return;
		}

		if (findSet(x) < findSet(y)) {
			arr[findSet(y)] = findSet(x);

		} else {
			arr[findSet(x)] = findSet(y);
		}

	}
}
