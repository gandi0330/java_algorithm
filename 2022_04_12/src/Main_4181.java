import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main_4181 {

	
	public static class Point{
		long x;
		long y;
		
		Point(long x, long y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		
		int cnt = 0;
		List<Point> pointList = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			char c = st.nextToken().charAt(0);
			
			if(c == 'Y') {
				cnt++;
				pointList.add(new Point(x,y));
			}
		}
		
		grahamScan(pointList);
	}
	
	static Point root = new Point(Long.MAX_VALUE,Long.MAX_VALUE);
	public static void grahamScan(List<Point> pointList) {
		// 루트노드 설정
		for(int i=0;i<pointList.size();i++) {
			Point point = pointList.get(i);
			if(point.x < root.x) {
				root = point;
			}
			else if(point.x == root.x) {
				if(point.y < root.y) {
					root = point;
				}
			}
		}
		
		// 루트노드를 기준으로 반시계 방향으로 정렬
		pointList.sort(new Comparator<Point>(){
			@Override
			public int compare(Point p1, Point p2) {
				long result = ccw(root,p1,p2);
				if(result > 0) {
					return -1;
				} else if(result < 0) {
					return 1;
				} else if(dist(root, p1) > dist(root,p2)){
					return 1;
				}
				return -1;
			}
		});
		
		// 반시계 방향 정렬 도중 ccw가 0일 때(세 점이 일직선에 있을 때) 거리로 오름차순 하였다.
		// root 로 돌아오는 길이 일직선인 경우에도 거리를 오름차순으로 정렬했기 때문에 
		// 돌아올 때도 root와 가까운 정점을 먼저 출력하게 된다.
		// 따라서 CCW를 검사하는 도중 루트로 돌아오는 일직선 상의 점들을 만나면 해당 점들은 CW가 되어 스택에서 빠지게 된다.
		// 때문에 CCW검사 후 스택에 없는 point들을 거리로 내림차순하여 스택에 넣는다.
		
		Stack<Point> stack = new Stack<>();
		stack.add(root);
		
		for(int i=1;i<pointList.size();i++) {
			while(stack.size()>1&&(ccw(stack.get(stack.size()-2),stack.get(stack.size()-1),pointList.get(i)) < 0)) {
				stack.pop();
			}
			
			stack.add(pointList.get(i));
		}
		
		// 스택에 없는 point 저장
		List<Point> extraPointList = new ArrayList<>();
		
		for(int i=0;i<pointList.size();i++) {
			if(!stack.contains(pointList.get(i))) {
				extraPointList.add(pointList.get(i));
			}
		}
		
		extraPointList.sort(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if(dist(root,o1) < dist(root,o2))return 1;
				return -1;
			}
		});
		
		stack.addAll(extraPointList);
		
		StringBuilder sb = new StringBuilder();
		sb.append(pointList.size()+"\n");
		for(Point point : stack) {
			sb.append(point.x + " "+ point.y + "\n");
		}
		
		System.out.print(sb);
		
	}
	
	public static long ccw(Point p1, Point p2, Point p3) {
		return p1.x*p2.y + p2.x*p3.y + p3.x*p1.y - (p1.y*p2.x + p2.y*p3.x + p3.y*p1.x);
	}
	
	public static long dist(Point p1, Point p2) {
		return (p2.x-p1.x)*(p2.x-p1.x) + (p2.y-p1.y)*(p2.y-p1.y);
	}

}
