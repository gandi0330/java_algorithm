import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11003 {

	
	public static class Element{
		int num;
		int idx;
		
		Element(int num, int idx){
			this.num = num;
			this.idx = idx;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Deque<Element> dq = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		
		for(int i=0;i<N;i++) {
			if(!dq.isEmpty() && dq.getFirst().idx < i-L+1 ) {
				dq.pollFirst();
			}
			
			while(!dq.isEmpty() && dq.getLast().num >= arr[i] ) {
				dq.pollLast();
			}
			
			dq.add(new Element(arr[i],i));
			sb.append(dq.getFirst().num+" ");
		}
		
		System.out.println(sb);
	}

}
