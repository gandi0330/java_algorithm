import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class Main_5430 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<T;t++) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			
			String temp = br.readLine();
			temp = temp.substring(1, temp.length()-1);
			
			Deque<String> deque = new LinkedList<>();
			if(n != 0) {
				for(String item : temp.split(",")) {
					deque.add(item);
				}
			}
			
			int isReversed = -1;
			boolean isError = false;
			for(int i=0;i<p.length();i++) {
				if(p.charAt(i) == 'R') {
					isReversed *= -1;
				}
				else if(p.charAt(i) == 'D') {
					if(deque.size() == 0) {
						isError = true;
						break;
					}else if(isReversed == -1) {
						deque.removeFirst();
					}else if(isReversed == 1) {
						deque.removeLast();
					}
				}
			}
			if(isError) {
				sb.append("error\n");
			}
			else if(isReversed == -1) {
				sb.append(Arrays.toString(deque.toArray()).replace(" ", "") + "\n");
			}else {
				List<Object> listItem = Arrays.asList(deque.toArray());
				Collections.reverse(listItem);
				sb.append(Arrays.toString(listItem.toArray()).replace(" ", "")+"\n");
			}
		}
		
		System.out.print(sb);
		
	}

}
