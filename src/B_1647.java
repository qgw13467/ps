import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1647 {
	static int node, edge, sum, count;

	static class Data implements Comparable<Data> {
		public int target, weight;

		@Override
		public int compareTo(Data o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}

		public Data() {
			// TODO Auto-generated constructor stub
		}

		Data(int target, int weitht) {
			this.target = target;
			this.weight = weitht;
		}

		@Override
		public String toString() {
			return "Data [target=" + target + ", weight=" + weight + "]" + "\n";
		}

	}

	static StringTokenizer stringTokenizer;
	static ArrayList<Data> map[];
	static boolean[] visited;
	static Queue<Data> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		node = Integer.parseInt(stringTokenizer.nextToken());
		edge = Integer.parseInt(stringTokenizer.nextToken());
		visited = new boolean[node + 1];
		map = new ArrayList[node + 1];

		for (int i = 0; i < node + 1; i++) {

			map[i] = new ArrayList<>();
		}

		for (int k = 0; k < edge; k++) {

			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int start = Integer.parseInt(stringTokenizer.nextToken());
			int target = Integer.parseInt(stringTokenizer.nextToken());
			int weight = Integer.parseInt(stringTokenizer.nextToken());

			map[start].add(new Data(target, weight));
			map[target].add(new Data(start, weight));
		}

		int count = 0;
		int result = 0;
		int max = 0;

		PriorityQueue<Data> queue = new PriorityQueue<Data>();

		queue.add(new Data(1, 0));

		while (true) {
			Data data = queue.poll();

			if (visited[data.target]) {
				continue;
			}

			
			result += data.weight;
			visited[data.target] = true;
			max = Math.max(max, data.weight);
			count++;

			if (count == node)
				break;

			for (Data v : map[data.target]) {
				if (!visited[v.target]) {
					queue.add(new Data(v.target, v.weight));
				}
			}
		}
		
		System.out.println(result - max);

	}
}
