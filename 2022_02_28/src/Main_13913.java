import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13913 {

	
	static int N,K;
	static int minT;
	static boolean[] answer;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		minT = Integer.MAX_VALUE;
		
		visited = new boolean[100001]; 
		visited[N] = true;
		dfs(N, 0);
		
		StringBuilder sb = new StringBuilder();
		sb.append(minT +"\n");
		for(int i=0;i<=100000;i++) {
			if(answer[i]) sb.append(i + " ");
		}
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
	
	public static void dfs(int node, int time) {
		System.out.println(node);
		if(minT < time) return;
		
		
		if(node == K) {
			if(minT > time) {
				minT = time;
				answer = visited;
				
			}
			return;
		}
		
		if(node-1 >= 0 && !visited[node-1]) {
			visited[node-1] = true;
			dfs(node-1,time+1);
			visited[node-1] = false;
		}
		
		if(node+1 <= 100000 && !visited[node+1]) {
			visited[node+1] = true;
			dfs(node+1, time+1);
			visited[node+1] = false;
		}
		
		if(node*2 <= 100000 && !visited[node*2]) {
			visited[node*2] = true;
			dfs(node *2,time+1);
			visited[node*2] = false;
		}
		
		
		
	}

}
