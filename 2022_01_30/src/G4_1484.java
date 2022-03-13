import java.util.Scanner;

public class G4_1484 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int G= sc.nextInt();
		
		int i = 1;
		int j = 1;
		
		boolean printed = false;
		
		while(i>=j || i<100001) {
			int g  = i*i - j*j;
			
			if(i-1 == j && g>G) {
				if(!printed) System.out.println(-1);
				break;
			}
			
			if(G > g) {
				i++;
			}
			else if(G == g) {
				System.out.println(i);
				printed = true;
				i++;
			}
			else {
				j++;
			}
			
		}
		sc.close();
	}

}
