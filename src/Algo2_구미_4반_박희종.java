import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo2_구미_4반_박희종 {
	//모음 배열 생성
	static char[] arr = new char[] { 'a', 'e', 'i', 'o', 'u' };

	public static void main(String[] args) throws IOException {
		//입력 설정
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		//입력받기
		StringBuilder stringBuilder =  new StringBuilder().append(bufferedReader.readLine());
		//입력 배열을 순회하면서
		for (int i = 0; i < stringBuilder.length(); i++) {
			
			//모음 배열을 순회하여
			for (int k = 0; k < arr.length; k++) {
				
				//모음이 있다면
				if (stringBuilder.charAt(i) == arr[k]) {
					//뒤의 2개를 삭제
					stringBuilder.delete(i+1, i+3);
					//반복문 멈춤
					break;
				}
			}
		}
		
		//결과 출력
		System.out.println(stringBuilder.toString());

	}
}
