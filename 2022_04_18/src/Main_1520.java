	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;
	
	public class Main_1520 {
	
		static int N,M;
		static int[][] map;
		static boolean[][] visited;
		static int cntPath;
		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = null;
			
			// 테스트 시작
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 행
			M = Integer.parseInt(st.nextToken()); // 열
			
			// 산의 지형 2차원 배열 초기화 및 입력
			map = new int[N][M]; 
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 산의 지형 2차원 배열의 방문기록 초기화
			visited = new boolean[N][M];
			visited[0][0] = true;
			
			// 시작점에서 끝점까지의 경로 수 
			cntPath = 0;
			
			// dfs로 모든 경로 탐색
			dfs(0,0);
			
			// 출력
			sb.append(cntPath);
			
			System.out.print(sb);
		}
		
		static int[] dr = {-1,0,1,0};
		static int[] dc = {0,1,0,-1};
		public static void dfs(int r, int c) {
			
			// 가장 오른쪽 아래 칸에 도달 시 경로 추가
			if(r == N-1 &&  c == M-1) {
				cntPath++;
				return;
			}
			
			// 사방탐색하여 내리막길인 경우 이동
			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				// 맵을 벗어났거나, 이미 방문했거나, 평지 또는 오르막길인 경우 탐색 중단
				if(nr<0||nr>=N||nc<0||nc>=M||visited[nr][nc]||map[r][c] <= map[nr][nc]) continue;
				
				visited[nr][nc] = true; // 방문 처리
				dfs(nr,nc); // 다음 지형으로 이동
				visited[nr][nc] = false; // 서로의 경로가 방문처리에 영향이 없도록 다시 false로 초기화
			}
		}
		
		
	
	}
