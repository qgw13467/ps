package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_11286 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		N = Integer.parseInt(stringTokenizer.nextToken());
		ArrayList<Num> list = new ArrayList<>();
		PriorityQueue<Num> heap = new PriorityQueue<>(new Comparator<Num>() {

			@Override
			public int compare(Num o1, Num o2) {
				if (o1.num == o2.num) {
					return o1.sign - o2.sign;
				}
				return o1.num - o2.num;
			}
		});

		for (int l = 0; l < N; l++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int temp = Integer.parseInt(stringTokenizer.nextToken());
			Num num = new Num();
			if (temp > 0) {

				num.num = temp;
				num.sign = 1;
				heap.add(num);
			} else if (temp < 0) {

				num.num = -temp;
				num.sign = -1;
				heap.add(num);
			} else {
				num = heap.poll();
				if (num == null) {
					System.out.println(0);
				} else if (num.sign == 1) {
					System.out.println(num.num);
				} else {
					System.out.println(-num.num);
				}
			}

		}

	}
}

class Num {
	int num;
	int sign;
}