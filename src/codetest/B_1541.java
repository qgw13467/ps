package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_1541 {

	static StringTokenizer stringTokenizer;
	static ArrayList<String> list = new ArrayList<>();
	static ArrayList<Integer> num = new ArrayList<>();
	static ArrayList<String> oper = new ArrayList<>();
	static ArrayList<Integer> resultNum = new ArrayList<>();
	static ArrayList<String> resultOper = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		stringTokenizer = new StringTokenizer(bufferedReader.readLine(), "-+", true);

		while (stringTokenizer.hasMoreTokens()) {
			list.add(stringTokenizer.nextToken());
		}

//		System.out.println(list);

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("+") || list.get(i).equals("-")) {
				oper.add(list.get(i));
			} else {
				num.add(Integer.parseInt(list.get(i)));
			}
		}

//		System.out.println(num);
//		System.out.println(oper);

		for (int i = 0; i < oper.size() - 1; i++) {
			if (oper.get(i).equals("-")) {
				int j = i + 1;
				while (j < oper.size()) {

					if (oper.get(j).equals("-")) {
						break;
					}
					j++;

				}
				j--;
//				System.out.println(i + 1 + " " + j);

				for (int k = i + 1; k <= j; k++) {
					num.set(i + 1, num.get(i + 1) + num.get(i + 2));
					num.remove(i + 2);
					oper.remove(i + 1);
				}
			}
		}
		int temp = oper.size();
		for (int i = 0; i < temp; i++) {
			if (oper.get(0).equals("-")) {
				num.set(0, num.get(0) - num.get(1));
				oper.remove(0);
				num.remove(1);
			} else {
				num.set(0, num.get(0) + num.get(1));
				oper.remove(0);
				num.remove(1);
			}

		}

//		System.out.println(num);
//		System.out.println(oper);
		System.out.println(num.get(0));

	}
}
