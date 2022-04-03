import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206_정현명 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		

		
		int[][] map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		boolean[][][] visited = new boolean[N][M][2];
		int[][] deltas = {{-1,0},{0,1},{0,-1},{1,0}};
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.add(new int[] {0,0,0,1});
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			int r = info[0];
			int c = info[1];
			int chance = info[2];
			int distance = info[3];
			
			if(r == N-1 && c == M-1) {
				System.out.println(distance);
				return;
			}
			
			for(int i=0;i<4;i++) {
				int nextR = r + deltas[i][0];
				int nextC = c + deltas[i][1];
				
				if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) continue;
				if(!visited[nextR][nextC][chance]) {
					if(map[nextR][nextC] == 0) {
						visited[nextR][nextC][chance] = true;
						queue.add(new int[] {nextR,nextC,chance,distance+1});
					}
				}

				if(chance<1 && map[nextR][nextC] == 1 && !visited[nextR][nextC][chance+1]) {
					visited[nextR][nextC][chance+1] = true;
					queue.add(new int[] {nextR,nextC,chance+1,distance+1});
				}
			}
		}
		
		System.out.println(-1);
	}

}
