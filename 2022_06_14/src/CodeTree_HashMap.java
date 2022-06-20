import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CodeTree_HashMap {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String, String> hashMap = new HashMap<>();
		
		for(int i=0;i<n;i++) {
			String[] command = br.readLine().split(" ");
			
			if(command[0].equals("add")) {
				hashMap.put(command[1], command[2]);
			}
			
			if(command[0].equals("find")) {
				if(hashMap.get(command[1]) != null) {
					System.out.println(hashMap.get(command[1]));
				}
				else {
					System.out.println("None");
				}
			}
			
			if(command[0].equals("remove")) {
				hashMap.remove(command[1]);
			}
		}
		
//		// 값 추가
//		hashMap.put(1, "가");
//		hashMap.put(2, "나");
//		hashMap.put(3, "다");
//		
//		// 값 확인
//		hashMap.get(1); // 가;
//		hashMap.get(2);
//		hashMap.get(3);
//		
//		// 값 삭제
//		hashMap.remove(1);
//		hashMap.get(1); // null;
//		
//		// key가 존재할 시 true, 존재하지 않으면 false
//		hashMap.containsKey(1); // false;
	}

}
