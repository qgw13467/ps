

import java.util.Scanner;

public class DayCount {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] months = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int month, day;

		System.out.println("월과 일을 입력하세요.");

		month = sc.nextInt();
		day = sc.nextInt();

		int sum = 0;
		for (int i = 0; i < month - 1; i++) {

			sum += months[i];
		}

		sum += day;

		System.out.println("" + month + "월 " + day + "일은 " + sum + "번째 날입니다.");

	}

}
