import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main_Gom_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashMap<String, Boolean> map = new HashMap<>();
		int answer = 0;
		for(int i=0;i<N;i++) {
			String command = br.readLine();
			
			if(command.equals("ENTER")) {
				map.clear();
			}else {
				if(map.get(command) == null) {
					map.put(command, true);
					answer++;
				}
			}
		}
		
		System.out.println(answer);
		
		
	}

}
