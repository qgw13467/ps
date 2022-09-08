import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import javax.management.monitor.Monitor;
import javax.naming.CompositeName;

public class B_1759 {
	static int L, C;
	static char[] list;
	static ArrayList<Character> arr = new ArrayList<>();
	static ArrayList<Character> mos = new ArrayList<>();
	static ArrayList<Character> jas = new ArrayList<>();

	static char[] mo = { 'a', 'e', 'i', 'o', 'u' };

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		L = Integer.parseInt(stringTokenizer.nextToken());
		C = Integer.parseInt(stringTokenizer.nextToken());

		list = new char[C];
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < C; i++) {
			list[i] = stringTokenizer.nextToken().charAt(0);
			if (list[i] == 'a' || list[i] == 'e' || list[i] == 'i' || list[i] == 'o' || list[i] == 'u') {
				mos.add(list[i]);
			} else {
				jas.add(list[i]);
			}

		}

		System.out.println(mos);
		System.out.println(jas);

		for (int k = 2; k < L; k++) {
			int[] visitedMos = new int[mos.size()];
			int[] visitiedJas = new int[jas.size()];

//			comb(mos, visitedMos, 0, L - k);
//			System.out.println();

			comb(jas, visitiedJas, 0, 0, k);
			System.out.println();
		}
	}

	static void comb(ArrayList<Character> arr, int[] visited, int start, int cnt, int r) {

//		if(r>arr.size()	) {
//			comb(arr, visited, start, arr.size());
//		}

		if (cnt == r) {
			ArrayList<Character> resultArrayList = new ArrayList<>();
			int count = 0;
			for (int i = 0; i < visited.length; i++) {
				if (visited[i] == 1) {
					count++;
					resultArrayList.add(arr.get(i));
				}

			}
			if (count == r) {
				System.out.println(resultArrayList);
			}
			return;
		}

		for (int i = start; i < arr.size(); i++) {
			visited[i] = 1;
			comb(arr, visited, start + 1, cnt + 1, r);
			visited[i] = 0;
		}

	}

}
