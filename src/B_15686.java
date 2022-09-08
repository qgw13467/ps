import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_15686 {
	static int n, m;
	static int[][] arr;
	static ArrayList<Chiken> chikens = new ArrayList<>();
	static ArrayList<User> users = new ArrayList<>();
	static int[] visit;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		n = Integer.parseInt(stringTokenizer.nextToken());
		m = Integer.parseInt(stringTokenizer.nextToken());

		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
				if (arr[i][j] == 2) {
					Chiken chiken = new Chiken();
					chiken.x = i;
					chiken.y = j;
					chikens.add(chiken);
				} else if (arr[i][j] == 1) {
					User user = new User();
					user.x = i;
					user.y = j;
					users.add(user);
				}
			}
		}
		visit = new int[chikens.size()];

//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
//		System.out.println();

		comb(0, m);

		System.out.println(min);
	}

	static int getChikenNum(int x, int y) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < chikens.size(); i++) {
			Chiken chiken = chikens.get(i);
			if (chiken.check == 0) {
				int temp = Math.abs(x - chiken.x) + Math.abs(y - chiken.y);
				min = Math.min(min, temp);
				chiken.sum += temp;
				chikens.set(i, chiken);
			}

		}
		return min;
	}

	static void comb(int cnt, int n) {
		if (n == 0) {

			Chiken tempChiken;

			// 조합에서 선택되지 않는 치킨집을 배열에서 삭제
			for (int k = 0; k < visit.length; k++) {
				if (visit[k] == 0) {
					arr[chikens.get(k).x][chikens.get(k).y] = 0;
					tempChiken = chikens.get(k);
					tempChiken.check = 1;
					chikens.set(k, tempChiken);

				}
			}
			int temp = 0;
			for (int i = 0; i < users.size(); i++) {
				User user = users.get(i);
				user.chiNum = getChikenNum(user.x, user.y);
				temp += user.chiNum;

				users.set(i, user);
			}

//			for (int i = 0; i < B_15686.n; i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
//			System.out.println();
//
//			for (Chiken chiken : chikens) {
//				System.out.println(chiken);
//			}
//			System.out.println();

			min = Math.min(min, temp);
//			System.out.println(min);
//			System.out.println();
			// 삭제한 치킨집을 원레대로 복구
			for (int k = 0; k < visit.length; k++) {
				if (visit[k] == 0) {
					arr[chikens.get(k).x][chikens.get(k).y] = 2;
					tempChiken = chikens.get(k);
					tempChiken.check = 0;
					chikens.set(k, tempChiken);

				}
			}
//			System.out.println(Arrays.toString(visit));
//			System.out.println("=========================");
			return;
		}

		if (cnt == chikens.size()) {
			return;
		}

		visit[cnt] = 1;
		comb(cnt + 1, n - 1);
		visit[cnt] = 0;
		comb(cnt + 1, n);

	}

}

class Chiken {
	int x, y, sum, check;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return x + " " + y + " " + sum + " " + check;
	}
}

class User {
	int x, y, chiNum;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return x + " " + y + " " + chiNum;
	}
}
