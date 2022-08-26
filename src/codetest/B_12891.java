package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class B_12891 {

	static int result = 0;
	static int[] v;
	static int count = 0;
	static int n, c;
	static char[] tempArr;
	static char[] arr;
	static Set<String> overlap = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int[] num = new int[4];
		int[] countnum = new int[4];
		arr = new char[n];

		n = Integer.parseInt(stringTokenizer.nextToken());
		c = Integer.parseInt(stringTokenizer.nextToken());

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		String temp = stringTokenizer.nextToken();
//		System.out.println(temp);

		stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			num[i] = Integer.parseInt(stringTokenizer.nextToken());

		}
//		System.out.println(Arrays.toString(num));

		String tempArr;
		loop: for (int i = 0; i < n - c + 1; i++) {

			tempArr = temp.substring(i, i + c);

//			System.out.println(tempArr);
			countnum = new int[4];
			for (int j = 0; j < c; j++) {
				switch (tempArr.charAt(j)) {
				case 'A':
					countnum[0]++;
					break;
				case 'C':
					countnum[1]++;
					break;
				case 'G':
					countnum[2]++;
					break;
				case 'T':
					countnum[3]++;
					break;
				}
			}

//			System.out.println(Arrays.toString(countnum));
//			System.out.println();
			for (int j = 0; j < 4; j++) {
				if (num[j] < countnum[j]) {
					continue loop;
				}
			}

			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(countnum[0]);
			stringBuilder.append(countnum[1]);
			stringBuilder.append(countnum[2]);
			stringBuilder.append(countnum[3]);

			String key = stringBuilder.toString();
			if (overlap.contains(key)) {
				continue;
			}

			count++;

		}

		System.out.println(count);

	}

}
