import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_19542 {

	static int N,S,D;
	static List<List<Integer>> edgeList;
	static int depth[];
	static int cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		edgeList = new ArrayList<>(); 
		for(int i=0;i<=N;i++) {
			edgeList.add(new ArrayList<>());
		}
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			edgeList.get(x).add(y);
			edgeList.get(y).add(x);
		}
		cnt = 0;
		depth = new int[N+1];
		dfs(S,-1);
		
		System.out.println(cnt*2);
		
	}
	
	public static int dfs(int node, int preNode) {
		for(int nextNode : edgeList.get(node)) {
			if(nextNode != preNode) {
				depth[node] = Math.max(depth[node], dfs(nextNode,node)+1);
			}
		}
		
		
		if(node!=S && depth[node] >= D) {
			cnt++;
		}
		
		return depth[node];
	}

}
