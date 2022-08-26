package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_1218 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());
			Stack<Character> stack = new Stack<>();

			int n = Integer.parseInt(stringTokenizer.nextToken());
			stringTokenizer = new StringTokenizer(bf.readLine());
			String temp = stringTokenizer.nextToken();

			int count = 0;
			int result = 1;
			loop: while (true) {
				if (count == temp.length()) {
					break;
				}

//				System.out.print(temp.charAt(count));

				switch (temp.charAt(count)) {
				case '[':
				case '{':
				case '(':
				case '<':
					stack.add(temp.charAt(count));
					break;

				case ']':
					if (stack.peek() == '[') {
						stack.pop();
					} else {
						result = 0;
						break loop;
					}
					break;
				case '}':
					if (stack.peek() == '{') {
						stack.pop();
					} else {
						result = 0;
						break loop;
					}
					break;

				case ')':
					if (stack.peek() == '(') {
						stack.pop();
					} else {
						result = 0;
						break loop;
					}
					break;
				case '>':
					if (stack.peek() == '<') {
						stack.pop();
					} else {
						result = 0;
						break loop;
					}
					break;
				}

				count++;

			}
			System.out.println("#" + tc + " " + result);

		}
	}
}
