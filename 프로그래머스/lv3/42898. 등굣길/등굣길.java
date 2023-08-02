import java.util.Arrays;

class Solution {
    public int solution(int m, int n, int[][] puddles) {

        int[][] map = new int[m + 1][n + 1];
        map[1][1] = 1;
        int dm = 1, dn = 1;
        int mindex = 1, nindex = 1;
        for (int i = 1; i <= m; i++) {
            Arrays.fill(map[i], 1);
        }


        for (int i = 0; i < puddles.length; i++) {
            map[puddles[i][0]][puddles[i][1]] = 0;
        }
        while (mindex != m + 1) {
            if (map[mindex][1] == 0) {
                dm = 0;
            }
            map[mindex][1] = dm;
            mindex++;
        }
        while (nindex != n + 1) {
            if (map[1][nindex] == 0) {
                dn = 0;
            }
            map[1][nindex] = dn;
            nindex++;
        }
//        for (int i = 0; i <= m; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                if (map[i][j] == 0) continue;
                if (map[i - 1][j] != 0 && map[i][j - 1] != 0) {
                    map[i][j] = (map[i - 1][j] % 1000000007 + map[i][j - 1] % 1000000007) % 1000000007;
                } else if (map[i - 1][j] == 0) {
                    map[i][j] = map[i][j - 1];
                } else if (map[i][j - 1] == 0) {
                    map[i][j] = map[i - 1][j];
                } else if (map[i - 1][j] == 0 && map[i][j - 1] == 0) {
                    map[i][j] = 0;
                }
            }
        }

//        for (int i = 0; i <= m; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }

        int answer = map[m][n];
        return answer;
    }
}