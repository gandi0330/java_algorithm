import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_10703 {

	static class Star{
		int r;
		int c;
		
		Star(int r,int c){
			this.r=r;
			this.c=c;
		}
	}
	
	static char[][] map;
	static int R, S;
	static List<Star> starList;
	static Star[] underStarList;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		map = new char[R][S];
		starList = new ArrayList<>(); // 전체 유성 리스트
		underStarList = new Star[S]; // 각 열의 유성 중 아래있는 유성 리스트
		
		// 입력 받기
		for(int i=0;i<R;i++) {
			String line = br.readLine();
			for(int j=0;j<S;j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'X') {
					map[i][j] = '.'; // 맵에는 .로 초기화해서 맵에는 땅과 공기만 존재
					starList.add(new Star(i,j)); // X를 유성리스트에 저장
					underStarList[j] = new Star(i,j); // 0행부터 계속 각 열에 유성을 집어넣으면 결국 가장 아래의 유성을 저장하게 됨
				}
			}
		}
		
		
		
		
		// 땅에 부딪히거나 맵을 벗어나기 전까지 유성을 아래로 내림
		go(1);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<S;j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
		
	}
	
	static void go(int cnt) {
		boolean isCrash = false;
		for(Star star : underStarList) {
			// 땅에 부딪히거나 맵을 벗어나면
			if(star!=null && (star.r+cnt >= R || map[star.r+cnt][star.c] == '#')) {
				isCrash = true;
				break;
			}
		}
		
		// 부딪혔다면 부딪히기 직전인 현재 상태의 유성을 맵에 그림
		if(isCrash) {
			for(Star star : starList) {
				map[star.r+cnt-1][star.c] = 'X';
			}
		}
		// 현재 유성의 위치를 cnt만큼 내렸을 때 땅에 부딪히지 않고 맵을 벗어나지도 않는다면 cnt증가 
		else { 
			go(cnt+1);
		}
	}

}
