

import java.util.Arrays;
import java.util.Scanner;

public class B_15649 {

	static int[] arr;
	static int[] v;
	static int count = 0;
	static int n;
	static int c;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		n = scanner.nextInt();
		c = scanner.nextInt();
		arr = new int[c];
		v = new int[n + 1];

		permu(0);

	}

	static void permu(int cnt) {

		if (cnt == c) {
			System.out.println(Arrays.toString(arr));
			return;

		}

		for (int i = 1; i <= n; i++) {

			if (v[i] == 1) {
				continue;
			}
			arr[cnt] = i;
			v[i] = 1;
			permu(cnt + 1);

			v[i] = 0;

		}

	}
}
