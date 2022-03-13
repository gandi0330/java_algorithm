import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_정현명 {
	static int N,M;
	static int cnt;
	static int deltas[][] = {{-1,1},{0,1},{1,1}};
	
	public static void main(String[] args) throws IOException{
		// =================== 입력 =====================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 행의 수
		M = Integer.parseInt(st.nextToken()); // 열의 수
		
		cnt = 0; // 파이프라인 최대 설치 수
		
		boolean[][] visited = new boolean[N][M]; // 파이프가 만들어졌거나 건물이 있는지
		
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<M;j++) {
				if(line.charAt(j) == 'x') visited[i][j] = true;
			}
		}
		
		
		// =================== 솔루션 ======================
		
		for(int i=0;i<N;i++) {
			if(dfs(i,0,visited)) cnt++; 
		}
		
		System.out.println(cnt);
		
		
		
		
	}
	
	
	public static boolean dfs(int i, int j, boolean[][] visited) {
		visited[i][j] = true;
		
		if(j == M-1) return true; //도착했을 때는 해당 근처 빵집에서 원웅빵집으로 도달할 수 있는 가장 위쪽의 파이프라인이 만들어짐
	
		// 근처 빵집 중 가장 위부터 차례로 탐색하기 때문에 가장 많은 파이프라인 설치를 위해서는 원웅 빵집의 가장 위부터 연결해야한다
		// 오른쪽 위, 오른쪽,  오른쪽 아래 방향으로 dfs를 진행한다 
		for(int deltaIdx = 0;deltaIdx<3;deltaIdx++) {
			int nextI = i + deltas[deltaIdx][0];
			int nextJ = j + deltas[deltaIdx][1];
			
			if(nextI < 0 || nextI >= N || nextJ < 0 || nextJ >= M || visited[nextI][nextJ] == true) continue;
			if(dfs(nextI,nextJ,visited)) return true;
		}
		
		return false;
	}

}
