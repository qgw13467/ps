import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_21276 {

	static int N, M;
	static String[] human;
	static HashMap<String, Integer> map;
	static ArrayList<ArrayList<Integer>> list;
	static int indegree[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		human = new String[N];
		indegree = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			human[i] = st.nextToken();
		}
		Arrays.sort(human);

		map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			map.put(human[i], i);
		}

		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<Integer>());
		}

		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int idx1 = map.get(st.nextToken());
			int idx2 = map.get(st.nextToken());

			list.get(idx2).add(idx1);
			indegree[idx1]++;
		}

		fuc();
	}

	static void fuc() {
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> root = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (indegree[i] == 0) {
				root.add(i);
				q.offer(i);
			}
		}

		ArrayList<ArrayList<Integer>> children = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			children.add(new ArrayList<Integer>());
		}

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : list.get(cur)) {
				indegree[next]--;
				if (indegree[next] == 0) {
					children.get(cur).add(next);
					q.offer(next);
				}
			}
		}

		System.out.println(root.size());
		for (int idx : root) {
			System.out.print(human[idx] + " ");
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			System.out.print(human[i] + " " + children.get(i).size() + " ");
			children.get(i).sort(null);
			for (int idx : children.get(i)) {
				System.out.print(human[idx] + " ");
			}
			System.out.println();
		}
	}

}
