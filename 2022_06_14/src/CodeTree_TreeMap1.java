import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.TreeMap;

public class CodeTree_TreeMap1 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		TreeMap<String, Integer> treeMap = new TreeMap<>();
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			treeMap.put(str, treeMap.getOrDefault(str, 0)+1);
		}
		
		for(Entry<String, Integer> entry : treeMap.entrySet()) {
			System.out.print(entry.getKey()+" ");
			System.out.printf("%.4f\n",(double)entry.getValue()/n*100);
		}
		
	}

}
