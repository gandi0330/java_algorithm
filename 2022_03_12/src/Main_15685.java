import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main_15685 {
    static int[][] deltas = {{0,1},{-1,0},{0,-1},{1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] mat = new boolean[101][101];

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            int[] direction = new int[]{0};
            direction = dragonCurve(0, direction,g);

            mat[y][x] = true;

            for(int j=0;j<direction.length;j++){
                y += deltas[(direction[j]+d)%4][0];
                x += deltas[(direction[j]+d)%4][1];

                mat[y][x] = true;
            }
        }
        int cnt = 0 ;
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(mat[i][j] && mat[i+1][j] && mat[i][j+1] && mat[i+1][j+1]) cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static int[] dragonCurve(int gen, int[] direction, int target){

        for(int i=1;i<=target;i++){
            int len = direction.length;
            int [] newDirection = new int[len*2];

            for(int j=0;j<len;j++){
                newDirection[j] = direction[j];
            }

            for(int j=len;j<len*2;j++){
                newDirection[j] = (direction[len*2 - j - 1] + 1) % 4;
            }
            direction = newDirection;
        }

        return direction;
    }
}