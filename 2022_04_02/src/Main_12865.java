import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12865 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] back = new int[N+1][2];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			back[i]= new int[] {w,v};
		}
		
		// 가방 개수와 무게에 대한 가치 최대값
		int[][] dp = new int[N+1][K+1];
		
		// 배낭 최대 만큼 반복
		for(int i =1;i<=N;i++) {
			// 이전 dp 확인
			for(int j=1;j<=K;j++) {
				if(back[i][0] <=j) {
					if(back[i][1] + dp[i-1][j-back[i][0]] > dp[i-1][j]) {
						dp[i][j] = back[i][1] + dp[i-1][j-back[i][0]];
					}
					else {
						dp[i][j] = dp[i-1][j];
					}
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		System.out.println(dp[N][K]);
		
	}

}
