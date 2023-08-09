import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, target;
    static int[] coin, now;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int tc = Integer.parseInt(br.readLine());

        for (int q = 0; q < tc; q++) {
            n = Integer.parseInt(br.readLine());
            coin = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }

            target = Integer.parseInt(br.readLine());
            now = new int[target + 1];

            for (int j = 0; j < coin.length; j++) {
                for (int i = 1; i <= target; i++) {
                    if (i - coin[j] == 0) {
                        now[i]++;
                    }
                    if (coin[j] <= i) {
                        now[i] += now[i - coin[j]];
                    }

                }
//                System.out.println(Arrays.toString(now));
            }
            System.out.println(now[target]);


        }

    }


}


