package codetest;

import java.util.ArrayList;
import java.util.Scanner;

public class B_15686 {

	static int[][] arr = new int[51][51];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		int k = scanner.nextInt();
		int[] kix = new int[k];
		int[] kiy = new int[k];
		ArrayList<Integer> kiList = new ArrayList<>();
		int kinum = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = scanner.nextInt();
				if (arr[i][j] == 2) {
					kix[kinum] = i;
					kiy[kinum] = j;

				}
			}
		}

		for (int i = 0; i < k; i++) {
			kiList.add(sumKi(kix[i], kiy[i], k));
		}

		int min = kiList.get(0);
		int minx = 0, miny = 0;
		for (int i = 0; i < k; i++) {
			if (min > kiList.get(i)) {
				min = kiList.get(i);
				minx = kix[i];
				miny = kiy[i];
			}
		}

		arr[minx][miny] = 0;
		
	}

	static int sumKi(int r, int c, int n) {
		int result = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (arr[i][j] == 1) {
					result += Math.abs(i - r);
					result += Math.abs(j - c);
				}
			}
		}

		return result;
	}
	
	
}
