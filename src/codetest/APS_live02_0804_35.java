package codetest;
import java.util.Stack;

public class APS_live02_0804_35 {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();

		String input = "6528-*2/+";

		int count = 0;
		while (count != input.length()) {
			if (input.charAt(count) >= '0' || input.charAt(count) <= 9) {
				stack.add(input.charAt(count) - '0');
			} else if (input.charAt(count) == '+') {
				int a = stack.pop();
				int b = stack.pop();
				int temp = a + b;
				stack.add(temp);

			} else if (input.charAt(count) == '-') {

				int a = stack.pop();
				int b = stack.pop();
				int temp = b - a;
				stack.add(temp);
			} else if (input.charAt(count) == '*') {

				int a = stack.pop();
				int b = stack.pop();
				int temp = a * b;
				stack.add(temp);
			} else if (input.charAt(count) == '/') {

				int a = stack.pop();
				int b = stack.pop();
				int temp = b / a;
				stack.add(temp);
			}

			count++;
		}

		int result = stack.pop();
		System.out.println(result);

	}
}
