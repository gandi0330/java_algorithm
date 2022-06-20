import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1520 {

	static int N,M;
	static int[][] map;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		dp = new int[N+1][M+1]; // 해당 좌표까지의 경로 수를 의미
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		System.out.println(dfs(1,1));
		
	}
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static int dfs(int r, int c) {
		
		// 끝에 도달했을 때 1 리턴
		if(r == N && c == M) {
			return 1;
		}
		
		// 이미 방문했다면  해당 좌표의 경로 수를 리턴
		if(dp[r][c] != -1) {
			return dp[r][c];
		}
		
		dp[r][c] = 0;
		
		for(int i=0;i<4;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr>N || nr<1 || nc>M || nc<1 || map[nr][nc] >= map[r][c]) continue;
			dp[r][c] += dfs(nr,nc);
		}
		
		
		return dp[r][c];
	}

}
