

import java.util.Scanner;

public class swea2001 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T;

		T = sc.nextInt();

		for (int test_case = 0; test_case < T; test_case++) {

			int[][] table = new int[16][16];

			int M, N;

			M = sc.nextInt();

			N = sc.nextInt();

			for (int i = 1; i <= M; i++) {

				for (int j = 1; j <= M; j++) {

					table[i][j] = sc.nextInt();

					table[i][j] += table[i][j - 1];

				}

			}

			for (int i = 1; i <= M; i++) {

				for (int j = 1; j <= M; j++) {

					table[i][j] = table[i][j] + table[i - 1][j];

				}

			}

			int max = 0;

			for (int i = N; i <= M; i++) {

				for (int j = N; j <= M; j++) {

					int temp = 0;

					if (i > N && j > N) {

						temp = table[i][j] - table[i - N][j] - table[i][j - N] + table[i - N][j - N];

					} else if (i == N && j > N) {

						temp = table[i][j] - table[i][j - N];

					} else if (i > N && j == N) {

						temp = table[i][j] - table[i - N][j];

					}

					else if (i == N && j == N) {

						temp = table[i][j];

					}

					if (temp > max) {

						max = temp;

					}

				}

			}

			for (int i = 1; i <= M; i++) {

				for (int j = 1; j <= M; j++) {

					System.out.print(table[i][j] + " ");

				}

				System.out.println();

			}

			System.out.println(max);

		}

	}

}