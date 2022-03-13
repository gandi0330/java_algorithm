import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//url : https://www.acmicpc.net/problem/14465

public class Main_S2_14465 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		boolean[] lightsOff = new boolean[N+1];
		
		for(int i=0;i<B;i++) {
			lightsOff[Integer.parseInt(br.readLine())] = true;
		}
		
		
		int answer = 100000;
		int cnt = 0;
		
		int l = 1;
		int r = K;
		
		for(int i=l;i<=K;i++) {
			if(lightsOff[i]) cnt++;
		}
		
		l++;
		r++;
		
		for(;l<=N-K+1;l++,r++) {
			if(lightsOff[l-1] && !lightsOff[r]) {
				cnt--;
			}
			else if(!lightsOff[l-1] && lightsOff[r]){
				cnt++;
			}
			
			answer = Math.min(answer, cnt);
		}
		
		System.out.println(answer);
		
	}

}
