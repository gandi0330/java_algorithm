import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9251_baekjoon {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = " "+ br.readLine();
		String str2 = " "+ br.readLine();
		
		int row = str1.length();
		int col = str2.length();
		
		int[][] dp = new int[row][col];
		int len = 0;
		for(int i =1; i<row; i++) {
			for(int j=1; j<col; j++) {
				if(str1.charAt(i) == str2.charAt(j)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]); 
				}
				
				len = Math.max(len, dp[i][j]);
			}
		}
		
		System.out.println(len);
		
	}

}
