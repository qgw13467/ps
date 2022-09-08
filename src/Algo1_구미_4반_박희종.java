import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo1_구미_4반_박희종 {
	// 변수 선언
	static int T, N, X, K;
	// 배열 선언
	static boolean[] arr;
	// 입력받을 StringTokenizer 선언
	static StringTokenizer stringTokenizer;

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력 설정
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// 입력 저장
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		//T 입력
		T = Integer.parseInt(stringTokenizer.nextToken());

		// T번 만큼 반복
		for (int k = 1; k <= T; k++) {
			//입력 저장
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			
			//N,X,K 초기화
			N = Integer.parseInt(stringTokenizer.nextToken());
			X = Integer.parseInt(stringTokenizer.nextToken());
			K = Integer.parseInt(stringTokenizer.nextToken());
			
			//배열 생성, 처음 간식이 있는 배열 변경
			arr = new boolean[N + 1];
			arr[X] = true;

			//K번만큼 입력 받음
			for (int i = 0; i < K; i++) {
				//입력 저장
				stringTokenizer = new StringTokenizer(bufferedReader.readLine());

				//인덱스 a,b를 입력
				int tempa = Integer.parseInt(stringTokenizer.nextToken());
				int tempb = Integer.parseInt(stringTokenizer.nextToken());
				
				//간식의 위치 바꿈
				swap(tempa, tempb);
			}
			
			//배열을 끝까지 순회
			for (int i = 1; i < N + 1; i++) {
				//arr[i]에 간식이 있으면
				if (arr[i]) {
					//출력
					System.out.println("# " + k + " " + i);
					//반복 멈춤
					break;
				}
			}

		}

	}
	//인덱스번호 a,b를 통해간식의 위치 바꿈
	static void swap(int a, int b) {
		boolean temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
