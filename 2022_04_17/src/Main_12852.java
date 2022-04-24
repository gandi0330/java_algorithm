import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_12852 {

	static int[] dp;
	static int parent[];
	static int minCnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 각 수를 찾아오는 최단거리를 저장
		dp = new int[N+1];
		Arrays.fill(dp,Integer.MAX_VALUE);
		dp[N] = 0; // N에서부터 시작
		
		// 해당 수의 전 수를 저장
		parent = new int[N+1];
		parent[N] = N;
		
		int temp = N;
		minCnt = Integer.MAX_VALUE;
		
		// 3으로 나누기, 2로 나누기, 1 빼기를 진행
		dfs(temp,0);
		
		// 1부터 역으로 부모를 찾아가기
		int[] arr = new int[minCnt];
		int subIdx = 1;

		for(int i=minCnt-1;i>=0;i--) {
			arr[i] = subIdx;
			subIdx = parent[subIdx];
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		sb.append(minCnt+"\n");
		sb.append(N+" ");
		
		for(int i=0;i<minCnt;i++) {
			sb.append(arr[i]+" ");
		}
		
		System.out.println(sb);
		
		
	}
	
	public static void dfs(int temp, int cnt) {
		
		if(minCnt <= cnt) return;
		
		if(temp == 1) {
			if(minCnt > cnt) minCnt = cnt;
		}
		
		if(temp % 3 == 0 && dp[temp/3] > cnt+1) {
				parent[temp/3] = temp;
				dp[temp/3] = cnt+1;
				dfs(temp/3, cnt+1);
		}
			
		if(temp % 2 == 0 && dp[temp/2] > cnt+1) {
			parent[temp/2] = temp;
			dp[temp/2] = cnt+1;
			dfs(temp/2, cnt+1);
		}
		if(temp-1 > 0 && dp[temp-1] > cnt+1) {
			parent[temp-1] = temp;
			dp[temp-1] = cnt+1;
			dfs(temp-1,cnt+1);
		}
	}

}
