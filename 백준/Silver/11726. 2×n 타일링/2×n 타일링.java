

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer stringTokenizer;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());

		arr = new int[1001];
		arr[1] = 1;
		arr[2] = 2;

		for (int i = 3; i < n + 1; i++) {
			arr[i] = (arr[i - 1] +  arr[i - 2])%10007;
		}

//		System.out.println(Arrays.toString(arr));
		System.out.println(arr[n] % 10007);

	}
}
