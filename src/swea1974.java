

import java.util.Scanner;
import java.io.FileInputStream;

public class swea1974 {

	public static int checkcube(int[][] table) {
		int[] start = { 0, 3, 6 };
		for (int i = 0; i < start.length; i++) {
			for (int j = 0; j < start.length; j++) {
				int[] check = new int[10];
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						check[table[start[i] + k][start[j] + l]] += 1;
					}

				}
				if (checkarr(check) == 0) {
					return 0;
				}

			}
		}
		return 1;
	}

	public static int checkrowcol(int[][] table) {
		for (int i = 0; i < 9; i++) {
			int[] checkrow = new int[10];
			int[] checkcol = new int[10];
			for (int j = 0; j < 9; j++) {
				checkrow[table[i][j]] += 1;
				checkcol[table[j][i]] += 1;

			}

			if (checkarr(checkrow) == 0) {
				return 0;
			}
			if (checkarr(checkcol) == 0) {
				return 0;
			}
		}
		return 1;

	}

	public static int checkarr(int arr[]) {
		for (int i = 1; i <= 9; i++) {
			if (arr[i] == 0) {
				return 0;
			}
		}
		return 1;
	}

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {
			int[][] table = new int[10][10];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					table[i][j] = sc.nextInt();
				}
			}
			if (checkcube(table) == 1 && checkrowcol(table) == 1) {
				System.out.println("#" + test_case + " " + 1);
			} else {
				System.out.println("#" + test_case + " " + 0);
			}

		}
	}
}
