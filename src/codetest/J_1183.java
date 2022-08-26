package codetest;
import java.util.ArrayList;
import java.util.Scanner;

public class J_1183 {
	static int price;
	static int[] coin = new int[6];
	static ArrayList<Integer> arr = new ArrayList<>();
	static int count;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		price = scanner.nextInt();
		for (int i = 0; i < 6; i++) {
			coin[i] = scanner.nextInt();
		}

		int result = arr.get(price + 1);

		System.out.println(result);
	}

	static void fuc() {
		for (int i = 0; i < coin[5]; i++) {
			arr.add(i);
		}

		for (int i = coin[5] + 1; i < price; i++) {
			
		}
	}

}
