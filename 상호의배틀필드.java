package 알고리즘공부;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 상호의배틀필드 {
	static char[] tank = { '^', 'v', '<', '>' };
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static char[] tank_d = { 'U', 'D', 'L', 'R' };
	static int H;
	static int W;
	static int tank_r;
	static int tank_c;

	static void shoot(char[][] map) {
		int l = 0;
		for (int i = 0; i < 4; i++) {
			if (tank[i] == map[tank_r][tank_c]) {
				int nr = tank_r + dr[i];
				int nc = tank_c + dc[i];
				for (; l < W; l++) {
					nr = tank_r + dr[i] * l;
					nc = tank_c + dc[i] * l;
					if (nr < H && nr >= 0 && nc < W && nc >= 0) {
						if (map[nr][nc] == '*') {
							map[nr][nc] = '.';
							break;
						}else if(map[nr][nc]=='#'){
							break;
						}
					} else {
						break;
					}
				}
			}
		}
	}

	static void move(char[][] map, char c) {
		for (int i = 0; i < 4; i++) {
			if (tank_d[i] == c) {
				map[tank_r][tank_c]=tank[i];
				int nr = tank_r + dr[i];
				int nc = tank_c + dc[i];
				if (nr < H && nr >= 0 && nc < W && nc >= 0) {
					if (map[nr][nc] == '.') {
						map[tank_r][tank_c] = '.';
						tank_r=nr;
						tank_c=nc;
						map[tank_r][tank_c]=tank[i];
					}
				} else {
					break;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		st = new StringTokenizer(br.readLine());
//		
		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			char[][] map = new char[H][W];
			for (int r = 0; r < H; r++) {
				String s = br.readLine();
				for (int c = 0; c < W; c++) {
					map[r][c] = s.charAt(c);
				}
			} // 맵 정보 입력
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					if (map[r][c] == '^' || map[r][c] == 'v' || map[r][c] == '<' || map[r][c] == '>') {
						tank_r = r;
						tank_c = c;
					}
				}
			}
//			for (int r = 0; r < H; r++) {
//				System.out.println();
//				for (int c = 0; c < W; c++) {
//					System.out.print(map[r][c]+" ");
//				}
//			} 
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			char[] order = new char[N];
			String s = br.readLine();
			for (int i = 0; i < N; i++) {
				order[i] = s.charAt(i);
			}
			for (int i = 0; i < N; i++) {
				if (order[i] == 'S') {
					shoot(map);
				}else {
					move(map, order[i]);
				}
			}
			System.out.print("#"+t+" ");
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					System.out.print(map[r][c]);
				}
				System.out.println();
			} 
		}
	}
}