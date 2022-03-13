import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2138_정현명 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String nowBulbStr = br.readLine();
		boolean[] nowBulb_firstO = new boolean[N];
		boolean[] nowBulb_firstX = new boolean[N];
		for(int i=0;i<N;i++) {
			if(nowBulbStr.charAt(i)=='0') {
				nowBulb_firstO[i] = true;
				nowBulb_firstX[i] = true;
			}
		}
		
		String targetBulbStr = br.readLine();
		boolean[] targetBulb = new boolean[N];
		
		for(int i=0;i<N;i++) {
			if(targetBulbStr.charAt(i) == '0')targetBulb[i] = true;
		}
		
		
		int cnt_firstO = 1;
		int cnt_firstX = 0;
		
		nowBulb_firstO[0] = !nowBulb_firstO[0];
		nowBulb_firstO[1] = !nowBulb_firstO[1];
		
		for(int i=1;i<N;i++) {
			if(nowBulb_firstO[i-1] != targetBulb[i-1]) {
				nowBulb_firstO[i-1] =!nowBulb_firstO[i-1];
				nowBulb_firstO[i] = !nowBulb_firstO[i];
				if(i != N-1) {
					nowBulb_firstO[i+1] = !nowBulb_firstO[i+1];
				}
				cnt_firstO++;
			}
			if(nowBulb_firstX[i-1] != targetBulb[i-1]) {
				nowBulb_firstX[i-1] =!nowBulb_firstX[i-1];
				nowBulb_firstX[i] = !nowBulb_firstX[i];
				if(i != N-1) {
					nowBulb_firstX[i+1] = !nowBulb_firstX[i+1];
				}
				cnt_firstX++;
			}
		}
		if(Arrays.equals(nowBulb_firstO,targetBulb) && Arrays.equals(nowBulb_firstX,targetBulb)) System.out.println(Math.min(cnt_firstO, cnt_firstX));
		else if(Arrays.equals(nowBulb_firstO,targetBulb)) System.out.println(cnt_firstO);
		else if(Arrays.equals(nowBulb_firstX,targetBulb)) System.out.println(cnt_firstX);
		else System.out.println(-1);
		
		
		
	}

}
