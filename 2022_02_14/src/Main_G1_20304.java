import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_G1_20304 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		int N = Integer.parseInt(br.readLine());
		int M  = Integer.parseInt(br.readLine());
		int passwords[] = new int[M];
		
		String NtoB =Integer.toBinaryString(N); 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 패스워드 배열에 입력받기
		for(int i=0;i<M;i++) {
			passwords[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxSecurity = Integer.MIN_VALUE;
		
		for(int masterPW = 2^(NtoB.length()-1); masterPW <=N; masterPW++) {
			
			int minSubSecurity = Integer.MAX_VALUE; 

			for(int i=0;i<M;i++) {
				minSubSecurity = Math.min(minSubSecurity, Integer.bitCount(masterPW^passwords[i]));
			}
			
			maxSecurity = Math.max(minSubSecurity, maxSecurity);
			
		}
		

		System.out.println(maxSecurity);
	}
	

}
