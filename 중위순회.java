
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 중위순회 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int test = 1; test < 11; test++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			char[] tree = new char[n+1];
			for(int i=0;i<n+1;i++) {
				tree[i]=0;
			}
			for(int i=1; i<n+1;i++) {
				st = new StringTokenizer(bf.readLine());
				Integer.parseInt(st.nextToken());
				tree[i]=st.nextToken().charAt(0);
			}
			System.out.print("#"+test+" ");
			inorder(1, tree);
			System.out.println();
		}
	}

	static void inorder(int i, char[] tree) {
		if (tree.length <= i || tree[i] == 0) {
			return;
		}
		inorder(i * 2, tree);
		System.out.print(tree[i]);
		inorder(i * 2 + 1, tree);
	}
}
