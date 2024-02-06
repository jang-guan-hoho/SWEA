import java.util.Scanner;

public class 거듭제곱 {
	public static int fct(int n,int m) {
		if(m>0)
			return n*fct(n, --m);
		else
			return 1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1;t<11;t++) {
			int i = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			System.out.println("#"+t+" "+fct(N,M));
		}
	}
}
