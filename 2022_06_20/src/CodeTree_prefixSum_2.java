import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_prefixSum_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int matrix[][] = new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				int num = Integer.parseInt(st.nextToken());
				matrix[i][j] = matrix[i-1][j] + matrix[i][j-1] + num - matrix[i-1][j-1];
			}
		}
		
		int sum = 0;
		for(int i=k;i<=n;i++) {
			for(int j=k;j<=n;j++) {
				int partSum = matrix[i][j] - matrix[i][j-k] - matrix[i-k][j] + matrix[i-k][j-k];
				if(sum < partSum) sum = partSum;
			}
		}
		
		System.out.println(sum);

	}

}
