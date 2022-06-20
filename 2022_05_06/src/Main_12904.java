import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_12904 {

	
	public static int go(String S, String T) {
		while(T.length()>=S.length()) {
			if(T.equals(S)) {
				return 1;
			}
			else if(T.charAt(T.length()-1) == 'A') {
				T = T.substring(0,T.length()-1);
			}else if(T.charAt(T.length()-1) == 'B') {
				T = new StringBuilder(T.substring(0,T.length()-1)).reverse().toString();
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		
		System.out.println(go(S,T));
		
	}
	
	

}
