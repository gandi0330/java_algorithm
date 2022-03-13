/* baekjoon url : https://www.acmicpc.net/problem/1620
 * silver 4
 * poketmon master
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;



public class S4_1620 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String[] poketList = new String [n+1];
		
		for(int i=1;i<=n;i++) {
		
			String read = br.readLine();
			map.put(read, i);
			poketList[i] = read; 
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<m;i++) {
			String read = br.readLine();
			
			if (read.charAt(0) >='0' && read.charAt(0)<='9') {
				sb.append(poketList[Integer.parseInt(read)]).append("\n");
			}
			else {
				sb.append(map.get(read)).append("\n");
			}
		}
		
		System.out.println(sb.toString());
		
	}

}
