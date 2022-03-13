import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2_12015 {

	static int N;
	static int[] arr;
	static int[] answerArr;
	static int size;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		arr = new int[N+1];
		answerArr = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		answerArr[1] = arr[1];
		size = 1;
		
		for(int i=2;i<=N;i++) {
			if(arr[i] > answerArr[size]) {
				answerArr[++size] = arr[i];
			}
			else {
				answerArr[lowerBound(arr[i])] = arr[i];
			}
		}
		
		System.out.println(size);
		
	}
	
	
	public static int lowerBound(int num) {
		int l = 1;
		int r = size;
		int i = 0;
		
		while(l<=r) {
			int mid = (l+r)/2;
			
			if(answerArr[mid] < num) {
				l = mid + 1;
			}
			else {
				i = mid;
				r = mid - 1;
			}
		}
		
		return i;
	}
	

}
