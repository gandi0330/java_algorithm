import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3036 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int nums[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int firstRing = nums[0];
		for(int i=1;i<N;i++) {
			int gcd = euclid(firstRing,nums[i]);
			
			System.out.println(firstRing/gcd+"/"+nums[i]/gcd);
		}
		
	}
	
	
	
	public static int euclid(int a, int b) {
		
		if(b ==0)return a;
		return euclid(b,a%b);
	}
	

}
