

/* baekjoon url : https://www.acmicpc.net/problem/2999
 * bronze 1
 * secret email
 */

import java.util.Scanner;

public class B1_2999 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String code = sc.next();
		int R = 0;
		int C = 0;
		int N = code.length();
		
		int lenSqrt = (int)Math.sqrt(N);
		
		
		// R<=C 이고 R*C = N 이면서 가장 큰 R을 찾기 위해서 N의 제곱근부터 1까지 탐색
		// N의 제곱근부터 시작하는 이유 : R의 최대 값은 N의 제곱근이 정수일 때 해당 값이기 때문
		for(int i=lenSqrt;i>0;i--) {
			if(N%i == 0) {
				R = i;
				C = N/R;
				break;
			}
		}
		
		char[][] grid = new char[R][C];
		
		int charIdx = 0;
		for(int i=0;i<C;i++) {
			for(int j=0;j<R;j++) {
				grid[j][i] = code.charAt(charIdx++);
			}
		}
		
		String answer = "";
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				answer += grid[i][j];
			}
		}
		
		System.out.println(answer);
		
		
	}

}
