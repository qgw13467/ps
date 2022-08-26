package codetest;
import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class B_17471 {
	static int n, subsetCount;
	static int[] ingu, visited;
	static ArrayList<Integer> sub, exc;
	static int[][] arr;
	static int[] subset;
	static int min = Integer.MAX_VALUE;
	static StringTokenizer stringTokenizer;
	static Queue<Integer> queue = new LinkedList<>();
	static HashSet<Integer>[] gragh;
	static HashSet<Integer> set;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bufferedReader.readLine());

		gragh = new HashSet[n];
		for (int i = 0; i < n; i++) {
			gragh[i] = new HashSet<>();
		}

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		ingu = new int[n];
		arr = new int[n][n];
		subset = new int[n];

		for (int i = 0; i < n; i++) {
			subset[i] = i;
		}

		for (int k = 0; k < n; k++) {
			ingu[k] = Integer.parseInt(stringTokenizer.nextToken());
		}

		for (int k = 0; k < n; k++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int temp = Integer.parseInt(stringTokenizer.nextToken());

			for (int i = 0; i < temp; i++) {
				int index = Integer.parseInt(stringTokenizer.nextToken());
				index--;

				gragh[k].add(index);
				gragh[index].add(k);
				arr[k][index] = 1;
				arr[index][k] = 1;
			}

		}

		for (int k = 0; k < n; k++) {
			System.out.println(gragh[k]);
		}
		System.out.println();

		for (int k = 0; k < n; k++) {
			System.out.println(Arrays.toString(arr[k]));
		}
		System.out.println();

		for (int k = 1; k < n / 2 + 1; k++) {
			visited = new int[n];
			sub = new ArrayList<>();
			exc = new ArrayList<>();
			subset(0, n, 0, k);
			System.out.println();

		}

	}

	static void subset(int cnt, int n, int checknum, int k) {

		if (cnt == n || checknum == k) {
			if (cnt == n && checknum != k) {
				return;
			}
			for (int i = 0; i < n; i++) {
				if (visited[i] == 1) {
					sub.add(subset[i]);
				} else {
					exc.add(subset[i]);
				}
			}
			System.out.println(Arrays.toString(visited));
			System.out.println(sub);
			System.out.println(exc);
			System.out.println();

			sub = new ArrayList<>();
			exc = new ArrayList<>();
			return;
		}

		visited[cnt] = 1;
		subset(cnt + 1, n, checknum + 1, k);

		visited[cnt] = 0;
		subset(cnt + 1, n, checknum, k);
	}

	static boolean checkLink(ArrayList<Integer> arr) {
		queue.offer(arr.get(0));
		for (int i = 1; i < arr.size(); i++) {
			set.add(arr.get(i));
		}

		while (!set.isEmpty()) {
			int node = queue.poll();
			for (int i = 0; i < gragh[node].size(); i++) {
				
			}

		}



		return true;
	}

	public static int combination(int n, int r) {
		if (n == r || r == 0)
			return 1;
		else
			return combination(n - 1, r - 1) + combination(n - 1, r);
	}

}
