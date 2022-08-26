package codetest;
import java.util.ArrayList;
import java.util.Scanner;

public class B_2023 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		ArrayList<Integer> result = new ArrayList<>();

//		for (int i = (int) Math.pow(10, n - 1) * 2; i < (int) Math.pow(10, n); i++) {
//			if (isPrime(i)) {
//				result.add(i);
//			}
//		}
//
//		for (Integer integer : result) {
//			System.out.println(integer);
//
//		}

		result.addAll(makenum(2, n));
		result.addAll(makenum(3, n));
		result.addAll(makenum(5, n));
		result.addAll(makenum(7, n));

		for (Integer integer : result) {
			System.out.println(integer);
		}
	

	}

	static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}

		}
		return true;

	}

	static ArrayList<Integer> makenum(int cnt, int target) {

		ArrayList<Integer> result = new ArrayList<>();
		if ((int) Math.log10(cnt) + 1 == target) {
			result.add(cnt);
			return result;
		}
		for (int i = 0; i < 10; i++) {
			int temp = cnt * 10 + i;
			if (isPrime(temp)) {
				result.addAll(makenum(temp, target));
			}
		}

		return result;
	}
}
