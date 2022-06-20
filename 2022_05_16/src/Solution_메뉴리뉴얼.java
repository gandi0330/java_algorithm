import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution_메뉴리뉴얼 {

	public static void main(String[] args) {
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};
		
		System.out.println(Arrays.toString(solution(orders, course)));
		
	}

	
	// 각 손님의 주문에 대해 course 크기 배열에 맵(조합, cnt)로 저장
	// .cnt가 2 이상인 조합을 배열에 저장
	static HashMap<String, Integer> map;
	public static String[] solution(String[] orders, int[] course) {
		
		map = new HashMap<>();
		for(int cnt : course) {
			for(String order : orders) {
				char[] temp = order.toCharArray();
				Arrays.sort(temp);
				combi(0,0,cnt,new String(temp),"");				
			}
		}
		
		List<String> answer = new ArrayList<>();
		for(String key : map.keySet()) {
			if(map.get(key) >= 2) answer.add(key);
		}
		
		return answer.toArray(new String[answer.size()]);
    }
	
	
	public static void combi(int first, int n, int target, String order, String menu) {
		if(n==target) {
			System.out.println(menu);
			map.put(menu,map.getOrDefault(menu, 0)+1);
			return;
		}
		
		for(int i=first;i<order.length();i++) {
			combi(i+1,n+1,target,order,menu+order.charAt(i));
		}
	}
}
