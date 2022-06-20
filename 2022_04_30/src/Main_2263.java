import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2263 {
	
	static int[] in;
	static int[] post;
	static int[] inIdxArr;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		in = new int[n];
		post = new int[n];
		
		inIdxArr = new int[n+1];
		
		// 인오더 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			in[i] = Integer.parseInt(st.nextToken());
			inIdxArr[in[i]] = i;
		}
		
		// 포스트오더 입력받기
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			post[i] = Integer.parseInt(st.nextToken());
		}
		
		sb = new StringBuilder();
		
		go(0, n-1, 0, n-1);
		
		System.out.print(sb);
	}
	
	static void go(int postStartIdx, int postEndIdx, int inStartIdx, int inEndIdx) {
		// 현재 루트 값 탐색
		int root = post[postEndIdx];
		sb.append(root+" ");
		
		// inorder에서 루트의 idx를 찾음 (idx기준으로 왼쪽은 왼쪽트리, 오른쪽은 오른쪽 트리이다.)
		int inRootIdx = inIdxArr[root];
		
		int leftTreeSize = inRootIdx - inStartIdx >= 0 ? inRootIdx - inStartIdx : 0;
		int rightTreeSize = inEndIdx - inRootIdx >= 0 ? inEndIdx - inRootIdx : 0;
		
		// 왼쪽 트리가 존재할 경우 왼쪽 트리의 post배열을 구해 in배열과 함께 왼쪽 트리를 탐색
		if(leftTreeSize > 0) {
			go(postStartIdx, postStartIdx+leftTreeSize-1, inStartIdx, inRootIdx-1);
		}
		
		// 오른쪽 트리가 존재할 경우 오른쪽 트리의 post배열을 구해 in배열과 함께 왼쪽 트리를 탐색
		if(rightTreeSize > 0) {
			go(postStartIdx+leftTreeSize, postEndIdx-1, inRootIdx+1, inEndIdx);
		}
		
	}

}
