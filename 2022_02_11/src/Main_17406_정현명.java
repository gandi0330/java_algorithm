import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17406_정현명 {

	static int matrix[][]; // 원 배열 저장
	static int temp[][]; // 임시 저장 
	static int n,m,k;
	static int[][] deltas = {{1,0},{0,1},{-1,0},{0,-1}};
	static List<int[]> list = new ArrayList<>(); // 회전 순서 순열 리스트
	static int rotateArr[][]; // 회전 정보
	static int minRowSum = Integer.MAX_VALUE; // 가장 낮은 행 합값
	
	public static void main(String[] args) throws IOException {
		// ==============입력 받기==================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
	
		matrix = new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=m;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rotateArr = new int[k][3];
		
		
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			rotateArr[i][0] = Integer.parseInt(st.nextToken());
			rotateArr[i][1] = Integer.parseInt(st.nextToken());
			rotateArr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		// =============== 회전 순서 리스트 만들기 ==============
		int numbers[] = new int[k];
		boolean selected[] = new boolean[k];
		permutation(0, numbers, selected ); // 순열을 통해 kPk 크기의 순서 배열을 list에 저장한다
		
		// =============== 회전 순서 리스트에서 하나씩 빼서 순서에 맞게 회전 한 후 회전 된 행렬의 값(행 합중 가장 낮은 값)을 구한다 ================
		for(int i=0;i<list.size();i++) {
			
			// 회전시킬 배열 생성
			temp = new int[n+1][m+1];
			
			// 깊은 복사 
			for(int r=1;r<=n;r++) {
				for(int c=1;c<=m;c++) {
					temp[r][c] = matrix[r][c];
				}
			}
			
			// r, c, s를 가진 int 배열 가져오기
			int rotateInfo[] = list.get(i);
			
			// 순서에 맞게 회전
			for(int j : rotateInfo) {
				rotate(rotateArr[j][0],rotateArr[j][1],rotateArr[j][2]);
			}
			
			// 회전한 배열을 탐색하여 최소 행합을 구함
			searchMinRowSum();
		}
		
		// ================ 여러 배열의 행 합중 가장 낮은 값 출력 ==============
		
		System.out.println(minRowSum);
	}
	
	
	public static void rotate(int r, int c, int s) {
		
		int leftUpR = r-s; 
		int leftUpC = c-s; 
		int rightDownR = r+s; 
		int rightDownC = c+s;
		
		int size = rightDownR - leftUpR + 1;
		
		// 부분 네모 
		for(int i=0;i<size/2;i++) {
			int firstR = leftUpR + i; 
			int firstC = leftUpC + i; 
			
			int firstValue = temp[firstR][firstC];
			
			int R = firstR;
			int C = firstC;
			
			for(int j=0;j<4;j++) {
				while(true) {
					int nextR = R + deltas[j][0];
					int nextC = C + deltas[j][1];
					
					if(nextR < leftUpR + i || nextR > rightDownR - i || nextC < leftUpC + i || nextC > rightDownC - i) break; 
					temp[R][C] = temp[nextR][nextC];
					R = nextR;
					C = nextC;
					
				}
			}
			
			temp[firstR][firstC+1] = firstValue;
		}
	}
	
	public static void searchMinRowSum() {
		for(int i=1;i<=n;i++) {
			int sum =0;
			for(int j=1;j<=m;j++) {
				sum+=temp[i][j];
			}
			
			minRowSum = Math.min(minRowSum, sum);
		}
		
	}
	
	
	// 순열
	public static void permutation(int cnt, int[] numbers, boolean[] selected) {
		if(cnt == k) {
			list.add(numbers.clone());
		}
		
		for(int i=0;i<k;i++) {
			if(selected[i] == false) {
				numbers[cnt] = i;
				selected[i] = true;
				permutation(cnt+1,numbers,selected);
				selected[i] = false;
			};
		}
	}

}
