import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S4_2217 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		
		for(int i=0;i<tc;i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list,Collections.reverseOrder());
		
		int max = 0;
		
		for(int i = 0; i< list.size(); i++) {
			max = max > list.get(i) * (i+1) ? max : list.get(i) * (i+1) ;
			
		}
		System.out.println(max);
	}

}
