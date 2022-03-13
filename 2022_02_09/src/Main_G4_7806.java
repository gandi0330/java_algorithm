import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_7806 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		loop : while((str = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(str);
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int answer = 1;
			
			for(int i=n;i>=1;i--) {
				if(gcd(i,k) > 1) {
					answer *= i;
					k/= i;
				}
			}
			System.out.println(answer);
		}
	}
	
	public static int gcd(int a, int b) {
		if(a>=b) return b == 0 ? b : gcd(b,a%b);
		else return a == 0 ? a : gcd(a, b%a);
	}

}
