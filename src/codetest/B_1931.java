package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_1931 {
	static ArrayList<Lecture> list = new ArrayList<>();
	static StringTokenizer stringTokenizer;
	static int n;
	static int count = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		n = Integer.parseInt(stringTokenizer.nextToken());

		for (int k = 0; k < n; k++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			Lecture lecture = new Lecture();
			lecture.start = Integer.parseInt(stringTokenizer.nextToken());
			lecture.end = Integer.parseInt(stringTokenizer.nextToken());
			list.add(lecture);
		}

		Collections.sort(list);

//		System.out.println(list);

		fuc();

		System.out.println(count);
	}

	static void fuc() {
		ArrayList<Lecture> result = new ArrayList<>();
		result.add(list.get(0));
		for (int i = 1; i < list.size(); i++) {

			if (result.get(result.size() - 1).end <= list.get(i).start) {
				result.add(list.get(i));
				count++;
			}
		}

	}

}

class Lecture implements Comparable<Lecture> {
	int start, end;

	@Override
	public int compareTo(Lecture o) {
		if (this.end == o.end) {
			return this.start - o.start;
		}
		return this.end - o.end;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return start + " " + end;
	}
}
