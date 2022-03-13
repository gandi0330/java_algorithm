import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_11279 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0;i<N;i++) {
			int command = Integer.parseInt(br.readLine());
			
			if(command != 0) {
				pq.offer(command);
			}
			else {
				if(pq.isEmpty()) sb.append(0);
				else sb.append(pq.poll());
				
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
		
	}

}
