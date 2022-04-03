import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3124_정현명 {

	static int[] parent;
	static int V,E;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			parent = new int[V+1];
			makeSet();
			
			int[][] lines = new int[E][3];
			
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				
				lines[i] = new int[] {v1,v2,cost};
			}
			
			Arrays.sort(lines,(o1,o2)-> Integer.compare(o1[2], o2[2]));
			
			long finalCost = 0;
			
			for(int i=0;i<E;i++) {
				if(union(lines[i][0],lines[i][1])) {
					finalCost+= lines[i][2];
				}
			}
			
			sb.append("#"+tc+" "+finalCost+"\n");
		}
		
		System.out.print(sb);
	}
	
	
	public static void makeSet() {
		for(int i=0;i<V;i++) {
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
		if(parent[a] == a)return a;
		
		return parent[a] = find(parent[a]);
	}
}
