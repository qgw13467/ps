package codetest;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11659 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(stringTokenizer.nextToken());
		int m = Integer.parseInt(stringTokenizer.nextToken());

		long[] arr = new long[n + 1];
		arr[0] = 0;
		stringTokenizer = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Long.parseLong(stringTokenizer.nextToken());

		}

		for (int i = 1; i <= n; i++) {
			arr[i] += arr[i - 1];
		}

		for (int tc = 1; tc <= m; tc++) {
			stringTokenizer = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(stringTokenizer.nextToken());
			int target = Integer.parseInt(stringTokenizer.nextToken());

			long sum = 0;

			sum = arr[target] - arr[start - 1];
			System.out.println(sum);
		}
	}
}
