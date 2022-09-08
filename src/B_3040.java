

import java.util.ArrayList;
import java.util.Scanner;

public class B_3040 {
	static int N;
	static int[] arr;

	static boolean[] v = new boolean[9];
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		arr = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = scanner.nextInt();
			sum += arr[i];

		}

		sum -= 100;

		loop: for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 9; j++) {
				if ((arr[i] + arr[j]) == sum) {
					v[i] = true;
					v[j] = true;
					break loop;
				}
			}
		}
		
		for(int i=0;i<9;i++) {
			if(v[i] == false) {
				list.add(arr[i]);
			}
		}
		
		for (Integer integer : list) {
			System.out.println(integer);
		}
		

	}

}
