package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_1260 {
	static int n, edge, start;
	static int[][] arr;
	static int[] bfsVisit;
	static int[] dfsVisit;
	static Queue<Integer> queue = new LinkedList<>();
	static Stack<Integer> stack = new Stack<>();
	static ArrayList<Integer> queueResult = new ArrayList<>();
	static ArrayList<Integer> stackResult = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		n = Integer.parseInt(stringTokenizer.nextToken());
		edge = Integer.parseInt(stringTokenizer.nextToken());
		start = Integer.parseInt(stringTokenizer.nextToken());
		arr = new int[n + 1][n + 1];
		bfsVisit = new int[n + 1];
		dfsVisit = new int[n + 1];
		for (int k = 0; k < edge; k++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int s, t;
			s = Integer.parseInt(stringTokenizer.nextToken());
			t = Integer.parseInt(stringTokenizer.nextToken());

			arr[s][t] = 1;
			arr[t][s] = 1;

		}

//		for (int[] ints : arr) {
//			System.out.println(Arrays.toString(ints));
//		}
//		System.out.println();
		dfs(start);

//		System.out.println("============================");
		bfs(start);

		for (Integer integer : stackResult) {
			System.out.print(integer + " ");
		}
		System.out.println();

		for (Integer integer : queueResult) {
			System.out.print(integer + " ");
		}
	}

	static void dfs(int start) {
		if (dfsVisit[start] == 1) {
			return;
		}
		dfsVisit[start] = 1;

		stackResult.add(start);

//		System.out.println(Arrays.toString(dfsVisit));
//		System.out.println(stackResult);
//		System.out.println();

		for (int i = 1; i < n + 1; i++) {
			if (dfsVisit[i] == 0 && arr[start][i] == 1) {
				stack.add(i);
				int nextStart = stack.pop();
				dfs(nextStart);
			}
		}

	}

	static void bfs(int start) {
		if (bfsVisit[start] == 1) {
			return;
		}
		bfsVisit[start] = 1;

		queueResult.add(start);

//		System.out.println(Arrays.toString(bfsVisit));
//		System.out.println(queueResult);
//		System.out.println();

		for (int i = 1; i < n + 1; i++) {
			if (bfsVisit[i] == 0 && arr[start][i] == 1) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int nextStart = queue.poll();
			bfs(nextStart);

		}

	}

}
