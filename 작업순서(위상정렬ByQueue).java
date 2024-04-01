import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 작업순서 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10 ;
		for(int test =1 ; test <= T; test++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			int[][] adj = new int [V+1][V+1];
			int[] degree = new int [V+1];
			Queue<Integer> queue = new LinkedList<>();
			
			for(int i = 0 ; i < E;i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				adj[A][B] = 1;
				degree[B]++;
			}
			
			for(int i = 1 ; i < V+1 ; i++) {
				if(degree[i]==0) {
					queue.offer(i);
				}
			}
			
			StringBuilder sb= new StringBuilder();
			sb.append("#"+test+" ");
			while(!queue.isEmpty()) {
				int curr = queue.poll();
				sb.append(curr+" ");
				
				for(int i = 1 ; i < V+1 ;i++ ) {
					if(adj[curr][i]==1) {
						degree[i]--;
						if(degree[i] == 0) {
							queue.offer(i);
						}
					}
				}
				
			}
			System.out.println(sb);
		}
	}
}
