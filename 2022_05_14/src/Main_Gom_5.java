import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_Gom_5 {
	

	static class Bird{
		int v;
		int s;
		int e;
		
		Bird(int v, int s, int e){
			this.v = v;
			this.s = s;
			this.e = e;
		}
	}
	
	public static int gcd(int num1, int num2){
        if(num2 == 0) return num1;
        else return gcd(num2, num1 % num2);
    }
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] A;
		boolean[] B;
		boolean[] C; 
		int v, s, e;
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		A = new boolean[v];
		
		for(int i=s;i<=e;i++) {
			A[i] = true;
		}
		
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		B = new boolean[v];
		
		for(int i=s;i<=e;i++) {
			B[i] = true;
		}
		
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		C = new boolean[v];
		
		for(int i=s;i<=e;i++) {
			C[i] = true;
		}
		
		
	}

}
