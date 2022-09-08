

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9229 {
	static int n;
	static int max;
	static int[] arr;
	static int[] v;
	static int num;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int l = Integer.parseInt(stringTokenizer.nextToken());

		for (int tc = 1; tc <= l; tc++) {

			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			n = Integer.parseInt(stringTokenizer.nextToken());
			max = Integer.parseInt(stringTokenizer.nextToken());

			arr = new int[n];
			v = new int[n];
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(stringTokenizer.nextToken());
			}

		}

	}

	static void fuc(int cnt) {

		int sum = 0;
		if (cnt == n - 1) {
			for (int i = 0; i < cnt; i++) {
				sum += arr[i];
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			v[i] = 1;
			fuc(cnt + 1);
			v[i] = 0;

		}
	}

}
