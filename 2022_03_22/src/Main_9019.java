import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9019 {

	static char[] chars = {'D','S','L','R'};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			bfs(A,B);
		}
	}
	
	public static void bfs(int start, int target) {
		
		
		int parent[] = new int[10000];
		Arrays.fill(parent, -1);
		char commands[] = new char[10000];
		
		Queue<Integer> que = new LinkedList<>();
		que.add(start);
		
		while(!que.isEmpty()) {
			
			int now = que.poll();
			
			if(parent[target] != -1) { // target에 도달한 적이 있으면 탈출 
				break;
			}
			
			for(int i=0;i<4;i++) {
				int res = cal(now, i);
				if(parent[res] == -1) {
					parent[res] = now;
					commands[res] = chars[i];
					que.add(res);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(target != start) {
			sb.append(commands[target]);
			target = parent[target];
		}
		
		sb = sb.reverse();
		System.out.println(sb);
		
	}
	
	public static int cal(int n, int command) {
		
		int res = 0;
		
		switch(command) {
		case 0:
			res = n*2 % 10000;
			break;
		case 1:
			res = n == 0? 9999 : n-1;
			break;
		case 2:
			res = (n / 1000) + (n % 1000) * 10;
			break;
		case 3:
			res = (n / 10) + (n % 10 * 1000);
			break;
		}
		
		return res;
	}
}
