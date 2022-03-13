
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_1012 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<testCase;tc++) {
			
			//입력받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			
			int[][] grid = new int[N][M];
			
			for(int i=0;i<K;i++) {
				String[] strs = br.readLine().split(" ");
				
				grid[Integer.parseInt(strs[1])][Integer.parseInt(strs[0])] = 1;
			}
			
			// dps
			
			boolean[][] visited = new boolean[N][M]; 
			int cnt = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(visited[i][j] == false && grid[i][j] == 1) {
						dps(grid, visited, i, j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
			
		}
	}
	
	public static void dps(int[][] grid, boolean[][] visited, int i, int j) {
		if(grid[i][j] == 1) {
			visited[i][j] = true;
			
			int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
			
			for(int idx=0;idx<4;idx++) {
				i += deltas[idx][0];
				j += deltas[idx][1];
				
				if(i>=0 && i<grid.length && j>=0 && j<grid[0].length && visited[i][j] == false) {
					dps(grid,visited,i,j);
				}
				
				i -= deltas[idx][0];
				j -= deltas[idx][1];
				
			}
		}
		
		
	}

}
