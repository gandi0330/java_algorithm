import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1158_정현명 {

	public static void main(String[] args) throws IOException{
		// --------------- input --------------------
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
		
		for(int i=1;i<=n;i++) {
			list.add(i);
		}
		
		int idx = -1; // list's idx
		
		// --------------- solution -----------------
		
		sb.append("<");
		while(!list.isEmpty()) {
			idx = (idx + k) % list.size();
			sb.append(list.get(idx)).append(", ");
			list.remove(idx--);
		}
		
		sb.setLength(sb.length()-2); // remove last ", "
		sb.append(">");
		
		System.out.println(sb);
	}

}
