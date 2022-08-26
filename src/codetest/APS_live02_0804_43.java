package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class APS_live02_0804_43 {
	public static void main(String[] args) throws IOException {

		Stack<String> front = new Stack<>();
		Stack<String> back = new Stack<>();

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine(), " ");
		String url = stringTokenizer.nextToken();
		System.out.println(url);
		while (true) {
			stringTokenizer = new StringTokenizer(bf.readLine(), " ");
			String temp = stringTokenizer.nextToken();
			if (temp.equals("V")) {
				back.add(url);
				temp = stringTokenizer.nextToken();
				url = temp;
				System.out.println(url);
			} else if (temp.equals("B")) {
				front.add(url);
				url = back.pop();
				System.out.println(url);
			} else if (temp.equals("F")) {
				back.add(url);
				url = front.pop();
				System.out.println(url);
			} else if (temp.equals("Q")) {
				break;
			}

		}

	}
}
