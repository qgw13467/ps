import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.*;
import java.util.concurrent.CountDownLatch;

public class Main {
    static int n;
    static int[] arr;
    static ArrayList<Integer> dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; ++i) {
            if (dp.size() == 0 || dp.get(dp.size() - 1) < arr[i]) {
                dp.add(arr[i]);
            } else {
                int left = 0;
                int right = dp.size() - 1;
                int mid = 0;

                while (left < right) {
                    mid = (left + right) / 2;
                    if (dp.get(mid) < arr[i]) {
                        left = mid + 1;

                    } else {
                        right = mid;
                    }
                }

                dp.set(right, arr[i]);

            }
//            System.out.println(dp);
        }

        System.out.println(dp.size());
    }

}


