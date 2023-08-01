import java.util.Arrays;

class Solution {
    static int answer = 0;

    public int solution(int k, int[][] dungeons) {
        int[] visit = new int[dungeons.length];
        fuc(k,dungeons,0,visit);
        return answer;
    }

    int fuc(int k, int[][] dungeons, int depth, int[] visit) {
        if (depth > answer) {
            System.out.println(Arrays.toString(visit));
            answer = depth;
        }
        if (depth == dungeons.length) {
            answer = depth;
            System.out.println(Arrays.toString(visit));
            return depth;
        }
        for (int i = 0; i < dungeons.length; i++) {
            if (visit[i] == 1) continue;
            if (k >= dungeons[i][0]) {
                visit[i] = 1;
                fuc(k - dungeons[i][1], dungeons, depth + 1, visit);
                visit[i] = 0;
            }
        }
        return answer;
    }
}