import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1655 {
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static PriorityQueue<Integer> min = new PriorityQueue<>();
	static int n;
	static StringTokenizer staStringTokenizer;
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());

		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(bufferedReader.readLine());
			pq.add(temp);
//			System.out.println(pq);


			int size = pq.size();
			for (int k = 0; k < (size - 1) / 2; k++) {
				queue.add(pq.poll());
			}
			temp = pq.poll();
			System.out.println(temp);
			
			pq.add(temp);
			int qsize = queue.size();
			for (int k = 0; k < qsize; k++) {
				pq.add(queue.poll());
			}
//			System.out.println(queue);
//			System.out.println();
		}

	}
}
