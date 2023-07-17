import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.NonReadableChannelException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static boolean visit[][];
    static int maze[][];
    static int dirY[] = {-1, 1, 0, 0};
    static int dirX[] = {0, 0, -1, 1};
    static Queue<Node> que = new LinkedList<>();

    static int now_x, now_y;
    static int x, y;
    static int N, M;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        visit = new boolean[N][M];
        maze = new int[N][M];

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                char ch = str.charAt(j);
                maze[i][j] = Character.getNumericValue(ch);
            }
        }

        BFS(0, 0);
        System.out.println(maze[N-1][M-1]);
    }

    static void BFS(int x, int y) {
        que.offer(new Node(x, y));
        visit[y][x] = true;

        while( !que.isEmpty() ) {
            Node node = que.poll();

            for(int i=0; i<4; i++) {
                now_y = node.y + dirY[i];
                now_x = node.x + dirX[i];

                if(Range_check() == true && visit[now_y][now_x] == false && maze[now_y][now_x] == 1) {
                    que.offer(new Node(now_x, now_y));
                    visit[now_y][now_x] = true;

                    maze[now_y][now_x] = maze[node.y][node.x] + 1;
                    if(visit[N-1][M-1] == true) {
                        return;
                    }

                }
            }
        }
    }

    public static boolean Range_check() {
        return (now_x >= 0 && now_x < M && now_y >= 0 && now_y < N);
    }


}