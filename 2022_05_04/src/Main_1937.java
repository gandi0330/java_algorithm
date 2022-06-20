import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1937 {

	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int go(int r, int c) {
		if(dp[r][c] != -1) {
			return dp[r][c];
		}
		
		int path = 1;
		
		for(int i=0;i<4;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr<0 || nr>=n || nc<0 || nc>=n || forest[r][c] >= forest[nr][nc]) continue;
			int prePath = go(nr,nc)+1;
			if(path < prePath) path = prePath;
		}
		
		return dp[r][c] = path;
		
	}
	
	static int n;
	static int[][] forest;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		forest = new int[n][n];
		dp = new int[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				forest[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				go(i,j);
			}
		}
		int max = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(max < dp[i][j]) max = dp[i][j];
			}
		}
		System.out.println(max);
	}

}
