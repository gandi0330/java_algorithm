import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_4949 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		while(!(str = br.readLine()).equals(".")) {
			Stack<Character> stack = new Stack<>();
			
			boolean pass = true;
			for(int i=0;i<str.length();i++) {
				char c = str.charAt(i);
				if(c == '(' || c == '[') stack.add(c);
				
				else if(c ==')') {
					if(!stack.isEmpty() && stack.pop() == '(') continue;
					else {
						pass = false;
						break;
					}
				}

				else if(c ==']') {
					if(!stack.isEmpty() && stack.pop() == '[') continue;
					else {
						pass = false;
						break;
					}
				}
					
					
				
			}
			
			if(stack.size() == 0 && pass) sb.append("yes").append("\n");
			else sb.append("no").append("\n");
		}
		
		System.out.println(sb);
		
	}

}
