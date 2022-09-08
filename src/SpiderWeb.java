

import java.util.Scanner;

public class SpiderWeb {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int max = 0;
		int x = -1;
		int y = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int tempsum = 1;
				if (arr[i][j] == 1) {
					continue;
				}
				for (int d = 1; d < n - i; d++) {
					if (arr[i + d][j] == 1 && arr[i + d - 1][j] == 1) {
						break;
					}
					if (arr[i + d][j] == 0) {

						tempsum++;
					}
				}

				for (int d = 1; d < i + 1; d++) {
					if (arr[i - d][j] == 1 && arr[i - d + 1][j] == 1) {
						break;
					}

					if (arr[i - d][j] == 0) {

						tempsum++;
					}
				}

				for (int d = 1; d < n - j; d++) {
					if (arr[i][j + d] == 1 && arr[i][j + d - 1] == 1) {
						break;
					}
					if (arr[i][j + d] == 0) {

						tempsum++;
					}
				}

				for (int d = 1; d < j + 1; d++) {
					if (arr[i][j - d] == 1 && arr[i][j - d + 1] == 1) {
						break;
					}
					if (arr[i][j - d] == 0) {

						tempsum++;
					}
				}

				int d = 1;
				while (true) {
					if ((i - d) < 0 || (j - d) < 0)
						break;
					if (arr[i - d][j - d] == 1 && arr[i - d + 1][j - d + 1] == 1) {
						break;
					}
					if (arr[i - d][j - d] == 0) {

						tempsum++;
					}

					d++;
				}

				d = 1;
				while (true) {
					if ((i + d) > (n - 1) || (j + d) > (n - 1)) {
						break;
					}
					if (arr[i + d][j + d] == 1 && arr[i + d - 1][j + d - 1] == 1) {
						break;
					}
					if (arr[i + d][j + d] == 0) {

						tempsum++;
					}

					d++;
				}
				d = 1;
				while (true) {
					if ((i - d) < 0 || (j + d) > (n - 1)) {
						break;
					}
					if (arr[i - d][j + d] == 1 && arr[i - d + 1][j + d - 1] == 1) {
						break;
					}
					if (arr[i - d][j + d] == 0) {

						tempsum++;
					}

					d++;
				}

				d = 1;
				while (true) {
					if ((i + d) > (n - 1) || (j - d) < 0) {
						break;
					}
					if (arr[i + d][j - d] == 1 && arr[i + d - 1][j - d + 1] == 1) {
						break;
					}
					if (arr[i + d][j - d] == 0) {
						tempsum++;
					}

					d++;
				}


				if (max < tempsum) {
					max = tempsum;
					x = i;
					y = j;
				}

			}
		}

		System.out.println(max);
		System.out.print(x + "," + y);

	}

}
