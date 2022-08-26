package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_15683 {
	static int[][] arr;
	static int[][] view;
	static StringTokenizer stringTokenizer;
	static int r, c;
	static int chang = 7;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int result = Integer.MAX_VALUE;
	static ArrayList<CCTV> cam = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		r = Integer.parseInt(stringTokenizer.nextToken());
		c = Integer.parseInt(stringTokenizer.nextToken());

		arr = new int[r][c];
		view = new int[r][c];
		for (int i = 0; i < r; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < c; j++) {
				arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());

				if (arr[i][j] == 6) {
					view[i][j] = 6;
				} else {
					view[i][j] = 0;
				}

				CCTV cctv = new CCTV();
				cctv.x = i;
				cctv.y = j;
				if (arr[i][j] == 1) {
					cctv.n = 1;
					cam.add(cctv);
				} else if (arr[i][j] == 2) {
					cctv.n = 2;
					cam.add(cctv);
				} else if (arr[i][j] == 3) {
					cctv.n = 3;
					cam.add(cctv);
				} else if (arr[i][j] == 4) {
					cctv.n = 4;
					cam.add(cctv);
				} else if (arr[i][j] == 5) {
					cctv.n = 5;
					cam.add(cctv);
				}

			}
		}

		Collections.sort(cam);
		System.out.println(cam);
		System.out.println();

		dfs();

		for (int i = 0; i < r; i++) {
			System.out.println(Arrays.toString(view[i]));
		}
		System.out.println();

		System.out.println(result);
	}
	static void dfs(int idx, int[][] nMap) {
		//		종료
		if(idx == cam.size()) {
			int cnt = 0;
			//			사작지대 갯수 세기
			for(int i = 0 ; i < r; i++) {
				for(int j = 0; j < c ;j++) {
					if(nMap[i][j] == 0) {
						cnt++;
					}
				}
			}
			result = Math.min(result, cnt);
			return;
		}
		//		재귀호출
		//		리스트에서 CCTV 뽑아서 감시 솔루션
		CCTV cctv = cam.get(idx);
		int x = cctv.x;
		int y = cctv.y;
		int[][] vMap = new int[r][c];
		switch(cctv.n) {
		case 1 : //  1번 감시 카메라
			for(int d = 0; d < 4 ; d++) {
				//				감시
				for(int i = 0; i < r; i++) {
					vMap[i] = Arrays.copyOf(nMap[i],c);
				}
				detect(x, y,vMap, d);
				//				다음번째  CCTV 호출
				dfs(idx + 1, vMap);
				//				백트래킹 (X)
			}
			break;
		case 2 : //  2번 감시 카메라
			for(int d = 0; d < 2 ; d++) {
				//				감시
				for(int i = 0; i < r; i++) {
					vMap[i] = Arrays.copyOf(nMap[i],c);
				}
				detect(x, y,vMap, d);
				detect(x, y,vMap, d+2);
				//				다음번째  CCTV 호출
				dfs(idx + 1, vMap);
				//				백트래킹 (X)
			}
			break;	
		case 3 : //  3번 감시 카메라
			for(int d = 0; d < 4 ; d++) {
				//				감시
				for(int i = 0; i < r; i++) {
					vMap[i] = Arrays.copyOf(nMap[i],c);
				}
				detect(x, y,vMap, d);
				detect(x, y,vMap, (d+1) % 4);
				//				다음번째  CCTV 호출
				dfs(idx + 1, vMap);
				//				백트래킹 (X)
			}
			break;	
		case 4 : //  4번 감시 카메라
			for(int d = 0; d < 4 ; d++) {
				//				감시
				for(int i = 0; i < r; i++) {
					vMap[i] = Arrays.copyOf(nMap[i],c);
				}
				detect(x, y,vMap, d);
				detect(x, y,vMap, (d+1) % 4);
				detect(x, y,vMap, (d+2) % 4);
				//				다음번째  CCTV 호출
				dfs(idx + 1, vMap);
				//				백트래킹 (X)
			}
			break;	
		case 5 : //  5번 감시 카메라
			//				감시
			for(int i = 0; i < r; i++) {
				vMap[i] = Arrays.copyOf(nMap[i],c);
			}
			detect(x, y,vMap, 0);
			detect(x, y,vMap, 1);
			detect(x, y,vMap, 2);
			detect(x, y,vMap, 3);			
			//				다음번째  CCTV 호출
			dfs(idx + 1, vMap);
			//				백트래킹 (X)
			break;			
		}

	}
	
	static void detect(int x, int y, int[][] cMap, int dir) {
		//	 0 : 왼쪽, 1 : 상, 2 : 오른쪽, 3 : 아래
		switch(dir) {
		case 0 : //왼쪽
			for(int i = x; i >= 0; i--) {
				if(cMap[y][i] == 6) { // 벽이되면,
					break;
				}
				cMap[y][i] = 9;
			}
			break;
		case 2 : //오른쪽
			for(int i = x; i < c; i++) {
				if(cMap[y][i] == 6) { // 벽이되면,
					break;
				}
				cMap[y][i] = 9;
			}
			break;
		case 1 : //위쪽
			for(int i = y; i >= 0; i--) {
				if(cMap[i][x] == 6) { // 벽이되면,
					break;
				}
				cMap[i][x] = 9;
			}
			break;	
		case 3 : //아래쪽
			for(int i = y; i < r; i++) {
				if(cMap[i][x] == 6) { // 벽이되면,
					break;
				}
				cMap[i][x] = 9;
			}
			break;		
		}
	}
	

	static void dfs() {
		for (int i = 0; i < cam.size(); i++) {

			if (cam.get(i).n == 5) {
				for (int d = 0; d < 4; d++) {
					fuc(cam.get(i).x, cam.get(i).y, d);
				}

			} else if (cam.get(i).n == 4) {
				int max = 0;
				int camd = 0;
				int camLeft = 0, camRight = 0;
				for (int d = 0; d < 4; d++) {
					int left = (d + 4 - 1) % 4;
					int right = (d + 4 + 1) % 4;
					int sum = 0;

					sum += getLineBlenk(cam.get(i).x, cam.get(i).y, d);
					sum += getLineBlenk(cam.get(i).x, cam.get(i).y, left);
					sum += getLineBlenk(cam.get(i).x, cam.get(i).y, right);

					if (max < sum) {
						max = sum;
						camd = d;
						camLeft = left;
						camRight = right;
					}

				}
				fuc(cam.get(i).x, cam.get(i).y, camd);
				fuc(cam.get(i).x, cam.get(i).y, camLeft);
				fuc(cam.get(i).x, cam.get(i).y, camRight);

			} else if (cam.get(i).n == 3) {
				int max = 0;
				int camd = 0;
				int camLeft = 0;
				for (int d = 0; d < 4; d++) {
					int left = (d + 4 - 1) % 4;
					int sum = 0;
					sum += getLineBlenk(cam.get(i).x, cam.get(i).y, d);
					sum += getLineBlenk(cam.get(i).x, cam.get(i).y, left);

					if (max < sum) {
						max = sum;
						camd = d;
						camLeft = left;
					}
				}
				fuc(cam.get(i).x, cam.get(i).y, camd);
				fuc(cam.get(i).x, cam.get(i).y, camLeft);
			} else if (cam.get(i).n == 2) {

				int max = 0;
				int camd = 0;
				int camReverse = 0;
				for (int d = 0; d < 2; d++) {
					int reverse = (d + 2) % 4;
					int sum = 0;
					sum += getLineBlenk(cam.get(i).x, cam.get(i).y, d);
					sum += getLineBlenk(cam.get(i).x, cam.get(i).y, reverse);

					if (max < sum) {
						max = sum;
						camd = d;
						camReverse = reverse;
					}
				}
				fuc(cam.get(i).x, cam.get(i).y, camd);
				fuc(cam.get(i).x, cam.get(i).y, camReverse);

			} else if (cam.get(i).n == 1) {
				int max = 0;
				int camd = 0;
				for (int d = 0; d < 4; d++) {
					int sum = 0;
					sum += getLineBlenk(cam.get(i).x, cam.get(i).y, d);

					if (max < sum) {
						max = sum;
						camd = d;
					}
				}
				fuc(cam.get(i).x, cam.get(i).y, camd);
			}

			System.out.println(cam);
			System.out.println();

			for (int l = 0; l < r; l++) {
				System.out.println(Arrays.toString(arr[l]));
			}
			System.out.println();

			for (int l = 0; l < r; l++) {
				System.out.println(Arrays.toString(view[l]));
			}
			System.out.println();
			System.out.println("===================================");
		}
	}

	static void fuc(int x, int y, int d) {

		view[x][y] = chang;
		int num = 1;
		while (true) {
			int delx = x + dx[d] * num;
			int dely = y + dy[d] * num;

			if (delx < 0 || delx >= r || dely < 0 || dely >= c || arr[delx][dely] == 6) {
				break;
			}
			view[delx][dely] = chang;
			num++;
		}
	}

	static int getLineBlenk(int x, int y, int d) {

		int result = 0;

		int num = 1;
		while (true) {
			int delx = x + dx[d] * num;
			int dely = y + dy[d] * num;

			if (delx < 0 || delx >= r || dely < 0 || dely >= c || arr[delx][dely] == 6) {
				break;
			}
			num++;
			if (view[delx][dely] == 0) {
				result++;
			}

		}

		return result;

	}

	static int getBlenk() {
		int result = 0;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (view[i][j] == 0) {
					result++;
				}
			}
		}
		return result;
	}

}

class CCTV implements Comparable<CCTV> {
	int x, y, n;

	@Override
	public int compareTo(CCTV o) {
		// TODO Auto-generated method stub
		return -(this.n - o.n);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return x + " " + y + " " + n;
	}
}
