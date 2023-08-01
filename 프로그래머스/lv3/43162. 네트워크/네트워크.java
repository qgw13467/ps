import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int[] visit;
    static int answer = 0;

    public int solution(int n, int[][] computers) {
        visit = new int[n];

        for (int i = 0; i < n; i++) {
            fuc(i, computers);
        }

        return answer;
    }

    void fuc(int i, int[][] computers) {
        if (visit[i] == 1) return;

        visit[i] = 1;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(i);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int k = 0; k < computers.length; k++) {
                if(now ==k)continue;
                if(visit[k] == 1){
                    continue;
                }
                if(computers[now][k] ==1){
                    queue.add(k);
                    visit[k] = 1;
                    
                }
            }
        }
        answer ++;
    }
}