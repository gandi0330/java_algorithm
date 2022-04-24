import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205_정현명 {

	static class Point{
		int r;
		int c;
		
		Point(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<t;tc++) {
			n = Integer.parseInt(br.readLine());
			
			pointList = new ArrayList<>();
			StringTokenizer st= null;
			// 리스트의 시작은 집, 끝은 페스티벌 장소
			for(int i=0;i<n+2;i++) {
				st = new StringTokenizer(br.readLine());
				int r= Integer.parseInt(st.nextToken());
				int c= Integer.parseInt(st.nextToken());
				pointList.add(new Point(r,c));
			}
			
			start = pointList.get(0);
			end = pointList.get(pointList.size()-1);
			
			if(bfs()) {
				sb.append("happy\n");
			}else sb.append("sad\n");
			
		}
		System.out.print(sb);
	}
	static int n;
	static Point start;
	static Point end;
	static List<Point> pointList;
	static boolean bfs() {
		boolean[] visited = new boolean[n+2];
		Queue<Point> queue = new LinkedList<>();
		queue.add(start);
		visited[0] = true;
		
		while(!queue.isEmpty()) {
			Point nowPoint = queue.poll();
			
			// 페스티벌에 도착했으면 true 반환
			if(nowPoint.r == end.r && nowPoint.c == end.c) {
				return true;
			}
			
			// 현재 위치에서 맥주 20병 마시면서 갈 수있는 최대 거리(1000)안에 편의점 혹은 페스티벌 장소가 있으면 큐에 집어넣음
			for(int i=1;i<n+2;i++) {
				if(!visited[i] && calDistance(nowPoint,pointList.get(i)) <= 1000) {
					visited[i] = true;
					queue.add(pointList.get(i));
				}
			}
		}
		
		return false;
	}
	
	static int calDistance(Point p1, Point p2) {
		return Math.abs(p2.r-p1.r)+ Math.abs(p2.c -p1.c); 
	}
}
