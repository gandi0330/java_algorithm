import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2565 {

	static class Wire implements Comparable<Wire>{
		int a;
		int b;
		
		Wire(int a, int b){
			this.a = a;
			this.b = b;
		}
		
		@Override
		public int compareTo(Wire o) {
			return this.a - o.a;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Wire> wireList = new ArrayList<>();
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			wireList.add(new Wire(a,b));
		}
		
		Collections.sort(wireList);
		
		int[] dp = new int[N];
		int max = 0;
		for(int i=0;i<N;i++) {
			dp[i] = 1;
			for(int j=0;j<i;j++) {
				if(wireList.get(i).b > wireList.get(j).b && dp[i] < dp[j]+1) {
					dp[i] = dp[j]+1;
				}
			}
			max = max < dp[i] ? dp[i] : max;
		}
		
		System.out.println(N-max);
		
	}

}
