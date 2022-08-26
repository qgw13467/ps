package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2567 {

	static int n;
	static int[][] table = new int[100][100];

	public static void main(String[] args) throws IOException {
		int result = 0;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		n = Integer.parseInt(stringTokenizer.nextToken());
		for (int l = 0; l < n; l++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int x = Integer.parseInt(stringTokenizer.nextToken());
			int y = Integer.parseInt(stringTokenizer.nextToken());
			for (int i = 0; i < 10; i++) {

				for (int j = 0; j < 10; j++) {
					if ((x + i) < 100 && (y + j) < 100) {
						table[x + i][y + j] = 1;
					}

				}
			}

		}

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				System.out.print(table[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();

	}

}
