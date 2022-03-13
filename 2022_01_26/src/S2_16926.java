import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_16926 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] grid = new int[N][M];
		
		for(int i=0;i<N;i++) {
			StringTokenizer line = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				grid[i][j] = Integer.parseInt(line.nextToken());
			}
		}
		
		int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
		
		// 회전 수
		for(int i=0;i<R;i++) {
			
			// 부분 회전 집합
			for(int j=0;j<Math.min(N, M)/2;j++) {
				
				int r= j;
				int c = j;
				int firstValue = grid[r][c];
				
				int k = 0;
				

				// 각 부분에서 가장 왼쪽 위 좌표부터 오른쪽으로 쭉 이동 하다 배열 범위를 벗어나면 아래로 ... 해서 사각형 테두리를 탐색 
				// 현재 위치에 다음 위치 값을 대입
				// 가장 마지막에 처음 시작값을 대입
				while(k<4) {
					int nr = r + deltas[k][0];
					int nc = c + deltas[k][1];
					
					if(nr >=j && nr < N-j && nc >= j && nc < M-j) {
						grid[r][c] = grid[nr][nc];
						
						r = nr;
						c = nc;
					}
					else {
						k++;
						continue;
					}
				}
				
				grid[j+1][j] = firstValue;
			}
			
			
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
	}

}
