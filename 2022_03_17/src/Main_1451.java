import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1451 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[][] map = new long[N+1][M+1];
		
		for(int i=1;i<=N;i++) {
			String line = br.readLine();
			for(int j=1;j<=M;j++) {
				map[i][j] = map[i][j-1] + map[i-1][j] - map[i-1][j-1] + (line.charAt(j-1) -'0');
			}
		}
		
		long max = 0;
		for(int i=1; i< N;i++) {
			long basedown = map[N][M] - map[i][M];
			for(int j=1;j<M;j++) {
				long left = map[i][j];
				long right = map[i][M] - map[i][j];
				
				long mul = basedown * left * right;
				if(max < mul) max = mul; 	
			}
			
			for(int j=1;j<i;j++) {
				long up = map[j][M];
				long mid = map[i][M] - map[j][M];
				
				long mul = basedown * up * mid;
				if(max < mul) max = mul; 	
			}
			
			
			long baseup = map[i][M];
			
			for(int j=1;j<M;j++) {
				long left = map[N][j] - map[i][j];
				long right = map[N][M] - map[N][j] - map[i][M] + map[i][j];
				
				long mul = baseup * left * right;
				if(max < mul) max = mul;
			}
			
			for(int j=i+1;j<N;j++) {
				long mid = map[j][M] - map[i][M];
				long down = map[N][M] - map[j][M];
				
				long mul = baseup * mid * down;
				if(max < mul) max = mul;
			}
			
		}
		
		
		
		for(int j=1; j< M;j++) {
			long baseright = map[N][M] - map[N][j];
			for(int i=1;i<N;i++) {
				long up = map[i][j];
				long down = map[N][j] - map[i][j];
				
				long mul = baseright * up * down;
				if(max < mul) max = mul; 	
			}
			
			for(int i=1;i<j;i++) {
				long left = map[N][i];
				long mid = map[N][j] - map[N][i];
				
				long mul = baseright * left * mid;
				if(max < mul) max = mul; 	
			}
			
			
			long baseleft = map[N][j];
			
			for(int i=1;i<N;i++) {
				long up = map[i][M] - map[i][j];
				long down = map[N][M] - map[N][j] - map[i][M] + map[i][j];
				
				long mul = baseleft * up * down;
				if(max < mul) max = mul;
			}
			
			for(int i=j+1;i<M;i++) {
				long mid = map[N][i] - map[N][j];
				long right = map[N][M] - map[N][i];
				
				long mul = baseleft * mid * right;
				if(max < mul) max = mul;
			}
			
		}
		
		System.out.println(max);
	}

}
