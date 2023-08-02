

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int answer = Integer.MAX_VALUE;
    static int[] fin = new int[3];

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        String N = bufferedReader.readLine();
        int n = Integer.parseInt(N);
        int[][] arr = new int[n][3];
        int[][] check = new int[n][3];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            arr[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            arr[i][1] = Integer.parseInt(stringTokenizer.nextToken());
            arr[i][2] = Integer.parseInt(stringTokenizer.nextToken());
        }
        for (int i = 1; i < n; i++) {
            arr[i][0] = arr[i][0] + Math.min(arr[i - 1][1], arr[i - 1][2]);
            arr[i][1] = arr[i][1] + Math.min(arr[i - 1][0], arr[i - 1][2]);
            arr[i][2] = arr[i][2] + Math.min(arr[i - 1][0], arr[i - 1][1]);
        }
        answer = Math.min(arr[n-1][0], Math.min(arr[n-1][1], arr[n-1][2]));

        System.out.println(answer);

    }


}