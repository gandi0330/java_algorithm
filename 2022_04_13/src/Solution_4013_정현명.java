import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_4013_정현명 {

	
	public static class Gear{
		int num;
		int magnetic[];
		
		Gear(int num, int[] magnetic){
			this.num = num;
			this.magnetic = magnetic;
		}
		
		public void rotate(int dir) {
			if(dir == 1) {
				int temp = this.magnetic[7];
				for(int i=7;i>=1;i--) {
					this.magnetic[i] = this.magnetic[i-1];
				}
				magnetic[0] = temp;
			}else {
				int temp = this.magnetic[0];
				for(int i=0;i<7;i++) {
					this.magnetic[i] = this.magnetic[i+1];
				}
				magnetic[7] = temp;
			}
		}
		
		public int getScore() {
			if(this.magnetic[0] == 1) {
				return (int)Math.pow(2,num-1);
			}
			return 0;
		}
	}
	
	static boolean isRotated[];
	static List<Gear> Gears;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			int K = Integer.parseInt(br.readLine());
			
			// 톱니바퀴 입력
			Gears = new ArrayList<>();
			for(int i=1;i<=4;i++) {
				int[] magnetic = new int[8];
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<8;j++) {
					magnetic[j] = Integer.parseInt(st.nextToken());
				}
				
				Gears.add(new Gear(i,magnetic));
			}
			
			// 명령어 수행
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int magNum = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
				isRotated = new boolean[5];
				rotateGear(magNum,dir);
			}
			
			int sumScore = 0;
			for(Gear gear : Gears) {
				sumScore += gear.getScore();
			}
			
			sb.append("#"+tc+" "+sumScore+"\n");
			
			
		}
		
		System.out.print(sb);
	}
	
	static void rotateGear(int magNum, int dir) {
		isRotated[magNum] = true;
		int gearIdx = magNum-1;
		Gear nowGear = Gears.get(gearIdx);
		
		// 왼쪽 검사
		if(magNum>1 && !isRotated[magNum-1]) {
			Gear leftGear = Gears.get(gearIdx-1);
			// 왼쪽 기어와 극이 같지 않으면 회전시킨다
			if(nowGear.magnetic[6] != leftGear.magnetic[2]) {
				rotateGear(magNum-1, -1*dir);
			}
		}
		//오른쪽 검사
		if(magNum<4 && !isRotated[magNum+1]) {
			Gear rightGear = Gears.get(gearIdx+1);
			// 오른쪽 기어와 극이 같지 않으면 회전시킨다
			if(nowGear.magnetic[2] != rightGear.magnetic[6]) {
				rotateGear(magNum+1, -1*dir);
			}
		}
		
		nowGear.rotate(dir);
	}

}
