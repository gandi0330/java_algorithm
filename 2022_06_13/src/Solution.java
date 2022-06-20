import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		String[][] places = {{"PXOOP", "XPXOX", "OXXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		System.out.println(Arrays.toString(solution(places)));
	}
	
	static int R;
	static int C;
	static boolean[][] visited;
	public static int[] solution(String[][] places) {
		int[] answer = new int[places.length];
		Arrays.fill(answer, 1);
		loop : for(int tc=0;tc<places.length;tc++) {
			R = places[tc].length;
			C = places[tc][0].length();
			visited = new boolean[R][C];
			
			for(int i=0;i<R;i++) {
	        	for(int j=0;j<C;j++) {
	        		if(places[tc][i].charAt(j) == 'P') {
	        			if(check(i,j,places[tc])) continue;
	        			answer[tc] = 0;
	        			continue loop;
	        		}
	        	}
	        }
		}
		
		return answer;
        
        
    }

	static int[] dr1 = {0,1,0,-1};
	static int[] dc1 = {1,0,-1,0};
	static int[] dr2VerHor = {0,2,0,-2};
	static int[] dc2VerHor = {2,0,-2,0};
	static int[] dr2Diag = {1,1,-1,-1};
	static int[] dc2Diag = {1,-1,-1,1};
	public static boolean check(int r, int c, String[] place) {
		
		visited[r][c] = true;
		
		// 한 칸 검색
		for(int i=0;i<4;i++) {
			int nextR = r + dr1[i];
			int nextC = c + dc1[i];
			
			if(nextR < 0 || nextR >= R || nextC < 0 || nextC >= C || visited[nextR][nextC] ) continue;
			if(place[nextR].charAt(nextC) == 'P') return false;
		}
		
		// 두 칸 가로세로 검색
		for(int i=0;i<4;i++) {
			int nextR = r + dr2VerHor[i];
			int nextC = c + dc2VerHor[i];
			
			if(nextR < 0 || nextR >= R || nextC < 0 || nextC >= C || visited[nextR][nextC] ) continue;
			if(place[nextR].charAt(nextC) == 'P') {
				if(place[r + dr2VerHor[i]/2].charAt(c + dc2VerHor[i]/2) == 'O') return false;
			}
			
		}
		
		// 두 칸 대각선 검색
		for(int i=0;i<4;i++) {
			int nextR = r + dr2Diag[i];
			int nextC = c + dc2Diag[i];
			
			if(nextR < 0 || nextR >= R || nextC < 0 || nextC >= C || visited[nextR][nextC] ) continue;
			if(place[nextR].charAt(nextC) == 'P') {
				if(place[r].charAt(nextC) == 'O' || place[nextR].charAt(c) == 'O') return false;
			}
		}
		
		return true;
	
	}
}
