package codetest;

import java.util.Scanner;

public class B_17478 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		String[] arr = new String[6];
		arr[0] = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
		arr[1] = "\"재귀함수가 뭔가요?\"";
		arr[2] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
		arr[3] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
		arr[4] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.";
		arr[5] = "라고 답변하였지.";

		recy(arr, n);
	}

	static void recy(String arg[], int n) {

		System.out.println(arg[0]);
		System.out.println(arg[1]);
		System.out.println(arg[2]);
		System.out.println(arg[3]);
		System.out.println(arg[4]);
		if (n != 1) {
			String[] arr = new String[6];
			arr[0] = "____" + arg[0];
			arr[1] = "____" + arg[1];
			arr[2] = "____" + arg[2];
			arr[3] = "____" + arg[3];
			arr[4] = "____" + arg[4];
			arr[5] = "____" + arg[5];

			recy(arr, n - 1);
		}
		System.out.println(arg[5]);

	}
}
