package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2252 {
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
		indegree = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			map[i] = new HashSet<>();
		}

		for (int i = 0; i < m; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int start = Integer.parseInt(stringTokenizer.nextToken());
			int target = Integer.parseInt(stringTokenizer.nextToken());

			map[start].add(target);
			indegree[target]++;
		}

		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
//				System.out.println(i+" ");
				queue.add(i);
			}
		}

		if (queue.size() == 0) {
			return;
		}
//		System.out.println();

		while (!queue.isEmpty()) {
			int node = queue.poll();

			if (indegree[node] == 0) {
				result.add(node);
			}

			for (Integer integer : map[node]) {
				indegree[integer]--;

				if (indegree[integer] == 0) {
					queue.offer(integer);
				}
			}

		}

		if (result.size() != n) {
			return;
		}

		for (Integer integer : result) {
			System.out.print(integer + " ");

		}

	}
}
