import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_2580_baekjoon {

	static int map[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		
		for(int i=1;i<=9;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=9;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sudoku(1,1);
	}
	
	public static void sudoku(int r, int c) {
//		System.out.println("r:" +  r + " c:" + c);
		if(r==10) {
			StringBuilder sb = new StringBuilder();
			for(int i=1;i<=9;i++) {
				for(int j=1;j<=9;j++) {
					sb.append(map[i][j] + " ");
				}
				sb.setLength(sb.length()-1);
				sb.append("\n");
			}
			System.out.print(sb);
			System.exit(0);
		}
		else if(c == 10) {
			sudoku(r+1,1);
			return;
		}
		
		if(map[r][c]==0) {
			for(int i=1;i<=9;i++) {
				if(isPromising(r,c,i)) {
					map[r][c] = i;
					sudoku(r,c+1);
					map[r][c] = 0;
				}
			}
			return;
		}
		sudoku(r,c+1);
	}
	
	public static boolean isPromising(int r, int c, int value) {
		
		for(int i=1;i<=9;i++) {
			if(map[r][i] == value) return false;
		}
		
		
		for(int i=1;i<=9;i++) {
			if(map[i][c] == value) return false;
		}
		
		int row = (r-1) - (r-1)%3 + 1;
		int col = (c-1) - (c-1)%3 + 1;
		
		for(int i= row;i<=row+2;i++) {
			for(int j= col;j<=col+2;j++) {
				if(map[i][j] == value) return false;
			}
		}
		
		return true;
	}

}
