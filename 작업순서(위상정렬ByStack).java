import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 작업순서ByStack {
	static int V;
	static int E;
	static int[][] adj;
	static int[] degree;
	static Stack<Integer> stack;
	static boolean[] visited;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10 ;
		for(int test =1 ; test <= T; test++) {
			V = sc.nextInt();
			E = sc.nextInt();
			
			adj = new int [V+1][V+1];
			stack = new Stack<>();
			degree = new int[V+1];
			visited = new boolean [V+1];

			for(int i = 0 ; i < E;i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				adj[A][B] = 1;
				degree[B]++;
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#"+test+" ");
			for(int i = 1; i < V+1 ; i++) {
				if(degree[i]==0)
					DFS(i);
			}
			
			while(!stack.isEmpty()) {
				sb.append(stack.pop()+" ");
			}
			System.out.println(sb);
		}
	}

	private static void DFS(int v) {
		visited[v] = true;
		
		for(int i = 1 ; i< V+1 ; i++) {
			if(adj[v][i]==1 && !visited[i]) {
				DFS(i);
			}
		}
		stack.add(v);
	}
}
