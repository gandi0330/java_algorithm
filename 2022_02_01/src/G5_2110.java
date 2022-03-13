import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_2110 {
	
	static int n,c;
	static int[] arr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException{
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr= new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		System.out.println(search());
		
	}
	
	public static int search() {
		int l = 1;
		int r = arr[n-1] - arr[0];
		int answer = 0;
		
		int mid; 
		
		while(l <= r) {
			mid = (r + l)/2;
			int start = arr[0];
			int d = 0;
			int cnt = 1;
			
			for(int i=1;i<n;i++) {
				d = arr[i] - start;
				if(mid <= d) {
					cnt++;
					start = arr[i];
				}
			}
			
			if(cnt >= c) {
				answer = mid;
				l = mid+1;
	
			}
			else {
				r = mid-1;
			}
			
		}
		
		return answer;
	}

}
