package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6808 {

	static int[] yourCards;
	static int[] myCards;
	static int result;
	static int win, lose, myPoint, yourPoint;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int n = Integer.parseInt(stringTokenizer.nextToken());

		for (int tc = 1; tc <= n; tc++) {
			boolean[] cards = new boolean[19];
			myCards = new int[9];
			int index = 0;
			yourCards = new int[9];
			int yourIndex = 0;
			boolean[] v = new boolean[9];

			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int i = 0; i < 9; i++) {
				int temp = Integer.parseInt(stringTokenizer.nextToken());
				cards[temp] = true;
			}

			for (int i = 1; i < 19; i++) {
				if (cards[i] == true) {
					yourCards[yourIndex] = i;
					yourIndex++;
				} else {
					myCards[index] = i;
					index++;
				}

			}

//			for (Integer integer : yourCards) {
//				System.out.print(integer + " ");
//			}
//			System.out.println();
//
//			for (Integer integer : myCards) {
//				System.out.print(integer + " ");
//			}
//			System.out.println();

			result = 0;
			win = 0;
			lose = 0;

			count = 0;
			fuc(0, 0);

			System.out.println("#" + tc + " " + win + " " + lose);
		}

	}

	static void fuc(int start, int cnt) {

		if (cnt == 9) {

			for (int i = 0; i < 9; i++) {
				if (myCards[i] > yourCards[i]) {
					myPoint += myCards[i] + yourCards[i];
				} else {
					yourPoint += myCards[i] + yourCards[i];
				}
			}
			if (myPoint > yourPoint) {
				lose++;
			} else if (myPoint < yourPoint) {
				win++;
			}

			myPoint = 0;
			yourPoint = 0;

			return;
		}
		for (int i = start; i < 9; i++) {
			int temp = myCards[start];
			myCards[start] = myCards[i];
			myCards[i] = temp;

			fuc(start + 1, cnt + 1);

			temp = myCards[start];
			myCards[start] = myCards[i];
			myCards[i] = temp;
		}

	}
}
