package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;

import java.util.StringTokenizer;

public class B_1697 {
	static int n, k;
	static int[] arr;
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		n = Integer.parseInt(stringTokenizer.nextToken());
		k = Integer.parseInt(stringTokenizer.nextToken());

		if (n >= k) {
			System.out.println(n - k);
		} else {
			System.out.println(bfs());
		}

	}

	static int bfs() {

		arr = new int[100001];
		queue.add(n);
		arr[n] = 1;
		while (!queue.isEmpty()) {
			int x = queue.poll();

			for (int i = 0; i < 3; i++) {
				int nx;
				if (i == 0)
					nx = x - 1;
				else if (i == 1)
					nx = x + 1;
				else
					nx = x * 2;

				if (nx == k)
					return arr[x];

				if (nx >= 0 && nx < 100001 && arr[nx] == 0) {
					arr[nx] = arr[x] + 1;
					queue.add(nx);
				}
			}
		}
		return 0;
	}

}
