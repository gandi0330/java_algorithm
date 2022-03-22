import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5582 {
    public static void main(String[] args)throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String str1 = " " + br.readLine();
    	String str2 = " " + br.readLine();
    	
    	
    	int[][] dp = new int[str1.length()][str2.length()];
    	
    	int max = 0;
    	for(int i=1;i<str1.length();i++) {
    		for(int j=1;j<str2.length();j++) {
    			if(str1.charAt(i) == str2.charAt(j)) {
    				dp[i][j] = dp[i-1][j-1] + 1;
    				max = Math.max(dp[i][j], max);
    			}
    		}
    	}
    	
    	System.out.println(max);
    }
}