import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14846 {

	static int N, Q;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int[][][] map = new int[N+1][N+1][11];
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				int num = Integer.parseInt(st.nextToken());
				for(int k=1;k<=10;k++) {
					map[i][j][k] = map[i-1][j][k] + map[i][j-1][k] - map[i-1][j-1][k];
				}
				map[i][j][num]++;
				
			}
		}
				
			
		
		StringBuilder sb = new StringBuilder();
		Q = Integer.parseInt(br.readLine());
		for(int i=0;i<Q;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int temp[] = new int[11];
			
			int cnt = 0;
			for(int j=1;j<=10;j++) {
				temp[j] = map[x2][y2][j];
			}
			
			for(int j=1;j<=10;j++) {
				temp[j] = temp[j] - map[x2][y1-1][j] - map[x1-1][y2][j] + map[x1-1][y1-1][j];
			}
			
			for(int j=1;j<=10;j++) {
				if(temp[j] > 0) cnt++; 
			}
			
			sb.append(cnt+"\n");
		}
		
		System.out.print(sb);
	}

}
