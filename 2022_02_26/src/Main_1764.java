import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main_1764 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>();
		ArrayList<String> names = new ArrayList<>();
	
		for(int i=0;i<N;i++) {
			String name = br.readLine();
			
			set.add(name);
		}
		
		for(int j=0;j<M;j++) {
			String name = br.readLine();
			
			if(set.contains(name)) {
				names.add(name);
			}
				
		}
		
		Collections.sort(names);
		System.out.println(names.size());
		
		for(int i=0;i<names.size();i++) {
			System.out.println(names.get(i));
		}
		
	}

}
