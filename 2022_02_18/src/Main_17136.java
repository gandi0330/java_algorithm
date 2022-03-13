import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17136 {

	static int cntPaperMin;
	static int[][] mat;
	static int papers[] = {0,5,5,5,5,5};
	static boolean pass;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		mat = new int[10][10];
		
		for(int i=0;i<10;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cntPaperMin = 10*10 + 1;
		dfs(0,0,0);
		System.out.println(cntPaperMin == 10*10+1 ? -1 : cntPaperMin);
		
	}
	
	
	public static void dfs(int r, int c, int cnt) {
		
		if(r >= 9 && c > 9) {
			cntPaperMin = cntPaperMin < cnt ? cntPaperMin : cnt;
			return;
		}
		
		if(c >= 10) {
			dfs(r+1,0,cnt);
			return;
		}
		if(mat[r][c] == 1) {
			for(int i=5;i>=1;i--) {
				if(papers[i] >= 1 && check(r,c,i)) {
					cover(r,c,i,0);
					papers[i]--;
					dfs(r,c+1,cnt+1);
					papers[i]++;
					cover(r,c,i,1);
				}
			}
		}
		else dfs(r,c+1,cnt);
		
		
	}
	
	public static boolean check(int r, int c, int size) {
		if(r < 0 || r >= 11-size || c < 0 || c >= 11-size) return false;
		
		for(int i=r;i<r+size;i++) {
			for(int j=c;j<c+size;j++) {
				if(mat[i][j] == 0) return false;
			}
		}
		
		return true;
		
	}
	
	public static void cover(int r,int c, int n, int fill) {
		for(int i=r;i<r+n;i++) {
			for(int j=c;j<c+n;j++) {
				mat[i][j] = fill;
			}
		}
	}
	

}
