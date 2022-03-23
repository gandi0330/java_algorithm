import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_1411 {
	static int answer;
	static int N;
	static int[] numbers;
	static String[] strs;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[2];
		strs = new String[N];
		for(int i=0;i<N;i++) {
			strs[i] = br.readLine();
		}
		
		answer = 0;
		combi(0,0);
		System.out.println(answer);
	}
	
	public static void combi(int start, int cnt) {
		if(cnt == 2) {
//			System.out.println(Arrays.toString(numbers));
			String str1 = strs[numbers[0]];
			String str1Answer = "";
			Map<Character,Character> map1 = new HashMap<>();
			char c='a';
			for(int i=0;i<str1.length();i++) {
				if(map1.containsKey(str1.charAt(i))) {
					str1Answer+=map1.get(str1.charAt(i));
				}
				else {
					map1.put(str1.charAt(i), (char)(c++));
					str1Answer+=map1.get(str1.charAt(i));
				}
			}
			
			
			String str2 = strs[numbers[1]];
			String str2Answer = "";
			Map<Character,Character> map2 = new HashMap<>();
			c = 'a';
			for(int i=0;i<str2.length();i++) {
				if(map2.containsKey(str2.charAt(i))) {
					str2Answer+=map2.get(str2.charAt(i));
				}
				else {
					map2.put(str2.charAt(i), (char)(c++));
					str2Answer+=map2.get(str2.charAt(i));
				}
			}
			
			if(str1Answer.equals(str2Answer)) {
//				System.out.println("str1 : " + str1 + " str2 :  " +str2);
				answer++;
			}
			
			return;
		}
		
		for(int i=start; i<N;i++) {
			numbers[cnt] = i;
			combi(i+1,cnt+1);
		}
	}

}
