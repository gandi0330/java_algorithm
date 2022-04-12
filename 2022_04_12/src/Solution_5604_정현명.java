import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5604_정현명 {

	static HashMap<Long, Long> map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		map = new HashMap<>();
		long sum = 0;
		for(long i=0;i<10;i++) {
			sum+=i;
			map.put(i,sum);
		}
		map.put(-1L, 0L);
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			
			sb.append("#"+tc+" "+(F(B) - F(A-1))+"\n");
		}
		System.out.print(sb);
	}
	
	public static long F(long n) {
		if(map.containsKey(n)) {
			return map.get(n);
		}
		
		long v = V(n);
		
		long value = F(n-1-n%v) + G(n);
		map.put(n, value);
		return value;
	}
	
	public static long G(long n) {
		long v = V(n);
		return n/v*(n%v+1)+F(n%v);
	}
	
	public static long V(long n) {
		long v = 1;
		
		while(10<= n) {
			v *=10;
			n /=10;
		}
		
		return v;
	}

}
