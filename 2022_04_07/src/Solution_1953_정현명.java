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
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][M];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
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
				
				String ways1 = searchWay(map[r][c]);
				for(int i=0;i<ways1.length();i++) {
					int nR = r + deltas[ways1.charAt(i)-'0'][0];
					int nC = c + deltas[ways1.charAt(i)-'0'][1];
					
					if(nR<0||nR>=N||nC<0||nC>=M||visited[nR][nC]||map[nR][nC]==0) continue;
					boolean isConnect = false;
					String ways2 = searchWay(map[nR][nC]);
					for(int j=0;j<ways2.length();j++) {
						int nnR = nR + deltas[ways2.charAt(j)-'0'][0];
						int nnC = nC + deltas[ways2.charAt(j)-'0'][1];
						if(nnR<0||nnR>=N||nnC<0||nnC>=M)continue;
						if(nnR == r && nnC == c) {
							isConnect = true;
							break;
						}
						
					}
					
					if(isConnect) {
						visited[nR][nC] = true;
						q.add(new int[] {nR,nC,t+1});						
					}
					
				}
			}
			sb.append("#"+tc+" "+cnt+"\n");
		}
		System.out.print(sb);
	}
	
	static String searchWay(int type) {
		String direction="";
		switch(type) {
		case 1:
			direction="0123";
			break;
		case 2:
			direction="02";
			break;
		case 3:
			direction="13";
			break;
		case 4:
			direction="01";
			break;
		case 5:
			direction="12";
			break;
		case 6:
			direction="23";
			break;
		case 7:
			direction="03";
			break;
		}
		
		return direction;
	}

}
