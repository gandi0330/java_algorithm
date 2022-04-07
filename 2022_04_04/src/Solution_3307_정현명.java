import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3307_정현명 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		int[] arr = null;
		int[] dp = null;
		
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			arr = new int[N];
			dp = new int[N];
			int maxValue = 0;
			
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<N;i++) {
				dp[i] = 1;
				for(int j=0;j<i;j++) {
					if(arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
						dp[i] = dp[j] + 1;
					}
				}
				if(maxValue < dp[i]) maxValue = dp[i];
			}
			
			sb.append("#"+tc+" "+maxValue+"\n");
			
		}
		
		System.out.println(sb);
	}
	// answer = Math.max(a,b) 보다 if(a > b) answer = a 가 더 빠른듯
}
