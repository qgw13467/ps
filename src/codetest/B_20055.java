package codetest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_20055 {
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int n = Integer.parseInt(stringTokenizer.nextToken());
		int k = Integer.parseInt(stringTokenizer.nextToken());
		int n2 = n * 2;
		int[] arr = new int[n * 2];
		int[] robot = new int[2 * n];

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < 2 * n; i++) {
			arr[i] = Integer.parseInt(stringTokenizer.nextToken());

		}

		int round = 1;
		int count = 0;
		int start = 0;
		loop: while (true) {

//			System.out.println(Arrays.toString(arr));
//			System.out.println(Arrays.toString(robot));
//			System.out.println();
			int tempArr = arr[n2 - 1];
			int tempRobot = robot[n2 - 1];
			for (int i = n2 - 1; i > 0; i--) {
				arr[i] = arr[i - 1];
				robot[i] = robot[i - 1];
			}
			arr[0] = tempArr;
			robot[0] = tempRobot;
			if (robot[n - 1] == 1) {
				robot[n - 1] = 0;
			}

//			System.out.println(Arrays.toString(arr));
//			System.out.println(Arrays.toString(robot));
//			System.out.println();

			for (int i = n - 2; i >= 0; i--) {
				if (robot[i] == 1 && arr[i + 1] > 0 && robot[i + 1] == 0) {
					robot[i] = 0;
					robot[i + 1] = 1;
					arr[i + 1] -= 1;
				}

			}
			if (robot[n - 1] == 1) {
				robot[n - 1] = 0;
			}
//			System.out.println(count);
//			System.out.println(Arrays.toString(arr));
//			System.out.println(Arrays.toString(robot));
//			System.out.println();

			if (robot[start] == 0 && arr[start] > 0) {
				robot[start] = 1;
				arr[start] -= 1;

			}
//			System.out.println(count);
//			System.out.println(Arrays.toString(arr));
//			System.out.println(Arrays.toString(robot));
//			System.out.println("-----------" + round + "-------------");
//			System.out.println(count + " " + round);
//			System.out.println();

			count = 0;
			for (int i = 0; i < n2; i++) {
				if (arr[i] == 0) {
					count++;
				}
			}
			if (count >= k) {
//				System.out.println(count);
				break loop;

			}

			round++;

		}

		System.out.println(round);
	}
}
