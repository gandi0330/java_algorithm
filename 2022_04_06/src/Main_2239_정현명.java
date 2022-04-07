import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2239_정현명 {

	static int[][] sudoku;
	static boolean isPrint;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sudoku = new int[9][9];
		int blankCnt = 0;
		for(int i=0;i<9;i++) {
			String line = br.readLine();
			for(int j=0;j<9;j++) {
				sudoku[i][j] = line.charAt(j) - '0';
				if(sudoku[i][j] == 0) blankCnt++;
			}
		}
		isPrint = false;
		fill(0,0,blankCnt);
		
	}
	
	public static void fill(int r, int c, int blankCnt) {
		// 한번 출력 됬다면 나머지 연산을 파괴
		if(isPrint) return;
		
		// 한 행을 다 돌면 행 증가
		if(c == 9) {
			fill(r+1,0,blankCnt);
			return;
		}
		
		// 스도쿠를 모두 채웠다면 출력
		if(r == 9 || blankCnt == 0) {
			print();
			isPrint = true;
			return;
		}
		
		// 빈칸이라면 각 빈칸에 대해 1부터 9까지 대입해보기
		if(sudoku[r][c] == 0) {
			for(int i=1;i<=9;i++) {
				if(check(r,c,i)) { // 빈칸에 수를 대입했을 때 스도쿠가 성립되면
					sudoku[r][c] = i;
					fill(r,c+1,blankCnt-1); // 다음 빈칸으로 넘어감
					sudoku[r][c] = 0;
				}
			}
		}
		else {
			fill(r,c+1,blankCnt);
		}
		
		
	}
	
	public static boolean check(int r, int c, int val) {
		// 가로 검사
		for(int j=0;j<9;j++) {
			if(sudoku[r][j] == val) return false;
		}
		
		// 세로 검사
		for(int i=0;i<9;i++) {
			if(sudoku[i][c] == val) return false;
		}
		
		r = r/3*3;
		c = c/3*3;
		
		// 네모 검사
		for(int i=r;i<r+3;i++) {
			for(int j=c;j<c+3;j++) {
				if(sudoku[i][j] == val) return false;
			}
		}
		
		// 통과
		return true;
	}
	
	public static void print() {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				sb.append(sudoku[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
