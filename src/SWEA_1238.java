import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238 {
	static HashMap<Integer, ArrayList<Integer>> graphHashMaps;
	static HashMap<Integer, Integer> keyMap;
	static int[] visited;
	static Queue<Integer> queue = new LinkedList<>();
	static ArrayList<Integer> result;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer;

		for (int tc = 1; tc <= 10; tc++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			int data = Integer.parseInt(stringTokenizer.nextToken());
			int startNode = Integer.parseInt(stringTokenizer.nextToken());

			graphHashMaps = new HashMap<>();
			keyMap = new HashMap<>();
			result = new ArrayList<>();

			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int i = 0; i < data / 2; i++) {
				int start = Integer.parseInt(stringTokenizer.nextToken());
				int target = Integer.parseInt(stringTokenizer.nextToken());
				keyMap.put(start, 0);
				keyMap.put(target, 0);

				if (graphHashMaps.containsKey(start)) {
					ArrayList<Integer> tempArrayList = graphHashMaps.get(start);
					tempArrayList.add(target);
					graphHashMaps.put(start, tempArrayList);
				} else {
					ArrayList<Integer> tempArrayList = new ArrayList<>();
					tempArrayList.add(target);
					graphHashMaps.put(start, tempArrayList);

				}
			}
//			System.out.println(graphHashMaps);

			queue.add(startNode);
			keyMap.put(startNode, 1);
			while (!queue.isEmpty()) {
				result = fuc();

			}

			int max = result.get(0);
			for (int i = 0; i < result.size(); i++) {
				if (max < result.get(i)) {
					max = result.get(i);
				}
			}

		System.out.println("#" + tc + " " + max);

		}

	}

	static ArrayList<Integer> fuc() {
		ArrayList<Integer> resultArrayList = new ArrayList<>();
		int queueSize = queue.size();
		for (int i = 0; i < queueSize; i++) {
			int node = queue.poll();
			resultArrayList.add(node);
			ArrayList<Integer> temp = graphHashMaps.get(node);
			if (temp == null) {
				continue;
			}

			for (int j = 0; j < temp.size(); j++) {
				if (keyMap.get(temp.get(j)) == 0) {
					queue.add(temp.get(j));
					keyMap.put(temp.get(j), 1);
				}
			}
		}

		return resultArrayList;

	}

}
