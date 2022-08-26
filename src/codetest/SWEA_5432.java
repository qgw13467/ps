package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_5432 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int t = Integer.parseInt(stringTokenizer.nextToken());

		for (int tc = 1; tc <= t; tc++) {
			Stack<Character> stack = new Stack<>();
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			String temp = stringTokenizer.nextToken();
			int result = 0;
			for (int i = 0; i < temp.length(); i++) {
				if (temp.charAt(i) == '(') {
					stack.add('(');

				} else {
					if (i > 0 && temp.charAt(i - 1) == '(') {

						stack.pop();
						result += stack.size();
						continue;
					}
					stack.pop();
					result += 1;

				}
			}

			System.out.println("#"+tc+" "+result);

		}
	}
}
