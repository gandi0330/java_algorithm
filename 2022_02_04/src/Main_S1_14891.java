import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_14891 {

	static String[] Gears;
	static Boolean visited[] = new Boolean[5];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Gears = new String[5];
		
		for(int i=1;i<=4;i++) {
			Gears[i] = br.readLine();
		}
		
		int r = Integer.parseInt(br.readLine());
		
		for(int i=0;i<r;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int gearNum = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			
			
			for(int k=1;k<=4;k++) {
				visited[k] = false;
			}
			
			rotate(gearNum,direction);

		}
		
		System.out.println(score());
	}
	
	
	public static void rotate(int gearNum, int direction) {
		
		visited[gearNum] = true;
		
		// 맞닿는 부분을 비교 해서 회전할지 안할지 결정
		if(gearNum >1 && gearNum <=4 && Gears[gearNum].charAt(6) != Gears[gearNum-1].charAt(2) && visited[gearNum-1] == false) {
			rotate(gearNum-1, -direction);
		}
		
		if( gearNum <4 && gearNum >= 1 && Gears[gearNum].charAt(2) != Gears[gearNum+1].charAt(6) && visited[gearNum+1] == false) {
			rotate(gearNum+1, -direction);
		}
		
		// 현재 톱니바퀴 회전
		if(direction == 1) { // 시계방향
			Gears[gearNum] = Gears[gearNum].charAt(7) + Gears[gearNum].substring(0,7);
		}
		else {// 반시계방향
			Gears[gearNum] = Gears[gearNum].substring(1) + Gears[gearNum].charAt(0);
		}
		
		
		
		
		
	}
	
	public static int score() {
		int score = 0;
		
		for(int i=1;i<=4;i++) {
			if(Gears[i].charAt(0) == '1') {
				score += Math.pow(2, i-1);
			}
		}
		
		return score;
	}

}
