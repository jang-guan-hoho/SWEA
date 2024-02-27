import java.util.Scanner;

public class 부분수열의합 {
	static int N;
	static int K;
	static boolean[] ans;
	static int[] num;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			N = sc.nextInt();
			K = sc.nextInt();
			num = new int[N];
			ans = new boolean[N];
			cnt = 0;
			for(int i=0;i<N;i++) {
				num[i] = sc.nextInt();
			}
			cal(0);
			System.out.println("#"+test+" "+cnt);
		}
	}

	static void cal(int idx) {
		if (idx >= N) {
			start();
			return;
		}

		ans[idx] = true;
		cal(idx + 1);
		ans[idx] = false;
		cal(idx + 1);
	}
	
	 static void start() {
		 int sum=0;
		 for(int i=0;i<N;i++) {
			 if(ans[i]) {
				 sum+=num[i];
			 }
		 }
		 if(sum==K) {
			 cnt++;
		 }
	 }
}
