import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9252 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int [][] dp = new int[str1.length()+1][str2.length()+1];
		
		for(int i=1;i<=str1.length();i++) {
			for(int j=1;j<=str2.length();j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		int r = str1.length();
		int c = str2.length();
		
		int len = dp[r][c];
		System.out.println(len);
		
		StringBuilder sb = new StringBuilder();
		
		
		while(true) {
			if(dp[r][c] == dp[r-1][c]) {
				r--;
			}
			else if(dp[r][c] == dp[r][c-1]) {
				c--;
			}
			else {
				sb.append(str1.charAt(r-1));
				r--;
				c--;
			}
			
			if(r <= 0 || c <= 0 || dp[r][c] == 0) break;
		}
		
		System.out.println(sb.reverse().toString());
		
		
	
	}

}
