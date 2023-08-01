import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] solution(int brown, int yellow) {

        int[] answer = new int[2];

        for (int i = 1; i * i <= yellow; i++) {
            if (yellow % i != 0) {
                continue;
            }
            int temp = (i + 2) * 2;
            temp += (yellow / i) * 2;
            if (temp == brown) {
                answer[0] = i + 2;
                answer[1] = yellow / i + 2;
            }
        }
        if(answer[0]< answer[1]){
            int temp = answer[1];
            answer[1] = answer[0];
            answer[0]= temp;
        }
        return answer;
    }
}