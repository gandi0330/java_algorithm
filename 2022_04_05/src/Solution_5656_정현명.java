import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5656_정현명 {
	
	static int deltas[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	static int map[][];
	static int N,W,H;
	static int numbers[];
	static int minBrick;
	static int[][] subMap;
	public static void main(String[] args) throws IOException{
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++){
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			map = new int[H][W];
			
			for(int i=0;i<H;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			numbers = new int[N];
			minBrick = Integer.MAX_VALUE;
			permuRep(0);
			
			sb.append("#"+tc+" "+minBrick+"\n");
		}
		System.out.println(sb);
	}
	
	// 중복순열로 n번째 구슬의 열 정하기
	public static void permuRep(int cnt) {
		
		if(cnt == N) {
			// 이미 벽돌이 다 깨져있으면 실행 x
			if(minBrick!=0) attack(numbers.clone());
			return;
		}
		
		for(int i=0;i<W;i++) {
			numbers[cnt] = i;
			permuRep(cnt+1);
		}
	}
	
	// 벽돌 깨기 시작
	public static void attack(int order[]) {
		// 맵 복사
		subMap = new int[H][W];
		for(int i=0;i<H;i++) {
			subMap[i] = map[i].clone();
		}
		// n번 구슬을 친다
		for(int i=0;i<order.length;i++) {
			int r = 0;
			while(r<H) { // 제일 윗 행에서부터 처음으로 벽돌을 찾을때 까지 반복
				if(subMap[r][order[i]] != 0) { // 가장 처음 벽돌을 찾으면 erase 실행
					erase(r,order[i]);
					break;				
				}
				r++;
			}
			dropBrick(); // 삭제되어 중간중간 비어있는 벽돌들을 아래로 떨어뜨림
		}
		
		int cnt =0;
	
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(subMap[i][j] != 0) cnt++;
			}
		}
		
		minBrick = minBrick > cnt ? cnt : minBrick;
	}
	
	
	public static void erase(int r, int c) {
		int size = subMap[r][c]; // 벽돌 숫자
		subMap[r][c] = 0; // 현재 벽돌을 제거
		// 네 방향으로 
		for(int i=0;i<4;i++) {
			// 벽돌 숫자 크기만큼
			for(int j=1;j<size;j++) {
				int nextR = r + j*deltas[i][0];
				int nextC = c + j*deltas[i][1];
				
				if(nextR>=0 && nextR < H && nextC >= 0 && nextC< W) {
					if(subMap[nextR][nextC] != 0) { // 또 다른 벽돌을 만나면
						erase(nextR,nextC); // erase 실행
					}
				}
			}
			
		}
	}
	
	
	public static void dropBrick() {
		for(int i=0;i<W;i++) { // 각 열에 대해
			int idx = H-1; // 아래서부터 채워나갈 인덱스  
			for(int j=H-1;j>=0;j--) {
				if(subMap[j][i] != 0) { // 현재 탐색한 높이에 벽돌이 있다면
					if(j == idx) { // idx와 현재 탐색한 높이가 같으면 패스
						idx--;
						continue;
					}
					// idx와 현재 탐색한 높이가 다르면 idx높이에 현재 벽돌을 옮기고, 벽돌을 제거
					subMap[idx][i] = subMap[j][i];
					subMap[j][i] = 0;
					idx--;
							
				}
			}
		}
	}

}
