import java.util.Arrays;

public class algorithm_unionfind {

	static int parent[];
	public static void main(String[] args) {
		
		// 1. 부모를 가리키는 배열 생성
		parent = new int[10];
		for(int i=0;i<10;i++) { //자신을 가리키도록 초기화
			parent[i] = i;
		}
		
		
		// 홀수만 묶어보기
		union(3,5);
		union(5,7);
		union(1,3);
		union(9,3);
		
		System.out.println(Arrays.toString(parent));
		
		// 최상위 부모만을 가리키도록 하기 위한 부모 갱신
		for(int i=0;i<10;i++) {
			parent[i] = find(i);
		}
		System.out.println(Arrays.toString(parent));
	}
	
	
	// 2. 모든 루트의 자식이 루트를 가리키도록 설정하면서 루트를 찾음
	public static int find(int x) {
		if(parent[x] == x) return x;
		
		return parent[x] = find(parent[x]);
	}
	
	// 3. y의 부모를 x로 하여 합집합을 만듦
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) parent[y] = x;

	}

}
