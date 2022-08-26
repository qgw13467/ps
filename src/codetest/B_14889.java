package codetest;
import java.util.Scanner;

public class B_14889 {
	final static boolean debug = false;
	static boolean[] visit;
	static int[][] arr = new int[21][21];
	static int n;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		visit = new boolean[n + 1];

		fuc(0, n / 2);
		DFS(0, 0);
		System.out.println(ans);

	}

	static void DFS(int x, int pos) {
		if (x == n / 2) {
			int start, link;
			start = 0;
			link = 0;

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (visit[i] == true && visit[j] == true)
						start += arr[i][j];
					if (visit[i] == false && visit[j] == false)
						link += arr[i][j];
				}
			}

			int temp = Math.abs(start - link);
			if (ans > temp)
				ans = temp;

			return;
		}

		for (int i = pos; i < n; i++) {
			visit[i] = true;
			DFS(x + 1, i + 1);

			visit[i] = false;
			DFS(x + 1, i);
		}

	}

	static void fuc(int cnt, int r) {
		if (r == 0) {

			int start, link;
			start = 0;
			link = 0;

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (visit[i] == true && visit[j] == true)
						start += arr[i][j];
					if (visit[i] == false && visit[j] == false)
						link += arr[i][j];
				}
			}

			int temp = Math.abs(start - link);
			if (ans > temp)
				ans = temp;

			return;
		}

		if (cnt == n / 2) {
			return;
		}

		visit[cnt] = true;
		fuc(cnt + 1, r - 1);
		visit[cnt] = false;
		fuc(cnt + 1, r);

	}
}
