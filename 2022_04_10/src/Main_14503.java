import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503 {

	
	public static class Robo{
		int r;
		int c;
		int dir;
		
		Robo(int r, int c, int dir){
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
	
	static int N,M;
	static int[][] map;
	static Robo robo;
	static boolean[][] visited;
	static int cnt;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		robo = new Robo(r,c,dir);
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N][M];
		cnt = 0;
		go();
		System.out.println(cnt);
	}
	
	public static void go() {
		
		
		//청소하지 않은 경우
		if(!visited[robo.r][robo.c]) {
			cnt++;
			visited[robo.r][robo.c] = true; 
		}
		
		//방향 탐색
		for(int i=3;i>=0;i--) {
			int dir = (robo.dir + i)%4;
			int nextR = robo.r+dr[dir];
			int nextC = robo.c+dc[dir];
//			System.out.println("r :" + robo.r + " c : " +robo.c + " dir : " +robo.dir);
//			System.out.println("nr :" + nextR + " nc : " +nextC + " ndir : " +dir);
			
			// 청소한 곳이거나 벽이면 패스
			if(visited[nextR][nextC] || map[nextR][nextC] == 1) continue;
//			System.out.println("pass");
			// 청소하지 않은 빈 공간 발견
			robo.r = nextR;
			robo.c = nextC;
			robo.dir = dir;
			
			go();
			return;
		}
		
		// 네 방향 모두 청소했거나 벽일 경우
		// 바로 뒤쪽이 벽인 경우 종료
		int nextR = robo.r-dr[robo.dir];
		int nextC = robo.c-dc[robo.dir];
		if(map[nextR][nextC] == 1) return;
		// 벽이 아닌 경우 후진
		robo.r = nextR;
		robo.c = nextC;
		go();
	}

}