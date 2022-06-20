import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10942 {

	public static int go(int S, int E) {
		// 이미 방문 했다면 팰린드롬 결과를 출력
		if(dp[S][E] != -1) {
			return dp[S][E];
		}
		
		// 양쪽의 숫자가 다르면 팰린드롬이 아님
		if(numArr[S] != numArr[E]) {
			return dp[S][E] = 0;
		}
		
		// 숫자배열 길이가 1이거나 2이면 팰린드롬
		if(S==E || S+1 == E) {
			return dp[S][E] = 1;
		}
		
		// 방문하지 않았고 숫자 배열의 길이가 3 이상이면서 양쪽의 숫자가 같으면 양쪽에서 한 칸씩 줄인 숫자 배열 확인
		return dp[S][E] = go(S+1,E-1);
		
	}
	
	
	
	static int N,M;
	static int[] numArr;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		numArr = new int[N+1];
		dp = new int[N+1][N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
			Arrays.fill(dp[i], -1); // 초기값을 -1로 설정
		}
		
		M = Integer.parseInt(br.readLine());
	
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			sb.append(go(S,E)+"\n");
		}
		
		System.out.print(sb);
		
	}

}
