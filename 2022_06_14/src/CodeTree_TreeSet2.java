import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class CodeTree_TreeSet2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		TreeSet<Integer> treeSet = new TreeSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			treeSet.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i=0;i<m;i++){
			int num = Integer.parseInt(br.readLine());
			
			if(treeSet.contains(num)) System.out.println(num);
			else if(treeSet.higher(num) != null) System.out.println(treeSet.higher(num));
			else System.out.println(-1);
		}
	}

}
