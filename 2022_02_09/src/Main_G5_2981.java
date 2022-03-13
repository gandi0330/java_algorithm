import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_G5_2981 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int x = arr[1] - arr[0];
		for(int i=2;i<N;i++) {
			int a = arr[i] - arr[i-1];
			if (a > x) x = gcd(a,x);
			else x = gcd(x,a);
		}
		
		divisor(x);
	}
	
	public static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b,a%b);
	}
	
	public static void divisor(int x) {
		StringBuilder sb = new StringBuilder();
		for(int i=2;i<=x;i++) {
			if(x % i == 0) {
				sb.append(i).append(" ");
			}
		}
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}

}
