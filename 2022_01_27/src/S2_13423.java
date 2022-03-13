import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S2_13423 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc  = Integer.parseInt(br.readLine());
		for(int i=0;i<tc;i++) {
			int cntDot = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<Integer> list = new ArrayList<>();
			
			
			
			int cnt = 0;
			
			for(int j=0;j<cntDot;j++) {
				
				int nowNum = Integer.parseInt(st.nextToken());
				list.add(nowNum);
				
			}
			
			Collections.sort(list);
			
			
			for(int nowIdx=1; nowIdx<cntDot-1;nowIdx++) {
				
				
				int frontIdx = nowIdx - 1;
				int backIdx = nowIdx + 1;
				
				
				while(frontIdx>=0 && backIdx <=cntDot-1) {
					int sub1 = list.get(nowIdx) - list.get(frontIdx);
					int sub2 = list.get(backIdx) - list.get(nowIdx);
					
					if(sub1 == sub2) {
						cnt++;
						frontIdx--;
						backIdx++;
					}
					else if(sub1 > sub2) {
						backIdx++;
					}
					else if(sub1 < sub2) {
						frontIdx--;
					}
					
					
				}
			}
			System.out.println(cnt);
			
			
			
			
		}
		
		
	}

}
