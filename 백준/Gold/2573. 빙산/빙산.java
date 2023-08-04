import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.CountDownLatch;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int M, N;
        st = new StringTokenizer(bufferedReader.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[][] map = new int[M][N];

        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i < N; i++) {
                map[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
//        System.out.println("+++++++++++++++++");
        int islandNum = getIslandNum(map);
//        System.out.println("=================");
        while (true) {
            answer++;
            ice(map);
            islandNum = getIslandNum(map);
//            System.out.println("answer: " + answer + " , islantNum:" + islandNum);
//            System.out.println("||||||||||||||||||||||||||||||||");
            if (islandNum >= 2) {
                break;
            }
            if (islandNum == 0) {
                answer = 0;
                break;
            }

        }
        System.out.println(answer);


    }

    public static void ice(int[][] map) {
        int[][] newMap = new int[map.length][map[0].length];

        for (int j = 0; j < map.length; j++) {
            for (int i = 0; i < map[j].length; i++) {
                for (int k = 0; k < 4; k++) {
                    if (j + dy[k] >= 0 && j + dy[k] < map.length
                            && i + dx[k] >= 0 && i + dx[k] < map[j].length) {
                        if (map[j][i] > 0 && map[j + dy[k]][i + dx[k]] <= 0) {
                            newMap[j][i]++;
                        }
                    }
                }
            }
        }

        for (int j = 0; j < map.length; j++) {
            for (int i = 0; i < map[j].length; i++) {
                map[j][i] = map[j][i] - newMap[j][i];
                if (map[j][i] < 0) {
                    map[j][i] = 0;
                }
            }
        }
//        System.out.println("ice");
//        show(newMap);


    }

    public static int getIslandNum(int[][] map) {
        int count = 0;
        int[][] visit = new int[map.length][map[0].length];
        for (int j = 0; j < map.length; j++) {
            for (int i = 0; i < map[j].length; i++) {
                if (visit[j][i] == 0 && map[j][i] > 0) {
//                    System.out.println("Point x: " + i + ", y: " + j);
                    bfs(map, visit, j, i);
                    count++;

//                    System.out.println("getIsland");
//                    show(map);
//                    show(visit);
                }
            }
        }
        return count;

    }

    public static void bfs(int[][] map, int[][] visit, int y, int x) {
        Queue<Point> queue = new LinkedList<>();

        Point temp = new Point(x, y);
        visit[y][x] = 1;
        queue.add(temp);

        while (!queue.isEmpty()) {
            temp = queue.poll();
//            System.out.println("Point x: " + temp.x + ", y: " + temp.y);

            for (int i = 0; i < 4; i++) {

                if (temp.x + dx[i] >= 0 && temp.x + dx[i] < map[0].length &&
                        temp.y + dy[i] >= 0 && temp.y + dy[i] < map.length &&
                        visit[temp.y + dy[i]][temp.x + dx[i]] == 0 && map[temp.y + dy[i]][temp.x + dx[i]] > 0) {
                    Point newPoint = new Point(temp.x + dx[i], temp.y + dy[i]);
                    visit[temp.y + dy[i]][temp.x + dx[i]] = 1;
                    queue.add(newPoint);
                }


            }

        }
    }

    static void show(int[][] map) {
        for (int j = 0; j < map.length; j++) {
            System.out.println(Arrays.toString(map[j]));
        }
        System.out.println();
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}