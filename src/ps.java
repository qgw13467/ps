
import java.text.BreakIterator;
import java.util.*;
public class ps {

	public static void main(String[] args) {

	}

}

class Solution2 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Queue<Integer> road = new LinkedList<Integer>();
	    for (int i = 0; i < truck_weights.length; i++) {
			queue.add(truck_weights[i]);
		}
	    int time = 0;
        int roadWeight =0;
        while (queue.isEmpty()) {
			int carWeight = queue.poll();
			road.add(carWeight);
			roadWeight +=carWeight;
			
			if (roadWeight< weight && road.size()<bridge_length) {
				int nextCarWeight = queue.peek();
				if((weight - roadWeight)>= nextCarWeight) {
					time++;
					road.add(nextCarWeight);
					queue.poll();
				}
			}
			else {
				time += bridge_length;
				road.poll();
				
			}
			
			
			
		}
        
		

        return time;
    }
}
class Solution {
    public int solution(String str1, String str2) {
    	HashMap<String, Integer> map1 = new HashMap<>();
    	HashMap<String, Integer> map2 = new HashMap<>();
    	str1 = str1.toUpperCase();
    	str2 = str2.toUpperCase();
    	System.out.println(str1);
    	System.out.println(str2);
    	for (int i = 0; i < str1.length()-1; i++) {
    		String tempString = str1.substring(i, i+2);
    		if(Character.isLetter(tempString.charAt(0))&&Character.isLetter(tempString.charAt(1))) {
    			if(map1.containsKey(tempString)){
    				Integer tempInteger = map1.get(tempString);
    				map1.put(tempString, tempInteger+1);
    			}
    			else {
    				map1.put(tempString, 1);
    			}
    		}
		}
    	
    	for (int i = 0; i < str2.length()-1; i++) {
    		String tempString = str2.substring(i, i+2);
    		if(Character.isLetter(tempString.charAt(0))&&Character.isLetter(tempString.charAt(1))) {
    			if(map2.containsKey(tempString)){
    				Integer tempInteger = map2.get(tempString);
    				map2.put(tempString, tempInteger+1);
    			}
    			else {
    				map2.put(tempString, 1);
    			}
    		}
		}
    	
    	Iterator<String> keys = map1.keySet().iterator();
    	Iterator<String> keys2 = map2.keySet().iterator();
    	while(keys.hasNext()) {
    		while (keys2.hasNext()) {
				
				
			}
    		keys2 = map2.keySet().iterator();
    	}
    	
    	
        int answer = 0;
        return answer;
    }
}