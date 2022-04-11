import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_정현명 {
	/*
	 * bfs로 특정 시간 이하 (L 이하)의 시간을 가진 노드를 센다.
	 * 현재 위치에서 이동하려면 현재의 파이프와 이동할 파이프가 연결되어있는지 확인해야 한다.
	 * 때문에 a에서 b로 연결되있다면 b에서 다시 a로 갈 수 있는 지 확인하고 양 파이프가 연결되었다면 그 때 이동한다. 
	 * 
	 */
	
	static int[][] deltas ={{-1,0},{0,-1},{0,1},{1,0}};
	static int N,M,R,C,L;
	static int[][] map;
	static String[] dir = {null,"0312","03","12","02","23","13","01"};
	static int bfs() {
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {R,C,1});
		visited[R][C] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int r = info[0];
			int c = info[1];
			int t = info[2];
			
			if(t > L) continue;
			cnt++;
			
			String ways = dir[map[r][c]];
			for(int i=0;i<ways.length();i++) {
				int d = ways.charAt(i) - '0';
				int nR = r + deltas[d][0];
				int nC = c + deltas[d][1];
				
				if(nR<0||nR>=N||nC<0||nC>=M||visited[nR][nC]||map[nR][nC]==0) continue;
				
				if(dir[map[nR][nC]].contains(Integer.toString(3-d))) {
					visited[nR][nC] = true;
					q.add(new int[] {nR,nC,t+1});	
				};
				
			}
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("#"+tc+" "+bfs()+"\n");
		}
		System.out.print(sb);
	}
	


}
