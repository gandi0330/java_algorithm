import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_2343 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		
		st = new StringTokenizer(br.readLine());
		int maxArr = 0;
		
		for(int i=0;i<N;i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
			if(maxArr < arr[i]) maxArr = arr[i];
		}
		
		int l = maxArr;
		int r = 1000000000;
		int answer = 0;
		while(l <= r) {
			
			int mid = (l+r)/2;
			int subSum = 0;
			int cnt = 0;
			
			
			// 앞 강의부터 순서대로 더하면서 mid 를 기준으로 쪼개어 개수를 세고 이를 M과 비교
			for(int i =0;i<N;i++) {
				
				
				if(subSum + arr[i] == mid) {
					cnt++;
					subSum = 0;
				}
				else if(subSum + arr[i] > mid) {
					cnt++;
					subSum = arr[i];
				}
				else {
					subSum += arr[i];
				}
			}
			
			
			// 블루레이 제한 개수를 넘었을 때
			if(cnt > M || (cnt==M && subSum>0)) {
				l = mid + 1;
			}
			// 블루레이 제한 개수 이내에 강의를 모두 넣었을 때
			else {
				answer = mid;
				r = mid -1;
			}
		}
		
		System.out.println(answer);
		
		
	}

}
