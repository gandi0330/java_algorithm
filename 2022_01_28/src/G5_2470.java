import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;



public class G5_2470 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list);
		
		int front = 0;
		int back = list.size() - 1;
		
		int answer = Integer.MAX_VALUE;
		int answerLeft = list.get(0);
		int answerRight = list.get(list.size()-1);
		
		
		loop : while(front <back) {
			int fv = list.get(front);
			int bv = list.get(back);
			
			int value = Math.abs(fv+bv);
			
			
			if(value < answer) {
				answer = value;
				answerLeft = fv;
				answerRight = bv;
				
				if(answer == 0) break loop;
			}
			
			if(fv+bv < 0) {
				front++;
			}
			else {
				back--;
			}
			
		}
		
		System.out.println(answerLeft + " " + answerRight);
	}

}
