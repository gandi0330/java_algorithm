import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15961 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+k];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i=N;i<N+k;i++) {
			arr[i] = arr[i-N];
		}
		
		int[] countArr = new int[d+1];
		int cnt = 0;
		
		for(int i=0;i<k;i++) {
			
			if(countArr[arr[i]] == 0) {
				cnt++;
			}
			countArr[arr[i]]++;
		}
		
		if(countArr[c] == 0) {
			countArr[c]++;
			cnt++;
		}
		
		int max = cnt;
		
		int l = 0;
		int r = k;

		while(l != N-1) {
			if(arr[l] != c ) {
				countArr[arr[l]]--;
				
				if(countArr[arr[l]] == 0) cnt--;
			}
			
			
			if(countArr[arr[r]] == 0) {
				cnt++;
			}
			countArr[arr[r]]++;
			
			
			max = Math.max(max, cnt);
			
			l++;
			r++;
		}
		
		System.out.println(max);
		
	}

}
