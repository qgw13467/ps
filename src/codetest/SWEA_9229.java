package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9229 {
	static int n, weight;
	static int max;
	static int[] arr;
	static int[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int l = Integer.parseInt(stringTokenizer.nextToken());
		for (int tc = 1; tc <= l; tc++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			n = Integer.parseInt(stringTokenizer.nextToken());
			weight = Integer.parseInt(stringTokenizer.nextToken());
			arr = new int[n];
			v = new int[n];

			stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(stringTokenizer.nextToken());
			}
			max = 0;
			fuc(0);

			System.out.println();
		}
	}

	static void fuc(int cnt) {
		if (cnt == n) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				if (v[i] == 1) {
					System.out.print(arr[i] + " ");
					sum += arr[i];
				}
			}
			System.out.println();

			if (max < sum) {
				max = sum;
			}
			return;
		} else {

			v[cnt] = 0;
			fuc(cnt + 1);

			v[cnt] = 1;
			int sum = 0;
			for (int i = 0; i < cnt; i++) {
				if (v[i] == 1) {
					sum += arr[i];
				}
			}

			fuc(cnt + 1);
		}
	}

}
