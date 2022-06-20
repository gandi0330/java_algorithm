import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_ {

	public static void main(String[] args) throws IOException{
		int[] arr = {1,5,4,2,9,7};
		
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		for(int i=a;i<=b;i++) {
			arr[i] = (arr[i]*7+15)%7;
		}
		
		System.out.println(Arrays.toString(arr));
	}

}
