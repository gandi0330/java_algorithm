import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11404 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] mat = new int[n+1][n+1];
		
		final int INF = 10000001;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i!= j) mat[i][j] = INF;
			}
		}
		
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			mat[v1][v2] = Math.min(cost, mat[v1][v2]);
		}
		
		
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				if(k==i) continue;
				for(int j=1;j<=n;j++) {
					if(k==j || i==j)  continue;
					mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
				}
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(mat[i][j] == INF) mat[i][j] = 0;
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}

}
