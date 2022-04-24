import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2473 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Long[] arr = new Long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		long minDiff = Long.MAX_VALUE;
		Long answer[] = new Long[3];
		loop : for(int i=0;i<N-2;i++) {
			int l = i+1;
			int r = N-1;
			
			while(l<r) {
				Long value = arr[i] + arr[l] + arr[r];
				
				if(minDiff > Math.abs(value)) {
					answer[0] = arr[i];
					answer[1] = arr[l];
					answer[2] = arr[r];
					minDiff = Math.abs(value);
				}
				
				if(value > 0) {
					r--;
				}else if(value < 0){
					l++;
				}else break loop;
				
			}
		}
		
		Arrays.sort(answer);
		for(int i=0;i<3;i++) {
			System.out.print(answer[i] + " ");
		}
	}

}
