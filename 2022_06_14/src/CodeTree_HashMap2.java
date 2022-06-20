import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CodeTree_HashMap2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		
		for(int i=0;i<n;i++) {
			int v = Integer.parseInt(st.nextToken());
			hashMap.put(v, hashMap.getOrDefault(v, 0) + 1);
		}
		
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<m;i++) {
			sb.append(hashMap.getOrDefault(Integer.parseInt(st.nextToken()), 0)+" ");
		}
		
		System.out.println(sb);
	}

}
