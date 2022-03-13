import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3040_정현명 {
	static int numbers[];
	static int arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[9];
		for(int i=0;i<9;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		numbers = new int[7];
		
		combination(0,0,0,0);
	}
	
	public static void combination(int start,int flag, int cnt, int sum) {
		if(cnt == 7) {
			if(sum == 100) {
				for(int i=0;i<7;i++) {
					System.out.println(numbers[i]);
				}
			}
			return;
		}
		
		for(int i=start;i<9;i++) {
			if((flag & 1<<i) != 0) continue;
			numbers[cnt] = arr[i];
			combination(i+1,flag|1<<i, cnt+1,sum+arr[i]);
		}
	}
}
