import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839_정현명 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int minCnt = 5000/3; 
		boolean isFull = false; // 한번이라도 N 킬로그램을 만들면 true
		
		// 0부터 N/5 까지의 5킬로그램 봉지를 골랐을 때마다 나머지의 무게가 3킬로그램으로 딱 떨어지면 해당 개수를 저장
		for(int i=0;i<=N/5;i++) {
			if ((N - 5*i) % 3 == 0) {
				minCnt = Math.min(minCnt, i + (N-5*i)/3);
				isFull = true;
			}
		}
		if(isFull) {
			System.out.println(minCnt);
		}
		else {
			System.out.println(-1);
		}
	}
}
