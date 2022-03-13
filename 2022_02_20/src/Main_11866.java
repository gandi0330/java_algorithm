import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11866 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken()); 
		
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=1;i<=n;i++) {
			list.add(i);
		}
		
		int idx = -1;
		int size = list.size();
		
		sb.append("<");
		while(size>0) {
			idx = (idx + k) % size--;
			sb.append(list.remove(idx--)).append(", ");
			
		}
		
		sb.setLength(sb.length()-2);
		sb.append(">");
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		
	}

}
