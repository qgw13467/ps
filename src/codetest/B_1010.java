package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1010 {
	static int[][] dp = new int[30][30];
	static int start, end;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int n = Integer.parseInt(stringTokenizer.nextToken());

		for (int l = 0; l < n; l++) {

			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int N = Integer.parseInt(stringTokenizer.nextToken());
			int M = Integer.parseInt(stringTokenizer.nextToken());

			System.out.println(fuc(start, end));
		}

	}

	static int fuc(int start, int end) {

		if (dp[start][end] > 0) {
			return dp[start][end];
		}

		if (start == end || end == 0) {
			return dp[start][end] = 1;
		}

		return fuc(start - 1, end - 1) + fuc(start - 1, end);

//		if (start == 1) {
//			result += end;
//			return;
//		}
//
//		for (int i = 1; i <= end - start+1; i++) {
//			fuc(start - 1, end - i);
//		}

	}
}
