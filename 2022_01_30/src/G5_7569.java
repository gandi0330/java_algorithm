import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class PointHNM{
	
	int h;
	int m;
	int n;
	
	public PointHNM(int h,int n, int m){
		this.h = h;
		this.m = m;
		this.n = n;
	}
}

public class G5_7569 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int m,n,h;
	static int[][] deltas  = {{-1,0,0},{0,1,0},{0,0,1},{0,-1,0},{0,0,-1},{1,0,0}};
	static Queue<PointHNM> q = new LinkedList<>();
	static int[][][] grid;
	
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		grid = new int[h][n][m];
		
		
		
		for(int i=0;i<h;i++) {
			for(int j=0;j<n;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<m;k++) {
					grid[i][j][k] = Integer.parseInt(st.nextToken());
					if(grid[i][j][k] == 1) {
						
						q.add(new PointHNM(i,j,k));
					}
				}
			}
		}
		
		System.out.println(bfs());
		
	}
	
	public static int bfs() {
		while(!q.isEmpty()) {
			PointHNM nowHnm = q.poll();
			
			int nowH = nowHnm.h;
			int nowN = nowHnm.n;
			int nowM = nowHnm.m;
			
			
			
			for(int i=0;i<6;i++) {
				int nextH = nowH + deltas[i][0];
				int nextN = nowN + deltas[i][1];
				int nextM = nowM + deltas[i][2];
							
				
				if(nextH>=0 && nextH<h && nextM>=0 && nextM < m && nextN>=0 && nextN<n && grid[nextH][nextN][nextM] == 0 ) {
					q.add(new PointHNM(nextH,nextN,nextM));
					grid[nextH][nextN][nextM] = grid[nowH][nowN][nowM] + 1;
					
				}
			}
		}
		
		int answer = Integer.MIN_VALUE;
		
		for(int i=0;i<h;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<m;k++) {
					if(grid[i][j][k] == 0) return -1;
					answer = Math.max(answer, grid[i][j][k]);
				}
			}
		}
		
		if(answer == 1) return 0;
		return answer-1;
		
	}
}
