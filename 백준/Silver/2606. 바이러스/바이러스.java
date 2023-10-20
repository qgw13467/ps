import java.io.*;
import java.util.*;

public class Main {

    static int[] visit;
    static int[][] map;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visit = new int[N + 1];
        int L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int start, end;
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            map[start][end] = 1;
            map[end][start] = 1;
        }

//        for(int[] arr : map){
//            System.out.println(Arrays.toString(arr));
//        }

        queue.add(1);
        visit[1] = 1;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            visit[now] = 1;
            for (int i = 1; i <= N; i++) {
                if (map[now][i] == 1 && visit[i] != 1) {
                    visit[i] = 1;
                    queue.add(i);
                }
            }
        }

        int answer = 0;
        for(int i = 1; i<= N; i++){
            if(visit[i] == 1){
                answer ++;
//                System.out.println(i);
            }
        }
//        System.out.println();
//        System.out.println(Arrays.toString(visit));
        System.out.println(answer -1);


    }


}


