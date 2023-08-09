import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, m, k;
    static int[][] map;
    static int[][][] visit;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;


        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new int[k + 1][n][m];
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < temp.length(); j++) {
                map[i][j] = temp.charAt(j) - '0';

            }
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
//        System.out.println();

        bfs();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            if (visit[i][n - 1][m - 1] != 0 && min > visit[i][n - 1][m - 1]) {
                min = visit[i][n - 1][m - 1];
            }
        }

        min = (min == Integer.MAX_VALUE) ? -1 : min;

        System.out.println(min);
    }

    static void bfs() {

        Queue<Data> queue = new LinkedList<>();
        visit[0][0][0] = 1;
        Data start = new Data(0, 0, 0, 1);
        queue.add(start);

        while (!queue.isEmpty()) {
            Data now = queue.poll();
//            System.out.println(now);

            if (now.x == m - 1 && now.y == n - 1) {
                return;
            }


            for (int i = 0; i < 4; i++) {

                if (now.x + dx[i] < 0 || now.x + dx[i] >= m || now.y + dy[i] < 0 || now.y + dy[i] >= n) {
                    continue;
                }

                if (
                        now.dep < k &&
                                map[now.y + dy[i]][now.x + dx[i]] == 1 &&
                                visit[now.dep + 1][now.y + dy[i]][now.x + dx[i]] ==0) {
                    visit[now.dep + 1][now.y + dy[i]][now.x + dx[i]] = now.leng + 1;
                    queue.add(new Data(now.x + dx[i], now.y + dy[i], now.dep + 1, now.leng + 1));
                }

                if (map[now.y + dy[i]][now.x + dx[i]] == 0 &&
                        visit[now.dep][now.y + dy[i]][now.x + dx[i]] ==0
                ) {
                    visit[now.dep][now.y + dy[i]][now.x + dx[i]] = now.leng + 1;
                    queue.add(new Data(now.x + dx[i], now.y + dy[i], now.dep, now.leng + 1));

                }


            }


//            for (int q = 0; q <= k; q++) {
//                for (int i = 0; i < n; i++) {
//                    System.out.println(Arrays.toString(visit[q][i]));
//                }
//                System.out.println();
//            }

        }

    }

    static class Data {
        int x, y, dep, leng;

        public Data(int x, int y, int dep, int leng) {
            this.x = x;
            this.y = y;
            this.dep = dep;
            this.leng = leng;
        }

        @Override
        public String toString() {
            return "{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dep=" + dep +
                    ", leng=" + leng +
                    '}';
        }
    }


}


