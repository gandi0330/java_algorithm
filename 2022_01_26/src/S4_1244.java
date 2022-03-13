import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class S4_1244 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int switchCnt = Integer.parseInt(br.readLine());
		String[] switchArr = br.readLine().split(" ");
		
		int studentCnt = Integer.parseInt(br.readLine());
		
		for(int i=0;i<studentCnt;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(sex == 1) {
				for(int j=1;j<=switchCnt;j++) {
					if (j % num == 0) {
						switchArr[j-1] = switchSwitch(switchArr[j-1]);
					}
				}
				
			}
			
			else {
				int nowIdx = num-1;
				switchArr[nowIdx] = switchSwitch(switchArr[nowIdx]);
				
				int frontIdx = nowIdx - 1;
				int backIdx = nowIdx + 1;
				
				while(true) {
					
					if(frontIdx>=0 && backIdx <switchCnt && switchArr[frontIdx].equals(switchArr[backIdx])) {
						switchArr[frontIdx] = switchSwitch(switchArr[frontIdx]);
						switchArr[backIdx] = switchSwitch(switchArr[backIdx]);
						frontIdx--;
						backIdx++;
					}
					else break;
				}
				
				
			}
		}
		
		for(int i=1;i<=switchArr.length;i++) {
			System.out.print(switchArr[i-1]+" ");
			
			if(i % 20==0) System.out.println();
		}
		
	}
	
	public static String switchSwitch(String str) {
		if(str.equals("0")) {
			return "1";
		}
		return "0";
	}

}
