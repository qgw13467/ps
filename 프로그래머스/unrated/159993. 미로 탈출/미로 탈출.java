import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public int solution(String[] maps) {
        int N = maps.length;
        int M = maps[0].length();
        Point st = null, lev = null, ex = null;
        Queue<Point> queue = new LinkedList<>();
        int startToLev = Integer.MAX_VALUE;
        int levToEx = Integer.MAX_VALUE;
        int[][] visitStart = new int[N][M];
        int[][] visitLev = new int[N][M];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    st = new Point(i, j);
                } else if (maps[i].charAt(j) == 'L') {
                    lev = new Point(i, j);
                } else if (maps[i].charAt(j) == 'E') {
                    ex = new Point(i, j);
                }
            }
        }

        startToLev = bfs(st.x, st.y, lev.x, lev.y, maps, visitStart);
        if (startToLev != Integer.MAX_VALUE) {
            levToEx = bfs(lev.x, lev.y, ex.x, ex.y, maps, visitLev);
        }

        int answer = startToLev + levToEx;
        if (startToLev == Integer.MAX_VALUE || levToEx == Integer.MAX_VALUE) {
            answer = -1;
        }
        return answer;
    }

    int bfs(int startX, int startY, int targetX, int targetY, String[] maps, int[][] visit) {
        int N = maps.length;
        int M = maps[0].length();
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY, 0));
        visit[startX][startY] = 1;

        while (!queue.isEmpty()) {
            Point temp = queue.poll();

            if (temp.x == targetX && temp.y == targetY) {
                return temp.depth;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = temp.x + dx[i];
                int nextY = temp.y + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M
                        || maps[nextX].charAt(nextY) == 'X' || visit[nextX][nextY] == 1) {
                    continue;
                }

                visit[nextX][nextY] = 1;
                queue.add(new Point(nextX, nextY, temp.depth + 1));
            }
        }
        return Integer.MAX_VALUE;
    }

    static class Point {
        public int x, y, depth;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}