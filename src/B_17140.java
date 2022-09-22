import java.util.PriorityQueue;
import java.util.Scanner;

public class B_17140 {

	static class Data implements Comparable<Data> {

		int num, leng;

		@Override
		public int compareTo(Data o) {
			if (this.leng == o.leng) {
				return this.num - o.num;
			}
			return this.leng - o.leng;
		}

	}

	static int[][] map= new int[101][101];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int r = sc.nextInt();
		r--;
		int c = sc.nextInt();
		c--;
		int k = sc.nextInt();

		int R = 3;
		int C = 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int time = -1;

		for (int l = 0; l <= 100; l++) {
			if (map[r][c] == k) {
				time = l;
				break;
			}

			if (R >= C) {
				int newC = 0;

				for (int i = 0; i < R; i++) {
					PriorityQueue<Data> q1 = new PriorityQueue<>();
					int[] numCnt = new int[101];

					for (int j = 0; j < C; j++) {

						numCnt[map[i][j]]++;
						map[i][j] = 0;
					}

					for (int m = 1; m < 101; m++) {
						if (numCnt[m] > 0) {
							Data data = new Data();
							data.leng = numCnt[m];
							data.num = m;
							q1.add(data);
						}
					}

					int index = 0;

					while (!q1.isEmpty()) {
						map[i][index++] = q1.peek().num;
						map[i][index++] = q1.peek().leng;
						q1.remove();
					}

					if (newC < index) {
						newC = index;
					}

				}
				C = newC;
			}

			else {
				int newR = 0;

				for (int i = 0; i < C; i++) {
					PriorityQueue<Data> q1 = new PriorityQueue<>();

					int[] numCnt = new int[101];

					for (int j = 0; j < R; j++) {
						numCnt[map[j][i]]++;
						map[j][i] = 0;
					}
					for (int m = 1; m < 101; m++) {
						if (numCnt[m] != 0) {
							Data data = new Data();
							data.leng = numCnt[m];
							data.num = m;
							q1.add(data);
						}
					}

					int index = 0;

					while (!q1.isEmpty()) {
						Data p = q1.poll();
						map[index++][i] = p.num;
						map[index++][i] = p.leng;
					}

					if (newR < index) {
						newR = index;
					}

				}
				R = newR;
			}

		}
		System.out.println(time);

	}

}
