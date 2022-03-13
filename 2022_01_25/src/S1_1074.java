import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class S1_1074 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		n = (int)Math.pow(2, n);
		
		
		z(n,0,0,0,r,c);
		
		
	}
	
	public static void z(int n, int i, int j, int cnt, int r, int c) {
		if(n%2 == 0) {
			n = n/2;
		
			if (r<i+n && c <j+n) z(n,i,j,cnt,r,c);
			else if (r<i+n && c >=j+n) z(n,i,j+n, cnt + n*n,r,c);
			else if (r>=i+n && c<j+n) z(n,i+n,j, cnt + 2*n*n,r,c);
			else if (r>=i+n && c>=j+n) z(n,i+n,j+n, cnt + 3*n*n,r,c);
		}
		else {
			
			System.out.println(cnt);
			
		}
	}

}
