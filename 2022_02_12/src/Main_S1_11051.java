import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_11051 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int dp [][] = new int[1001][1001];
		
		for(int i=1;i<=n;i++) {
			for(int j=0;j<=n;j++) {
				if(j==0 || i == j) {
					dp[i][j] = 1;
					
				}
				else {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
				}
			}
		}
		
		System.out.println(dp[n][r]);
	}

}
