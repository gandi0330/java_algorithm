import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1992_정현명 {

	static int matrix[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		matrix = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<N;j++) {
				matrix[i][j] = line.charAt(j) - '0';
			}
		}
		
		int tempSize = N;
		
		quadTree(tempSize,0,0);
		
	}
	
	public static void quadTree(int tempSize, int r, int c) {
		
		boolean isSame = true;
		
		int num = matrix[r][c];
		for(int i=r;i<r+tempSize;i++) {
			for(int j=c;j<c+tempSize;j++) {
				if(matrix[i][j] == num) continue;
				isSame = false;
				break;
			}
		}
		
		if(isSame) System.out.print(num);
		else {
			int nextTempSize = tempSize/2;
			System.out.print("(");
			quadTree(nextTempSize,r,c);
			quadTree(nextTempSize,r,c+nextTempSize);
			quadTree(nextTempSize,r+nextTempSize,c);
			quadTree(nextTempSize,r+nextTempSize,c+nextTempSize);
			System.out.print(")");
		}
	}

}
