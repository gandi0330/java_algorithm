import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class S1_16507 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer firstLine = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(firstLine.nextToken());
		int C = Integer.parseInt(firstLine.nextToken());
		int Q = Integer.parseInt(firstLine.nextToken());
		
		int[][] grid = new int[R][C];
		
		for(int i=0;i<R;i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int partSum = 0;
			for(int j=0;j<C;j++) {
				partSum += Integer.parseInt(st.nextToken());
				grid[i][j] = partSum;
			}
		}
		
		for(int tc=0;tc<Q;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int r1 = Integer.parseInt(st.nextToken()) - 1;
			int c1 = Integer.parseInt(st.nextToken()) - 1;
			int r2 = Integer.parseInt(st.nextToken()) - 1;
			int c2 = Integer.parseInt(st.nextToken()) - 1;
			
			int sum = 0;
			
			for(int i=r1;i<=r2;i++) {
				if(c1 -1 >=0) {
				sum += grid[i][c2] - grid[i][c1-1];
				}
				else {
					sum += grid[i][c2];
				}
			}
			
			System.out.println(sum/((r2-r1+1)*(c2-c1+1)));
		}
		
	}

}
