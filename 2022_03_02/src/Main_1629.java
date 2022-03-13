import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main_1629 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BigDecimal a = new BigDecimal(st.nextToken());
		BigDecimal b = new BigDecimal(st.nextToken());
		BigDecimal c = new BigDecimal(st.nextToken());
		
		System.out.println(a.multiply(b).remainder(c));
	}

}
