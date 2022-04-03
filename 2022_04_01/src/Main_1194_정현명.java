import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_정현명 {
	static int N, M;
	static int nowR, nowC;
	static char map[][];
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	static char[] doors = {'A','B','C','D','E','F'};
	static char[] keys = {'a','b','c','d','e','f'};
	public static void main(String args[])throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		nowR = -1;
		nowC = -1;
		
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == '0') {
					nowR = i;
					nowC = j;
				}
			}
		}
		
		
		bfs();
		
	}
	
	public static void bfs() {
		
		boolean[][][] visited = new boolean[N][M][65];
		
		Queue<Info> queue = new LinkedList<>();
		queue.add(new Info(nowR,nowC, 0, 0));
		
		visited[nowR][nowC][0] = true;
		
		while(!queue.isEmpty()) {
			Info info = queue.poll();
			
			
			if(map[info.r][info.c] == '1') {
				System.out.println(info.cnt);
				return;
			}
			
			for(int i=0;i<4;i++) {
				int nextR = info.r + deltas[i][0];
				int nextC = info.c + deltas[i][1];
				
				// 벽이거나 벗어났거나 이미 방문했으면 중단
				if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= M || map[nextR][nextC] == '#' || visited[nextR][nextC][info.key]) continue;
				
				
				char value = map[nextR][nextC];
				// 열쇠일 때
				for(int j=0;j<6;j++) {
					if(value == keys[j]) {
						Info newInfo = new Info();
						newInfo.key = info.key | (1 << j);
						visited[nextR][nextC][info.key] = true;
						newInfo.cnt = info.cnt+1;
						newInfo.r = nextR;
						newInfo.c = nextC;
						queue.add(newInfo);
						break;
					}
				}
				
				// 문일 때
				for(int j=0;j<6;j++) {
					if(value == doors[j]) {
						
						// 열쇠도 있으면
						if(((info.key & (1<<j)) > 0)) {
							visited[nextR][nextC][info.key] = true;
							Info newInfo = new Info();
							newInfo.cnt = info.cnt+1;
							newInfo.r = nextR;
							newInfo.c = nextC;
							newInfo.key = info.key;
							queue.add(newInfo);
							break;
						}
					}
				}
				
				// 그냥 이동할 수 있을 때
				if(value == '0' || value == '.' || value =='1') {
					visited[nextR][nextC][info.key] = true;
					Info newInfo = new Info();
					newInfo.cnt = info.cnt+1;
					newInfo.r = nextR;
					newInfo.c = nextC;
					newInfo.key = info.key;
					queue.add(newInfo);
				}
				
				
			}
			
			
		}
		
		System.out.println(-1);
	}
	
	
	public static class Info{
		int r;
		int c;
		int key;
		int cnt;
		
		public Info() {};
		public Info(int r, int c, int key, int cnt){
			super();
			this.r = r;
			this.c = c;
			this.key = key;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Info [r=" + r + ", c=" + c + ", key=" + key + ", cnt=" + cnt + "]";
		}
		
		
	}
	
}
