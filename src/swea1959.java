

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class swea1959 {
	public static long solution(ArrayList<Integer> firstArrayList, ArrayList<Integer> secondArrayList) {
		long max = 0;
		for (int i = 0; i < secondArrayList.size() - firstArrayList.size() + 1; i++) {
			int temp = 0;
			for (int j = 0; j < firstArrayList.size(); j++) {

				temp += firstArrayList.get(j) * secondArrayList.get(i + j);

			}

			if (temp > max) {
				max = temp;
			}
		}
		
		return max;
	}
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("/codetest/src/codetest/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			ArrayList<Integer> firstArrayList = new ArrayList<>();
			ArrayList<Integer> secondArrayList = new ArrayList<>();

			int firstlength = sc.nextInt();
			int secondlength = sc.nextInt();

			for (int i = 0; i < firstlength; i++) {
				firstArrayList.add(sc.nextInt());
			}

			for (int i = 0; i < secondlength; i++) {
				secondArrayList.add(sc.nextInt());
			}

			long max = 0;

			if (firstlength == secondlength) {
				for (int i = 0; i < firstlength; i++) {
					for (int j = 0; j < firstlength; j++) {
						max += firstArrayList.get(i) * secondArrayList.get(j);
					}
				}
				System.out.println("#" + test_case + " " + max);
				
			} else if (firstlength < secondlength) {

				max = solution(firstArrayList,secondArrayList);

				System.out.println("#" + test_case + " " + max);
			} else {
				max = solution(secondArrayList,firstArrayList);
				System.out.println("#" + test_case + " " + max);
			}

		}
	}
}
