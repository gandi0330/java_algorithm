import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1389 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 유저 수
		int M = Integer.parseInt(st.nextToken()); // 친구 관계 수
		
		// 배열 초기화
		int[][] mat = new int[N+1][N+1];		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				mat[i][j] = 101;
			}
		}
		
		// 친구 관계 입력
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			mat[v1][v2] = 1;
			mat[v2][v1] = 1;
		}
		
		// 플로이드 워샬
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				if(k == i) continue;
				for(int j=1;j<=N;j++) {
					if(k==j || i==j) continue;
					mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
				}
			}
		}
		
		int[] answer = new int[N+1];
		
		int min = Integer.MAX_VALUE;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i!=j) answer[i] += mat[i][j];
			}
			if(min > answer[i]) min = answer[i];
		}
		
		for(int i=1;i<=N;i++) {
			if(min == answer[i]) {
				System.out.println(i);
				break;
			}
		}
		
	}

}
