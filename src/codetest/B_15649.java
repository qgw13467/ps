package codetest;
import java.util.Scanner;

public class B_15649 {

	static int[] arr;
	static int[] v;
	static int n;
	static int c;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		n = scanner.nextInt();
		c = scanner.nextInt();
		arr = new int[c];
		v = new int[n + 1];

		fuc(0);

	}

	static void fuc(int cnt) {

		if (cnt == c) {

			for (int i = 0; i < c; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (v[i] == 1) {
				continue;
			}
			arr[cnt] = i;
			v[i] = 1;

			fuc(cnt + 1);

			v[i] = 0;
		}

	}
}
