import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_S1_2564 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int shopN = Integer.parseInt(br.readLine());
		
		List<obj> shopList = new ArrayList<>();
		
		for(int i=0;i<shopN;i++) {
			st = new StringTokenizer(br.readLine());
			shopList.add(new obj(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		st = new StringTokenizer(br.readLine());
		obj dongken = new obj(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		int sum = 0;
		
		for(int i=0;i<shopN;i++) {
			obj shop = shopList.get(i);
			
			if(dongken.direction == shop.direction) {
				sum += Math.abs(dongken.distance - shop.distance);
			}
			else if (dongken.direction == 1) {
				if (shop.direction == 3){
					sum += dongken.distance + shop.distance;
				}
				else if (shop.direction == 2) {
					sum += Math.min(r+dongken.distance+shop.distance, r+(c-dongken.distance)+(c-shop.distance));
				}
				else if (shop.direction == 4) {
					sum += (c-dongken.distance) + shop.distance;
				}
			}
			else if (dongken.direction == 3) {
				if (shop.direction == 1){
					sum += dongken.distance + shop.distance;
				}
				else if (shop.direction == 2) {
					sum += (r- dongken.distance) + shop.distance;
				}
				else if (shop.direction == 4) {
					sum += Math.min(c+dongken.distance+shop.distance, c+(r-dongken.distance) + (r-shop.distance));
				}
			}
			else if (dongken.direction == 2) {
				if (shop.direction == 1){
					sum +=  Math.min(r+dongken.distance+shop.distance, r+(c-dongken.distance)+(c-shop.distance));
				}
				else if (shop.direction == 3) {
					sum += dongken.distance + (r - shop.distance);
				}
				else if (shop.direction == 4) {
					sum += (c - dongken.distance) + (r - shop.distance);
				}
			}
			else if( dongken.direction == 4) {
				if (shop.direction == 1){
					sum +=  dongken.distance + (c - shop.distance);
				}
				else if (shop.direction == 3) {
					sum += Math.min(c+dongken.distance+shop.distance, c+(r-dongken.distance) + (r-shop.distance));
				}
				else if (shop.direction == 2) {
					sum += (c - dongken.distance) + (c - shop.distance);
				}
			}
			
			
		}
		
		System.out.println(sum);
		
	}
	
	public static class obj{
		int direction,distance;
		
		obj(int direction, int distance){
			this.direction = direction;
			this.distance = distance;
		}
	}
}
