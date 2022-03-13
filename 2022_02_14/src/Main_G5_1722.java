import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_1722 {
	static int [] arr;
	static int N;
	static int cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int [N];
		
		for(int i=1;i<=N;i++) {
			arr[i-1] = i;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int type = Integer.parseInt(st.nextToken());
		
		if(type == 1) {
			int seq = Integer.parseInt(st.nextToken());
			cnt = 1;
			do {
				if(cnt == seq) {
					for(int i=0;i<N;i++) {
						sb.append(arr[i] + " ");
					}
					sb.setLength(sb.length()-1);
					System.out.println(sb);
					break;
				}
			}while(np());
		}
		else {
			int numbers[] = new int[N];
			for(int i=0;i<N;i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			cnt = 1;
			do {
				boolean isSame = true;
				for(int i=0;i<N;i++) {
					if(numbers[i] != arr[i]) {
						isSame= false;
						break;
					}
				}
				if(isSame) {
					System.out.println(cnt);
					break;
				}
				
			}while(np());
		}
		
	}
	
	public static boolean np() {
		// 1. 뒤에서부터 꼭대기 값을 찾음 ( 인덱스가 0일 때 가장 마지막 순열이 되므로 return)
		// 2. 또 뒤에서부터 꼭대기 바로 전보다 큰 값을 찾음
		// 3. 스왑함
		// 4. 스왑한 자리 뒤로 정렬함
		int i = N-1;
		while(i>0 && arr[i] < arr[i-1]) i--;
		if(i==0) return false;
		
		int j = N-1;
		while(arr[i-1] > arr[j]) j--;
		swap(i-1,j);
		
		int k = N-1;
		while(i<k) {
			swap(i++,k--);
		}
		cnt++;
		return true;
	}
	
	public static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
