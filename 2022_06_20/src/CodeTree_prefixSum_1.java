import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_prefixSum_1 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n =Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		int max = Integer.MIN_VALUE;
		int sum  = 0;
		for(int i=1;i<=n;i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			sum+=num;
			
			if(i >= k) {
				sum -= arr[i-k];
				
				if(sum > max) max =sum;
			}
		}
		System.out.println(max);
	}

}
