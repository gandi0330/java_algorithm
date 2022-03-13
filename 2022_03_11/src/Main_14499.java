import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14499 {
	
	static int N,M,x,y,K;
	static int map[][];
	static int deltas[][] = {{},{0,1},{0,-1},{-1,0},{1,0}};
	static int dice[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dice = new int[6]; // 0 : 윗면, 5 : 아랫면
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<K;i++) {
			int d = Integer.parseInt(st.nextToken());
			
			int nextX = x + deltas[d][0];
			int nextY = y + deltas[d][1];
			
			if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
			
			x = nextX;
			y = nextY;
			roll(d);
			
			if(map[x][y] == 0) {
				map[x][y] = dice[5];
			}
			else {
				dice[5] = map[x][y];
				map[x][y] = 0;
			}
			
			System.out.println(dice[0]);
		}
	}
	
	public static void roll(int d) {
		
		int temp = dice[0];
		if(d==1) {
			dice[0] = dice[3];
			dice[3] = dice[5];
			dice[5] = dice[2];
			dice[2] = temp;
		}
		else if(d==2) {
			dice[0] = dice[2];
			dice[2] = dice[5];
			dice[5] = dice[3];
			dice[3] = temp;
		}
		else if(d==3) {
			dice[0] = dice[4];
			dice[4] = dice[5];
			dice[5] = dice[1];
			dice[1] = temp;
		}
		else {
			dice[0] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[4];
			dice[4] = temp;
		}
	}

}
