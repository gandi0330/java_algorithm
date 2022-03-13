import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_16935 {
	
	static int N,M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		// 배열 입력
		int arr[][] = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 명령 받기
		st= new StringTokenizer(br.readLine());
		
		// 명령 수행
		for(int i=0;i<R;i++) {
			int func = Integer.parseInt(st.nextToken());
			
			switch (func) {
			case 1:
				arr = func1(arr);
				break;
			
			case 2:
				arr = func2(arr);
				break;
				
			case 3:
				int temp = M;
				M = N;
				N = temp;
				arr = func3(arr);
				break;
				
			case 4:
				temp = M;
				M = N;
				N = temp;
				arr = func4(arr);
				break;
			
			
			case 5:
				arr = func5(arr);
				break;
				
			case 6:
				arr = func6(arr);
				break;
			}
		}
		
		// 배열 출력
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.print(sb);
		
			
		
	}
	
	// 상하 반전
	public static int[][] func1(int arr[][]) {
		int[][] temp = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				temp[i][j] = arr[N-1-i][j];
			}
		}
		
		return temp;
	}
	
	// 좌우 반전
	public static int[][] func2(int arr[][]) {
		int[][] temp = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				temp[i][j] = arr[i][M-j-1];
			}
		}
		
		return temp;
	}
	
	// 시계방향 회전
	public static int[][] func3(int arr[][]) {
		int[][] temp = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				temp[i][j] = arr[M-1-j][i];
			}
		}
		
		return temp;
	}
	
	// 반시계방향 회전
	public static int[][] func4(int arr[][]) {
		int[][] temp = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				temp[i][j] = arr[j][N-1-i];
			}
		}
		
		return temp;
	}
	
	// 사분면 시계방향 회전
	public static int[][] func5(int arr[][]){
		int[][] temp = new int[N][M];
		
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(i < N/2 && j < M/2) temp[i][j+M/2] = arr[i][j];
				if(i < N/2 && j >= M/2) temp[i+N/2][j] = arr[i][j];
				if(i >= N/2 && j >= M/2) temp[i][j-M/2] = arr[i][j];
				if(i >= N/2 && j < M/2) temp[i-N/2][j] = arr[i][j];
				
			}
		}
		return temp;
	}
	
	// 사분면 반시계방향 회전
	public static int[][] func6(int arr[][]){
		int[][] temp = new int[N][M];
		
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(i < N/2 && j < M/2) temp[i+N/2][j] = arr[i][j];
				if(i < N/2 && j >= M/2) temp[i][j-M/2] = arr[i][j];
				if(i >= N/2 && j >= M/2) temp[i-N/2][j] = arr[i][j];
				if(i >= N/2 && j < M/2) temp[i][j+M/2] = arr[i][j];
				
			}
		}
		return temp;
	}

}
