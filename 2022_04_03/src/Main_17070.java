import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17070 {

	static int[][] map;
	static List<String> visited;
	static int N;
	static int cnt;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 0;
		visited = new ArrayList<>();
		visited.add("1");
		dfs(0,1,"1");
		
		System.out.println(cnt);
	}
	
	public static void dfs(int r, int c, String path) {
		
		// 완료
		if(r == N-1 && c == N-1) {
			cnt++;
			return;
		}
		
		char[] way = null;
		switch(path.charAt(path.length()-1)) {
		// 가로
		case '1' :
			way = new char[] {'1','3'};
			break;
		// 세로
		case '2' :
			way = new char[] {'2','3'};
			break;
		// 대각선
		case '3' :
			way = new char[] {'1','2','3'};
			break;
		}
		
		for(int i=0;i<way.length;i++) {
			if(way[i] == '1') {
				int nextR = r;
				int nextC = c+1;
				
				if(nextC >= N || map[nextR][nextC] == 1) continue;
				if(!visited.contains(path+"1")) dfs(nextR,nextC,path+"1");
			}else if(way[i] == '2') {
				int nextR = r+1;
				int nextC = c;
				
				if(nextR >= N || map[nextR][nextC] == 1 )continue;
				if(!visited.contains(path+"2")) dfs(nextR,nextC,path+"2");
			}else if(way[i] == '3') {
				int nextR = r+1;
				int nextC = c+1;
				
				if(nextR >= N || nextC >= N || map[nextR][nextC] == 1 || map[nextR-1][nextC] == 1 || map[nextR][nextC-1] == 1)continue;
				if(!visited.contains(path+"3")) dfs(nextR,nextC,path+"3");
			}
		}
	}

}
