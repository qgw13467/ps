package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1225 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			bf.readLine();
			StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine(), " ");

			System.out.print("#" + tc + " ");
			Queue<Integer> queue = new LinkedList<>();
			for (int i = 0; i < 8; i++) {

				String tempString = stringTokenizer.nextToken();
				queue.add(Integer.parseInt(tempString));

			}
			int num = 1;
			while (true) {
				int temp = queue.poll();

				if ((temp - num) > 0) {
					queue.add(temp - num);

				} else {
					queue.add(0);
					break;

				}

				if (num == 5) {
					num = 0;
				}
				num++;

			}
			while (queue.size() != 0) {
				System.out.print(queue.poll() + " ");
			}

			System.out.println();
		}

	}
}
