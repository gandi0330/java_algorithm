import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780 {
	
	static int[] cnt;
	static int[][] papers;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		papers = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				papers[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = new int[3];
		
		divide(0,0,N);
		for(int i=0;i<3;i++) {
			System.out.println(cnt[i]);
		}
	}
	
	public static void divide(int r, int c, int size) {
		
		boolean isOne = true;
		
		for(int i=r;i<r+size;i++) {
			for(int j=c;j<c+size;j++) {
				if(papers[i][j] == papers[r][c]) continue;
				isOne = false;
				break;
			}
		}
		if(isOne) {
			cnt[papers[r][c]+1]++;
			return;
		}
		
		divide(r,c,size/3);
		divide(r+size/3,c,size/3);
		divide(r+size*2/3,c,size/3);
		divide(r,c+size/3,size/3);
		divide(r+size/3,c+size/3,size/3);
		divide(r+size*2/3,c+size/3,size/3);
		divide(r,c+size*2/3,size/3);
		divide(r+size/3,c+size*2/3,size/3);
		divide(r+size*2/3,c+size*2/3,size/3);
	}

}
