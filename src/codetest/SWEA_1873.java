package codetest;


import java.util.Scanner;

public class SWEA_1873 {
	static int x = 0, y = 0;

	// 포탄 시작점
	static int px = 0, py = 0;
	static int direc = 0;
	static int h = 2, w = 2;
	static char[][] arr = new char[20][20];
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static void move(char com) {

		if (com == 'S') {
//			System.out.println("check " + direc);
			while (true) {
				// 테이블 범위 안일 때
				if (direc == 0 && (px + dx[direc]) > -1) {
					if (arr[px + dx[direc]][py] == '*') {
						arr[px + dx[direc]][py] = '.';
						break;
					}
					if (arr[px + dx[direc]][py] == '#') {
						break;
					}
					px--;
				} else if (direc == 1 && (py + dy[direc]) < w) {
					if (arr[px][py + dy[direc]] == '*') {
						arr[px][py + dy[direc]] = '.';
						break;
					}
					if (arr[px][py + dy[direc]] == '#') {
						break;
					}
					py++;
				} else if (direc == 2 && (px + dx[direc]) < h) {
					if (arr[px + dx[direc]][py] == '*') {
						arr[px + dx[direc]][py] = '.';
						break;
					}
					if (arr[px + dx[direc]][py] == '#') {
						break;
					}
					px++;
				} else if (direc == 3 && (py + dy[direc]) > -1) {
					if (arr[px][py + dy[direc]] == '*') {
						arr[px][py + dy[direc]] = '.';
						break;
					}
					if (arr[px][py + dy[direc]] == '#') {
						break;
					}
					py--;
				} else if ((px + dx[direc]) < 0 || (px + dx[direc]) > (h - 1) || (py + dy[direc]) < 0
						|| (py + dy[direc]) > (w - 1)) {
					break;
				}

			}

		} else {

			if (com == 'U') {
				direc = 0;
//				System.out.println(direc);
				if ((x + dx[direc]) > -1 && arr[x + dx[direc]][y] == '.') {
					arr[x][y] = '.';
					x = x + dx[direc];
					arr[x][y] = '^';

				} else {
					arr[x][y] = '^';
				}
			} else if (com == 'R') {

				direc = 1;
//				System.out.println(direc);
				if ((y + dy[direc]) < w && arr[x][y + dy[direc]] == '.') {
					arr[x][y] = '.';
					y = y + dy[direc];
					arr[x][y] = '>';
				} else {
					arr[x][y] = '>';
				}
			} else if (com == 'D') {

				direc = 2;
//				System.out.println(direc);
				if ((x + dx[direc]) < h && arr[x + dx[direc]][y] == '.') {
					arr[x][y] = '.';
					x = x + dx[direc];
					arr[x][y] = 'v';
				} else {
					arr[x][y] = 'v';
				}
			} else if (com == 'L') {

				direc = 3;
//				System.out.println(direc);
				if ((y + dy[direc]) > -1 && arr[x][y + dy[direc]] == '.') {
					arr[x][y] = '.';
					y = y + dy[direc];
					arr[x][y] = '<';
				} else {
					arr[x][y] = '<';
				}
			}

		}
//		for (int i = 0; i < h; i++) {
//			for (int j = 0; j < w; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();

		px = x;
		py = y;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		for (int tc = 1; tc <= n; tc++) {

			// 데이터 입력
			h = scanner.nextInt();
			w = scanner.nextInt();

			for (int i = 0; i < h; i++) {
				String temp = scanner.next();
				for (int j = 0; j < w; j++) {
					arr[i][j] = temp.charAt(j);
				}
			}

			int control = scanner.nextInt();
			char[] controls = new char[control];
			String temp = scanner.next();
			for (int i = 0; i < control; i++) {
				controls[i] = temp.charAt(i);
			}

//			System.out.println("start");
//			for (int i = 0; i < h; i++) {
//				for (int j = 0; j < w; j++) {
//					System.out.print(arr[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();

			// 탱크의 방향 확인

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {

					if (arr[i][j] == '^') {
						x = i;
						y = j;
						px = i;
						py = j;
						direc = 0;
					} else if (arr[i][j] == '>') {
						x = i;
						y = j;
						px = i;
						py = j;
						direc = 1;
					} else if (arr[i][j] == 'v') {
						x = i;
						y = j;
						px = i;
						py = j;
						direc = 2;
					} else if (arr[i][j] == '<') {
						x = i;
						y = j;
						px = i;
						py = j;
						direc = 3;
					}
				}
			}
//			System.out.println(x + " " + y + " " + direc);
//			System.out.println();

			for (int k = 0; k < control; k++) {
				move(controls[k]);

			}

			System.out.print("#" + tc+" ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}

		}
	}
}
