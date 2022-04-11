import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607_정현명 {

	static final long P = 1234567891;
	public static void main(String[] args) throws IOException{
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			sb.append("#"+tc+" "+nCr(N,R)+"\n");
		}
		System.out.print(sb);
	}
	
	public static long nCr(int N, int R) {
		
		if(R == 0) return 1;
		if(R == 1) return N;
		
		// 팩토리얼 바텀업
		long fac[] = new long[N+1];
		fac[0] = 1;
		for(int i=1;i<=N;i++) {
			fac[i] = fac[i-1] * i % P;
		}
		
		// 분모 r!(n-r)! % p 를 페르마 소정리로 r!(n-r)! ^ (p-2)로 바꿈 
		// 이유는 r! * (n-r)! 가 long의 최대 범위를 벗어날 수 있기 때문에 
		long bottom	= pow(fac[R],P-2) * pow(fac[N-R],P-2) % P;
		
		return fac[N] * bottom % P;
		
	}
	
	// 분할 정복 a의 b승
	public static long pow(long a, long b) {
		if(b == 1) {
			return a;
		}
		long tmp = pow(a, b/2);
		if(b%2 == 1) return tmp*tmp%P*a%P;
		return tmp*tmp%P;
	}

}
