
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2309_정현명 {

	
	static int[] numbers = new int[7];
	static int[] arr;
	static boolean isbreak = false;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[9];
		for(int i=0;i<9;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		combination(0,0,0);
		
	}
	
	public static void combination(int cnt, int start, int sum) {
		
		if(isbreak) return;
		
		if(cnt == 7) {
			if(sum == 100) {
				isbreak = true;
				for(int i=0;i<7;i++) {
					System.out.println(numbers[i]);
				}
			}
			return;
		}
		
		for(int i=start;i<9;i++) {
				numbers[cnt] = arr[i];
				combination(cnt+1, i+1, sum+arr[i]);
			
		}
	}
}
