import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7662 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			int k = Integer.parseInt(br.readLine());
			
			for(int j=0;j<k;j++) {
				StringTokenizer st = new StringTokenizer(br.readLine()); 
				char command = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				
				
			}
			
		}
	}

}
