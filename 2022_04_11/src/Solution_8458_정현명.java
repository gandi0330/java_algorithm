import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8458_정현명 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int nums[] = new int[N];
			StringTokenizer st = null;
			
			int max = 0;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				nums[i] = Math.abs(x) + Math.abs(y);
				if(max < nums[i]) max = nums[i];
			}
			
			int moveCnt = 0;
			int moveSum = 0;
			while(true) {
				if(moveSum >= max && isOdd(moveSum) == isOdd(max)) break;
				moveCnt++;
				moveSum+= moveCnt;	
			}
			boolean isMove = true;
			for(int i=0;i<N;i++) {
				if(isOdd(nums[i]) != isOdd(moveSum)) {
					isMove = false;
					break;
				}
			}
			sb.append("#"+tc+" ");
			if(isMove) sb.append(moveCnt);
			else sb.append(-1);
			sb.append("\n");	
		}
		System.out.print(sb);
	}
	
	public static boolean isOdd(int num) {
		if(num % 2 == 0) return false;
		return true;
	}

}
