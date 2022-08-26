package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11723 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int n = Integer.parseInt(stringTokenizer.nextToken());
		int memory = 0;
		StringBuilder stringBuilder = new StringBuilder();

		for (int l = 0; l < n; l++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			String command = stringTokenizer.nextToken();

			if (command.equals("add")) {
				int temp = Integer.parseInt(stringTokenizer.nextToken());
				memory = memory | (1 << temp);
//				System.out.println(Integer.toBinaryString(memory));
			} else if (command.equals("check")) {
				int temp = Integer.parseInt(stringTokenizer.nextToken());
				if ((memory & (1 << temp)) != 0) {
					stringBuilder.append(1).append("\n");
//					System.out.println(1);
				} else {
					stringBuilder.append(0).append("\n");
//					System.out.println(0);
				}
			} else if (command.equals("remove")) {
				int temp = Integer.parseInt(stringTokenizer.nextToken());
				memory = memory ^ (1 << temp);
//				System.out.println(Integer.toBinaryString(memory));
			} else if (command.equals("toggle")) {
				int temp = Integer.parseInt(stringTokenizer.nextToken());
				if ((memory & (1 << temp)) != 0) {
					memory = memory ^ (1 << temp);
					stringBuilder.append(1).append("\n");
					System.out.println(1);
//					System.out.println(Integer.toBinaryString(memory));
				} else {
					memory = memory | (1 << temp);
					stringBuilder.append(1).append("\n");
//					System.out.println(0);
//					System.out.println(Integer.toBinaryString(memory));
				}
			} else if (command.equals("all")) {
				for (int i = 1; i <= 20; i++) {
					memory = memory | (1 << i);
				}
//				System.out.println(Integer.toBinaryString(memory));
			} else if (command.equals("empty")) {
				memory = memory ^ memory;
//				System.out.println(Integer.toBinaryString(memory));

			}
		}
		System.out.println(stringBuilder.toString());

	}
}
