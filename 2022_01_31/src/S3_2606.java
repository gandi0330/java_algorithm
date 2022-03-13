import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_2606 {

	
	static boolean[] visited;
	static int comN;
	static int connectN;
	static boolean[][] grid;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		comN = Integer.parseInt(br.readLine());
		connectN = Integer.parseInt(br.readLine());
		grid = new boolean[comN+1][comN+1];
		visited  = new boolean[comN+1];
		
		for(int i=1;i<=connectN;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			grid[a][b] = true;
			grid[b][a] = true;
		}
		
		dfs(1);
		
		int cnt = -1;
		for(int i=1;i<=comN;i++) {
			if(visited[i]) cnt++;
		}
		
		System.out.println(cnt);
		
		
	}
	
	public static void dfs(int node) {
		visited[node] = true;
		
		for(int i=1;i<=comN;i++) {
			if(grid[node][i] == true && visited[i]== false) {
				dfs(i);
			}
		}
		
		
	}

}
