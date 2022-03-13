import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493_정현명 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		Stack<int[]> stack = new Stack<>();
		
		for(int i=0;i<N;i++) {
			int nowNum = Integer.parseInt(st.nextToken());
			
			
			if(stack.empty()) {
				sb.append(0).append(" ");
			}
			else {
				while(!stack.empty()) {
					if(stack.peek()[1] > nowNum) {
						sb.append(stack.peek()[0]).append(" ");
						break;
					}
					else {
						stack.pop();
					}
				}
				
				if(stack.empty()) {
					sb.append(0).append(" ");
				}
				
			}
			
			stack.push(new int[] {i+1,nowNum});
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

}
