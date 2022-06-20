import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1005 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			// 시간 입력받기
			int costs[] = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=N;i++) {
				costs[i] = Integer.parseInt(st.nextToken());
			}
			
			// 간선과 건물의 진입차수 입력받기
			List<List<Integer>> edgeList = new ArrayList<>();
			int topo[] = new int[N+1];
			for(int i=0;i<=N;i++) {
				edgeList.add(new ArrayList<>());
			}
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				edgeList.get(x).add(y);
				topo[y]++;
			}
			
			// 목표 건물
			int W = Integer.parseInt(br.readLine());
			
			// 해당 건물을 짓기 위한 최소 시간
			int[] answer = new int[N+1];
			
			// 진입 차수가 0인 건물을 찾아 zeroQ에 넣기
			Queue<Integer> zeroQ = new LinkedList<>();
			for(int i=1;i<=N;i++) {
				if(topo[i] == 0) zeroQ.add(i);
			}
			
			// 건물의 선행자가 없을 때까지 반복
			while(!zeroQ.isEmpty()) {
				int node = zeroQ.poll();
				
				// 현재 건물의 후행자의 최소 건물 시간 갱신
				for(int nextNode : edgeList.get(node)) {
					answer[nextNode] = Math.max(answer[nextNode], answer[node]+costs[node]);
					if(--topo[nextNode] == 0) {
						zeroQ.add(nextNode);
					}
				}
			}
			
			sb.append((answer[W]+costs[W])+"\n");
		}
		System.out.print(sb);
	}

}
