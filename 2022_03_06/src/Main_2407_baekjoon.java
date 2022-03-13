import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main_2407_baekjoon {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
			
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		System.out.println(multipleAtoB(n,n-m+1).divide(multipleAtoB(m,1)));
		
	}

	
	public static BigDecimal multipleAtoB(int a, int b) {
		
		BigDecimal answer = new BigDecimal("1");
		
		for(int i=a;i>=b;i--) {
			answer = answer.multiply(new BigDecimal(i)); 
		}
		
		return answer;
	}
}
