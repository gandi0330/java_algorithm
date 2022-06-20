import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_CodeTree_LRTech {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] checkpoints = new int[n][2];
		int[] L = new int[n];
		int[] R = new int[n];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st=  new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			checkpoints[i][0] = x;
			checkpoints[i][1] = y;
			
		}
		
		for(int i=1;i<n;i++) {
			L[i] = L[i-1] + calDistance(checkpoints[i], checkpoints[i-1]);
		}
		
		for(int i=n-2;i>=0;i--) {
			R[i] = R[i+1] + calDistance(checkpoints[i], checkpoints[i+1]);
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=1;i<n-1;i++) {
			int cal = L[i-1] + R[i+1] + calDistance(checkpoints[i-1], checkpoints[i+1]);
			if(min > cal) min = cal;
		}
		
		System.out.println(min);
	}
	
	public static int calDistance(int[] checkpoint1, int[] checkpoint2) {
		return Math.abs(checkpoint1[0] - checkpoint2[0]) + Math.abs(checkpoint1[1] - checkpoint2[1]);
	}

}
