

import java.util.Scanner;
import java.io.FileInputStream;

public class swea1961 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int[][] arr = new int[8][8];
			int N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();

				}
			}
			System.out.println("#" + test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					System.out.print(arr[N - 1 - j][i]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {

					System.out.print(arr[N - i - 1][N - j - 1]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {

					System.out.print(arr[j][N - 1 - i]);
				}
				System.out.println();
			}

		}
	}
}
