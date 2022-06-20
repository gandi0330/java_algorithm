import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main_14226 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		bfs(n);
		
	}
	
	public static class Node{
		int n; // 현재 화면의 이모티콘 개수
		int t; // 현재까지 걸린 시간
		int clip; // 현재 클립보드에 복사된 이모티콘 개수 
		
		Node(int n, int t, int clip){
			this.n = n;
			this.t = t;
			this.clip = clip;
		}
	}
	
	public static void bfs(int target) {
		
		int minTime = Integer.MAX_VALUE;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(1,0,0));
		
		boolean[][] visited = new boolean[2001][2001];
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			if(visited[node.n][node.clip]) continue; 
			visited[node.n][node.clip] = true; 
			if(minTime < node.t) continue; 
			
			if(node.n == target) {
				if(node.t < minTime) 
					minTime = node.t;
				continue;
			}
			
			
			if(node.clip > 0 && node.n + node.clip < 2000) q.add(new Node(node.n+node.clip, node.t+1, node.clip));
			if(node.n > 0 && node.n < 2000) {
				q.add(new Node(node.n, node.t+1, node.n));
				q.add(new Node(node.n-1, node.t+1, node.clip));
			}
			
		}
		
		System.out.println(minTime);
	}

}
