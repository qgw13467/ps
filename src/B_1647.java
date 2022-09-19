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
		public int start, target, weight;

		@Override
		public int compareTo(B_1647.Data o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}

		@Override
		public String toString() {
			return "Data [start=" + start + ", target=" + target + ", weight=" + weight + "]"+"\n";
		}

	}

	static StringTokenizer stringTokenizer;
	static int[] visited;
	static Queue<Data> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		node = Integer.parseInt(stringTokenizer.nextToken());
		edge = Integer.parseInt(stringTokenizer.nextToken());
		visited = new int[node + 1];
		queue = new LinkedList<>();
		for (int k = 0; k < edge; k++) {

			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			Data data = new Data();
			data.start = Integer.parseInt(stringTokenizer.nextToken());
			data.target = Integer.parseInt(stringTokenizer.nextToken());
			data.weight = Integer.parseInt(stringTokenizer.nextToken());
			queue.add(data);
		}
		
		Collections.sort((List<Data>) queue);
		System.out.println(queue);

		Data temp = queue.poll();
		visited[temp.start] =1;
		visited[temp.target] =1;
		
		sum+=temp.weight;
		count++;
		
		
		while(!queue.isEmpty()) {
			Data data = queue.poll();
			if(visited[data.start] ==1 && visited[data.target]==1) {
				continue;
			}
			if(visited[data.start] ==0 && visited[data.target]==0) {
				queue.add(data);
				continue;
			}
			
			visited[data.start] =1;
			visited[data.target] =1;
			
			sum+=data.weight;
			count++;
			
			System.out.println(data);
		}
		
		System.out.println(sum);
		
		
	}
}
