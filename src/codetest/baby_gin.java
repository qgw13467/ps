package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baby_gin {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		HashMap<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		HashSet<Integer> set = new HashSet<>();

		int result = 0;

		while (stringTokenizer.hasMoreTokens()) {
			int temp = Integer.parseInt(stringTokenizer.nextToken());
			set.add(temp);

			if (map.containsKey(temp)) {
				map.put(temp, map.get(temp) + 1);

			} else {
				map.put(temp, 1);
			}

		}

		for (Integer integer : set) {
			queue.add(integer);
		}

		int[] list = new int[queue.size()];
		int count = 0;
		for (int i : queue) {
			list[count] = i;
			count++;
		}

		int[] increasecheck = new int[queue.size()];

		for (int i = list.length - 1; i > 0; i--) {
			if (list[i - 1] + 1 == list[i]) {
				increasecheck[i - 1] = 1 + increasecheck[i];
			}

		}

		for (int i = 0; i < list.length; i++) {
			if (increasecheck[i] == 2) {
				result = 1;
				break;
			}

		}

		for (Integer integer : map.keySet()) {
			if (map.get(integer) >= 3) {
				result = 1;
				break;
			}
		}

		
		System.out.println(Arrays.toString(list));
		System.out.println(Arrays.toString(increasecheck));

		System.out.println(result);

	}
}
