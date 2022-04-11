import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14003 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		int[] LIS = new int[N];
		int[] rec = new int[N];
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken()); 
		
		
		int size = 0;
		
        for (int i=0; i < N; i++) {
        	
            int temp = Arrays.binarySearch(LIS, 0, size, arr[i]);
            if(temp < 0) temp = Math.abs(temp)-1;
            rec[i] = temp;
            LIS[temp] = arr[i];

            if (size == temp) {
                size++;
            }
        }
        
        int answer[] = new int[size];
        int answerIdx = size-1;
        for(int i=N-1;i>=0;i--) {
        	if(rec[i] == answerIdx) answer[answerIdx--] = arr[i];
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(size+"\n");
        for(int i=0;i<size;i++) {
        	sb.append(answer[i]+" ");
        }
        System.out.println(sb);
       
	}
	
	
}
