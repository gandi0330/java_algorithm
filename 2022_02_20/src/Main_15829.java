import java.util.Scanner;

public class Main_15829 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String str = sc.next();
		
		int r = 31;
		long sum = 0;
		for(int i=0;i<str.length();i++) {
			long a = (long)((int)(str.charAt(i) - 'a' + 1));
			
			long b = 1;
			for(int k=0;k<i;k++) {
				b  = (b * r) % 1234567891;
			}
			sum += (a*b) % 1234567891;
		}
		
		System.out.println(sum %1234567891);
	}

}
