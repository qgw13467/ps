package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3289 {

	static int[] arr;
	static StringTokenizer stringTokenizer;
	static int n, m;
	static int command, start, target;
	static StringBuilder stringBuilder;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int t = Integer.parseInt(stringTokenizer.nextToken());

		for (int tc = 1; tc <= t; tc++) {
			stringBuilder = new StringBuilder();

			stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			n = Integer.parseInt(stringTokenizer.nextToken());
			m = Integer.parseInt(stringTokenizer.nextToken());

			arr = new int[n + 1];
			for (int i = 0; i < n+1; i++) {
				arr[i] = i;
			}

			for (int i = 0; i < m; i++) {
				stringTokenizer = new StringTokenizer(bufferedReader.readLine());
				command = Integer.parseInt(stringTokenizer.nextToken());
				start = Integer.parseInt(stringTokenizer.nextToken());
				target = Integer.parseInt(stringTokenizer.nextToken());

				if (command == 0) {
					union(start, target);
				} else {
					if (findSet(start) == findSet(target)) {
						stringBuilder.append(1);
					} else {
						stringBuilder.append(0);
					}
				}

//				System.out.println(Arrays.toString(arr));

			}

			System.out.println("#" + tc + " " + stringBuilder.toString());

		}

	}

	static int findSet(int x) {
		int result = 0;
		if (arr[x] == x) {
			return x;
		} else {
			result = findSet(arr[x]);
			arr[x]=result;
		}

		return result;

	}

	static void union(int x, int y) {

		if (findSet(x) <= findSet(y)) {
			arr[findSet(y)] = findSet(x);
			
			
		} else {
			arr[findSet(x)] = findSet(y);
		}

	}
}
