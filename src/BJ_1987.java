// 0818 algo online day 6
// Daily homework

// BOJ 1987 알파벳
// https://www.acmicpc.net/problem/1987

import java.util.*;
import java.io.*;

public class BJ_1987 {

	static int N, M;
	static char[][] map;
	// A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z
	static int[] v;
	static int[] dr = { -1, 0, 1, 0 }; // 상, 우, 하, 좌
	static int[] dc = { 0, 1, 0, -1 }; // 상, 우, 하, 좌
	static int totalCnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		v = new int[26];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}

		totalCnt = 0;
		dfs(0, 0, 1);

		bw.write(totalCnt + "");
		bw.close();
		br.close();
	} // end main function

	private static void dfs(int curR, int curC, int cnt) {

		totalCnt = Math.max(totalCnt, cnt);

		int idx = map[curR][curC] - 'A';

		v[idx] = 1;

		for (int i = 0; i < 4; i++) {

			int nr = curR + dr[i];
			int nc = curC + dc[i];

			if ((nr < 0) || (nc < 0) || (N <= nr) || (M <= nc))
				continue;

			int index = map[nr][nc] - 'A';
			if (v[index] == 1)
				continue;

			dfs(nr, nc, cnt + 1);
		}
		v[idx] = 0;

	} // end dfs function

}
