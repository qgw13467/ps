package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_16935 {
	static int n, m, r;
	static ArrayList<Integer> a = new ArrayList<>();
	static int[][] arr;
	static int[][] result;
	static int[][] temp1, temp2, temp3, temp4;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		n = Integer.parseInt(stringTokenizer.nextToken());
		m = Integer.parseInt(stringTokenizer.nextToken());
		r = Integer.parseInt(stringTokenizer.nextToken());
		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		for (int i = 0; i < r; i++) {
			a.add(Integer.parseInt(stringTokenizer.nextToken()));
		}

		for (int l = 0; l < a.size(); l++) {
			fuc(a.get(l));
			n = result.length;
			m = result[0].length;
			arr = new int[result.length][result[0].length];
			for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result[0].length; j++) {
					arr[i][j] = result[i][j];
				}

			}
		}

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void fuc(int a) {
		switch (a) {
		case 1:
			fuc1();
			break;
		case 2:
			fuc2();
			break;
		case 3:
			fuc3();
			break;
		case 4:
			fuc4();
			break;
		case 5:
			fuc5();
			break;
		case 6:
			fuc6();
			break;
		}
	}

	static void fuc1() {
		result = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result[n - 1 - i][j] = arr[i][j];
			}
		}
	}

	static void fuc2() {
		result = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result[i][m - 1 - j] = arr[i][j];
			}
		}
	}

	static void fuc3() {
		result = new int[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result[j][n - 1 - i] = arr[i][j];
			}
		}
	}

	static void fuc4() {
		result = new int[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result[m - 1 - j][i] = arr[i][j];
			}
		}
	}

	static void fuc5() {
		result = new int[n][m];
		setting();
		int r = n / 2;
		int c = m / 2;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result[i][j] = temp4[i][j];
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result[i][j + c] = temp1[i][j];
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result[i + r][j + c] = temp2[i][j];
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result[i + r][j] = temp3[i][j];
			}
		}

	}

	static void fuc6() {
		result = new int[n][m];
		setting();
		int r = n / 2;
		int c = m / 2;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result[i][j] = temp2[i][j];
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result[i][j + c] = temp3[i][j];
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result[i + r][j + c] = temp4[i][j];
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result[i + r][j] = temp1[i][j];
			}
		}
	}

	static void setting() {
		int r = n / 2;
		int c = m / 2;
		temp1 = new int[r][c];
		temp2 = new int[r][c];
		temp3 = new int[r][c];
		temp4 = new int[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				temp1[i][j] = arr[i][j];
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = c; j < m; j++) {
				temp2[i][j - c] = arr[i][j];
			}
		}

		for (int i = r; i < n; i++) {
			for (int j = c; j < m; j++) {
				temp3[i - r][j - c] = arr[i][j];
			}
		}

		for (int i = r; i < n; i++) {
			for (int j = 0; j < c; j++) {
				temp4[i - r][j] = arr[i][j];
			}
		}

	}
}
