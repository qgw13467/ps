package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1157 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		String word = stringTokenizer.nextToken();
		int[] alpha = new int[26];
		word = word.toLowerCase();
		for (int i = 0; i < word.length(); i++) {

			alpha[word.charAt(i) - 'a']++;
		}

		int max = 0;
		int index = 0;
		int maxNum = 0;
		for (int i = 0; i < 26; i++) {

			if (max == alpha[i]) {
				maxNum++;
			}
			if (max < alpha[i]) {
				index = i;
				max = alpha[i];
				maxNum = 1;
			}
		}

		if (maxNum > 1) {
			System.out.println("?");
		} else {
			char result = (char) ('A' + index);
			System.out.println(result);
		}

	}
}
