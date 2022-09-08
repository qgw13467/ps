

import java.util.Scanner;

public class ArrayTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] intArr = new int[] { 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		for (int num : intArr) {

			System.out.print(num);
		}
		System.out.println();

		int N = sc.nextInt();
		String[] strings = new String[N];
		for (int i = 0; i < N; i++) {
			strings[i] = sc.next();
		}

		for (String string : strings) {
			System.out.println(string);
		}
	}
}
