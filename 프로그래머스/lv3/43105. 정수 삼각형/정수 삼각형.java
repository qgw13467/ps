import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {

        int n = triangle.length;

        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                triangle[i - 1][j] += Math.max(triangle[i][j], triangle[i][j + 1]);
            }
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(triangle[i]));
//        }
        int answer = triangle[0][0];

        return answer;
    }
}