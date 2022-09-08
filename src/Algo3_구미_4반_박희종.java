import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo3_구미_4반_박희종 {
	static char[][] arr;
	static int R, C, N;
	static StringTokenizer stringTokenizer;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		R = Integer.parseInt(stringTokenizer.nextToken());
		C = Integer.parseInt(stringTokenizer.nextToken());

		arr = new char[R][C];

		for (int i = 0; i < R; i++) {
			String string = bufferedReader.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = string.charAt(j);
			}
		}

//		for (int i = 0; i < R; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
//		System.out.println();

		N = Integer.parseInt(bufferedReader.readLine());
		for (int i = 0; i < N; i++) {
			int col = Integer.parseInt(bufferedReader.readLine()) - 1;

			input(0, col);

		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}

	}

	static void input(int row, int col) {

		int i = row;
		while (true) {
			if (i + 1 == R || arr[i + 1][col] == 'X') {
				arr[i][col] = 'O';
				return;

			}

			else if (i + 1 < R && arr[i + 1][col] == 'O' && col - 1 >= 0 && arr[i][col - 1] == '.'
					&& arr[i + 1][col - 1] == '.') {
				input(i, col - 1);
				return;
			} 
			else if (i + 1 < R && arr[i + 1][col] == 'O' && col + 1 <= C - 1 && arr[i][col + 1] == '.'
					&& arr[i + 1][col + 1] == '.') {
				input(i, col + 1);
				return;
			}

			else if (arr[i + 1][col] == 'O' && col == 0) {
				arr[i][col] = 'O';
				return;
			}

			else if (arr[i + 1][col] == 'O' && col == C - 1) {
				arr[i][col] = 'O';
				return;
			}
			i++;
		}

	}
}
