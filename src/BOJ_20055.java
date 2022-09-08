import java.util.*;
import java.io.*;

public class BOJ_20055 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

//		Deque<Integer> belt = new ArrayDeque<>();
//		Deque<Integer> robot = new ArrayDeque<>();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] belt = new int[2 * N];
		int[] robot = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}

		int check = 0;
		int count = 0;

		while (check < K) {

			check = 0;

			System.out.println("원래 벨트 상태");
			System.out.println(Arrays.toString(belt));
			System.out.println(Arrays.toString(robot));

			// 벨트 회전
			int temp_belt = belt[2 * N - 1];
			for (int i = 2 * N - 1; i > 0; i--) {
				belt[i] = belt[i - 1];
			}
			belt[0] = temp_belt;

			// 벨트 회전에 따른 로봇 이동
			for (int i = N - 1; i > 0; i--) {
				robot[i] = robot[i - 1];
			}
			robot[0] = 0;

			System.out.println("벨트 회전");
			System.out.println(Arrays.toString(belt));
			System.out.println(Arrays.toString(robot));

			// 로봇 추가 이동
			for (int i = 0; i < N - 1; i++) {
				if ((robot[i] == 1) && (robot[i + 1] == 0) && (belt[i + 1] > 0)) {
					robot[i + 1] = robot[i];
					robot[i] = 0;
					belt[i + 1]--;
					i++;
				}
			}

			System.out.println("로봇 추가 이동");
			System.out.println(Arrays.toString(belt));
			System.out.println(Arrays.toString(robot));

			// 내구성이 0이 아닐 때, 첫번째 벨트에 로봇 태우기
			if (belt[0] > 0) {

				belt[0]--;
				robot[0] = 1;
			}

			System.out.println("내구성이 0이 아닐 때, 첫번째 벨트에 로봇 태우기");
			System.out.println(Arrays.toString(belt));
			System.out.println(Arrays.toString(robot));
			System.out.println();
			for (int i = 0; i < 2 * N; i++) {
				if (belt[i] <= 0)
					check++;
			}
			count++;
//			System.out.println("check: " + check);

		}

		bw.write(count + "");
		bw.close();
		br.close();

	}

}