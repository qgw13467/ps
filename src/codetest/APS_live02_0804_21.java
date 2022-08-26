package codetest;
import java.util.ArrayList;

public class APS_live02_0804_21 {

	static int[] arr;
	static int[] v;
	static boolean pass;

	public static void main(String[] args) {

		arr = new int[] { -7, -3, -2, 5, 8 };
		v = new int[arr.length];
		fuc(0);

		System.out.println("가능여부: " + pass);
	}

	static void fuc(int cnt) {

		if (cnt == arr.length - 1) {
			ArrayList<Integer> list = new ArrayList<>();
			int result = 0;
			int count = 0;
			for (int i = 0; i < v.length; i++) {

				if (v[i] == 1) {
					count++;
					result += arr[i];
					list.add(arr[i]);
				}
			}
			if (result == 0 && count != 0) {
				pass = true;
			}
			System.out.println(list.toString() + "= " + result);
		} else {
			v[cnt] = 1;
			fuc(cnt + 1);
			v[cnt] = 0;
			fuc(cnt + 1);
		}
	}
}
