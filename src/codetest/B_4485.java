package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_4485 {
	static StringTokenizer st;
	static int n; 
	static int[][] arr;
	static int[][] dist;

	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
    
	public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int count = 0;
    	while(true) {
    		count++;
    		n = Integer.parseInt(br.readLine());
    		
    		if(n == 0) {
    			return;
    		}
    		
    		arr = new int[n][n];
    		dist = new int[n][n];
    		
    		for(int i = 0; i < n; i++) {
    			st = new StringTokenizer(br.readLine());
    			for(int j = 0; j < n; j++) {
    				arr[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		
    		for(int i = 0; i < n; i++) {
    			for(int j = 0; j < n; j++) {
    				dist[i][j] = Integer.MAX_VALUE;
    			}
    		}
    		
    		bfs(0,0);
    		
    		System.out.println("Problem" + " " + count + ": " + dist[n - 1][n - 1]);
    		
//    		for(int i=0;i<n;i++) {
//    			for(int j=0;j<n;j++	) {
//    				System.out.print(dist[i][j]+" ");
//    			}
//    			System.out.println();
//    		}
//    		System.out.println();
    	}
    }
    
    public static void bfs(int x, int y) {
    	Queue<Pair> queue = new LinkedList<>();
    	
    	queue.offer(new Pair(x,y));
    	dist[x][y] = arr[x][y];
    	
    	while(!queue.isEmpty()) {
    		Pair cur = queue.poll();
    		
    		for(int i = 0; i < 4; i++) {
    			int nextX = cur.x + dx[i];
    			int nextY = cur.y + dy[i];
    			
    			if(nextX >= 0 && nextY >=0 && nextX < n && nextY < n) {
    				int curValue = dist[cur.x][cur.y] + arr[nextX][nextY]; // 현재 값
    				
    				if(curValue < dist[nextX][nextY]) {
    					dist[nextX][nextY] = curValue;
    					queue.offer(new Pair(nextX, nextY));
    				}
    			}
    		}
    	}
    }

	static class Edge implements Comparable<Edge> {
		int target, weight;

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

		public Edge(int target, int weight) {
			this.target = target;
			this.weight = weight;
		}

		public Edge() {
		}

	}

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
