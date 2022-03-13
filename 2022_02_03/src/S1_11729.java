import java.util.Scanner;

public class S1_11729 {

	static StringBuilder sb = new StringBuilder();
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		hanoi(n,1,2,3);
		
		System.out.println(cnt);
		System.out.println(sb.toString());
		
		sc.close();
	}
	
	
	public static void hanoi(int n, int from, int temp, int to) {
		
		if(n==0) return;
		// n-1 부분  from에서 temp로 이동
		hanoi(n-1,from,to,temp);
		
		// n from 에서 to로 이동
		
		sb.append(from+" "+to+"\n");
		cnt++;
		
		
		//n -1 부분 temp 에서 to로 이동
		hanoi(n-1,temp,from,to);
	}

}
