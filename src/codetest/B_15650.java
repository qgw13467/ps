package codetest;
import java.util.Scanner;

public class B_15650 {
	static int[] arr;
	static int[] v;
	static int n;
	static int c;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		n = scanner.nextInt();
		c = scanner.nextInt();

		arr = new int[c];
		v = new int[c];
		fuc(0);
	}

	static void fuc(int cnt) {

		if (cnt == c) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();

			return;
		}
		
		
		for(int i=0;i<n;i++) {
			 
		}
	}
}
