

import java.util.Scanner;

public class B_2961 {

	static Food[] foods;
	static boolean[] v;
	static int N;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		foods = new Food[N];
		v = new boolean[N];
		for (int l = 0; l < N; l++) {
			Food food = new Food();
			food.sh = scanner.nextInt();
			food.ss = scanner.nextInt();
			foods[l] = food;
		}

		comb(0);
		System.out.println(min);
		scanner.close();

	}

	static void comb(int cnt) {
		int count = 0;
		if (cnt == N) {
			int so = 1;
			int bi = 0;
			for (int i = 0; i < N; i++) {
				if (v[i]) {
					so *= foods[i].sh;
					bi += foods[i].ss;
					count++;
				}
			}
			if (count == 0) {
				return;
			}
			int result = Math.abs(so - bi);
			if (min > result) {
				min = result;
			}
			return;

		}

		v[cnt] = true;
		comb(cnt + 1);
		v[cnt] = false;
		comb(cnt + 1);
	}
}

class Food {
	int sh, ss;

}
