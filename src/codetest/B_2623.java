package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2623 {
	static StringTokenizer stringTokenizer;
	static int n, m;
	static HashSet<Integer>[] map;
	static int[] indegree;
	static Queue<Integer> queue = new LinkedList<>();
	static ArrayList<Integer> result = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		n = Integer.parseInt(stringTokenizer.nextToken());
		m = Integer.parseInt(stringTokenizer.nextToken());
		map = new HashSet[n + 1];
		for (int i = 0; i < n + 1; i++) {
			map[i] = new HashSet<>();
		}
		indegree = new int[n + 1];

		for (int i = 0; i < m; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			stringTokenizer.nextToken();
			ArrayList<Integer> list = new ArrayList<>();
			while (stringTokenizer.hasMoreTokens()) {
				list.add(Integer.parseInt(stringTokenizer.nextToken()));

			}

			for (int j = 0; j < list.size() - 1; j++) {
				if (!map[list.get(j)].contains(list.get(j + 1))) {

					map[list.get(j)].add(list.get(j + 1));
					indegree[list.get(j + 1)]++;
				}

			}

		}
//		System.out.println(Arrays.toString(indegree));
//
//		for (HashSet<Integer> set : map) {
//			System.out.print(set);
//		}
//		System.out.println();

		for (int i = 1; i < n + 1; i++) {
			if (indegree[i] == 0) {
//				System.out.print(i + " ");
				queue.offer(i);
			}
		}
//		System.out.println();

		if (queue.size() == 0) {
			System.out.println(0);
			return;
		}

		while (!queue.isEmpty()) {
			int node = queue.poll();

			result.add(node);

			for (Integer integer : map[node]) {
				indegree[integer]--;

				if (indegree[integer] == 0) {
					queue.offer(integer);
				}

			}

		}

		if (result.size() != n) {
			System.out.println(0);
			return;
		}

		for (Integer integer : result) {
			System.out.print(integer + " ");
		}

	}
}
