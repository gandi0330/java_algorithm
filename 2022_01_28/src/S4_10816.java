		
//		Map<Integer, Integer> map = new HashMap<>();
//		
//		String[] strs = br.readLine().split(" ");
//		
//		for(String str : strs) {
//			int cardNum = Integer.parseInt(str);
//			
//			if(map.containsKey(cardNum)) map.replace(cardNum, map.get(cardNum)+1);
//			else map.put(cardNum, 1);
//		}
//		
//		int printNum = Integer.parseInt(br.readLine());
//		
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		for(int i=0;i<printNum;i++) {
//			
//			int key = Integer.parseInt(st.nextToken());
//			
//			if(map.get(key)!=null) System.out.print(map.get(key));
//			else System.out.print(0);
//			System.out.print(" ");
//		}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class S4_10816 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		
		int[] arrP = new int[10000001];
		int[] arrM = new int[10000001];
		
		String[] strs = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		
		for(String str : strs) {
			int cardNum = Integer.parseInt(str);
			
			if(cardNum>=0) {
				arrP[cardNum]++;
			}
			else {
				arrM[-cardNum]++;
			}
		}
		
		int printNum = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<printNum;i++) {
			
			int idx = Integer.parseInt(st.nextToken());
			
			if(idx>=0) {
				sb.append(arrP[idx]).append(" ");
			}
			else {
				sb.append(arrM[-idx]).append(" ");
			}
			
		}
		
		System.out.println(sb);
		
		
	}

}

