import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_1197 {
	static StringTokenizer stringTokenizer;
	static int[] node;
	static int t, n, m;
	static ArrayList<Edge> edgeList;
	static int start, target, weight;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		edgeList = new ArrayList<>();
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		n = Integer.parseInt(stringTokenizer.nextToken());
		m = Integer.parseInt(stringTokenizer.nextToken());

		node = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			node[i] = i;
		}

		for (int i = 0; i < m; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			Edge edge = new Edge();
			edge.start = Integer.parseInt(stringTokenizer.nextToken());
			edge.target = Integer.parseInt(stringTokenizer.nextToken());
			edge.weight = Integer.parseInt(stringTokenizer.nextToken());
			edgeList.add(edge);

		}

		Collections.sort(edgeList);
		long sum = 0;
		int count = 0;
		for (int i = 0; i < edgeList.size(); i++) {
			if (count == n - 1) {
				break;
			}
//			System.out.println(Arrays.toString(node));
			Edge edge = edgeList.get(i);
			if (findSet(edge.start) != findSet(edge.target)) {
				count++;
				union(edge.start, edge.target);
				sum += edge.weight;
			}
		}

		System.out.println(sum);
	}

	static int findSet(int x) {
		int result = 0;
		if (node[x] == x) {
			return x;
		} else {
			result = findSet(node[x]);
			node[x] = result;
		}

		return result;

	}

	static void union(int x, int y) {

		if (findSet(x) <= findSet(y)) {
			node[findSet(y)] = findSet(x);

		} else {
			node[findSet(x)] = findSet(y);
		}

	}

	static class Edge implements Comparable<Edge> {
		int start, target, weight;

		@Override
		public int compareTo(Edge o) {
			return weight - o.weight;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return start + " " + target + " " + weight;

		}
	}
}
