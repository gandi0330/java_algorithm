import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_S2_11725 {
	
	
	static int parent [];
	static boolean visited[];
	static List<ArrayList<Integer>> list;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		 list = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<=n;i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<n-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			list.get(v1).add(v2);
			list.get(v2).add(v1);
		}
		
		parent = new int[n+1];
		visited = new boolean[n+1];
		dfs(1);
		
		for(int i=2;i<=n;i++) {
			System.out.println(parent[i]);
		}
	}
	
	public static void dfs(int node) {
		visited[node] = true;
		List<Integer> subList = list.get(node);
		if(subList.size() == 0) {
			return;
		}
		
		for(int i=0;i<subList.size();i++) {
			int nextNode = (int)subList.get(i);
			if(visited[nextNode]) {
				parent[node] = nextNode;
			}
			else {
				dfs(nextNode);
			}
		}
	}
	
	
	
	

	
	
}
