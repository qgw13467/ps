package codetest;

import java.util.Scanner;

public class SWEA_1210 {

	static int[][] table = new int[101][101];

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = scanner.nextInt();

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					table[i][j] = scanner.nextInt();
				}
			}

//			for (int i = 0; i < 100; i++) {
//				for (int j = 0; j < 100; j++) {
//					System.out.print(table[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();

			int startx = 99;
			int startj = 100;
			for (int j = 0; j < 100; j++) {
				if (table[99][j] == 2) {
					startj = j;
					break;
				}
			}

//			System.out.println(startx + " " + startj);

			int result = 100;
			while (true) {
				if (startx == 0) {
					result = startj;
					break;
				}

				if ((startj + 1) < 100 && table[startx][startj + 1] == 1) {
					while ((startj + 1) < 100 && table[startx][startj + 1] == 1) {
//						System.out.println(startj);
						startj += 1;
					}

				} else if ((startj - 1) >= 0 && table[startx][startj - 1] == 1) {
					while ((startj - 1) >= 0 && table[startx][startj - 1] == 1) {
//						System.out.println(startj);
						startj -= 1;
					}

				}

				startx -= 1;

//				System.out.println(startx + " " + startj);
			}

			System.out.println("#" + test_case + " " + result);

		}
	}

}
