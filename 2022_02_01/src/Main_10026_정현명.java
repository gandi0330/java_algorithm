import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10026_정현명 {

	static boolean visited1[][];
	static boolean visited2[][];
	static int N;
	static char grid[][];
	static int cnt1 = 0, cnt2 = 0;
	static int deltas[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException{
		
		// 입력받기
		
		
		N = Integer.parseInt(br.readLine());
		grid= new char[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			String line = br.readLine();
			for(int j=1;j<=N;j++) {
				grid[i][j] = line.charAt(j-1);
			}
		}
		
		
		visited1 = new boolean[N+1][N+1];
		visited2 = new boolean[N+1][N+1];
		
		
		// 구현
		
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(visited1[i][j] == false) {
					cnt1++; 
					dfs1(i,j);
				}
				if(visited2[i][j] == false) {
					cnt2++;
					dfs2(i,j);
				}
			}
		}
		
		System.out.println(cnt1+" "+cnt2);
	}
	
	
	
	public static void dfs1(int r, int c) {
		visited1[r][c] = true;
		char now = grid[r][c];
		// 4방탐색
		for(int i=0;i<4;i++) {
			int nr = r + deltas[i][0];
			int nc = c + deltas[i][1];
			
			if(nr>0 && nr<=N && nc>0 && nc<=N && !visited1[nr][nc] && grid[nr][nc] == now) {
				dfs1(nr,nc);
			}
		}
	}

	public static void dfs2(int r, int c) {
		visited2[r][c] = true;
		char now = grid[r][c];
		// 4방탐색
		for(int i=0;i<4;i++) {
			int nr = r + deltas[i][0];
			int nc = c + deltas[i][1];
			
			if(now == 'R' || now == 'G') {
				if(nr>0 && nr<=N && nc>0 && nc<=N && !visited2[nr][nc] && (grid[nr][nc] == 'R' || grid[nr][nc] == 'G')) {
					dfs2(nr,nc);
				}
			}
			
			else if(nr>0 && nr<=N && nc>0 && nc<=N && !visited2[nr][nc] && grid[nr][nc] == now) {
				dfs2(nr,nc);
			}
		}
	}
}
