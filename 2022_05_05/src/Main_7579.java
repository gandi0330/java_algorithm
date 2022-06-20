import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7579 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int bytes[] = new int[N+1];
		int costs[] = new int[N+1];
		int costSum = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			bytes[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			costs[i] = Integer.parseInt(st.nextToken());
			costSum += costs[i];
		}
		
		int dp[][] = new int[N+1][costSum+1]; 
		int answer = costSum;
		for(int i=1;i<=N;i++) {
			for(int j=0;j<=costSum;j++) {
				
				if(costs[i]>j) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], bytes[i] + dp[i-1][j-costs[i]]);					
				}
				
				if(dp[i][j] >=M) answer = Math.min(answer, j); 
			}
		}
		
		
		System.out.println(answer);
	}

}
