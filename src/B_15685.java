import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B_15685 {

	static boolean[][] map = new boolean[101][101];
	static int N;
	static StringTokenizer stringTokenizer;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bufferedReader.readLine());
		
		for (int tc = 0; tc < N; tc++) {
			int temp[] = new int[4];
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for(int k=0;k<4;k++) {
				temp[k] = Integer.parseInt(stringTokenizer.nextToken());
			}
			
			List<Integer> list = new ArrayList<>();
	        list.add(temp[2]);

	        for (int i = 0; i < temp[3]; i++) {
	            for (int j = list.size() - 1; j >= 0; j--) {
	            	list.add((list.get(j) + 1) % 4);
	            }
	        }

	        map[temp[1]][temp[0]] = true;
	        for (Integer d : list) {
	        	temp[0] += dx[d];
	        	temp[1] += dy[d];
	            map[temp[1]][temp[0]] = true;
	        }
			
		}
		
		int count=0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
                    count++;
                }
            }
        }
        System.out.println(count);
        bufferedReader.close();
        
		
	}
	

}
