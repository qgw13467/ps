import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.CountDownLatch;

public class Main {
    static int n;
    static Data[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());

        arr = new Data[n];
        dp = new int[n + 5];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Data(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));

        }
//        System.out.println(Arrays.toString(arr));
//        System.out.println();

        dp[arr[0].T] = arr[0].P;
//        System.out.println(Arrays.toString(dp));

        for (int i = 1; i < n; i++) {
            if (dp[i] < dp[i - 1]) {
                dp[i] = dp[i - 1];
            }

            if (dp[arr[i].T + i] <= dp[i] + arr[i].P) {
                dp[arr[i].T + i] = dp[i] + arr[i].P;
            }
//            System.out.println(Arrays.toString(dp));

        }

        int max = dp[0];
        for (int i = 1; i <= n; i++) {
            max = max < dp[i] ? dp[i] : max;
        }

        System.out.println(max);
    }

    static class Data {
        int T, P;

        public Data(int t, int p) {
            this.T = t;
            this.P = p;

        }

        @Override
        public String toString() {
            return "Data{" +
                    "T=" + T +
                    ", P=" + P +
                    '}';
        }
    }

}


