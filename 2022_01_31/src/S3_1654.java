import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_1654 {

	static int k;
	static int n;
	static long[] lanArr;
	static long maxValue=0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		lanArr = new long[k];
		
		for(int i=0;i<k;i++) {
			lanArr[i] = Integer.parseInt(br.readLine());
			maxValue = Math.max(maxValue, lanArr[i]);
		}
		
		System.out.println(search());
		
		
		
	}
	
	public static long search() {
		long l = 0;
		long r = maxValue+1;
		long mid = 0;
		
		while(l < r) {
			
			mid = (l+r)/2;
			
			int makeN = 0;
			for(long value : lanArr) {
				makeN += value / mid;
			}
			if(makeN >= n) {
				l = mid + 1;
				
			}
			else if(makeN < n) {
				r = mid;
			}
			
		}
		return l -1;
		
	}

}
