import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_2304 {

	public static void main(String[] args) throws IOException{
		
		// 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];
		
		for(int i=0;i<n;i++) {
			String line = br.readLine();
			int idx = Integer.parseInt(line.split(" ")[0]);
			int height = Integer.parseInt(line.split(" ")[1]);
			
			arr[idx] = height;
		}
		
		
		// 구현
		int leftIdx = 0;
		int rightIdx = 1000;
		
		int leftMax = 0;
		int rightMax = 0;
		
		int volume = 0;
		
		while(leftIdx <=rightIdx) {
			
			leftMax = Math.max(leftMax, arr[leftIdx]);
			rightMax = Math.max(rightMax, arr[rightIdx]);
			
			if (leftMax < rightMax) {
				volume += leftMax;
				leftIdx++;
				
			}
			else {
				volume += rightMax;
				rightIdx--;
			}
			
			
		}
		
		
		System.out.println(volume);
		
		
	}

}
