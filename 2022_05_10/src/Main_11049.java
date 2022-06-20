import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11049 {

	
	static int cal(int l, int r) {
		if(dp[l][r] != -1) return dp[l][r];
		else if(l == r) return 0;
		else {
			for(int i=l;i<r;i++) {
				int temp = cal(l,i)+cal(i+1,r)+matrix[l][0]*matrix[i][1]*matrix[r][1];
				if(dp[l][r] == -1 || temp < dp[l][r]) dp[l][r] = temp;
			}
			return dp[l][r];
		}
	}
	
	static int[][] dp;
	static int[][] matrix;
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		matrix = new int[n][2];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			matrix[i][0] = Integer.parseInt(st.nextToken());
			matrix[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[n][n];
		
		for(int i=0;i<n;i++) {
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(cal(0,n-1));
		
		
	}

}
