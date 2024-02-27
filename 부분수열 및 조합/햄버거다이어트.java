import java.util.Scanner;

public class 햄버거다이어트 {
	static int[][] rcp;
	static int L;
	static int N;
	static boolean[] bg;
	static int Max;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			Max = Integer.MIN_VALUE;
			N = sc.nextInt();
			L = sc.nextInt();
			rcp = new int[N][2];
			bg = new boolean[N];
			
			for(int i=0;i<N;i++) {
				rcp[i][0]=sc.nextInt();
				rcp[i][1]=sc.nextInt();
			}
			make(0);
			System.out.println("#"+test+" "+Max);
		}
	}

	public static void make(int idx) {
		if(idx>=N) {
			cal();
			return;
		}
		
		bg[idx] = true;
		make(idx+1);
		bg[idx] = false;
		make(idx+1);
	}
	
	public static void cal() {
		int[] ans = new int[2];
		for(int i=0;i<N;i++) {
			if(bg[i]) {
				ans[0]+=rcp[i][0];
				ans[1]+=rcp[i][1];
			}
				if(ans[1]<=L&&Max<ans[0]) {
					Max = ans[0];
			}
		}
	}
}
