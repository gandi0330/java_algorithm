import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_Gom_3 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String foods = br.readLine();
		
		int chickens = 0;
		
		for(int i=0;i<N;i++) {
			if(foods.charAt(i) == 'C') {
				chickens++;
			}
		}
		if(chickens == N) {
			System.out.println(N);
		}
		else System.out.println(N/(N-chickens+1));
		
		
	}

}
