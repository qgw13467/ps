import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static Queue<Point> queue = new LinkedList<>();

    static int answer = Integer.MAX_VALUE;


    public int solution(int[][] maps){


        fuc(0,0,0,maps.length-1, maps[0].length-1, maps);
        if(answer == Integer.MAX_VALUE){
            answer = -1;
        }
        return answer;

    }


    void fuc(int startx, int starty, int dept, int targetx, int targety, int[][] maps){

        Point point = new Point();
        point.x = startx;
        point.y = starty;
        point.dept = 1;
        queue.offer(point);

        while(!queue.isEmpty()){
            Point temp = queue.poll();
            if(temp.x == targetx && temp.y == targety){
                answer =  temp.dept;
            }

            for(int i = 0;i<4;i++){
                int nextx = temp.x + dx[i];
                int nexty = temp.y + dy[i];

                if(nextx<0 || nextx>= maps.length || nexty < 0 || nexty >=maps[0].length
                        || maps[nextx][nexty] == 0){
                    continue;
                }
                Point input = new Point();
                input.x = nextx;
                input.y = nexty;
                input.dept = temp.dept +1;
                
                maps[nextx][nexty] =0;
                
                queue.add(input);

            }
        }
        
        


    }
    static class Point{
        public int x, y ,dept;
    }
}