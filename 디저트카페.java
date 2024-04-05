import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class 디저트카페 {
 
    static int N, map[][], res, X, Y;
    static boolean isAte[];

    static int[] dx = {1, 1, -1, -1};
    static int[]dy = {1, -1, -1, 1};
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            res = -1;
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            for (int i = 0; i < N - 2; i++) {
                for (int j = 1; j < N - 1; j++) {
                    isAte = new boolean[101];
                    isAte[map[i][j]] = true;
                    X = i;
                    Y = j;
                    
                    go(i, j, -1, -1, 0, 0);
                }
            }
            
            System.out.println("#" + tc + " " + res);
        }
 
    }
 

    private static void go(int x, int y, int prevX, int prevY, int cnt, int sd) {
 
        for (int d = sd; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y+ dy[d];        
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(nx == prevX && ny == prevY) continue;
            if(nx == X && ny == Y) {
                res = Math.max(res, cnt + 1);
                return;
            }
            if(isAte[map[nx][ny]]) continue;
            
            isAte[map[nx][ny]] = true;
            go(nx, ny, x, y, cnt + 1, d);
                       
            isAte[map[nx][ny]] = false;
        }
        
    }
 
}