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
		loop1 : for(int i=0;i<N;i++) { // �� �࿡�� ���������� ���ϴ� �� Ž��
			boolean[] ramp = new boolean[N];
			for(int j=0;j<N-1;) {
				
				int now = map[i][j];
				//System.out.println("i : " + i + " j : " + j + " now : " + now);
				
				
				if(now == map[i][j+1]) {
					j++;
					continue; // ���� ��ġ�� ���� ��ġ�� ������ �н�
				}
				else if(now == map[i][j+1] +1) { // ���� ��ġ���� ���� ��ġ�� ������ �Ʒ��� ���� ��ġ �������� Ȯ��
					boolean isPath = true;
					if(L + j < N) { // ���� ���� �Ÿ��� ���θ� ��ġ�� �� ������ŭ ����ϸ�
						
						for(int next= j+1;next <= j+L;next++) {
							if(map[i][next] == now - 1) continue;
							isPath = false;
							break;
						}
						
					}
					else {
						isPath = false;
					}

					
					if(!isPath) continue loop1; // ���� �� Ž�� Ż��
					
					for(int k = j+1;k<= j+L;k++) {
						ramp[k] = true;
					}
					j+=L;
				}
				else if(now == map[i][j+1] - 1) { // ���� ��ġ���� ���� ��ġ�� ũ�� ���� ���� ��ġ �������� Ȯ��
					boolean isPath = true;
					if(j - L + 1>= 0 ) { // ������� ���� �Ÿ��� ���θ� ��ġ�� �� ������ŭ ����ϸ�
						
						for(int next= j;next > j-L;next--) {
							if(map[i][next] == now && !ramp[next]) continue;
							isPath = false;
							break;
						}
						
					}
					else {
						isPath = false;
					}

					
					if(!isPath) continue loop1; // ���� �� Ž�� Ż��
					for(int k=j;k>=j-L+1;k--) {
						ramp[k] = true;
					}
					j++;
				}
				else {
					continue loop1;
				}
			}
			// �� ��� ��
			cnt++;
			System.out.println("i : " + i);
		}
		
		loop2 : for(int j=0;j<N;j++) { // �� ������ �Ʒ��� ���ϴ� �� Ž��
			boolean[] ramp = new boolean[N];
			for(int i=0;i<N-1;) {
				int now = map[i][j];
				//System.out.println("j : " + j + " i : " + i + " now : " + now);				
				if(now == map[i+1][j]) {
					i++;
					continue; // ���� ��ġ�� ���� ��ġ�� ������ �н�
				}
				else if(now == map[i+1][j] + 1) { // ���� ��ġ���� ���� ��ġ�� ������ �Ʒ��� ���� ��ġ �������� Ȯ��
					boolean isPath = true;
					if(L + i < N) { // ���� ���� �Ÿ��� ���θ� ��ġ�� �� ������ŭ ����ϸ�
						
						for(int next= i+1;next <= i+L;next++) {
							if(map[next][j] == now - 1) continue;
							isPath = false;
							break;
						}
						
					}
					else {
						isPath = false;
					}

					
					if(!isPath) continue loop2; // ���� �� Ž�� Ż��
					for(int k = i+1;k<= i+L;k++) {
						ramp[k] = true;
					}
					i+=L;
				}
				else if(now == map[i+1][j] - 1) { // ���� ��ġ���� ���� ��ġ�� ũ�� ���� ���� ��ġ �������� Ȯ��
					boolean isPath = true;
					if(i - L + 1>= 0 ) { // ������� ���� �Ÿ��� ���θ� ��ġ�� �� ������ŭ ����ϸ�
						
						for(int next= i;next > i-L;next--) {
							if(map[next][j] == now && !ramp[next]) continue;
							isPath = false;
							break;
						}
						
					}
					else {
						isPath = false;
					}

					
					if(!isPath) continue loop2; // ���� �� Ž�� Ż��
					
					for(int k=i;k>=i-L+1;k--) {
						ramp[k] = true;
					}
					i++;
				}
				else {
					continue loop2;
				}
			}
			// �� ��� ��
			System.out.println("j : " + j);
			cnt++;
		}
		return cnt;
	}

}
