import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main_1302 {

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Map<String,Integer> map = new HashMap<>();
		
		int maxSell = 1;
		for(int i=0;i<n;i++) {
			String title = br.readLine();
			if(map.containsKey(title)) {
				int plusSellCnt = map.get(title)+1;
				map.put(title,plusSellCnt);
				if(maxSell < plusSellCnt) maxSell = plusSellCnt;
			}else {
				map.put(title, 1);
			}
		}
		
		Object[] titles = map.keySet().toArray();
		
		Arrays.sort(titles);
		
		for(Object title : titles) {
			if(map.get((String)title) == maxSell) {
				System.out.println(title);
				break;
			}
		}
	}
}
