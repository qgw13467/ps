import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    static int T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int L;
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        int[] arr = new int[L];
        boolean[] visit = new boolean[L];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 1; i <= arr.length; i++) {
            fuc(arr, visit, 0, 0, i);

        }
        wr.write(answer + "\n");
        wr.flush();


    }

    static void fuc(int[] arr, boolean[] visit, int d, int r, int c) {
        if (r == c) {
            int temp = 0;
            for (int i = 0; i < arr.length; i++) {
                if (visit[i]) {
                    temp += arr[i];
                }

            }
            if (temp == T) {
                answer++;
            }
            return;
        }
        if (d == arr.length) {
            return;
        }

        visit[d] = true;
        fuc(arr, visit, d + 1, r + 1, c);
        visit[d] = false;
        fuc(arr, visit, d + 1, r, c);


    }


}


