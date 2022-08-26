package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_2644 {
	static int[][] arr;
	static int[] visited;
	static int n;
	static int m;
	static StringTokenizer stringTokenizer;
	static int start, target;
	static int count;
	static int result;
	static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		n = Integer.parseInt(stringTokenizer.nextToken());

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		start = Integer.parseInt(stringTokenizer.nextToken());
		target = Integer.parseInt(stringTokenizer.nextToken());

		arr = new int[n + 1][n + 1];
		visited = new int[n + 1];

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		m = Integer.parseInt(stringTokenizer.nextToken());

		for (int p = 0; p < m; p++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			int i = Integer.parseInt(stringTokenizer.nextToken());
			int j = Integer.parseInt(stringTokenizer.nextToken());
//			if (map.containsKey(j)) {
//				ArrayList<Integer> list = map.get(j);
//				list.add(i);
//				map.put(j, list);
//			} else {
//				ArrayList<Integer> list = new ArrayList<>();
//				list.add(i);
//				map.put(j, list);
//			}

			arr[i][j] = 1;
			arr[j][i] = 1;
		}

//		for (int i = 0; i <= n; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}

		fuc(start, target);

		if (result == 0) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}

	}

	static void fuc(int start, int target) {

		if (start == target) {
			result = count;
			return;
		}
		count++;
		visited[start] = 1;
		for (int i = 1; i <= n; i++) {

			if (visited[i] == 0 && arr[start][i] == 1) {
				visited[i] = 1;
				fuc(i, target);
				visited[i] = 0;
			}

		}
		count--;
		visited[start] = 0;

//		ArrayList<Integer> list = map.get(target);
//		for (Integer integer : list) {
//			if (integer == start) {
//				result = count;
//				return;
//			}
//
//			else {
//				stack.add(integer);
//				count++;
//				fuc(integer, start);
//				count--;
//
//			}
//
//		}

	}
}
