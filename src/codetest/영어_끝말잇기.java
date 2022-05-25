package codetest;

import java.util.HashSet;

public class 영어_끝말잇기 {
	public int[] solution(int n, String[] words) {
		int[] answer = { 0, 0 };
		HashSet<String> wordSet = new HashSet<>();

		for (int i = 0; i < words.length; i++) {
			int usernum = i % n;

			if (i > 0) {
				int pastwordlength = words[i - 1].length();

				if (words[i - 1].charAt(pastwordlength - 1) != words[i].charAt(0)) {
					answer[0] = usernum + 1;
					answer[1] = i / n + 1;
					return answer;
				}
			}

			if (wordSet.contains(words[i])) {
				answer[0] = usernum + 1;
				answer[1] = i / n + 1;
				return answer;
			}
			wordSet.add(words[i]);
		}

		return answer;
	}
}
