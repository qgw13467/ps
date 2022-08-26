package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class J_1828 {
	static StringTokenizer stringTokenizer;
	static int n;
	static ArrayList<Chemi> chemis = new ArrayList<>();
	static int start, end;
	static int count = 0;
	static int check = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		n = Integer.parseInt(stringTokenizer.nextToken());
		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			Chemi chemi = new Chemi();
			chemi.start = Integer.parseInt(stringTokenizer.nextToken());
			chemi.end = Integer.parseInt(stringTokenizer.nextToken());
			chemis.add(chemi);
		}
		Collections.sort(chemis);

		System.out.println(chemis);
		while (true) {
			if (check == 1) {
				break;
			}
			check = 0;
			fuc();
			count++;
		}

		System.out.println(count);

	}

	static void fuc() {
		ArrayList<Chemi> resultArrayList = new ArrayList<>();
		if (chemis.size() == 0) {
			System.out.println(resultArrayList);
			check = 1;
			return;
		}
		resultArrayList.add(chemis.get(0));
		start = chemis.get(0).start;
		end = chemis.get(0).end;
		chemis.remove(0);
		for (int i = 0; i < chemis.size(); i++) {
			if (resultArrayList.get(resultArrayList.size() - 1).end <= chemis.get(i).start) {
				resultArrayList.add(chemis.get(i));
				chemis.remove(i);
				i--;
			}
		}

	}
}

class Chemi implements Comparable<Chemi> {
	int start, end;

	@Override
	public int compareTo(Chemi o) {
		return end != o.end ? end - o.end : start - o.start;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return start + " " + end;
	}

}
