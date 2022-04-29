import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2629 {

	
	static int Ngrams[], Mgrams[];
	static int[] numbers;
	static int N, M;
	static boolean isCheck;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		
		N = Integer.parseInt(br.readLine()); // 추 개수
		Ngrams = new int[N]; // 추 무게 배열
		
		// 추 입력
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			Ngrams[i] = Integer.parseInt(st.nextToken());
		}
		
		
		M = Integer.parseInt(br.readLine()); // 구슬 개수
		Mgrams = new int[M]; // 구슬 무게 배열
		
		// 구슬 입력
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			Mgrams[i] = Integer.parseInt(st.nextToken());
		}
		
		
		
		boolean isValid[] = new boolean[15001];
		
		for(int i=0;i<N;i++) {
			List<Integer> list = new ArrayList<>();
			list.add(Ngrams[i]);
			for(int j=0;j<=15000;j++) {
				if(isValid[j]) {
					if(j+Ngrams[i] <= 15000) list.add(j+Ngrams[i]);
					list.add(Math.abs(j-Ngrams[i]));
				}
			}
			
			for(int j=0;j<list.size();j++) {
				isValid[list.get(j)] = true;
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<M;i++) {
			if(Mgrams[i] > 15000) sb.append("N ");
			else if(isValid[Mgrams[i]]) sb.append("Y ");
			else sb.append("N ");
		}
		
		System.out.println(sb);
		
	}
}
