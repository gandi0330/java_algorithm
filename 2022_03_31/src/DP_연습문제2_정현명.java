
public class DP_연습문제2_정현명 {

	public static void main(String[] args) {
	
		int[] dp = new int[7];
		
		dp[1] = 2;
		dp[2] = 5;
		
		for(int i=3;i<7;i++) {
			dp[i] = dp[i-1]*2 + dp[i-2];
			
		}
		
		System.out.println(dp[6]);
	}

}
