import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2166 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[][] points = new long[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			points[i][0] = Long.parseLong(st.nextToken());
			points[i][1] = Long.parseLong(st.nextToken());
			
		}
		
		long res = 0;
		for(int i=2;i<N;i++) {
			res += ccw(points[0],points[i-1], points[i]);
		}
		
		res = Math.abs(res);
        if(res % 2 == 0) {
            System.out.println(res/2+".0");
        }else
            System.out.println(res/2+".5");
	}
	
	public static double ccw(long[] p1, long[] p2, long[] p3) {
		return (p1[0] * p2[1] + p2[0] * p3[1] + p3[0] * p1[1]) - (p1[1] * p2[0] + p2[1] * p3[0] + p3[1] * p1[0]);
	}

}
