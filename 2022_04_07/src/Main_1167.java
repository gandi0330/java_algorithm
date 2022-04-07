import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1167 {

	static class Node{
		int target;
		int cost;
		
		Node(int target, int cost){
			this.target = target;
			this.cost = cost;
		}
	}
	static int max;
	static List<List<Node>> edge;
	static boolean visited[];
	static int maxNode;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		edge = new ArrayList<>();
		for(int i=0;i<n;i++) {
			edge.add(new ArrayList<>());
		}
		
		StringTokenizer st = null;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken())-1;
			
			while(true){
				int v2 = Integer.parseInt(st.nextToken());
				
				if(v2 == -1) break;
				int cost = Integer.parseInt(st.nextToken());
				edge.get(v1).add(new Node(v2-1,cost));
			}
		}
		max = 0;
		visited = new boolean[n];
		dfs(0,0);
		
		max = 0;
		visited = new boolean[n];
		dfs(maxNode,0);
		System.out.println(max);
		
	}
	
	public static void dfs(int now, int costSum) {
		visited[now] = true;
		
		for(Node node : edge.get(now)) {
			if(!visited[node.target]) {
				dfs(node.target,costSum+node.cost);
			}
		}
		
		if(max < costSum) {
			max = costSum;
			maxNode = now;
		}
	}

}