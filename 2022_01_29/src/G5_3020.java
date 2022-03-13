import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_3020 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[] floor = new int[H+1];
		int[] ceil = new int[H+1];
		
		
		for(int i=0;i<N/2;i++) {
			floor[Integer.parseInt(br.readLine())]++;
			ceil[Integer.parseInt(br.readLine())]++;
		}
		
		for(int i=H-1;i>0;i--) {
			floor[i] +=floor[i+1];
			ceil[i] += ceil[i+1];
		}
		
		int[] collision = new int[H+1];
		int min = Integer.MAX_VALUE;
				
		for(int i=1;i<=H;i++) {
			collision[i] = floor[i] + ceil[H-i+1];
			min = Math.min(collision[i], min);
		}
		
		int cnt = 0;
		
		for(int i=1;i<=H;i++) {
			if (collision[i] == min) {
				cnt++;
			}
		}
		
		System.out.println(min+" "+cnt);
		
		
	}

}
