import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class 보급로 {
	
	static class Node implements Comparable<Node> {
		int ed;
		int t;

		public Node(int ed, int t) {
			super();
			this.ed = ed;
			this.t = t;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.t, o.t);
		}

		@Override
		public String toString() {
			return "Node [ed=" + ed + ", t=" + t + "]";
		}
		
		
	}
	
	
	static int N;
	static PriorityQueue<Node> pq;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[] visited;
	static List<Node>[] adjList;
	static int[] dist;
	
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visited = new boolean[N * N]; // 노드 개수
			dist = new int[N * N];
			Arrays.fill(dist, Integer.MAX_VALUE);
			for (int r = 0; r < N; r++) {
				String s = br.readLine();
				for (int c = 0; c < N; c++) {
					map[r][c] = Character.getNumericValue(s.charAt(c));
				}
			}

			adjList = new ArrayList[N * N]; // 인접 리스트 선언
			for (int i = 0; i < N * N; i++) {
				adjList[i] = new ArrayList<>();
			} // 인접 리스트 초기화

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (nr < N && nr >= 0 && nc < N && nc >= 0) {
							adjList[r * N + c].add(new Node(nr * N + nc, map[nr][nc]));
						}
					}
				}
			} // 간선 정보 저장
//			for(List<Node> node:adjList) {
//				System.out.println(node.toString());
//			}
			dijkstra(0);

			System.out.println("#"+test+" "+dist[N*N-1]);
		}
	}
	
	static void dijkstra(int start) {
		pq = new PriorityQueue<>();

		dist[start] = 0;

		pq.add(new Node(start, 0));


		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (visited[curr.ed])
				continue;
			visited[curr.ed] = true;

			for (Node node : adjList[curr.ed]) {
				if (!visited[node.ed] && dist[node.ed] > dist[curr.ed] + node.t) {
					dist[node.ed] = dist[curr.ed] + node.t;
					pq.add(new Node(node.ed, dist[node.ed]));
				}
			}
		}
}
}
