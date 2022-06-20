import java.time.LocalDate;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		int year = now.getYear();
		int month = now.getMonthValue();
		String key = year + " " + month;
		
		int[] month31 = {0,2,4,6,7,9,11};
		int[] month30 = {3,5,8,10};
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i=0;i<month31.length;i++) {
			map.put(key, 31);
		}
		
		for(int i=0;i<month30.length;i++) {
			map.put(key, 30);
		}
		
		if((year % 4 == 0) && (year % 100 != 0) || (year % 400) == 0) {
			map.put("1", 29);
		}else {
			map.put("1", 28);
		}
		
		System.out.println(map.get(key));
		
	}

}
