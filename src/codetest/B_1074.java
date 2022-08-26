package codetest;
import java.util.Scanner;

public class B_1074 {
	static int n, x, y;
	static int answer = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();

		x = scanner.nextInt();
		y = scanner.nextInt();

		fuc(n + 1, x, y);

		System.out.println(answer - 1);
	}

	static void fuc(int n, int x, int y) {
		if (n == 0) {
			answer++;
			return;
		}

		int snm = 0;
		if (x < (int) Math.pow(2, n) / 2 && y < (int) Math.pow(2, n) / 2) {
			snm = 0;
		} else if (x < (int) Math.pow(2, n) / 2 && y >= (int) Math.pow(2, n) / 2) {
			y = y - (int) Math.pow(2, n) / 2;
			snm = 1;
		} else if (x >= (int) Math.pow(2, n) / 2 && y < (int) Math.pow(2, n) / 2) {
			x = x - (int) Math.pow(2, n) / 2;
			snm = 2;
		} else {
			x = x - (int) Math.pow(2, n) / 2;
			y = y - (int) Math.pow(2, n) / 2;
			snm = 3;
		}

		int toSum = ((int) Math.pow(2, n) / 2) * ((int) Math.pow(2, n) / 2);

		answer += toSum * snm;

		fuc(n - 1, x, y);
	}

}
