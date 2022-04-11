import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_7662 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T  = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			int k = Integer.parseInt(br.readLine());
			
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
			
			HashMap<Integer,Integer> map = new HashMap<>();
			
			for(int j = 0;j< k;j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				char command = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				
				
				
				if(command == 'I') {
					pq.offer(num);
					maxPq.offer(num);
					map.put(num, map.getOrDefault(num, 0)+1);
				}
				else {
					
					if(num == 1) {
						while(!maxPq.isEmpty()&&map.get(maxPq.peek()) == null) {
							maxPq.poll();
						}
						if(maxPq.isEmpty()) continue;
						int delNum = maxPq.poll();
						if(map.get(delNum) == 1) map.remove(delNum);
						else if(map.get(delNum) > 1) map.put(delNum, map.get(delNum)-1);
						
					}
					else {
						while(!pq.isEmpty()&&map.get(pq.peek()) == null) {
							pq.poll();
						}
						if(pq.isEmpty()) continue;
						int delNum = pq.poll();
						if(map.get(delNum) == 1) map.remove(delNum);
						else if(map.get(delNum) > 1) map.put(delNum, map.get(delNum)-1);
					}
				}
			}
			while(!maxPq.isEmpty()&&map.get(maxPq.peek()) == null) {
				maxPq.poll();
			}
			while(!pq.isEmpty()&&map.get(pq.peek()) == null) {
				pq.poll();
			}
			
			if(pq.isEmpty()) sb.append("EMPTY\n");
			else{
				
				
				sb.append(maxPq.poll() + " " +  pq.poll() + "\n");
			}
		}
		System.out.print(sb);
	}
}
