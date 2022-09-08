

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class swea1979 {

	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;
			int[][] table = new int[15][15];
			int[][] rowcheck = new int[15][15];
			int[][] colcheck = new int[15][15];
			int N = sc.nextInt();
			int K = sc.nextInt();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					table[i][j] = sc.nextInt();
					rowcheck[i][j] = table[i][j];
					colcheck[i][j] = table[i][j];
					if (i > 0 && table[i - 1][j] != 0 && table[i][j] != 0) {
						rowcheck[i][j] = rowcheck[i - 1][j] + 1;
						if (rowcheck[i][j] == K) {
							answer++;
						} else if (rowcheck[i - 1][j] == K) {
							answer--;
						}
					}
					
					if (j > 0 && table[i][j - 1] != 0 && table[i][j] != 0) {
						colcheck[i][j] = colcheck[i][j - 1] + 1;
						if (colcheck[i][j] == K) {
							answer++;
						} else if (colcheck[i][j - 1] == K) {
							answer--;
						}

					}
				}

			}
			

			
			System.out.println("#" + T + " " + answer);
		}
	}

}
