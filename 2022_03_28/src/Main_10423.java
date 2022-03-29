import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_10423 {
	static int[][] parent;
	static int N,M,K;
	static List<Integer> powers;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		powers = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=K;i++) {
			powers.add(Integer.parseInt(st.nextToken()));
		}
		
		int[][] graph = new int[M+1][3];
		
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[i] = new int[] {u,v,w};
		}
		
		Arrays.sort(graph,(o1,o2)->Integer.compare(o1[2], o2[2]));
		
		parent = new int[N+1][2];
		makeSet();
		
		int cost = 0;
		for(int i=1;i<=M;i++) {
			if(union(graph[i][0],graph[i][1])) {
				cost += graph[i][2];
			}
			
			if(connect()) break;
		}
		
		System.out.println(cost);
		
	}
	
	public static boolean connect() {
		boolean isConnect = true;
		
		List<Integer> powerRoot = new ArrayList<>();
		
		for(int i=0;i<K;i++) {
			powerRoot.add(find(powers.get(i)));
		}
		
		
		for(int i=1;i<=N;i++) {
			if(powerRoot.contains(find(i))) continue;
			isConnect = false;
			break;
		}
		
		return isConnect;
	}
	
	public static void makeSet() {
		for(int i=1;i<=N;i++) {
			if(powers.contains(i))parent[i][1] = 1;
			parent[i][0] = i;
		}
	}
	
	public static boolean union(int a, int b) {
		
		
		a = find(a);
		b = find(b);
		
		if(a!=b && parent[a][1] + parent[b][1] != 2) {
			if(parent[a][1] == 1) {
				parent[b][0] = a;
			}else if(parent[b][1] == 1){
				parent[a][0] = b;
			}else {
				parent[b][0] = a;				
			}
			
			return true;
		}
		return false;
	}
	
	public static int find(int a) {
		if(parent[a][0] == a) return a;
		
		return parent[a][0] = find(parent[a][0]);
	}

}
