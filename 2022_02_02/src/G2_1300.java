import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G2_1300 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		// N 배열을 오름차순 했을 때 k번째 수가 S라 하면 S보다 작거나 같은 수는 k개이다
		
		
		int l = 1;
		int r = k;
		int answer = 0;
		while(l<=r) {
		
			int mid = (l+r) / 2;
			
			int cnt = 0;
			
			for(int i=1;i<=N;i++) {
				// 한 행에서 S보다 작거나 같은수의 의미는 min(N, S/i) 와 같다
				cnt += Math.min(N, mid/i);
			}
			
			if(cnt >= k) {
				answer = mid;
				r = mid-1;
			}
			else {
				
				l = mid+1;
			}
			
		}
		System.out.println(answer);
	}

}
