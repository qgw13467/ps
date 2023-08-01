import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int answer = Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {
        int[][] map = new int[n + 1][n + 1];
        for (int i = 0; i < wires.length; i++) {
            map[wires[i][0]][wires[i][1]] = 1;
            map[wires[i][1]][wires[i][0]] = 1;
        }

        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                if (i == j || map[i][j] == 0) continue;

                if (map[i][j] == 1) {

                    map[i][j] = 0;
//                    for (int k = 0; k < map.length; k++) {
//                        System.out.println(Arrays.toString(map[k]));
//                    }
//                    System.out.println();
                    fuc(map);
                    map[i][j] = 1;
                }
            }
        }
        return answer;
    }

    void fuc(int[][] map) {
        int[] visit = new int[map.length];
        int group1 = 0, group2 = 0;

        group1 = bfs(map, visit);
        System.out.println(Arrays.toString(visit));
        group2 = bfs(map, visit);
        System.out.println(Arrays.toString(visit));
        System.out.println(group1 + "  " + group2);
        int dist = Integer.MAX_VALUE;

        int sum = 0;
        for (int i = 1; i < visit.length; i++) {
            if (visit[i] == 1) {
                sum++;
            }
        }
        if (group1 != 0 && group2 != 0 && sum == visit.length - 1) {
            dist = Math.abs(group1 - group2);
        }
//        dist = Math.abs(group1 - group2);

        if (dist < answer) {
            answer = dist;
        }

    }

    int bfs(int[][] map, int[] visit) {
        int start = 0, end = 0;
        for (int i = 1; i < visit.length; i++) {
            if (visit[i] == 1) {
                start++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        loop:
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                if (visit[i] == 0) {
                    visit[i] = 1;
                    queue.add(i);
                    break loop;
                }

            }
        }

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int j = 1; j < map.length; j++) {
                if (visit[j] == 0 && map[temp][j] == 1) {
                    visit[j] = 1;
                    queue.add(j);
                }

            }
        }

        for (int i = 1; i < visit.length; i++) {
            if (visit[i] == 1) {
                end++;
            }
        }
        return end - start;
    }


}