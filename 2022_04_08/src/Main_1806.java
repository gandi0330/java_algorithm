import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1806 {

	public static void main(String[] args) throws IOException{
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int nums[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int l = 0;
		int r = 0;
		int sum = 0;
		int len = 0;
		int minLen = Integer.MAX_VALUE;
		while(l<=r && r < N) {
			// 현재 부분합이 S보다 작거나 같으면 무조건 r늘림
			if(sum <= S) {
				if(sum == S) minLen = Math.min(minLen, len);
				sum += nums[r];
				len++;
				r++;
			}
			// 현재 부분합이 S보다 크면 현재 부분합에서 nums[l]값 빼고 늘림
			else if(sum > S){ 
				minLen = Math.min(minLen, len);
				sum -= nums[l];
				l++;
				len--;
			}
			
		}
		
		// 맨 끝에서 부분합이 완성 되었거나, 완성된 후 left를 제외시켰을 때 부분합이 S보다 크거나 같을 경우 갱신
		while(l<N) {
			if(sum >= S) minLen = Math.min(minLen, len);
			sum -= nums[l];
			len--;
			l++;
		}
		
		if(minLen == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(minLen);
	}

}
