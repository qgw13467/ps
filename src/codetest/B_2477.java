package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2477 {
	static int N;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	static int[][] arr = new int[6][2];
	static int[] count = new int[5];

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		N = Integer.parseInt(stringTokenizer.nextToken());

		for (int l = 0; l < 6; l++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			arr[l][0] = Integer.parseInt(stringTokenizer.nextToken());
			arr[l][1] = Integer.parseInt(stringTokenizer.nextToken());

			switch (arr[l][0]) {
			case 1:
				count[1]++;
				break;
			case 2:
				count[2]++;
				break;
			case 3:
				count[3]++;
				break;
			case 4:
				count[4]++;
			}

		}

//		System.out.println(Arrays.toString(count));

		int hdi = 0, wdi = 0;
		int hMax = 0, wMax = 0;
		int hmMin = Integer.MAX_VALUE;
		int wmMin = Integer.MAX_VALUE;
		int hmindex = 0, wmindex = 0;

		for (int i = 1; i < 5; i++) {
			if (count[i] == 1) {
				if (i <= 2) {
					wdi = i;
				} else {
					hdi = i;
				}
			}

			if (count[i] == 2) {
				if (i <= 2) {
					wmindex = i;
				} else {
					hmindex = i;
				}
			}
		}

//		System.out.println(wdi + " " + hdi);

		for (int i = 1; i <= 4; i++) {

			if (count[i] == 1) {
				if (i <= 2) {
					wdi = i;
				} else {
					hdi = i;
				}
			}

		}

		for (int i = 0; i < 6; i++) {
			if (arr[i][0] == wdi) {
				wMax = arr[i][1];
			}
			if (arr[i][0] == hdi) {
				hMax = arr[i][1];
			}

			if (arr[i][0] == wmindex) {
				if (wmMin > arr[i][1]) {
					wmMin = arr[i][1];
				}
			}

			if (arr[i][0] == hmindex) {
				if (hmMin > arr[i][1]) {
					hmMin = arr[i][1];
				}
			}
		}
//		System.out.println(hdi + " " + wdi);
//		System.out.println(hMax + " " + wMax + " " + hmindex + " " + wmindex);
//		System.out.println(hmMin + " " + wmMin);
		int area = hMax * wMax;
//		System.out.println(area);
		area -= hmMin * wmMin;
		System.out.println(area * N);
	}

}
