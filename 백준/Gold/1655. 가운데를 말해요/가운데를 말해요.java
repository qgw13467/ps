import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> -(o1 - o2));
        PriorityQueue<Integer> right = new PriorityQueue<>();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {

            int temp = Integer.parseInt(br.readLine());
            if (left.size() == right.size()) {
                left.add(temp);
                if (right.size() != 0 && left.peek() > right.peek()) {
                    right.add(left.poll());
                    left.add(right.poll());
                }

            } else {
                right.add(temp);
                if(left.peek()> right.peek()){
                    left.add(right.poll());
                    right.add(left.poll());
                }
            }
            stringBuilder.append(left.peek()+"\n");

        }
        System.out.println(stringBuilder);


    }




}


