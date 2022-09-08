

import java.util.Iterator;

public class 땅따먹기 {
    int solution(int[][] land) {
        int answer = 0;
        for(int i=1;i<land.length;i++) {
        	for (int j = 0; j < land[0].length; j++) {
        		int max = 0;
        		for (int k = 0; k < land[0].length; k++) {
					if(j!=k) {
						
						max = Math.max(land[i][j], max);
					}
					
				}
        		land[i][j] =land[i][j] + max;
			}
        }
        
        answer = land[land.length-1][0];
        for (int i = 0; i < land[0].length; i++) {
        	answer = Math.max(answer, land[land.length-1][i]);
		}
        
        
        for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[0].length; j++) {
				System.out.print(land[i][j]+" ");
			}
			System.out.println();
		}
        
        return answer;
    }
}
