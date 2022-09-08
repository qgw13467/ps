import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1992 {
	static int[][] arr;
	static StringTokenizer stringTokenizer;
	static int N;
	static String result;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		N = Integer.parseInt(stringTokenizer.nextToken());

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			String temp = stringTokenizer.nextToken();
			for (int j = 0; j < N; j++) {
				arr[i][j] = temp.charAt(j) - '0';
			}
		}

//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}

		String answer = fuc(N, 0, 0);
		System.out.println(answer);

	}

	static String fuc(int n, int x, int y) {
		String result = "(";
		if (n == 1) {
			if (arr[x][y] == 1) {
				return "1";
			} else {
				return "0";
			}
		}
		int sum = 0;

		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				sum += arr[i][j];
//				System.out.print(arr[i][j] + " ");
			}
//			System.out.println();
		}
//		System.out.println();
//
//		System.out.println(n / 2 + " " + sum);
//		System.out.println("=======================");
		if (sum == n * n) {
			return "1";
		} else if (sum == 0) {
			return "0";
		} else {
//			System.out.println(x + " " + y);
//			System.out.println(x + " " + (y + n / 2));
//			System.out.println((x + n / 2) + " " + y);
//			System.out.println((x + n / 2) + " " + (y + n / 2));
			result = result + fuc(n / 2, x, y);
			result = result + fuc(n / 2, x, y + n / 2);
			result = result + fuc(n / 2, x + n / 2, y);
			result = result + fuc(n / 2, x + n / 2, y + n / 2);
		}
		return result + ")";
	}
}
