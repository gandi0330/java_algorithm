import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_17144 {
	
	static int R,C,T;
	static int[][] mat;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	static int[][] airCleaner;
	static int[][] upClear = {{0,1},{-1,0},{0,-1},{1,0}};
	static int[][] downClear = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		mat = new int[R][C];
		
		airCleaner = new int[2][2];
		int airIdx = 0;
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				if(mat[i][j] == -1) airCleaner[airIdx++] = new int[] {i,j};
			}
		}
		
		for(int i=0;i<T;i++) {
			spreadDust();
			airCleanerOn();
		}
		
		
		int cnt =0;
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(mat[i][j] != -1) cnt += mat[i][j];
			}
		}
		
		System.out.println(cnt);
		
	}
	
	public static class Dust {
		int r,c,a;
		
		Dust(int r, int c, int a){
			this.r = r;
			this.c = c;
			this.a = a;
		}
	}
	
	public static void spreadDust() {
		
		Stack<Dust> dusts = new Stack<>();
		
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(mat[i][j] > 0) dusts.add(new Dust(i,j,mat[i][j]));
			}
		}
		
		while(!dusts.isEmpty()) {
			Dust dust = dusts.pop();
			
			int spreadCnt = 0;
			for(int i=0;i<4;i++) {
				int nextR = dust.r + deltas[i][0];
				int nextC = dust.c + deltas[i][1];
				
				if(nextR < 0 || nextR >= R || nextC < 0 || nextC >= C || mat[nextR][nextC] == -1) continue;
				spreadCnt++;
				mat[nextR][nextC] += dust.a/5;
			}
			
			mat[dust.r][dust.c] -= dust.a/5 * spreadCnt; 
		}
	}
	
	public static void airCleanerOn() {
		int nowR = airCleaner[0][0];
		int nowC = airCleaner[0][1];
		
		int preValue = 0;
		loop :for(int i=0;i<4;i++) {
			
			while(true) {
				
				int nextR = nowR + upClear[i][0];
				int nextC = nowC + upClear[i][1];
				
				if(nextR < 0 || nextR >= R || nextC < 0 || nextC >= C || mat[nextR][nextC] == -1) continue loop;
				int temp = mat[nextR][nextC];
				mat[nextR][nextC] = preValue;
				preValue = temp;
				
				nowR = nextR;
				nowC = nextC;
			}
		}
		
		nowR = airCleaner[1][0];
		nowC = airCleaner[1][1];
		
		preValue = 0;
		
		loop :for(int i=0;i<4;i++) {
			
			while(true) {
				
				int nextR = nowR + downClear[i][0];
				int nextC = nowC + downClear[i][1];
				
				if(nextR < 0 || nextR >= R || nextC < 0 || nextC >= C || mat[nextR][nextC] == -1) continue loop;
				int temp = mat[nextR][nextC];
				mat[nextR][nextC] = preValue;
				preValue = temp;
				
				nowR = nextR;
				nowC = nextC;
			}
		}
		
	}
}
