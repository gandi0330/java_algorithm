
public class Main_3 {
	static char[] arr = {'A','S','A','D','A','D','A','S'};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		
		print(0);
		
		System.out.println(sb);
	}
	
	public static void print(int i) {
		if(i == 8) return;
		
		sb.append(arr[i]);
		print(i+1);
		sb.append(arr[i]);
	}
}
