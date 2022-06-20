import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CodeTree_GridCompression1 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		int cnt = 1;
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(st.nextToken());
			map.put(num, cnt++);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<q;i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			sb.append(map.get(r) - map.get(l) + 1);
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}

}
