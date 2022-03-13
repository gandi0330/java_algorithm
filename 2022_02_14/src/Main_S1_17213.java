import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;

public class Main_S1_17213 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		
		
		long up = 1;
		long down = 1;
		for(int i = M-N+1;i<=M-1;i++) {
			up *= i;
		}
		
		for(int i=1; i<=N-1;i++) {
			down*= i;
		}
		
		System.out.println(up/down);
		
		
	}
	
	
	
	

}
