import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1197 {

	static int parent[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int finalCost = 0;
		
		parent = new int[V+1];
		makeSet();
		
		int graph[][] = new int[E][3];
		
		for(int i = 0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[i] = new int[] {v1,v2,cost};
		}
		
		Arrays.sort(graph, (o1,o2) -> Integer.compare(o1[2],o2[2]));
		
		for(int i=0;i<E;i++) {
			if(union(graph[i][0], graph[i][1])) {
				finalCost += graph[i][2];
			}
		}
		
		System.out.println(finalCost);
		
	}
	
	public static void makeSet() {
		for(int i=1;i<parent.length;i++) {
			parent[i] = i;
		}
	}
	
	public static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) {
			parent[b] = a;
			return true;
		}
		
		return false;
	}
	
	public static int find(int a) {
		if(a == parent[a]) return a;
		
		return parent[a] = find(parent[a]);
	}
	
	

}
