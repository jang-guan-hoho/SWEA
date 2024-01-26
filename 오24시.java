import java.util.Scanner;

public class 오24시 {
 public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int first =sc.nextInt();
		int second =sc.nextInt();
			System.out.println("#"+(t+1)+" "+(first+second)%24);
	}
}
}
