package codetest;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2805 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 선언
		int q = Integer.parseInt(bf.readLine()); // Int
		for (int tc = 1; tc <= q; tc++) {

			int n = Integer.parseInt(bf.readLine());
			int[][] arr = new int[n][n];

			for (int i = 0; i < n; i++) {
				String temp = bf.readLine();
				for (int j = 0; j < n; j++) {

					arr[i][j] = temp.charAt(j) - '0';
				}
			}

//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					System.out.print(arr[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();

			int result = 0;
			for (int j = 0; j < n; j++) {
				result += arr[n / 2][j];
			}
			for (int i = 1; i < (n / 2) + 1; i++) {
				for (int j = i; j < n - i; j++) {

					result += arr[(n / 2) + i][j];
					result += arr[(n / 2) - i][j];

				}
			}

//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					System.out.print(arr[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();

			System.out.println("#" + tc + " " + result);

		}
	}
}
