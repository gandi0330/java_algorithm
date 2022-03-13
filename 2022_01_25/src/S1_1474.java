import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;

public class S1_1474 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<String> strList = new ArrayList<>();
		int lenSum = 0;
		int common_ = 0;
		int special_ = 0;
		
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			lenSum += str.length();
			strList.add(str);
		}
		
		common_ = (m - lenSum) / (strList.size() - 1);
		special_ = (m - lenSum) % (strList.size() -1);
		
		String answer = strList.get(0);
		
		for(int i=1;i<n;i++) {
			
			String nowStr = strList.get(i);
			
			String underBar = "";
			for(int j=0;j<common_;j++) {
				underBar += "_";
			}
			
			if(nowStr.charAt(0) >'_' && special_>0 ) {
				answer += "_";
				special_--;
			}
			else if(n-i <=special_ && special_>0) {
				answer += "_";
				special_--;
			}
			
			
			
			answer += underBar + nowStr;
			
		}
		
		System.out.println(answer);
		
	}

}
