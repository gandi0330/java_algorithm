import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_9760 {

	static List<Character> cardSeq = Arrays.asList('A','2','3','4','5','6','7','8','9','T','J','Q','K');
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st=  null;
		StringBuilder sb = new StringBuilder();
		String cards[] = new String[5];
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<5;i++) {
				cards[i] = st.nextToken();
			}
			
			sb.append("#"+tc+" "+check(cards)+"\n");
		}
		System.out.print(sb);
	}
	
	
	public static String check(String[] cards) {
		
		if(isStraightFlush(cards)) {
			return "Straight Flush";
		}else if(isFourOfAKind(cards)) {
			return "Four of a Kind";
		}else if(isFullHouse(cards)) {
			return "Full House";
		}else if(isFlush(cards)) {
			return "Flush";
		}else if(isStraight(cards)) {
			return "Straight";
		}else if(isThreeOfAKind(cards)) {
			return "Three of a kind";
		}else if(isTwoPair(cards)) {
			return "Two pair";
		}else if(isOnePair(cards)) {
			return "One pair";
		}else return "High card";
	}
	
	public static boolean isRoyal(String[] cards) {
		
		if(!isFlush(cards)) return false;
		
		int cardIdx[] =  new int[5];
		for(int i=0;i<5;i++) {
			cardIdx[i] = cardSeq.indexOf(cards[i].charAt(1));
		}
		Arrays.sort(cardIdx);
		
		int[] royalSeq = {0,9,10,11,12};
		for(int i=0;i<5;i++) {
			if(cardIdx[i] != royalSeq[i]) return false; 
		}
		return true;
		
	}
	
	public static boolean isStraightFlush(String[] cards) {
	
		if((isFlush(cards) && (isStraight(cards)) || isRoyal(cards))) return true;
		return false;
	}
	
	public static boolean isFourOfAKind(String[] cards) {
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i=0;i<5;i++) {
			map.put(cards[i].charAt(1), map.getOrDefault(cards[i].charAt(1), 0)+ 1);
		}
		
		for(int value : map.values()) {
			if(value == 4) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isFullHouse(String[] cards) {
		if(isThreeOfAKind(cards) && isOnePair(cards)) return true;
		return false;
	}
	
	public static boolean isFlush(String[] cards) {
		char shape = cards[0].charAt(0);
		
		for(int i=1;i<5;i++) {
			if(cards[i].charAt(0) != shape) return false;
		}
		return true;
	}
	
	public static boolean isStraight(String[] cards) {
		int cardIdx[] =  new int[5];
		for(int i=0;i<5;i++) {
			cardIdx[i] = cardSeq.indexOf(cards[i].charAt(1));
		}
		Arrays.sort(cardIdx);
		for(int i=1;i<5;i++) {
			if(cardIdx[i-1] +1 != cardIdx[i]) return false; 
		}
		return true;
	}
	
	public static boolean isThreeOfAKind(String[] cards) {
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i=0;i<5;i++) {
			map.put(cards[i].charAt(1), map.getOrDefault(cards[i].charAt(1), 0)+ 1);
		}
		
		for(int value : map.values()) {
			if(value == 3) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isTwoPair(String[] cards) {
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i=0;i<5;i++) {
			map.put(cards[i].charAt(1), map.getOrDefault(cards[i].charAt(1), 0)+ 1);
		}
		
		int pairCnt = 0; 
		for(int value : map.values()) {
			if(value == 2) {
				pairCnt++;
			}
		}
		
		if(pairCnt == 2) return true;
		return false;
	}
	
	public static boolean isOnePair(String[] cards) {
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i=0;i<5;i++) {
			map.put(cards[i].charAt(1), map.getOrDefault(cards[i].charAt(1), 0)+ 1);
		}
		
		for(int value : map.values()) {
			if(value == 2) {
				return true;
			}
		}
		
		return false;
	}

}
