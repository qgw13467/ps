



public class 조이스틱 {
	
	public int keyNum(char start, char target) {
    	if(start == target) {
    		return 1;
    	}
		
    	int result = Math.abs(target - start) ;
    	int aDistance = Math.abs(target - 'A' )+1;
    	int zDistance = Math.abs('Z' - target )+1;
    	
    	result = Math.min(result, aDistance);
    	result = Math.min(result, zDistance);
    	System.out.println(result);
		return result;
    	
    }

	public int solution(String name) {
		keyNum('J','E');
		int answer = 0;
		char[] charArray = name.toCharArray();
		
		answer = answer + keyNum('A', charArray[0]);
		for (int i = 1; i < charArray.length; i++) {
			answer = answer + keyNum(charArray[i-1], charArray[i]);
		}
		
		return answer;
	}
}
