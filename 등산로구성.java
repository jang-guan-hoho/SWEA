import java.nio.channels.Pipe;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 등산로구성 {
	static int[][] map;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, K, max;
	static PriorityQueue<Integer> results;
	static boolean[][] visited;
	static int maxLength;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			N = sc.nextInt();
			K = sc.nextInt();

			map = new int[N][N];
			visited = new boolean[N][N];
			maxLength = 0 ;

			max = Integer.MIN_VALUE;
			Queue<Integer> idx = new LinkedList<>();

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
					if (map[r][c] >= max) {
						max = map[r][c];
					}
				}
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == max) {
						idx.add(r);
						idx.add(c);
					}
				}
			}
			
//			System.out.println(K);
			while (!idx.isEmpty()) {
				int r = idx.poll();
				int c= idx.poll();
				visited[r][c] =true;
				search(max, r, c, false,1);
				visited[r][c] = false;
			}// 꼭대기 좌표를 받아와서 탐색 시작
			System.out.println("#" + test + " " +maxLength );

		}
	}

	static void search(int value, int r, int c, boolean k, int length) {
		for (int j = 0; j < 4; j++) {
			if(maxLength< length) {
				maxLength = length;
			}
			int nr = r + dr[j];
			int nc = c + dc[j];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N&&!visited[nr][nc]) {
				if (map[nr][nc] < value) {
					visited[nr][nc]=true;
					search(map[nr][nc], nr, nc, k,length+1);
					visited[nr][nc]=false;
				} else if (!k&&map[nr][nc] - K < value ) {
					visited[nr][nc]=true;
					search(value - 1, nr, nc, true,length+1);
					visited[nr][nc]=false;
				}

			}
		}
	}
}
