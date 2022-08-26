package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_1228 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			int n = Integer.parseInt(stringTokenizer.nextToken());

			LinkedList<Integer> list = new LinkedList<>();
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int i = 0; i < n; i++) {
				list.add(Integer.parseInt(stringTokenizer.nextToken()));
			}
//			for (Integer integer : list) {
//				System.out.print(integer + " ");
//			}
//			System.out.println();

			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int m = Integer.parseInt(stringTokenizer.nextToken());

			stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			for (int i = 0; i < m; i++) {

				stringTokenizer.nextToken();
				int x = Integer.parseInt(stringTokenizer.nextToken());
				int y = Integer.parseInt(stringTokenizer.nextToken());

				for (int j = 0; j < y; j++) {
					list.add(x + j, Integer.parseInt(stringTokenizer.nextToken()));
				}

			}

			System.out.print("#" + tc + " ");
			for (int j = 0; j < 10; j++) {
				System.out.print(list.get(j) + " ");
			}
			System.out.println();
		}

	}
}
