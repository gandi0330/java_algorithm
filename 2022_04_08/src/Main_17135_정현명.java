import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17135_정현명 {

	static int N,M,D;
	static int[][] map;
	static int[] numbers;
	static int enemyCnt;
	static int maxKillCnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		enemyCnt = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) enemyCnt++;
			}
		}
		
		numbers = new int[3];
		maxKillCnt = 0;
		combi(0,0);
		
		System.out.println(maxKillCnt);
	}
	
	static void combi(int cnt, int start) {
		if(cnt == 3) {
			// 궁수 배치 완료
			go();
			return;
		}
		
		for(int i=start;i<M;i++) {
			numbers[cnt] = i;
			combi(cnt+1,i+1);
		}
	}
	
	// 시뮬레이션
	static void go() {
		int killCnt = 0;
		int[][] archers = {{N,numbers[0]},{N,numbers[1]},{N,numbers[2]}};
		int tempEnemyCnt = enemyCnt;
		
		// 맵 복사
		int[][] tempMap = new int[N][M];
		for(int i=0;i<N;i++) {
			tempMap[i] = map[i].clone();
		}
		
		// 맵에 적이 없으면 끝
		while(tempEnemyCnt>0) {
			
			// 궁수가 공격할 적 선택
			List<int[]> selectEnemys = new ArrayList<>();
			for(int i=0;i<3;i++) {
				int[] enemyInfo = {-1,-1, 11};
				
				int[] archer = archers[i];
				for(int r=0;r<N;r++) {
					for(int c=0;c<M;c++) {
						if(tempMap[r][c] == 1) { //r행 c열이 적일 때
							int d = Math.abs(r-archer[0]) + Math.abs(c-archer[1]);
							if(d <= D) { // i번째 궁수의 사정거리 안이라면
								// 이전 적보다 더 궁수에 가깝거나, 거리가 같고 더 왼쪽에 있을 경우 갱신
								if(d < enemyInfo[2] || (d == enemyInfo[2] && c < enemyInfo[1])) { 
									enemyInfo[0] = r;
									enemyInfo[1] = c;
									enemyInfo[2] = d;
								}
							}
						}
					}
				}
				
				if(enemyInfo[0] != -1) selectEnemys.add(new int[] {enemyInfo[0],enemyInfo[1]});
			}
			
			// 궁수 동시 공격
			for(int[] enemyInfo : selectEnemys) {
				// 이전 궁수가 해당 적을 죽였다면
				if(tempMap[enemyInfo[0]][enemyInfo[1]] == 0) continue;
				
				killCnt++;
				tempEnemyCnt--;
				tempMap[enemyInfo[0]][enemyInfo[1]] = 0;
			}

			
			// 적 아래로 한칸 이동
			for(int i=N-1;i>=0;i--) {
				for(int j=M-1;j>=0;j--) {
					// 적이 맨 아래에 있으면 격자판의 적 수를 줄임
					if(i == N-1 && tempMap[i][j] == 1) {
						tempEnemyCnt--; 
					}

					if(i == 0) tempMap[i][j] = 0;
					else tempMap[i][j] = tempMap[i-1][j];
					
				}
			}
		}
		
		maxKillCnt = Math.max(maxKillCnt, killCnt);
	}

}
