import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17471_정현명 {

	static boolean[] isRed; // 빨간 구역 = true, 파란 구역 = false
	static int N; // 구역 수
	static int[] people; // 각 구역의 인구 수
	static boolean[][] isConnect; // 구역 연결 인접 행렬
	static int min; // 인구 차이 최솟값
	public static void main(String[] args) throws IOException{
		// ------------ 입력 ---------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		people = new int[N+1];
		isConnect = new boolean[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int adj = Integer.parseInt(st.nextToken());
			
			for(int j=0;j<adj;j++) {
				int v = Integer.parseInt(st.nextToken());
				isConnect[i][v] = true;
				isConnect[v][i] = true;
			}
		}
		// ------------------------------
		min = Integer.MAX_VALUE; // 최솟값 초기화
		
		isRed = new boolean[N+1]; // 부분집합 초기화
		
		subSet(1);
		
		if(min == Integer.MAX_VALUE) { // 두 선거구로 나눌 방법이 없을 경우
			System.out.println(-1);
		}else {
			System.out.println(min);			
		}
	}
	
	public static void subSet(int cnt) {
		if(cnt > N) {
			if(check()) {
				int red = 0;
				int blue = 0;
				for(int i=1;i<=N;i++) {
					if(isRed[i]) red +=people[i];
					else blue += people[i];
				}
				
				min = Math.min(Math.abs(red-blue), min);
			}
			
			return;
		}
		
		isRed[cnt] = true;
		subSet(cnt+1);
		isRed[cnt] = false;
		subSet(cnt+1);
	}
	
	static boolean[] visited;
	public static boolean check() {
		// dfs로 같은색을 한번에 탐색하기 때문에 첫 dfs 실행 수가 구역 수를 뜻한다
		visited = new boolean[N+1];
		int section = 0;
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				dfs(i);
				section++;
			}
		}
		
		if(section == 2) { // 구역이 2 개로 나눠졌다면
			return true;
		}
		return false;
	}
	
	public static void dfs(int node) {
		visited[node] = true;
		
		for(int i=1;i<=N;i++) {
			if(!visited[i] && isConnect[node][i] && isRed[node] == isRed[i]) dfs(i);
		}
	}

}
