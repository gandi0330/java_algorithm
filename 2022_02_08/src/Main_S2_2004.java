import java.util.Scanner;

public class Main_S2_2004 {

	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		
		System.out.println(Math.min(count2(n)-count2(m)-count2(n-m), count5(n)-count5(m)-count5(n-m)));
		sc.close();
	}
	
	
	
	public static int count2(int num) {
		int cnt2 = 0;
		while (num != 0){
			num /=2;
			cnt2 += num;
		}
		return cnt2;
	}
	
	public static int count5(int num) {
		int cnt5 = 0;
		while (num != 0){
			num /=5;
			cnt5 += num;
		}
		return cnt5;
	}
}
