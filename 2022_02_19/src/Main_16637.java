import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_16637 {
    static int N;
    static String str;
    static int answer;
    static int numbers[];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
        
        answer = Integer.MIN_VALUE;
        if(N == 1) System.out.println(str);
        else {
        	
        	for(int i=1;i<=(N - N/2)/2;i++){
                numbers = new int[i];
                combination(0,0,i);
            }

            System.out.println(answer);
        }
        
        
    }

    public static void combination(int start, int cnt, int end){
        if(cnt == end){
            StringBuffer sb = new StringBuffer();
            sb.append(str);
            int cntPlus = 0;
            int temp = -4;
            for(int i=0;i<end;i++){
            	
            	if(temp + 4 <= numbers[i]) {
            		sb.insert(numbers[i]+cntPlus,"(");
                    sb.insert(numbers[i]+cntPlus+4,")");
                    cntPlus += 2;
                    temp = numbers[i];
                    
            	}
            	else {
            		return;
            	}
            	answer = Math.max(cal(sb.toString()), answer);
            	
            }
            
            
            return;

            
        }
        for(int i=start;i<=N-3;i+=2){
            numbers[cnt] = i;
            combination(i+2, cnt+1, end);
        }
    }
    
    public static int cal(String expression) {
    	
//    	System.out.println(expression);
    	List<String> list = new ArrayList<>();
    	
    	
    	for(int i=0;i<expression.length();) {
    		if(expression.charAt(i) == '(') {
    			i++;
    			String sub = "";
    			while(true) {
	    			if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
	    				sub += expression.charAt(i);
	    				i++;
	    				continue;
	    			}
	    			break;
    			}
    			int numLeft = Integer.parseInt(sub);
    			char op = expression.charAt(i);
    			i++;
    			
    			sub = "";
    			while(true) {
	    			if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
	    				sub += expression.charAt(i);
	    				i++;
	    				continue;
	    			}
	    			break;
    			}
    			int numRight = Integer.parseInt(sub);
    			i++;
    			
    			if(op == '+') list.add((numLeft+numRight)+"");
    			else if(op == '-') list.add((numLeft-numRight)+"");
    			else list.add((numLeft*numRight)+"");
    		
    		}
    		else {
    			String sub = "";
    			while(i<expression.length()) {
	    			if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
	    				sub += expression.charAt(i);
	    				i++;
	    				continue;
	    			}
	    			else {
	    				if(sub == "") {
	    					sub  = expression.charAt(i)+"";
	    					i++;
	    				}
	    				break;
	    			}
    			}
    			
    			list.add(sub);
    		}
    	}
    	
//    	System.out.println(list.toString());
    	int sum = Integer.parseInt(list.get(0));
    	for(int i=1;i<list.size();i += 2) {
    		char op = list.get(i).charAt(0);
    		
    		if(op == '+') sum += Integer.parseInt(list.get(i+1));
    		else if(op == '-') sum -= Integer.parseInt(list.get(i+1));
    		else sum *= Integer.parseInt(list.get(i+1));
    		
    	}
    	
    	return sum;
    }
}