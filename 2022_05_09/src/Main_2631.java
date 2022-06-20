import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2631 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[n+1];
		int max = 0;
		
		for(int i=1;i<=n;i++) {
			dp[i] = 1;
			for(int j=1;j<i;j++) {
				if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
			if(max < dp[i]) max = dp[i];
		}
		
		System.out.println(n - max);
		
		
		
	}

}
