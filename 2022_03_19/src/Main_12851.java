import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12851 {

	static int N,M;
	static int time;
	static int cnt;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		time = 100001;
		cnt = 0;
		visited = new boolean[100001];
		bfs();
		
		System.out.println(time);
		System.out.println(cnt);
		
	}
	
	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {N,0});
		
		while(!q.isEmpty()) {
			
			int[] now = q.poll();
			visited[now[0]] = true;
			if(time < now[1]) break;
			if(now[0] == M) {
				if(time != now[1]) time = now[1];
				cnt++;
			}
			
			if(now[0]-1 >=0 && !visited[now[0]-1]) q.add(new int[] {now[0]-1,now[1]+1});
			if(now[0]*2 <= 100000 && !visited[now[0]*2]) q.add(new int[] {now[0]*2,now[1]+1});
			if(now[0]+1 <= 100000 && !visited[now[0]+1]) q.add(new int[] {now[0]+1,now[1]+1});
		
		}
		
	}

}
