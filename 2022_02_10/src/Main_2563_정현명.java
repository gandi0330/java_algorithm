import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_정현명 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 종이 개수
		boolean[][] black = new boolean[100][100]; // 흰색 도화지
		
		// 검은 색종이 입력 받기
		for(int cnt = 0; cnt<n; cnt++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 검은 색종이의 x,y 좌표
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 해당 좌표를 왼쪽 밑으로 하는 길이 10인 정사각형 부분을 true로 설정
			for(int i = y;i<y+10;i++) {
				for(int j = x;j<x+10;j++) {
					black[i][j] = true;
				}
			}
		}
		
		int answer = 0;
		
		// 검은 부분을 카운트
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(black[i][j]) answer++;
			}
		}
		
		System.out.println(answer);
	}

}
