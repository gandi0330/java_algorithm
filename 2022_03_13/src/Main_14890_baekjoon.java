import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14890_baekjoon {

	static int N,L;
	static int map[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(checkPaths());
		
	}
	
	public static int checkPaths() {
		int cnt = 0;
		loop1 : for(int i=0;i<N;i++) { // 각 행에서 오른쪽으로 향하는 길 탐색
			boolean[] ramp = new boolean[N];
			for(int j=0;j<N-1;) {
				
				int now = map[i][j];
				//System.out.println("i : " + i + " j : " + j + " now : " + now);
				
				
				if(now == map[i][j+1]) {
					j++;
					continue; // 현재 위치가 다음 위치와 같으면 패스
				}
				else if(now == map[i][j+1] +1) { // 현재 위치보다 다음 위치가 작으면 아래로 경사로 설치 가능한지 확인
					boolean isPath = true;
					if(L + j < N) { // 남은 길의 거리가 경사로를 설치할 수 있을만큼 충분하면
						
						for(int next= j+1;next <= j+L;next++) {
							if(map[i][next] == now - 1) continue;
							isPath = false;
							break;
						}
						
					}
					else {
						isPath = false;
					}

					
					if(!isPath) continue loop1; // 현재 길 탐색 탈출
					
					for(int k = j+1;k<= j+L;k++) {
						ramp[k] = true;
					}
					j+=L;
				}
				else if(now == map[i][j+1] - 1) { // 현재 위치보다 다음 위치가 크면 위로 경사로 설치 가능한지 확인
					boolean isPath = true;
					if(j - L + 1>= 0 ) { // 현재부터 이전 거리가 경사로를 설치할 수 있을만큼 충분하면
						
						for(int next= j;next > j-L;next--) {
							if(map[i][next] == now && !ramp[next]) continue;
							isPath = false;
							break;
						}
						
					}
					else {
						isPath = false;
					}

					
					if(!isPath) continue loop1; // 현재 길 탐색 탈출
					for(int k=j;k>=j-L+1;k--) {
						ramp[k] = true;
					}
					j++;
				}
				else {
					continue loop1;
				}
			}
			// 길 통과 시
			cnt++;
			System.out.println("i : " + i);
		}
		
		loop2 : for(int j=0;j<N;j++) { // 각 열에서 아래로 향하는 길 탐색
			boolean[] ramp = new boolean[N];
			for(int i=0;i<N-1;) {
				int now = map[i][j];
				//System.out.println("j : " + j + " i : " + i + " now : " + now);				
				if(now == map[i+1][j]) {
					i++;
					continue; // 현재 위치가 다음 위치와 같으면 패스
				}
				else if(now == map[i+1][j] + 1) { // 현재 위치보다 다음 위치가 작으면 아래로 경사로 설치 가능한지 확인
					boolean isPath = true;
					if(L + i < N) { // 남은 길의 거리가 경사로를 설치할 수 있을만큼 충분하면
						
						for(int next= i+1;next <= i+L;next++) {
							if(map[next][j] == now - 1) continue;
							isPath = false;
							break;
						}
						
					}
					else {
						isPath = false;
					}

					
					if(!isPath) continue loop2; // 현재 길 탐색 탈출
					for(int k = i+1;k<= i+L;k++) {
						ramp[k] = true;
					}
					i+=L;
				}
				else if(now == map[i+1][j] - 1) { // 현재 위치보다 다음 위치가 크면 위로 경사로 설치 가능한지 확인
					boolean isPath = true;
					if(i - L + 1>= 0 ) { // 현재부터 이전 거리가 경사로를 설치할 수 있을만큼 충분하면
						
						for(int next= i;next > i-L;next--) {
							if(map[next][j] == now && !ramp[next]) continue;
							isPath = false;
							break;
						}
						
					}
					else {
						isPath = false;
					}

					
					if(!isPath) continue loop2; // 현재 길 탐색 탈출
					
					for(int k=i;k>=i-L+1;k--) {
						ramp[k] = true;
					}
					i++;
				}
				else {
					continue loop2;
				}
			}
			// 길 통과 시
			System.out.println("j : " + j);
			cnt++;
		}
		return cnt;
	}

}
