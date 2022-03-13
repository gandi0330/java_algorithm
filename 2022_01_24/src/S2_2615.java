import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class S2_2615 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 받기
		int N = 19;
		int[][] grid = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			
			String[] line = br.readLine().split(" ");
			for(int j=1;j<=N;j++) {
				grid[i][j] = Integer.parseInt(line[j-1]); 
			}
		}
		
		
		// 탐색 하기
		
		
		
		loop : for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(grid[i][j] != 0) { 
					GoStone ansGo = new GoStone(i,j,grid[i][j],false);
					ansGo = search(grid,ansGo);
					if (ansGo.isWin) {
						System.out.println(ansGo.color);
						System.out.println(ansGo.r + " " + ansGo.c);
						break loop;
					}
					
					
				}
				else if (i ==N && j == N) System.out.println("0");
				
			}
		}
		
		
		

	}
	public static class GoStone {
		private int r;
		private int c;
		private int color;
		private boolean isWin;
		
		public GoStone() {};
		public GoStone(int r, int c){
			this.r = r;
			this.c = c;
		}
		
		public GoStone(int r, int c, int color, boolean isWin) {
			this.r=r;
			this.c=c;
			this.color=color;
			this.isWin=isWin;
		}
	}
	
	
	public static GoStone compare(GoStone a, GoStone b) {
		b.isWin = a.isWin;
		b.color = a.color;
		
		if(a.c < b.c) {
			return a;
		}
		else if(a.c == b.c) {
			return a.r < b.r ? a : b;
		}
		return b;
	}
	
	public static GoStone search( int[][] grid, GoStone ansGo) {
		int[][] deltas = {{-1,0},{-1,1},{0,1},{1,1}}; // 현재 위치에서 한 방향과 반대 방향인 2방향을 함께 탐색 하기 위한 deltas
		int[] cnts = {1,1,1,1};
		
		
		// 4방향 탐색
		for(int i=0;i<4;i++) {
			
			// 한 방향과 그 반대 방향을 동시에 탐색
			int r1 = ansGo.r + deltas[i][0];
			int c1 = ansGo.c + deltas[i][1];
			int r2 = ansGo.r - deltas[i][0];
			int c2 = ansGo.c - deltas[i][1];
			
			// 정방향 탐색
			if(r1>0 && r1<20 && c1>0 && c1<20 && grid[r1][c1] == ansGo.color) {
				cnts[i]++;
				ansGo = compare(ansGo,new GoStone(r1,c1));
				
				while(true) {
					
					if (cnts[i] >5) return ansGo;
					
					r1 += deltas[i][0];
					c1 += deltas[i][1];
					
					if(r1>0 && r1<20 && c1>0 && c1<20 && grid[r1][c1] == ansGo.color) {
						cnts[i]++;
						ansGo = compare(ansGo,new GoStone(r1,c1));
						continue;
					}
					else break;
					
				}
			}
			
			// 역방향 탐색
			if(r2>0 && r2<20 && c2>0 && c2<20 && grid[r2][c2] == ansGo.color) {
				cnts[i]++;
				ansGo = compare(ansGo,new GoStone(r2,c2));
				while(true) {
					
					if (cnts[i] >5) return ansGo;
					
					r2 -= deltas[i][0];
					c2 -= deltas[i][1];
					
					if(r2>0 && r2<20 && c2>0 && c2<20 && grid[r2][c2] == ansGo.color) {
						cnts[i]++;
						ansGo = compare(ansGo,new GoStone(r2,c2));
						continue;
					}
					else break;
					
				}
			}
			
			if(cnts[i] == 5) {
				ansGo.isWin = true;
				return ansGo;
			}
			
		}
	
		return ansGo;
	}
	

}


