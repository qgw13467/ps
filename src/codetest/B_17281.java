package codetest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_17281 {
	static int N;
	static int[][] map;
	static int[] visit;
	static int[] play;
	static int result = 0;
	static StringTokenizer stringTokenizer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bufferedReader.readLine());

		map = new int[N][10];
		visit = new int[10];
		play = new int[10];

		for (int i = 0; i < N; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 1; j <= 9; j++) {
				map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		visit[1] = 1;
		play[4] = 1;

		result = 0;
		fuc(1);

		System.out.println(result);
	}

	public static void fuc(int num) {
		if (num == 10) {
			fuc2();
//			for(int i=0;i<N;i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			return;
		}

		if (num == 4) {
			fuc(num + 1);
			return;
		}

		for (int i = 1; i <= 9; i++) {
			if (visit[i] == 1) {
				continue;
			}
//			System.out.println(Arrays.toString(play));
			
			play[num] = i;
			visit[i] = 1;
			fuc(num + 1);
			visit[i] = 0;
		}
	}

	static void fuc2() {
		int score = 0;
		int startPlayer = 1;

		for (int i = 0; i < N; i++) {

			boolean[] base = new boolean[4];
			int outCnt = 0;
			while (outCnt < 3) {

				if (map[i][play[startPlayer]] == 1) {
					if (base[3]) {
						score++;
						base[3] = false;
					}
					if (base[2]) {
						base[3] = true;
						base[2] = false;
					}
					if (base[1]) {
						base[2] = true;
					}
					base[1] = true;
				} else if (map[i][play[startPlayer]] == 2) {
					if (base[3]) {
						score++;
						base[3] = false;
					}
					if (base[2]) {
						score++;
					}
					if (base[1]) {
						base[3] = true;
						base[1] = false;
					}
					base[2] = true;
				} else if (map[i][play[startPlayer]] == 3) {
					if (base[3]) {
						score++;
					}
					if (base[2]) {
						score++;
						base[2] = false;
					}
					if (base[1]) {
						score++;
						base[1] = false;
					}
					base[3] = true;
				} else if (map[i][play[startPlayer]] == 4) {
					if (base[3]) {
						score++;
						base[3] = false;
					}
					if (base[2]) {
						score++;
						base[2] = false;
					}
					if (base[1]) {
						score++;
						base[1] = false;
					}
					score++;
				} else if (map[i][play[startPlayer]] == 0) {
					outCnt++;
				}

				startPlayer++;
				if (startPlayer > 9) {
					startPlayer = startPlayer % 9;
				}
			}

			if (score > result) {
				result = score;
			}

		}
	}

}
