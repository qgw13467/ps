

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_2164 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		while (queue.size() != 1) {
			queue.poll();
			int temp = queue.poll();
			queue.add(temp);
		}

		int result = queue.poll();

		System.out.println(result);
	}
}
