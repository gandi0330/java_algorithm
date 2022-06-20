import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1032 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] strs = new String[n];
		String answer = "";
		
		for(int i=0;i<n;i++) {
			strs[i] = br.readLine();
		}
		
		for(int i=0;i<strs[0].length();i++) {
			char c = strs[0].charAt(i);
			boolean isSame = true;
			for(int j=1;j<n;j++) {
				if(strs[j].charAt(i) == c) continue;
				isSame = false;
				break;
			}
			if(!isSame) {
				answer+="?";
			}
			else {
				answer+=c;
			}
		}
		System.out.println(answer);
	}

}
