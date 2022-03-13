import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11660 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int pSum[][] = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			st=  new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				pSum[i][j] = pSum[i][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			
			for(int i=x1;i<=x2;i++) {
				sum += pSum[i][y2] - pSum[i][y1-1];
			}
			
			sb.append(sum+"\n");
		}
		
		System.out.print(sb);
	}

}
