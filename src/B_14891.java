import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14891 {

	static int n;
	static int gear[][];
	static StringTokenizer stringTokenizer;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		gear = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String temp = bufferedReader.readLine();
			for (int j = 0; j < 6; j++) {
				gear[i][j] = temp.charAt(j) - '0';
			}

		}

		n = Integer.parseInt(bufferedReader.readLine());
		for (int k = 0; k < n; k++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			int num = Integer.parseInt(stringTokenizer.nextToken());
			int dir = Integer.parseInt(stringTokenizer.nextToken());

			fuc(num, dir);

		}

	}

	static void fuc(int num, int dir) {
		left(num-1, -dir);
		right(num+1, -dir);
		rotate(num,dir);
	}

	static void left(int index, int dir) {
		if (index < 0)
			return;
		if (gear[index][2] == gear[index + 1][6])
			return;
		left(index - 1, -dir);
		rotate(index, dir);
	}

	static void right(int index, int dir) {
		if (index > 3)
			return;
		if (gear[index][6] == gear[index - 1][2])
			return;
		right(index + 1, -dir);
		rotate(index, dir);
	}

	static void rotate(int index, int dir) {
		if (index == 1) {
			int tmp = gear[index][7];
			for (int i = 7; i > 0; i--) {
				gear[index][i] = gear[index][i - 1];
			}
			gear[index][0] = tmp;
		} else {
			int tmp = gear[index][0];
			for (int i = 0; i < 7; i++) {
				gear[index][i] = gear[index][i + 1];
			}
			gear[index][7] = tmp;
		}
	}
}
