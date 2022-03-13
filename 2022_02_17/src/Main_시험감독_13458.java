import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_시험감독_13458 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int students[] = new int[N];
		
		for(int i=0;i<N;i++) {
			students[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		
		long sum = 0;
		
		for(int i=0;i<N;i++) {
			sum++;
			int r = students[i] - B; 
			if (r > 0) {
				sum += r/C;
				if(r % C != 0) sum++;
			}
		}
		
		System.out.println(sum);
	}

}
