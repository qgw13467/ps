package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1233 {
	static String[] arr;
	static int index;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int n = Integer.parseInt(stringTokenizer.nextToken());
			arr = new String[n + 1];

			for (int i = 1; i <= n; i++) {

				stringTokenizer = new StringTokenizer(bufferedReader.readLine());
				stringTokenizer.nextToken();
				arr[i] = stringTokenizer.nextToken();
			}

//			System.out.println();
//			for (int i = 1; i <= n; i++) {
//				System.out.print(arr[i] + " ");
//			}
//			System.out.println();

			System.out.println("#" + tc + " " + fuc(n));
		}

	}

	static boolean isOper(String arg) {
		if (arg.equals("*") || arg.equals("/") || arg.equals("+") || arg.equals("-")) {
			return true;
		}
		return false;
	}

	static int fuc(int cnt) {
		int result = 0;
		if (cnt == 1) {
			return 1;
		}

		if (!isOper(arr[cnt]) && !isOper(arr[cnt - 1]) && isOper(arr[cnt / 2])) {
			arr[cnt / 2] = "1";
			result = fuc(cnt - 2);
		}

		return result;
	}
}
