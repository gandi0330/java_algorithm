import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_CodeTree_plus1minus1Tech {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		TreeMap<Integer, Integer> map = new TreeMap<>();
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			map.put(Integer.parseInt(st.nextToken()),1);
			map.put(Integer.parseInt(st.nextToken()),-1);
		}
		
		int sum = 0;
		int max = 0;
		for(int key : map.keySet()) {
			sum+= map.get(key);
			if(max < sum) max = sum;
		}
		
		System.out.println(max);
		
		
	}

}
