import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CodeTree_Preprocessing1 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int[] L = new int[str.length()-1];
		int[] R = new int[str.length()-1];
		
		for(int i=0;i<str.length()-1;i++) {
			if(i == 0) L[i] = 0;
			else L[i] = L[i-1];
			
			if(str.charAt(i) =='(' && str.charAt(i+1) == '(') {
				L[i]++;
			}
		}
		
		for(int i=str.length()-2;i>=0;i--) {
			if(i==str.length()-2) R[i] = 0;
			else R[i] = R[i+1];
			
			if(str.charAt(i) == ')' && str.charAt(i+1) == ')') {
				R[i]++;
			}
		}
		
		System.out.println(Arrays.toString(L));
		System.out.println(Arrays.toString(R));
		
		int sum = 0;
		for(int i=0;i<str.length()-2;i++) {
			if(sum < L[i]*R[i+1]) sum = L[i]*R[i+1];
		}
		System.out.println(sum);

	}

}
