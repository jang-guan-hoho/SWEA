import java.util.Scanner;

public class 쉬운거스름돈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] money = {50000,10000,5000,1000,500,100,50,10};
		for(int t=0;t<T;t++) {
			System.out.println("#"+(t+1));
			int N = sc.nextInt();
			for(int i=0;i<money.length;i++) {
				System.out.print(N/money[i]+" ");;
				N=N%money[i];
			}
			System.out.println();
		}
	}
}
