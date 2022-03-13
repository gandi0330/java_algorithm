import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_정현명 {

	static int R,C;
	static int cntMax;
	static char matrix[][];
	static int visited[][];
	static int deltas[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		matrix = new char[R][C];
		
		for(int i=0;i<R;i++) {
			matrix[i] = br.readLine().toCharArray();
		}
		
		cntMax = 1;
		visited = new int[R][C];
		dfs_backtrack(0,0,1,1<<matrix[0][0]-'A' );
		System.out.println(cntMax);
	}
	
	
	// 2차원배열의 visited에 방문했을 때의 flag를 저장하여 다른경로로 같은 알파벳을 지나온 경우를 제외한다
	public static void dfs_backtrack(int i, int j, int cnt, int flag) {
		if(visited[i][j] == flag) return; // 다른 경로로 같은 알파벳을 지나왔을 때
		visited[i][j] = flag;
		cntMax = cntMax > cnt ? cntMax : cnt;
		for(int deltaIdx = 0; deltaIdx<4; deltaIdx++) {
			int nextI = i + deltas[deltaIdx][0];
			int nextJ = j + deltas[deltaIdx][1];
			if(nextI < 0 || nextI >= R || nextJ < 0 || nextJ >= C ) continue;
			if((flag & 1<<matrix[nextI][nextJ]-'A') == 0) dfs_backtrack(nextI,nextJ,cnt+1,flag | 1<<matrix[nextI][nextJ] -'A');
		}
	}

}
