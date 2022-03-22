import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_18808 {
	
	static int N,M,K;
	static int[][] notebook;
	public static void main(String[] args) throws IOException{
		// ============== 입력 =================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N  = Integer.parseInt(st.nextToken()); // 노트북 가로
		M  = Integer.parseInt(st.nextToken()); // 노트북 세로
		K  = Integer.parseInt(st.nextToken()); // 스티커 개수
		
		notebook = new int[N][M];
		
		List<int[][]> stickers = new ArrayList<int[][]>(); // 스티커리스트
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken()); // 스티커 가로
			int C = Integer.parseInt(st.nextToken()); // 스티커 세로
			
			int[][] sticker = new int[R][C]; 
			
			for(int r=0;r<R;r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0;c<C;c++) {
					sticker[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			if(isSticker(sticker)) stickers.add(sticker);
		}
		
		// ============== 솔루션 ==================
		
		for(int i=0;i<K;i++) {
			int[][] sticker = stickers.get(i);
			// 0, 90, 180, 270도 검사 
			for(int j=0;j<4;j++) {
				if(!attach(sticker)) { // 못붙였으면 회전
					sticker = rotate(sticker);
				}
				else { // 붙였으면 다음 스티커로 넘어감
					break;
				}
			}
		}
		
		int cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(notebook[i][j] == 1) cnt++; 
			}
		}
		
		System.out.println(cnt);
	}
	
	public static int[][] rotate(int[][] sticker) {
		int temp[][] = new int[sticker[0].length][sticker.length];
		
		for(int i=0;i<sticker[0].length;i++) {
			for(int j=0;j<sticker.length;j++) {
				temp[i][j] = sticker[sticker.length-j-1][i];
			}
		}
		
		
		return temp;
	}
	
	public static boolean isSticker(int[][] sticker) {
		
		// 가로 검사
		loop :for(int i=0;i<sticker.length;i++) {
			for(int j=0;j<sticker[0].length;j++) {
				if(sticker[i][j] == 1) continue loop;
			}
			// 여기로 오면 행 전체가 0인 것
			return false;
		}
		
		// 세로 검사
		loop : for(int j=0;j<sticker[0].length;j++) {
			for(int i=0;i<sticker.length;i++) {
				if(sticker[i][j] == 1) continue loop;
			}
			// 여기로 오면 열 전체가 0인 것
			return false;
		}
		
		// 연결 검사
		int cnt = 0;
		visited = new boolean[sticker.length][sticker[0].length];
		for(int i=0;i<sticker.length;i++) {
			for(int j=0;j<sticker[0].length;j++) {
				if(sticker[i][j] == 1 && visited[i][j] == false) {
					cnt++;
					dfs(i,j, sticker.length, sticker[0].length);
				}
			}
		}
		
		if(cnt != 1) return false;
		
		return true;
		
	}
	
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	static boolean[][] visited;
	public static void dfs(int i, int j, int r, int c) {
		visited[i][j] = true;
		
		for(int idx = 0;idx <4; idx ++) {
			int nextI = i + deltas[idx][0];
			int nextJ = j + deltas[idx][1];
			
			if(nextI < 0 || nextI >= r || nextJ < 0 || nextJ >= c || visited[nextI][nextJ]) continue;
			dfs(nextI,nextJ,r,c);
		}
	}
	
	
	public static boolean attach(int[][] sticker) {
		
		if(sticker.length > N || sticker[0].length > M) {
			return false;
		}
		
		for(int i=0;i<=N-sticker.length;i++) {
			loop : for(int j=0;j<=M-sticker[0].length;j++) {
				
				for(int r=0;r<sticker.length;r++) {
					for(int c=0;c<sticker[0].length;c++) {
						if(sticker[r][c] == 1) {
							if(notebook[i+r][j+c] == 1) continue loop;
						}
					}
				}
				
				// 여기까지 오면 스티커를 붙일 수 있는 상태
				
				for(int r=0;r<sticker.length;r++) {
					for(int c=0;c<sticker[0].length;c++) {
						if(sticker[r][c] == 1) {
							notebook[i+r][j+c] = 1;
						}
					}
				}
				return true;
				
			}
		}
		return false;
	}

}
