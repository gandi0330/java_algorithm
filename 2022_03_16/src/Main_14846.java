import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14846 {

	static int N, Q;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		long[][] map = new long[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				long num = Long.parseLong(st.nextToken());
				map[i][j] = map[i-1][j] + map[i][j-1] +  (long)(Math.pow(10, num-1)) - map[i-1][j-1];
			}
		}
				
			
		
//		System.out.println(Arrays.toString(map.get(N).get(N).toArray()));
//		StringBuilder sb = new StringBuilder();
		Q = Integer.parseInt(br.readLine());
		for(int i=0;i<Q;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			System.out.println("1:" + map[x2][y2]);
			System.out.println("2:" + map[x2][y1-1]);
			System.out.println("3:" + map[x1-1][y2]);
			System.out.println("4:" + map[x1-1][y1-1]);
			String num = Long.toString(map[x2][y2] - map[x2][y1-1] - map[x1-1][y2] + map[x1-1][y1-1]);
			System.out.println("sum" + num);
			int cnt =0;
			
			for(int j=0;j<num.length();j++) {
				if(num.charAt(j)-'0' > 0 ) cnt++;
			}
			
//			sb.append(cnt+"\n");
			System.out.println(cnt);
		}
		
//		System.out.print(sb);
	}

}
