import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_정현명 {

	public static void main(String[] args) throws IOException{
		
		// ================= 입력 =================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int costs[][] = new int[N][3];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			costs[i][0] = Integer.parseInt(st.nextToken());
			costs[i][1] = Integer.parseInt(st.nextToken());
			costs[i][2] = Integer.parseInt(st.nextToken());
		}
		
		// ================= 솔루션 ==================
		int dp[][] = new int[N][3]; //dp 생성
		
		// 1번 집 칠하기
		dp[0][0] = costs[0][0];
		dp[0][1] = costs[0][1];
		dp[0][2] = costs[0][2];
		
		// 현재 집의 색이 빨강이면 이전 집에서 초록과 파랑으로 칠한 것 중 작은 값을 현재의 dp 에 더함 
		for(int i=1;i<N;i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][2];
		}
		
		// 모두 칠한 후 가장 최솟값 출력
		int minCost = Integer.MAX_VALUE;
		
		for(int i=0;i<3;i++) {
			if(minCost > dp[N-1][i]) minCost = dp[N-1][i];
		}
		
		System.out.println(minCost);
	}

}
