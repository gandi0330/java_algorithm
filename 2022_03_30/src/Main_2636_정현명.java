import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2636_정현명 {

	static int r,c;
	static boolean[][] map;
	static int preCheezeCnt;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	static int time;
	static boolean visited[][];
	static List<int[]> edgeCheeze;
	public static void main(String[] args) throws IOException{
		// ==================== 입력 ========================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new boolean[r][c];
		preCheezeCnt = 0;
		
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<c;j++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					map[i][j] = true;
					preCheezeCnt++;
				}
			}
		}
		
		time = 0;
		
		// =================== 솔루션 ==========================
		// 치즈가 모두 녹기 전까지 반복
		while(true) {
			visited = new boolean[r][c];
			edgeCheeze = new ArrayList<>();
			time++;
			dfs(0,0); // 치즈 외부의 공기는 모두 이어져 있으므로 가장자리에서 dfs를 한번만 실행
			if(preCheezeCnt == edgeCheeze.size()) break; // 치즈가 모두 녹기 직전이면 멈춤
			else { // 치즈가 모두 녹기 직전이 아니면 가장 자리 치즈를 녹이고 다시 반복
				for(int i=0;i<edgeCheeze.size();i++) {
					int[] cheeze = edgeCheeze.get(i);
					map[cheeze[0]][cheeze[1]] = false;
				}
				preCheezeCnt -= edgeCheeze.size();
			}
		}
		
		System.out.println(time);
		System.out.println(preCheezeCnt);
		
		
	}
	
	// 사방탐색하여 치즈를 만나면 가장자리 치즈 리스트에 넣기
	public static void dfs(int i,int j) {
		
		for(int k=0;k<4;k++) {
			int nextR = i + deltas[k][0];
			int nextC = j + deltas[k][1];
			
			if(nextR <0 || nextR >= r || nextC < 0 || nextC >= c || visited[nextR][nextC]) continue;
			visited[nextR][nextC] = true;
			if(map[nextR][nextC]) {
				edgeCheeze.add(new int[] {nextR,nextC});
			}
			else {
				dfs(nextR,nextC);
			}
		}
	}
}
