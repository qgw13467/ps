package codetest;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import javax.naming.spi.DirStateFactory.Result;

public class B_14888 {
	static ArrayList<Integer> integers = new ArrayList<>();
	static ArrayList<String> characters = new ArrayList<>();
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		ArrayList<String> arrayList = new ArrayList<>();
		int n = scanner.nextInt();

		for (int l = 0; l < n; l++) {
			integers.add(scanner.nextInt());
		}

		int plus, minus, pul, div;
		plus = scanner.nextInt();
		minus = scanner.nextInt();
		pul = scanner.nextInt();
		div = scanner.nextInt();

		for (int i = 0; i < plus; i++) {
			characters.add("+");
		}

		for (int i = 0; i < minus; i++) {
			characters.add("-");
		}

		for (int i = 0; i < pul; i++) {
			characters.add("*");
		}

		for (int i = 0; i < div; i++) {
			characters.add("/");
		}

		Fuc(characters, 0, characters.size());

		System.out.println(max);
		System.out.println(min);

	}

	static void Fuc(ArrayList<String> arr, int start, int end) {

		if (start == end) {
			return;
		}

		for (int i = start; i < arr.size(); i++) {

			String temp = arr.get(start);
			arr.set(start, arr.get(i));
			arr.set(i, temp);

			Fuc(arr, start + 1, end);

			temp = arr.get(start);
			arr.set(start, arr.get(i));
			arr.set(i, temp);

		}

//		for (String string : arr) {
//			System.out.print(string + " ");
//		}
//		System.out.println();

		Stack<Integer> integerStack = new Stack<>();
		for (int i = integers.size() - 1; i >= 0; i--) {
			integerStack.add(integers.get(i));
		}

		int count = 0;
		int result = 0;
		while (integerStack.size() != 1) {
			int a = integerStack.pop();
			int b = integerStack.pop();
			if (arr.get(count).equals("*")) {
				a = a * b;
				integerStack.push(a);
			} else if (arr.get(count).equals("/")) {
				a = a / b;
				integerStack.push(a);
			} else if (arr.get(count).equals("+")) {
				a = a + b;
				integerStack.push(a);
			} else if (arr.get(count).equals("-")) {
				a = a - b;
				integerStack.push(a);
			}

			count++;
		}

		result = integerStack.pop();
		if (min > result) {
			min = result;
		}
		if (max < result) {
			max = result;
		}

	}
}
