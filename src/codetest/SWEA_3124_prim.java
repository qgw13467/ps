package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class SWEA_3124_prim {
	static StringTokenizer stringTokenizer;
	static int[] vistied;
	static ArrayList<ArrayList<Edge>> arr;
	static int t, n, m;
	static int start, target, weight;
	static PriorityQueue<Edge> queue = new PriorityQueue<>();
	static int count, sum;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		t = Integer.parseInt(stringTokenizer.nextToken());

		for (int tc = 1; tc <= t; tc++) {
			queue = new PriorityQueue<>();
			count = 0;
			sum = 0;

			stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			n = Integer.parseInt(stringTokenizer.nextToken());
			m = Integer.parseInt(stringTokenizer.nextToken());

			vistied = new int[n + 1];
			arr = new ArrayList<>();

			for (int i = 0; i < m; i++) {
				stringTokenizer = new StringTokenizer(bufferedReader.readLine());
				start = Integer.parseInt(stringTokenizer.nextToken());
				target = Integer.parseInt(stringTokenizer.nextToken());
				weight = Integer.parseInt(stringTokenizer.nextToken());
				Edge edge = new Edge(start, target, weight);
				ArrayList<Edge> temp = arr.get(start);
				temp.add(edge);
				arr.set(start, temp);
			}

			vistied[1] = 1;

			for (int i = 0; i < arr.get(1).size(); i++) {
				Edge edge = new Edge();
				edge.start = arr.get(1).get(i).start;
				edge.target = arr.get(1).get(i).target;
				edge.weight = arr.get(1).get(i).weight;
				queue.add(edge);
			}

			System.out.println(queue);
			System.out.println();

			;

			while (!queue.isEmpty()) {

				if (count == n - 1) {
					break;
				}
				fuc();
				count++;
			}

			System.out.println("#" + tc + " " + sum);
			System.out.println();

		}
	}

	static void fuc() {
//		while (!queue.isEmpty()) {
//			Edge edge = queue.poll();
//			if (vistied[edge.target] == 0) {
//				sum += edge.weight;
//
//				for (int i = 1; i < n + 1; i++) {
//					if (vistied[i] == 0 && arr[edge.target][i] > 0) {
//						Edge temp = new Edge(edge.target, i, arr[edge.target][i]);
//						vistied[edge.target] = 1;
//						queue.add(temp);
//						System.out.println(queue);
//
//					}
//				}
//				break;
//			}
//
//		}

	}

	static class Edge implements Comparable<Edge> {
		int start, target, weight;

		public Edge() {
			// TODO Auto-generated constructor stub
		}

		public Edge(int start, int target, int weight) {
			this.start = start;
			this.target = target;
			this.weight = weight;
		}

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
