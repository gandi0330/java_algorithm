import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_Gom_4 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[] isPossibleDay = new boolean[7];
		StringTokenizer st = new StringTokenizer(br.readLine());
		String answer = "NO";
		
		int dayArr[] = new int[N];
		for(int i=0;i<N;i++) {
			dayArr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N;i++) {
			
			Set<Integer> possibleDays = new HashSet<>();
			for(int j=0;j<7;j++) {
				if(isPossibleDay[j]) {
					possibleDays.add((j+dayArr[i]) % 7);
				}
			}
			possibleDays.add((dayArr[i]-1)%7);
			
			for(int item : possibleDays) {
				isPossibleDay[item] = true;
			}
			
			if(isPossibleDay[3]) {
				answer = "YES";
				break;
			}
		}
		
		System.out.println(answer);
		
	}

}
