import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	static int parts;
    static int numbers[];
    static int target;
    static boolean[][] parts_;
    static boolean isSuccess;
	public static void main(String[] args) {
		
		int factory[][] = {{1,1,1,1,0,0,0,0,0},{0,0,1,0,0,0,0,0,1},{0,0,0,1,0,1,0,0,1},{1,1,0,0,1,0,0,0,1}}; 
		
        parts = factory[0].length;
        
        parts_ = new boolean[parts][factory.length];
        for(int i=0;i<factory.length;i++) {
        	for(int j=0;j<factory[0].length;j++) {
        		if(factory[i][j] == 1) {
        			parts_[j][i] = true;
        		}
        	}
        }
        
        isSuccess = false;

        for(int i=2;i<=parts;i++){
            numbers = new int[i];
            target = i;
            combi(0,0);
            if(isSuccess) {
            	System.out.println(i);
            	break;
            }
        }
	}
	
	public static void combi(int cnt, int start) {
        if(cnt == target) {
//        	System.out.println(Arrays.toString(numbers));
            boolean answer[] = new boolean[parts_[0].length];
            int answerCnt= 0;
        	
            for(int i=0;i<target;i++){
                for(int j=0;j<parts_[0].length;j++) {
                	if(answer[j]) continue;
                	else if(parts_[numbers[i]][j]) {
                		answer[j] = true;
                		answerCnt++;
                	}
                }
            }
        
            if(answerCnt == answer.length) isSuccess = true;
            return;
        }
    
    
    
        for(int i=start;i<parts;i++) {
            numbers[cnt] = i;
            combi(cnt+1,i+1);
        }
    
    }
}



class Solution {
	static int cardsCnt;
	static int[] numbers;
	static int target;
	static int result;
	static String[] cards_;
    public int solution(String[] cards) {
    	cardsCnt = cards.length;
    	cards_ = cards;
    	result = 0;
    	for(int i=3;i<=cardsCnt;i++){
            numbers = new int[i];
            target = i;
            combi(0,0);
        }
    	
    	return result;
    }
    
    public static void combi(int cnt, int start) {
        if(cnt == target) {
        	
        	String[] select = new String[target];
        	for(int i=0;i<target;i++) {
        		select[i] = cards_[numbers[i]];
        	}
        	
        	result += charSame(select) + numSame(select) + notSame(select);
        	return;
        }
    
    
    
        for(int i=start;i<cardsCnt;i++) {
            numbers[cnt] = i;
            combi(cnt+1,i+1);
        }
    
    }
    
    public static int charSame(String[] cards) {
    	
    	char c = cards[0].charAt(0);
    	
    	for(int i=1;i<cards.length;i++) {
    		if(c == cards[i].charAt(0))continue;
    		return 0;
    	}
    	return cards.length*cards.length;
    }
    
    public static int numSame(String[] cards) {
    	
    	char c = cards[0].charAt(1);
    	
    	for(int i=1;i<cards.length;i++) {
    		if(c == cards[i].charAt(1))continue;
    		return 0;
    	}
    	return cards.length*cards.length;
    }
    
    public static int notSame(String[] cards) {
    	List<Character> list = new ArrayList<>();
    	
    	for(int i=0;i<cards.length;i++) {
    		if(list.contains(cards[i].charAt(0))) return 0;
    		else list.add(cards[i].charAt(0));
    		
    		if(list.contains(cards[i].charAt(1))) return 0;
    		else list.add(cards[i].charAt(1));
    	}
    	
    	
    	return cards.length*cards.length;
    }
}