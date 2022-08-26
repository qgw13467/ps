package codetest;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 2117. [모의 SW 역량테스트] 홈 방범 서비스
public class SWEA_2117 {

//	방범기지는 하나만 설치할수 있음
//	
	static int res;
	static int N, M; // Map 사이즈, 집당 비용
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();

		for (int t = 1; t <= TC; t++) {

			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
//			모든 위치에서 방범위치 중앙을 잡고 배치해 봄(BFS)
			res = 1; // 최대값을 구하여야 함으로 1으로 초기화 (최소 1집은 있다고 함)
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bfs(i, j);
				}
			}

			System.out.println("#" + t + " " + res);
		}

	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	private static void bfs(int y, int x) {
		Queue<Data> q = new LinkedList<Data>();
		boolean[][] v = new boolean[N][N]; // 2차원 방문체크
//		방범 중앙위치 삽입 및 방문처리
		q.offer(new Data(x, y));
		v[y][x] = true;
//		단계 초기화
		int k = 1; // 최소 한단계
		int nx, ny;
		int cnt = 0;
		while (!q.isEmpty()) {
//			레벨단위로 방범위치를 넓혀감(손해를 보지 않을때까지)
			int size = q.size();
			Data cur;

			for (int i = 0; i < size; i++) {
				cur = q.poll();
//				현재 위치에 집이 있으면 집 누적하기
				if (map[cur.y][cur.x] == 1) {
					cnt++;
				}
//				4방위 넓힘
				for (int d = 0; d < 4; d++) {
					nx = cur.x + dx[d];
					ny = cur.y + dy[d];
//					범위 체크 , 방문체크
					if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
						continue;
					}
					if (v[ny][nx]) {
						continue;
					}
//					새로운 방범영역 큐에 삽입 및 방문체크
					v[ny][nx] = true;
					q.offer(new Data(nx, ny));
				}
			} // 한단계 완료
//			방범 비용 및 집 수익 계산하기
			int cost = k * k + (k - 1) * (k - 1); // 운영비용
			int income = cnt * M; // 집 수익
			if (income >= cost) { // == 반드시 포함
				res = Math.max(res, cnt);
			}
//			끝내면 안됨 다음 단계도 모두 해보아야 함
			k++;
		}
	}

//	데이터 관리필요 좌표값만 저장, cnt 값은 BFS의 레벨 관리로 하기
	static class Data {
		int x, y;

		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}